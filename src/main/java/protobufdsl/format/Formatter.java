package protobufdsl.format;

import protobufdsl.common.Constants;
import protobufdsl.common.Context;
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

import protobufdsl.common.StringUtils;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Feb 26, 2014 6:13:06 PM
 * 
 */
public class Formatter extends AstVisitor<String, Context> {

    @Override
    public void init(Context context) throws AstVisitingException {
        // TODO Auto-generated method stub
        
    }
    
    private final int nextStepSpace = 4;

    @Override
    protected String visitNode(Node node, Context context) throws AstVisitingException {
        return node.accept(this, context);
    }

    @Override
    public String process(Node node, Context context) throws AstVisitingException {
        return super.process(node, context);
    }

    @Override
    public String visitRepeatedCount(RepeatedCount node, Context context) {

        StringBuilder b = new StringBuilder(64);
        b.append("RepeatedCount:");
        b.append("[ RepeatedCountType:" + node.getRepeatedCountType());
        b.append(" , Indentifier:" + visitIdentifier(node.getRepeatedCountRef(), context));
        b.append(" , repeatedCountNumber:" + visitIntegerNumber(node.getRepeatedCount(), context));
        b.append(" ]");

        return b.toString();
    }

    @Override
    public String visitStatement(Statement node, Context context) throws AstVisitingException {
        int spaces = initSpaces(context);
        StringBuilder b = new StringBuilder(64);

        b.append(StringUtils.makeSpaces(spaces));
        b.append("Statement:{");
        b.append("\n");

        b.append(StringUtils.makeSpaces(spaces + nextStepSpace));
        b.append("ProtobufFieldId:" + visitIntegerNumber(node.getProtobufFieldId(), context));
        b.append("\n");

        b.append(StringUtils.makeSpaces(spaces + nextStepSpace));
        b.append("Identifier:" + visitIdentifier(node.getIdentifier(), context));
        b.append("\n");

        b.append(visitTypeDefine(node.getTypeDefine(), context));
        b.append("\n");

        b.append(StringUtils.makeSpaces(spaces));
        b.append("}");

        recoverSpaces(context, spaces);
        return b.toString();
    }

    @Override
    public String visitStatementList(StatementList node, Context context) throws AstVisitingException {

        int spaces = initSpaces(context);
        StringBuilder b = new StringBuilder(64);

        b.append(StringUtils.makeSpaces(spaces));
        b.append("StatementList:{");
        b.append("\n");

        Statement[] ss = node.getStatementList();
        for (int i = 0; i < ss.length; i++) {
            b.append(visitStatement(ss[i], context));
            b.append("\n");
        }

        b.append(StringUtils.makeSpaces(spaces));
        b.append("}");
        b.append("\n");

        recoverSpaces(context, spaces);
        return b.toString();
    }

    @Override
    public String visitStart(Start node, Context context) throws AstVisitingException {
        int spaces = initSpaces(context);
        StringBuilder b = new StringBuilder(64);
        b.append(StringUtils.fillSpaces(spaces, "Start:{\n"));
        b.append(visitStatementList(node.getStatementList(), context));
        b.append("}\n");
        recoverSpaces(context, spaces);
        return b.toString();
    }

    @Override
    public String visitTypeDefine(TypeDefine node, Context context) throws AstVisitingException {
        String r = super.visitTypeDefine(node, context);
        return r;
    }

    @Override
    public String visitPrimaryType(PrimaryType node, Context context) throws AstVisitingException {
        int spaces = initSpaces(context);

        StringBuilder b = new StringBuilder(64);
        b.append(StringUtils.makeSpaces(spaces));
        b.append("PrimaryType:{");
        b.append("\n");

        b.append(StringUtils.makeSpaces(spaces + nextStepSpace));
        b.append("Primary:" + visitPrimary(node.getPrimary(), context));
        b.append("\n");

        b.append(StringUtils.makeSpaces(spaces + nextStepSpace));
        b.append(visitRepeatedCount(node.getRepeatedCount(), context));
        b.append("\n");

        b.append(StringUtils.makeSpaces(spaces));
        b.append("}");

        recoverSpaces(context, spaces);
        return b.toString();
    }

    @Override
    public String visitCombinationType(CombinationType node, Context context) throws AstVisitingException {

        int spaces = initSpaces(context);

        StringBuilder b = new StringBuilder(64);
        b.append(StringUtils.makeSpaces(spaces));
        b.append("CombinationType:{");
        b.append("\n");

        b.append(StringUtils.makeSpaces(spaces + nextStepSpace));
        b.append(visitRepeatedCount(node.getRepeatedCount(), context));
        b.append("\n");

        b.append(visitStatementList(node.getStatementList(), context));

        b.append(StringUtils.makeSpaces(spaces));
        b.append("}");
        // b.append("\n");

        recoverSpaces(context, spaces);

        return b.toString();
    }

    private int initSpaces(Context context) {
        int spaces = context.getInt(Constants.SPACE_COUNT_KEY);
        int nextSpaces = spaces + nextStepSpace;
        context.put(Constants.SPACE_COUNT_KEY, nextSpaces);
        return spaces;
    }

    private void recoverSpaces(Context context, int spaces) {
        context.put(Constants.SPACE_COUNT_KEY, spaces);
    }

    @Override
    public String visitIdentifier(Identifier node, Context context) {
        if (node == null) {
            return "null";
        }
        return node.getIdentifier();
    }

    @Override
    public String visitIntegerNumber(IntegerNumber node, Context context) {
        return String.format("%d", node.getValue());
    }

    @Override
    public String visitPrimaryANSI(PrimaryANSI node, Context context) {
        return node.getName();
    }

    @Override
    public String visitPrimaryB8UTF(PrimaryB8UTF node, Context context) {
        return node.getName();
    }

    @Override
    public String visitPrimaryBASE64(PrimaryBASE64 node, Context context) {
        return node.getName();
    }

    @Override
    public String visitPrimaryBYTES(PrimaryBYTES node, Context context) {
        return node.getName();
    }

    @Override
    public String visitPrimaryDOUBLE(PrimaryDOUBLE node, Context context) {
        return node.getName();
    }

    @Override
    public String visitPrimaryFLOAT(PrimaryFLOAT node, Context context) {
        return node.getName();
    }

    @Override
    public String visitPrimarySINT16(PrimarySINT16 node, Context context) {
        return node.getName();
    }

    @Override
    public String visitPrimarySINT32(PrimarySINT32 node, Context context) {
        return node.getName();
    }

    @Override
    public String visitPrimarySINT64(PrimarySINT64 node, Context context) {
        return node.getName();
    }

    @Override
    public String visitPrimarySINT8(PrimarySINT8 node, Context context) {
        return node.getName();
    }

    @Override
    public String visitPrimaryUINT16(PrimaryUINT16 node, Context context) {
        return node.getName();
    }

    @Override
    public String visitPrimaryUINT32(PrimaryUINT32 node, Context context) {
        return node.getName();
    }

    @Override
    public String visitPrimaryUINT8(PrimaryUINT8 node, Context context) {
        return node.getName();
    }

    @Override
    public String visitPrimaryUTF8(PrimaryUTF8 node, Context context) {
        return node.getName();
    }

}
