package protobufdsl.protogenerate;

import java.util.HashSet;
import java.util.Stack;

import protobufdsl.common.Constants;
import protobufdsl.common.Context;
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
 * @version Mar 10, 2014 10:33:41 AM
 * 
 */
public class ProtoRuleGenerator extends AstVisitor<String, Context> {

    @Override
    public void init(Context context) throws AstVisitingException {
        // TODO Auto-generated method stub
    }

    private final int nextStepSpace = 4;
    private final Stack<HashSet<String>> identifierFrames = new Stack<HashSet<String>>();
    private final Stack<HashSet<Integer>> fieldIdFrames = new Stack<HashSet<Integer>>();
    private final Stack<String> messageScopeName = new Stack<String>();

    private int initSpaces(Context context) {
        int spaces = context.getInt(Constants.SPACE_COUNT_KEY);
        int nextSpaces = spaces + nextStepSpace;
        context.put(Constants.SPACE_COUNT_KEY, nextSpaces);
        return spaces;
    }

    private void recoverSpaces(Context context, int spaces) {
        context.put(Constants.SPACE_COUNT_KEY, spaces);
    }

    private String chainMessageScopes() {
        StringBuilder builder = new StringBuilder(64);
        for (int i = 0; i < messageScopeName.size(); i++) {
            String o = messageScopeName.get(i);
            builder.append(o);
            if (i != messageScopeName.size() - 1) {
                builder.append('.');
            }
        }
        return builder.toString();
    }

    @Override
    protected String visitNode(Node node, Context context) throws AstVisitingException {
        return node.accept(this, context);
    }

    @Override
    public String process(Node node, Context context) throws AstVisitingException {
        return super.process(node, context);
    }

    @Override
    public String visitRepeatedCount(RepeatedCount node, Context context) throws AstVisitingException {
        return super.visitRepeatedCount(node, context);
    }

    @Override
    public String visitStatement(Statement node, Context context) throws AstVisitingException {
        int spaces = initSpaces(context);
        // check duplicated identifier
        String name = visitIdentifier(node.getIdentifier(), context);
        HashSet<String> identifiersInCurrentFrame = identifierFrames.peek();
        if (identifiersInCurrentFrame.contains(name)) {
            throw new ProtoGeneratingException(String.format("Duplicated identifier [ %s ] in message [ %s ].", name,
                    chainMessageScopes()));
        }
        identifiersInCurrentFrame.add(name);

        // check dunplicated field id
        int pid = node.getProtobufFieldId().getValue();
        HashSet<Integer> fieldIdFrame = fieldIdFrames.peek();
        if (fieldIdFrame.contains(Integer.valueOf(pid))) {
            throw new ProtoGeneratingException(String.format("Duplicated field id [ %d ] in message [ %s ].", pid,
                    chainMessageScopes()));
        }
        fieldIdFrame.add(Integer.valueOf(pid));

        String prefix = "repeated";
        int reppeatedCount = node.getTypeDefine().getRepeatedCount().getRepeatedCount().getValue();

        if (node.getTypeDefine().getRepeatedCount().getRepeatedCountType() == RepeatedCount.REPEATED_COUNT_TYPE_DIRECT) {
            if (reppeatedCount == 1) {
                prefix = "optional";
            }
        }

        boolean isPrimary = (node.getTypeDefine() instanceof PrimaryType);
        String typeName = null;
        String messageDefine = null;
        if (isPrimary) {
            typeName = visitTypeDefine(node.getTypeDefine(), context);
        } else {
            recoverSpaces(context, spaces);
            messageScopeName.push(name);
            messageDefine = visitTypeDefine(node.getTypeDefine(), context);
            messageScopeName.pop();
        }
        StringBuilder builder = new StringBuilder(64);

        if (!isPrimary) {
            typeName = StringUtils.nestedTypeName(name);
            builder.append(StringUtils.makeSpaces(spaces));
            builder.append("message ");
            builder.append(typeName);
            builder.append(" {\n");
            builder.append(messageDefine);
            builder.append(StringUtils.makeSpaces(spaces));
            builder.append("}");
            builder.append("\n");
        }

        builder.append(StringUtils.makeSpaces(spaces));
        builder.append(prefix);
        builder.append(' ');
        builder.append(typeName);
        builder.append(' ');
        builder.append(name);
        builder.append(" = ");
        builder.append(pid);
        builder.append(";");

        recoverSpaces(context, spaces);
        return builder.toString();
    }

