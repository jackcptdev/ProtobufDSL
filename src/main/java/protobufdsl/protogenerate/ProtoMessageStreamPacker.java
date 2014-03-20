package protobufdsl.protogenerate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;

import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors.Descriptor;

import protobufdsl.common.DataReaderAdapter;
import protobufdsl.common.ProtobufUtils;
import protobufdsl.common.StringUtils;
import protobufdsl.parse.tree.AstVisitingException;
import protobufdsl.parse.tree.AstVisitor;
import protobufdsl.parse.tree.CombinationType;
import protobufdsl.parse.tree.Identifier;
import protobufdsl.parse.tree.IntegerNumber;
import protobufdsl.parse.tree.Node;
import protobufdsl.parse.tree.PrimaryType;
import protobufdsl.parse.tree.RepeatedCount;
import protobufdsl.parse.tree.Start;
import protobufdsl.parse.tree.Statement;
import protobufdsl.parse.tree.StatementList;
import protobufdsl.parse.tree.TypeDefine;
import protobufdsl.parse.tree.primary.Primary;
import protobufdsl.parse.tree.primary.PrimaryANSI;
import protobufdsl.parse.tree.primary.PrimaryB8UTF;
import protobufdsl.parse.tree.primary.PrimaryBASE64;
import protobufdsl.parse.tree.primary.PrimaryBYTES;
import protobufdsl.parse.tree.primary.PrimaryDOUBLE;
import protobufdsl.parse.tree.primary.PrimaryFLOAT;
import protobufdsl.parse.tree.primary.PrimarySINT16;
import protobufdsl.parse.tree.primary.PrimarySINT32;
import protobufdsl.parse.tree.primary.PrimarySINT64;
import protobufdsl.parse.tree.primary.PrimarySINT8;
import protobufdsl.parse.tree.primary.PrimaryUINT16;
import protobufdsl.parse.tree.primary.PrimaryUINT32;
import protobufdsl.parse.tree.primary.PrimaryUINT8;
import protobufdsl.parse.tree.primary.PrimaryUTF8;
import protobufdsl.stream.DataInput;
import sun.misc.BASE64Decoder;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Mar 19, 2014 10:39:03 AM
 * 
 */
public class ProtoMessageStreamPacker extends AstVisitor<Object, DataReaderAdapter> {

    private final Stack<com.google.protobuf.DynamicMessage.Builder> structFrames = new Stack<com.google.protobuf.DynamicMessage.Builder>();
    private final Stack<Descriptor> descriptorFrames = new Stack<Descriptor>();
    private final Stack<String> messageNameFrames = new Stack<String>();

    private final Stack<HashMap<String, Object>> countableIndentiferFrames = new Stack<HashMap<String, Object>>();

    private long getCountableVariable(String identifer) throws ProtoGeneratingException {
        Object v = this.countableIndentiferFrames.peek().get(identifer);
        if (v == null) {
            throw new ProtoGeneratingException(String.format("Cannot find [ %s ]'s value.", identifer));
        }
        if (!(v instanceof Number)) {
            throw new ProtoGeneratingException(String.format("Ref [ %s ] is not a number.", identifer));
        }
        return Long.valueOf(v.toString());
    }

    @Override
    public void init(DataReaderAdapter context) throws AstVisitingException {
        if (context.getInputSource() == null) {
            throw new ProtoGeneratingException("no input stream.");
        }

        Object input = context.getInputSource();
        if (!(input instanceof DataInput)) {
            throw new ProtoGeneratingException(
                    String.format("Invalid input stream [ %s ].", input.getClass().getName()));
        }

        String messageName = context.getOuterMessageName();
        if (messageName == null) {
            throw new ProtoGeneratingException("Message name is null.");
        }

        com.google.protobuf.DynamicMessage.Builder messageStruct = context.getMessageStruct();
        if (messageStruct == null) {
            throw new ProtoGeneratingException("Message builder is null.");
        }

    }

    private DataInput getDataInput(DataReaderAdapter context) {
        return (DataInput) context.getInputSource();
    }

    @Override
    protected Object visitNode(Node node, DataReaderAdapter context) throws AstVisitingException {
        return node.accept(this, context);
    }

    @Override
    public Object process(Node node, DataReaderAdapter context) throws AstVisitingException {
        return super.process(node, context);
    }

    @Override
    public Object visitRepeatedCount(RepeatedCount node, DataReaderAdapter context) throws AstVisitingException {

        if (node.getRepeatedCountType() == RepeatedCount.REPEATED_COUNT_TYPE_DIRECT) {
            return Long.valueOf((Integer) visitIntegerNumber(node.getRepeatedCount(), context));
        } else {
            String identifier = (String) visitIdentifier(node.getRepeatedCountRef(), context);
            return this.getCountableVariable(identifier);
        }
    }

