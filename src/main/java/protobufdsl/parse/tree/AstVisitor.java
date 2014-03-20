package protobufdsl.parse.tree;

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
 * 
 * @author jackcptdev<jackcptdev@gmail.com>
 * 
 * @param <R>
 * @param <C>
 */
public abstract class AstVisitor<R, C> {

    public abstract void init(C context) throws AstVisitingException;

    protected R visitNode(Node node, C context) throws AstVisitingException {
        return node.accept(this, context);
    }

    public R process(Node node, C context) throws AstVisitingException {
        return node.accept(this, context);
    }

    public R visitRepeatedCount(RepeatedCount node, C context) throws AstVisitingException {
        return visitNode(node, context);
    }

    public R visitStatement(Statement node, C context) throws AstVisitingException {
        return visitNode(node, context);
    }

    public R visitStatementList(StatementList node, C context) throws AstVisitingException {
        return visitNode(node, context);
    }

    public R visitStart(Start node, C context) throws AstVisitingException {
        return visitNode(node, context);
    }

    public R visitTypeDefine(TypeDefine node, C context) throws AstVisitingException {
        return visitNode(node, context);
    }

    public R visitPrimary(Primary node, C context) throws AstVisitingException {
        return visitNode(node, context);
    }

    public R visitPrimaryType(PrimaryType node, C context) throws AstVisitingException {
        return visitTypeDefine(node, context);
    }

    public R visitCombinationType(CombinationType node, C context) throws AstVisitingException {
        return visitTypeDefine(node, context);
    }

    public R visitIdentifier(Identifier node, C context) throws AstVisitingException {
        return visitNode(node, context);
    }

    public R visitIntegerNumber(IntegerNumber node, C context) throws AstVisitingException {
        return visitNode(node, context);
    }

    public R visitPrimaryANSI(PrimaryANSI node, C context) throws AstVisitingException {
        return visitNode(node, context);
    }

    public R visitPrimaryB8UTF(PrimaryB8UTF node, C context) throws AstVisitingException {
        return visitNode(node, context);
    }

    public R visitPrimaryBASE64(PrimaryBASE64 node, C context) throws AstVisitingException {
        return visitNode(node, context);
    }

    public R visitPrimaryBYTES(PrimaryBYTES node, C context) throws AstVisitingException {
        return visitNode(node, context);
    }

    public R visitPrimaryDOUBLE(PrimaryDOUBLE node, C context) throws AstVisitingException {
        return visitNode(node, context);
    }

    public R visitPrimaryFLOAT(PrimaryFLOAT node, C context) throws AstVisitingException {
        return visitNode(node, context);
    }

    public R visitPrimarySINT16(PrimarySINT16 node, C context) throws AstVisitingException {
        return visitNode(node, context);
    }

    public R visitPrimarySINT32(PrimarySINT32 node, C context) throws AstVisitingException {
        return visitNode(node, context);
    }

    public R visitPrimarySINT64(PrimarySINT64 node, C context) throws AstVisitingException {
        return visitNode(node, context);
    }

    public R visitPrimarySINT8(PrimarySINT8 node, C context) throws AstVisitingException {
        return visitNode(node, context);
    }

    public R visitPrimaryUINT16(PrimaryUINT16 node, C context) throws AstVisitingException {
        return visitNode(node, context);
    }

    public R visitPrimaryUINT32(PrimaryUINT32 node, C context) throws AstVisitingException {
        return visitNode(node, context);
    }

    public R visitPrimaryUINT8(PrimaryUINT8 node, C context) throws AstVisitingException {
        return visitNode(node, context);
    }

    public R visitPrimaryUTF8(PrimaryUTF8 node, C context) throws AstVisitingException {
        return visitNode(node, context);
    }
}