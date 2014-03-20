package protobufdsl.parse.tree;

import protobufdsl.common.Utils;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Feb 24, 2014 5:44:22 PM
 * 
 */
public class Start extends Node {

    private final StatementList statementList;

    public Start(StatementList statementList) {
        Utils.checkNotNull(statementList);
        this.statementList = statementList;
    }

    public StatementList getStatementList() {
        return statementList;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) throws AstVisitingException {
        return visitor.visitStart(this, context);
    }

    @Override
    public int hashCode() {
        return this.statementList == null ? 0 : this.statementList.hashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        } else if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }

        Start o = (Start) obj;
        return this.statementList.equals(o.getStatementList());
    }

    @Override
    public String toString() {
        return String.format("Start: %s", this.statementList.toString());
    }

}
