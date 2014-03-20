package protobufdsl.protogenerate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import com.google.protobuf.DescriptorProtos.DescriptorProto;
import com.google.protobuf.DescriptorProtos.DescriptorProto.Builder;
import com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Label;

import protobufdsl.common.Constants;
import protobufdsl.common.Context;
import protobufdsl.common.Countable;
import protobufdsl.common.Uncountable;
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
 * @version Mar 17, 2014 3:55:59 PM
 * 
 */
public class ProtoMessageStructGenerator extends AstVisitor<Object, Context> {

    private static final String CURRENT_FIELD_NAME = "current.field.name.key";
    private static final String CURRENT_FIELD_LABEL = "current.field.label.key";

    // for checking duplicated identifiers
    private final Stack<HashSet<String>> identifierFrames = new Stack<HashSet<String>>();
    // for chekcing duplicated fieldId
    private final Stack<HashSet<Integer>> fieldIdFrames = new Stack<HashSet<Integer>>();

    private final Stack<HashMap<String, Object>> identifiers2valuesFrames = new Stack<HashMap<String, Object>>();
    private final Stack<HashSet<String>> refIdentifersFrames = new Stack<HashSet<String>>();

    private final Stack<DescriptorProto.Builder> messageStuctBuilderFrames = new Stack<DescriptorProto.Builder>();
    private final Stack<String> messageNameFrames = new Stack<String>();

    private int dept = 0;
    private int maxDept = -1;

    public int getMaxDept() {
        return maxDept;
    }

    private void updateMaxDept(int dept) {
        maxDept = dept > maxDept ? dept : maxDept;
    }

    @Override
    public void init(Context context) throws AstVisitingException {

    }

    private String chainMessageScopes() {
        StringBuilder builder = new StringBuilder(64);
        for (int i = 0; i < messageNameFrames.size(); i++) {
            String o = messageNameFrames.get(i);
            builder.append(o);
            if (i != messageNameFrames.size() - 1) {
                builder.append('.');
            }
        }
        return builder.toString();
    }

    @Override
    protected Object visitNode(Node node, Context context) throws AstVisitingException {
        return node.accept(this, context);
    }

    @Override
    public Object process(Node node, Context context) throws AstVisitingException {
        return super.process(node, context);
    }

    @Override
    public Object visitRepeatedCount(RepeatedCount node, Context context) throws AstVisitingException {
        return super.visitRepeatedCount(node, context);
    }