    @Override
    public Object visitStatement(Statement node, DataReaderAdapter context) throws AstVisitingException {

        com.google.protobuf.DynamicMessage.Builder currentStruct = this.structFrames.peek();
        Descriptor currentDescriptor = this.descriptorFrames.peek();
        HashMap<String, Object> currentCountableIdentifiers = this.countableIndentiferFrames.peek();

        String identifer = (String) visitIdentifier(node.getIdentifier(), context);
        int fieldId = (Integer) visitIntegerNumber(node.getProtobufFieldId(), context);

        long repeatedCount = (Long) visitRepeatedCount(node.getTypeDefine().getRepeatedCount(), context);
        boolean isRepeated = true;
        if (node.getTypeDefine().getRepeatedCount().getRepeatedCountType() == RepeatedCount.REPEATED_COUNT_TYPE_DIRECT) {
            if (repeatedCount == 1) {
                isRepeated = false;
            }
        }

        boolean isPrimary = (node.getTypeDefine() instanceof PrimaryType);

        if (isPrimary) {
            if (isRepeated) {
                for (long i = 0; i < repeatedCount; i++) {
                    Object value = visitTypeDefine(node.getTypeDefine(), context);
                    currentStruct.addRepeatedField(currentDescriptor.findFieldByNumber(fieldId), value);
                }
            } else {
                Object value = visitTypeDefine(node.getTypeDefine(), context);
                currentStruct.setField(currentDescriptor.findFieldByNumber(fieldId), value);
                currentCountableIdentifiers.put(identifer, value);
            }
        } else {
            String nestedTypeName = StringUtils.nestedTypeName(identifer);
            Descriptor subDescriptor = currentDescriptor.findNestedTypeByName(nestedTypeName);

            if (isRepeated) {

                for (long i = 0; i < repeatedCount; i++) {
                    com.google.protobuf.DynamicMessage.Builder subMessageBuilder = ProtobufUtils
                            .createMessagePackBuilder(subDescriptor);
                    this.countableIndentiferFrames.push(new HashMap<String, Object>());
                    this.descriptorFrames.push(subDescriptor);
                    this.structFrames.push(subMessageBuilder);
                    this.messageNameFrames.push(nestedTypeName);

                    visitTypeDefine(node.getTypeDefine(), context);
                    currentStruct.addRepeatedField(currentDescriptor.findFieldByNumber(fieldId),
                            subMessageBuilder.build());

                    this.messageNameFrames.pop();
                    this.structFrames.pop();
                    this.descriptorFrames.pop();
                    this.countableIndentiferFrames.pop();
                }

            } else {
                // currentStruct.newBuilderForField(currentDescriptor.findFieldByNumber(fieldId));
                com.google.protobuf.DynamicMessage.Builder subMessageBuilder = ProtobufUtils
                        .createMessagePackBuilder(subDescriptor);
                this.countableIndentiferFrames.push(new HashMap<String, Object>());
                this.descriptorFrames.push(subDescriptor);
                this.structFrames.push(subMessageBuilder);
                this.messageNameFrames.push(nestedTypeName);

                visitTypeDefine(node.getTypeDefine(), context);
                currentStruct.setField(currentDescriptor.findFieldByNumber(fieldId), subMessageBuilder.build());

                this.messageNameFrames.pop();
                this.structFrames.pop();
                this.descriptorFrames.pop();
                this.countableIndentiferFrames.pop();

            }
        }
        return null;
    }

    @Override
    public Object visitStatementList(StatementList node, DataReaderAdapter context) throws AstVisitingException {

        Statement[] statements = node.getStatementList();
        for (int i = 0; i < statements.length; i++) {
            visitStatement(statements[i], context);
        }
        return null;
    }

    @Override
    public Object visitStart(Start node, DataReaderAdapter context) throws AstVisitingException {

        String messageName = context.getOuterMessageName();
        com.google.protobuf.DynamicMessage.Builder messageStruct = context.getMessageStruct();
        Descriptor globalDescriptor = context.getMessageDescriptor();
        this.structFrames.push(messageStruct);
        this.messageNameFrames.push(messageName);
        this.descriptorFrames.push(globalDescriptor);
        this.countableIndentiferFrames.push(new HashMap<String, Object>());

        visitStatementList(node.getStatementList(), context);

        this.countableIndentiferFrames.pop();
        this.messageNameFrames.pop();
        this.structFrames.pop();
        this.descriptorFrames.pop();

        return messageStruct;
    }

    @Override
    public Object visitTypeDefine(TypeDefine node, DataReaderAdapter context) throws AstVisitingException {
        if (node instanceof PrimaryType) {
            return visitPrimaryType((PrimaryType) node, context);
        } else {
            return visitCombinationType((CombinationType) node, context);
        }
    }

    @Override
    public Object visitPrimary(Primary node, DataReaderAdapter context) throws AstVisitingException {
        return visitNode(node, context);
    }

    @Override
    public Object visitPrimaryType(PrimaryType node, DataReaderAdapter context) throws AstVisitingException {
        return visitPrimary(node.getPrimary(), context);
    }

    @Override
    public Object visitCombinationType(CombinationType node, DataReaderAdapter context) throws AstVisitingException {
        visitStatementList(node.getStatementList(), context);
        return null;
    }