    @Override
    public String visitStatementList(StatementList node, Context context) throws AstVisitingException {
        int spaces = initSpaces(context);

        HashSet<String> identifierFrame = new HashSet<String>();
        identifierFrames.push(identifierFrame);

        HashSet<Integer> fieldIdFrame = new HashSet<Integer>();
        fieldIdFrames.push(fieldIdFrame);

        StringBuilder builder = new StringBuilder(256);

        Statement[] statements = node.getStatementList();
        for (int i = 0; i < statements.length; i++) {
            String r = visitStatement(statements[i], context);
            builder.append(r);
            builder.append("\n");
        }
        recoverSpaces(context, spaces);

        identifierFrame = identifierFrames.pop();
        identifierFrame.clear();

        fieldIdFrame = fieldIdFrames.pop();
        fieldIdFrame.clear();

        return builder.toString();
    }

    @Override
    public String visitStart(Start node, Context context) throws AstVisitingException {

        String messageName = context.getString(Constants.PROTO_OUTER_MESSAGE_NAME_KEY);
        if (messageName == null) {
            throw new ProtoGeneratingException("Message name is null.");
        }

        messageScopeName.push(messageName);

        StringBuilder builder = new StringBuilder(256);
        builder.append("message ");
        builder.append(messageName);
        builder.append(" {\n");
        builder.append(visitStatementList(node.getStatementList(), context));
        builder.append("}");

        messageScopeName.pop();
        return builder.toString();
    }

    @Override
    public String visitTypeDefine(TypeDefine node, Context context) throws AstVisitingException {
        return super.visitTypeDefine(node, context);
    }

    @Override
    public String visitPrimary(Primary node, Context context) throws AstVisitingException {
        return super.visitPrimary(node, context);
    }

    @Override
    public String visitPrimaryType(PrimaryType node, Context context) throws AstVisitingException {
        return visitPrimary(node.getPrimary(), context);
    }

    @Override
    public String visitCombinationType(CombinationType node, Context context) throws AstVisitingException {
        return visitStatementList(node.getStatementList(), context);
    }

    @Override
    public String visitIdentifier(Identifier node, Context context) throws AstVisitingException {
        return node.getIdentifier();
    }

    @Override
    public String visitIntegerNumber(IntegerNumber node, Context context) throws AstVisitingException {
        return String.valueOf(node.getValue());
    }

    @Override
    public String visitPrimaryANSI(PrimaryANSI node, Context context) throws AstVisitingException {
        return "bytes";
    }

    @Override
    public String visitPrimaryB8UTF(PrimaryB8UTF node, Context context) throws AstVisitingException {
        return "string";
    }

    @Override
    public String visitPrimaryBASE64(PrimaryBASE64 node, Context context) throws AstVisitingException {
        return "string";
    }

    @Override
    public String visitPrimaryBYTES(PrimaryBYTES node, Context context) throws AstVisitingException {
        return "bytes";
    }

    @Override
    public String visitPrimaryDOUBLE(PrimaryDOUBLE node, Context context) throws AstVisitingException {
        return "double";
    }

    @Override
    public String visitPrimaryFLOAT(PrimaryFLOAT node, Context context) throws AstVisitingException {
        return "float";
    }

    @Override
    public String visitPrimarySINT16(PrimarySINT16 node, Context context) throws AstVisitingException {
        return "sint32";
    }

    @Override
    public String visitPrimarySINT32(PrimarySINT32 node, Context context) throws AstVisitingException {
        return "sint32";
    }

    @Override
    public String visitPrimarySINT64(PrimarySINT64 node, Context context) throws AstVisitingException {
        return "sint64";
    }

    @Override
    public String visitPrimarySINT8(PrimarySINT8 node, Context context) throws AstVisitingException {
        return "sint32";
    }

    @Override
    public String visitPrimaryUINT16(PrimaryUINT16 node, Context context) throws AstVisitingException {
        return "int32";
    }

    @Override
    public String visitPrimaryUINT32(PrimaryUINT32 node, Context context) throws AstVisitingException {
        return "int64";
    }

    @Override
    public String visitPrimaryUINT8(PrimaryUINT8 node, Context context) throws AstVisitingException {
        return "int32";
    }

    @Override
    public String visitPrimaryUTF8(PrimaryUTF8 node, Context context) throws AstVisitingException {
        return "string";
    }

}