    @Override
    public Object visitStatement(Statement node, Context context) throws AstVisitingException {

        HashMap<String, Object> currentIdentifiers2Values = this.identifiers2valuesFrames.peek();
        Set<String> currentRefIdentifiers = this.refIdentifersFrames.peek();

        String fieldName = (String) visitIdentifier(node.getIdentifier(), context);
        Integer fieldNumber = (Integer) visitIntegerNumber(node.getProtobufFieldId(), context);

        // check duplicated identifier name
        HashSet<String> identifiersInCurrentFrame = identifierFrames.peek();
        if (identifiersInCurrentFrame.contains(fieldName)) {
            throw new ProtoGeneratingException(String.format("Duplicated identifier [ %s ] in message [ %s ].",
                    fieldName, chainMessageScopes()));
        }
        identifiersInCurrentFrame.add(fieldName);

        // check dunplicated field id
        HashSet<Integer> fieldIdFrame = fieldIdFrames.peek();
        if (fieldIdFrame.contains(Integer.valueOf(fieldNumber))) {
            throw new ProtoGeneratingException(String.format("Duplicated field id [ %d ] in message [ %s ].",
                    fieldNumber, chainMessageScopes()));
        }
        fieldIdFrame.add(Integer.valueOf(fieldNumber));

        // find field's label (repeated or optional)
        com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Label label = com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED;
        int reppeatedCount = node.getTypeDefine().getRepeatedCount().getRepeatedCount().getValue();

        if (node.getTypeDefine().getRepeatedCount().getRepeatedCountType() == RepeatedCount.REPEATED_COUNT_TYPE_DIRECT) {
            if (reppeatedCount == 1) {
                label = com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL;
            }
        } else {
            // if repeated count is a Ref, check if the Ref exists or not.
            String ref = node.getTypeDefine().getRepeatedCount().getRepeatedCountRef().getIdentifier();
            if (!currentIdentifiers2Values.containsKey(ref)) {
                throw new ProtoGeneratingException(String.format(
                        "[ %s ] does not exists before [ %s ] in the same pack.", ref, fieldName));
            }
            // add ref to set
            currentRefIdentifiers.add(ref);
        }

        Builder currentStruct = this.messageStuctBuilderFrames.peek();

        boolean isPrimary = (node.getTypeDefine() instanceof PrimaryType);
        if (isPrimary) {
            context.put(CURRENT_FIELD_NAME, fieldName);
            context.put(CURRENT_FIELD_LABEL, label);

            Object type = visitTypeDefine(node.getTypeDefine(), context);
            ProtobufUtils.addFieldToStruct(currentStruct, fieldName, fieldNumber,
                    (com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type) type, label);

            context.remove(CURRENT_FIELD_NAME);
            context.remove(CURRENT_FIELD_LABEL);
        } else {

            // if field is not primary , the field is not countable
            currentIdentifiers2Values.put(fieldName, Uncountable.instance);

            String nestedMessageStructName = StringUtils.nestedTypeName(fieldName);
            Builder nestedStruct = ProtobufUtils.createMessageStruct(nestedMessageStructName);
            this.messageNameFrames.push(nestedMessageStructName);
            this.messageStuctBuilderFrames.push(nestedStruct);
            this.identifiers2valuesFrames.push(new HashMap<String, Object>());
            this.refIdentifersFrames.push(new HashSet<String>());

            this.dept++;
            this.updateMaxDept(dept);

            // create nested type
            visitTypeDefine(node.getTypeDefine(), context);

            this.dept--;

            HashMap<String, Object> finishFrame = this.identifiers2valuesFrames.pop();
            Set<String> finishSavedIdentifier = this.refIdentifersFrames.pop();
            // check Ref
            checkRefIdentifiers(finishFrame, finishSavedIdentifier);

            // add nested type to current struct
            currentStruct.addNestedType(nestedStruct);
            ProtobufUtils.addFieldToStruct(currentStruct, fieldName, fieldNumber, nestedMessageStructName, label);

            this.messageNameFrames.pop();
            this.messageStuctBuilderFrames.pop();
        }

        return null;

    }

    /**
     * check all Ref in current frame, check existing and countable
     * 
     * @param currentAllIdentifiers
     * @param currentRefIdentifers
     * @throws ProtoGeneratingException
     */
    private void checkRefIdentifiers(HashMap<String, Object> currentAllIdentifiers, Set<String> currentRefIdentifers)
            throws ProtoGeneratingException {
        for (String s : currentRefIdentifers) {
            Object c = currentAllIdentifiers.get(s);
            if (c == null) {
                throw new ProtoGeneratingException(String.format("[ %s ] is not define.", s));
            }
            if (!(c instanceof Countable)) {
                throw new ProtoGeneratingException(String.format("[ %s ] is not countable.", s));
            }
        }
    }

    @Override
    public Object visitStatementList(StatementList node, Context context) throws AstVisitingException {

        HashSet<String> identifierFrame = new HashSet<String>();
        identifierFrames.push(identifierFrame);

        HashSet<Integer> fieldIdFrame = new HashSet<Integer>();
        fieldIdFrames.push(fieldIdFrame);

        Statement[] statements = node.getStatementList();
        for (int i = 0; i < statements.length; i++) {
            visitStatement(statements[i], context);
        }

        identifierFrame = identifierFrames.pop();
        identifierFrame.clear();

        fieldIdFrame = fieldIdFrames.pop();
        fieldIdFrame.clear();

        return null;
    }

    @Override
    public Object visitStart(Start node, Context context) throws AstVisitingException {

        String messageName = context.getString(Constants.PROTO_OUTER_MESSAGE_NAME_KEY);
        if (messageName == null) {
            throw new ProtoGeneratingException("Message name is null.");
        }

        this.messageNameFrames.push(messageName);
        Builder globalStruct = ProtobufUtils.createMessageStruct(messageName);
        this.messageStuctBuilderFrames.push(globalStruct);

        this.identifiers2valuesFrames.push(new HashMap<String, Object>());
        this.refIdentifersFrames.push(new HashSet<String>());

        this.dept++;
        this.updateMaxDept(this.dept);

        visitStatementList(node.getStatementList(), context);

        this.dept--;

        HashMap<String, Object> finishIdentifers = this.identifiers2valuesFrames.pop();
        Set<String> finishSavedIdentifers = this.refIdentifersFrames.pop();

        checkRefIdentifiers(finishIdentifers, finishSavedIdentifers);

        this.messageNameFrames.pop();
        this.messageStuctBuilderFrames.pop();
        return globalStruct;
    }