    @Override
    public Object visitIdentifier(Identifier node, DataReaderAdapter context) throws AstVisitingException {
        return node.getIdentifier();
    }

    @Override
    public Object visitIntegerNumber(IntegerNumber node, DataReaderAdapter context) throws AstVisitingException {
        return Integer.valueOf(node.getValue());
    }

    @Override
    public Object visitPrimaryANSI(PrimaryANSI node, DataReaderAdapter context) throws AstVisitingException {
        try {
            String v = this.getDataInput(context).readANSI();
            return ByteString.copyFrom(v, "ISO8859-1");
        } catch (IOException e) {
            throw new ProtoGeneratingException(e);
        }
    }

    @Override
    public Object visitPrimaryB8UTF(PrimaryB8UTF node, DataReaderAdapter context) throws AstVisitingException {
        try {
            byte[] bs = new byte[node.getLength().getValue()];
            this.getDataInput(context).readFully(bs);
            return new String(bs, "utf-8");
        } catch (IOException e) {
            throw new ProtoGeneratingException(e);
        }
    }

    @Override
    public Object visitPrimaryBASE64(PrimaryBASE64 node, DataReaderAdapter context) throws AstVisitingException {
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            return new String(decoder.decodeBuffer(this.getDataInput(context).readUTF8()), "utf-8");
        } catch (IOException e) {
            throw new ProtoGeneratingException(e);
        }
    }

    @Override
    public Object visitPrimaryBYTES(PrimaryBYTES node, DataReaderAdapter context) throws AstVisitingException {
        try {
            byte[] buf = new byte[node.getLength().getValue()];
            this.getDataInput(context).readFully(buf);
            return ByteString.copyFrom(buf);
        } catch (IOException e) {
            throw new ProtoGeneratingException(e);
        }
    }

    @Override
    public Object visitPrimaryDOUBLE(PrimaryDOUBLE node, DataReaderAdapter context) throws AstVisitingException {
        try {
            double doubleV = this.getDataInput(context).readDouble();
            return doubleV;
        } catch (IOException e) {
            throw new ProtoGeneratingException(e);
        }
    }

    @Override
    public Object visitPrimaryFLOAT(PrimaryFLOAT node, DataReaderAdapter context) throws AstVisitingException {
        try {
            float floatV = this.getDataInput(context).readFloat();
            return floatV;
        } catch (IOException e) {
            throw new ProtoGeneratingException(e);
        }
    }

    @Override
    public Object visitPrimarySINT16(PrimarySINT16 node, DataReaderAdapter context) throws AstVisitingException {
        try {
            short sint16 = this.getDataInput(context).readShort();
            return Integer.valueOf(sint16);
        } catch (IOException e) {
            throw new ProtoGeneratingException(e);
        }
    }

    @Override
    public Object visitPrimarySINT32(PrimarySINT32 node, DataReaderAdapter context) throws AstVisitingException {
        try {
            int sint32 = this.getDataInput(context).readInt();
            return sint32;
        } catch (IOException e) {
            throw new ProtoGeneratingException(e);
        }
    }

    @Override
    public Object visitPrimarySINT64(PrimarySINT64 node, DataReaderAdapter context) throws AstVisitingException {
        try {
            long sint64 = this.getDataInput(context).readLong();
            return sint64;
        } catch (IOException e) {
            throw new ProtoGeneratingException(e);
        }
    }

    @Override
    public Object visitPrimarySINT8(PrimarySINT8 node, DataReaderAdapter context) throws AstVisitingException {
        try {
            byte sint8 = this.getDataInput(context).readByte();
            return Integer.valueOf(sint8);
        } catch (IOException e) {
            throw new ProtoGeneratingException(e);
        }
    }

    @Override
    public Object visitPrimaryUINT16(PrimaryUINT16 node, DataReaderAdapter context) throws AstVisitingException {
        try {
            int uint16 = this.getDataInput(context).readUnsignedShort();
            return uint16;
        } catch (IOException e) {
            throw new ProtoGeneratingException(e);
        }
    }

    @Override
    public Object visitPrimaryUINT32(PrimaryUINT32 node, DataReaderAdapter context) throws AstVisitingException {
        try {
            long uint32 = this.getDataInput(context).readUnsignedInt();
            return uint32;
        } catch (IOException e) {
            throw new ProtoGeneratingException(e);
        }
    }

    @Override
    public Object visitPrimaryUINT8(PrimaryUINT8 node, DataReaderAdapter context) throws AstVisitingException {
        try {
            int uint8 = this.getDataInput(context).readUnsignedByte();
            return uint8;
        } catch (IOException e) {
            throw new ProtoGeneratingException(e);
        }
    }

    @Override
    public Object visitPrimaryUTF8(PrimaryUTF8 node, DataReaderAdapter context) throws AstVisitingException {
        try {
            String utf8 = this.getDataInput(context).readUTF8();
            return utf8;
        } catch (IOException e) {
            throw new ProtoGeneratingException(e);
        }
    }

}
