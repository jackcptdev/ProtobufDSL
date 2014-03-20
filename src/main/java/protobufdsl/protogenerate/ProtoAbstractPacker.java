package protobufdsl.protogenerate;

import java.util.HashMap;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.DynamicMessage.Builder;

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

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Mar 20, 2014 6:07:54 PM
 * 
 */
public abstract class ProtoAbstractPacker extends AstVisitor<Object, DataReaderAdapter> {

    private final com.google.protobuf.DynamicMessage.Builder[] messageStructsFrames;
    private final Descriptor[] messageStructDescriptorsFrames;
    private final String[] messageNamesFrames;
    private final String[] defineNamesFrames;
    private final HashMap<String, Object>[] countableIdentifiersFrames;
    private int stackIndex = -1;

    public ProtoAbstractPacker(DataReaderAdapter adapter) {
        int dept = adapter.getMaxStructDept() + 1;
        this.messageStructsFrames = new com.google.protobuf.DynamicMessage.Builder[dept];
        this.messageStructDescriptorsFrames = new Descriptor[dept];
        this.messageNamesFrames = new String[dept];
        this.defineNamesFrames = new String[dept];
        this.countableIdentifiersFrames = new HashMap[dept];
    }

    @Override
    public void init(DataReaderAdapter context) throws AstVisitingException {
        String messageName = context.getOuterMessageName();
        if (messageName == null) {
            throw new ProtoGeneratingException("Message name is null.");
        }

        com.google.protobuf.DynamicMessage.Builder messageStruct = context.getMessageStruct();
        if (messageStruct == null) {
            throw new ProtoGeneratingException("Message builder is null.");
        }
    }

    private void enterNewStackFrame(com.google.protobuf.DynamicMessage.Builder messageStruct,
            Descriptor messageDescriptor, String messageName, String defineName) {
        stackIndex++;
        this.messageStructsFrames[stackIndex] = messageStruct;
        this.messageStructDescriptorsFrames[stackIndex] = messageDescriptor;
        this.messageNamesFrames[stackIndex] = messageName;
        this.defineNamesFrames[stackIndex] = defineName;
        this.countableIdentifiersFrames[stackIndex] = new HashMap<String, Object>();
        this.down();
    }

    private void leaveCurrentStackFrame() {
        this.countableIdentifiersFrames[stackIndex].clear();
        this.countableIdentifiersFrames[stackIndex] = null;
        this.messageNamesFrames[stackIndex] = null;
        this.messageStructDescriptorsFrames[stackIndex] = null;
        this.messageStructsFrames[stackIndex] = null;
        this.defineNamesFrames[stackIndex] = null;
        stackIndex--;
        this.up();
    }

    protected abstract void down();

    protected abstract void up();

    protected String getCurrentDefineName() {
        return this.defineNamesFrames[stackIndex];
    }

    protected Builder getCurrentMessageStruct() {
        return this.messageStructsFrames[stackIndex];
    }

    protected String getCurrentMessageName() {
        return this.messageNamesFrames[stackIndex];
    }

    protected Descriptor getCurrentMessageStructDescriptor() {
        return this.messageStructDescriptorsFrames[stackIndex];
    }