    @Override
    public Object visitTypeDefine(TypeDefine node, Context context) throws AstVisitingException {

        if (node instanceof PrimaryType) {
            return visitPrimaryType((PrimaryType) node, context);
        } else {
            return visitCombinationType((CombinationType) node, context);
        }
    }

    @Override
    public Object visitPrimary(Primary node, Context context) throws AstVisitingException {
        return visitNode(node, context);
    }

    @Override
    public Object visitPrimaryType(PrimaryType node, Context context) throws AstVisitingException {
        return visitPrimary(node.getPrimary(), context);
    }

    @Override
    public Object visitCombinationType(CombinationType node, Context context) throws AstVisitingException {
        visitStatementList(node.getStatementList(), context);
        return null;
    }

    @Override
    public Object visitIdentifier(Identifier node, Context context) throws AstVisitingException {
        return node.getIdentifier();
    }

    @Override
    public Object visitIntegerNumber(IntegerNumber node, Context context) throws AstVisitingException {
        return Integer.valueOf(node.getValue());
    }

    private void registerIdentiferType(Primary node, Context context) {
        HashMap<String, Object> currentIdentifiers = this.identifiers2valuesFrames.peek();
        com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Label label = (Label) context
                .get(CURRENT_FIELD_LABEL);
        if (label == com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL) {
            currentIdentifiers.put(context.getString(CURRENT_FIELD_NAME), node);
        } else {
            currentIdentifiers.put(context.getString(CURRENT_FIELD_NAME), Uncountable.instance);
        }
    }

    @Override
    public Object visitPrimaryANSI(PrimaryANSI node, Context context) throws AstVisitingException {
        registerIdentiferType(node, context);
        return com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_BYTES;
    }

    @Override
    public Object visitPrimaryB8UTF(PrimaryB8UTF node, Context context) throws AstVisitingException {
        registerIdentiferType(node, context);
        return com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_STRING;
    }

    @Override
    public Object visitPrimaryBASE64(PrimaryBASE64 node, Context context) throws AstVisitingException {
        registerIdentiferType(node, context);
        return com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_STRING;
    }

    @Override
    public Object visitPrimaryBYTES(PrimaryBYTES node, Context context) throws AstVisitingException {
        registerIdentiferType(node, context);
        return com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_BYTES;
    }

    @Override
    public Object visitPrimaryDOUBLE(PrimaryDOUBLE node, Context context) throws AstVisitingException {
        registerIdentiferType(node, context);
        return com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE;
    }

    @Override
    public Object visitPrimaryFLOAT(PrimaryFLOAT node, Context context) throws AstVisitingException {
        registerIdentiferType(node, context);
        return com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_FLOAT;
    }

    @Override
    public Object visitPrimarySINT16(PrimarySINT16 node, Context context) throws AstVisitingException {
        registerIdentiferType(node, context);
        return com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_SINT32;
    }

    @Override
    public Object visitPrimarySINT32(PrimarySINT32 node, Context context) throws AstVisitingException {
        registerIdentiferType(node, context);
        return com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_SINT32;
    }

    @Override
    public Object visitPrimarySINT64(PrimarySINT64 node, Context context) throws AstVisitingException {
        registerIdentiferType(node, context);
        return com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_SINT64;
    }

    @Override
    public Object visitPrimarySINT8(PrimarySINT8 node, Context context) throws AstVisitingException {
        registerIdentiferType(node, context);
        return com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_SINT32;
    }

    @Override
    public Object visitPrimaryUINT16(PrimaryUINT16 node, Context context) throws AstVisitingException {
        registerIdentiferType(node, context);
        return com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT32;
    }

    @Override
    public Object visitPrimaryUINT32(PrimaryUINT32 node, Context context) throws AstVisitingException {
        registerIdentiferType(node, context);
        return com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64;
    }

    @Override
    public Object visitPrimaryUINT8(PrimaryUINT8 node, Context context) throws AstVisitingException {
        registerIdentiferType(node, context);
        return com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT32;
    }

    @Override
    public Object visitPrimaryUTF8(PrimaryUTF8 node, Context context) throws AstVisitingException {
        registerIdentiferType(node, context);
        return com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_STRING;
    }

}