    private long getCountableVariable(String identifer) throws ProtoGeneratingException {
        Object v = this.countableIdentifiersFrames[stackIndex].get(identifer);
        if (v == null) {
            throw new ProtoGeneratingException(String.format("Cannot find [ %s ]'s value.", identifer));
        }

        if (v.getClass() == Integer.class) {
            return (Integer) v;
        }

        if (v.getClass() == Long.class) {
            return (Long) v;
        }
        
        return Long.valueOf(v.toString());
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

    private boolean isStatementRepeated(Statement node, long repeatedCount) {
        if (node.getTypeDefine().getRepeatedCount().getRepeatedCountType() == RepeatedCount.REPEATED_COUNT_TYPE_DIRECT) {
            if (repeatedCount == 1) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object visitStatement(Statement node, DataReaderAdapter context) throws AstVisitingException {
        com.google.protobuf.DynamicMessage.Builder currentStruct = this.messageStructsFrames[stackIndex];
        Descriptor currentDescriptor = this.messageStructDescriptorsFrames[stackIndex];
        HashMap<String, Object> currentCountableIdentifiers = this.countableIdentifiersFrames[stackIndex];

        String identifer = (String) visitIdentifier(node.getIdentifier(), context);
        int fieldId = (Integer) visitIntegerNumber(node.getProtobufFieldId(), context);

        context.setCurrentIdentifer(identifer);

        long repeatedCount = (Long) visitRepeatedCount(node.getTypeDefine().getRepeatedCount(), context);

        boolean isRepeated = isStatementRepeated(node, repeatedCount);

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
            Descriptor nestedDescriptor = currentDescriptor.findNestedTypeByName(nestedTypeName);

            if (isRepeated) {

                for (long i = 0; i < repeatedCount; i++) {
                    com.google.protobuf.DynamicMessage.Builder nestedMessageStruct = ProtobufUtils
                            .createMessagePackBuilder(nestedDescriptor);
                    this.enterNewStackFrame(nestedMessageStruct, nestedDescriptor, nestedTypeName, identifer);

                    visitTypeDefine(node.getTypeDefine(), context);
                    currentStruct.addRepeatedField(currentDescriptor.findFieldByNumber(fieldId),
                            nestedMessageStruct.build());

                    this.leaveCurrentStackFrame();
                }

            } else {
                // currentStruct.newBuilderForField(currentDescriptor.findFieldByNumber(fieldId));
                com.google.protobuf.DynamicMessage.Builder nestedMessageStruct = ProtobufUtils
                        .createMessagePackBuilder(nestedDescriptor);
                this.enterNewStackFrame(nestedMessageStruct, nestedDescriptor, nestedTypeName, identifer);

                visitTypeDefine(node.getTypeDefine(), context);
                currentStruct.setField(currentDescriptor.findFieldByNumber(fieldId), nestedMessageStruct.build());

                this.leaveCurrentStackFrame();
            }
        }

        context.setCurrentIdentifer(null);
        return repeatedCount;
    }

    @Override
    public Object visitStatementList(StatementList node, DataReaderAdapter context) throws AstVisitingException {
        Statement[] statements = node.getStatementList();
        for (int i = 0; i < statements.length; i++) {
            visitStatement(statements[i], context);
        }
        return statements.length;
    }

    @Override
    public Object visitStart(Start node, DataReaderAdapter context) throws AstVisitingException {
        String messageName = context.getOuterMessageName();
        com.google.protobuf.DynamicMessage.Builder messageStruct = context.getMessageStruct();
        Descriptor globalDescriptor = context.getMessageDescriptor();

        this.enterNewStackFrame(messageStruct, globalDescriptor, messageName, messageName);

        visitStatementList(node.getStatementList(), context);

        this.leaveCurrentStackFrame();
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
        return visitStatementList(node.getStatementList(), context);
    }

    @Override
    public Object visitIdentifier(Identifier node, DataReaderAdapter context) throws AstVisitingException {
        return node.getIdentifier();
    }

    @Override
    public Object visitIntegerNumber(IntegerNumber node, DataReaderAdapter context) throws AstVisitingException {
        return Integer.valueOf(node.getValue());
    }

    /**
     * return ByteString
     */
    @Override
    public abstract Object visitPrimaryANSI(PrimaryANSI node, DataReaderAdapter context) throws AstVisitingException;

    /**
     * return String
     */
    @Override
    public abstract Object visitPrimaryB8UTF(PrimaryB8UTF node, DataReaderAdapter context) throws AstVisitingException;

    /**
     * return String
     */
    @Override
    public abstract Object visitPrimaryBASE64(PrimaryBASE64 node, DataReaderAdapter context)
            throws AstVisitingException;

    /**
     * return ByteString
     */
    @Override
    public abstract Object visitPrimaryBYTES(PrimaryBYTES node, DataReaderAdapter context) throws AstVisitingException;

    /**
     * return double
     */
    @Override
    public abstract Object visitPrimaryDOUBLE(PrimaryDOUBLE node, DataReaderAdapter context)
            throws AstVisitingException;

    /**
     * return float
     */
    @Override
    public abstract Object visitPrimaryFLOAT(PrimaryFLOAT node, DataReaderAdapter context) throws AstVisitingException;

    /**
     * return Int to cover sint16
     */
    @Override
    public abstract Object visitPrimarySINT16(PrimarySINT16 node, DataReaderAdapter context)
            throws AstVisitingException;

    /**
     * return Int just for sint32
     */
    @Override
    public abstract Object visitPrimarySINT32(PrimarySINT32 node, DataReaderAdapter context)
            throws AstVisitingException;

    /**
     * return Long just for sint64
     */
    @Override
    public abstract Object visitPrimarySINT64(PrimarySINT64 node, DataReaderAdapter context)
            throws AstVisitingException;

    /**
     * return Int to cover sint8
     */
    @Override
    public abstract Object visitPrimarySINT8(PrimarySINT8 node, DataReaderAdapter context) throws AstVisitingException;

    /**
     * return Int to cover uint16
     */
    @Override
    public abstract Object visitPrimaryUINT16(PrimaryUINT16 node, DataReaderAdapter context)
            throws AstVisitingException;

    /**
     * return Long to cover uint32
     */
    @Override
    public abstract Object visitPrimaryUINT32(PrimaryUINT32 node, DataReaderAdapter context)
            throws AstVisitingException;

    /**
     * return Int to cover uint8
     */
    @Override
    public abstract Object visitPrimaryUINT8(PrimaryUINT8 node, DataReaderAdapter context) throws AstVisitingException;

    /**
     * return String
     */
    @Override
    public abstract Object visitPrimaryUTF8(PrimaryUTF8 node, DataReaderAdapter context) throws AstVisitingException;

}
