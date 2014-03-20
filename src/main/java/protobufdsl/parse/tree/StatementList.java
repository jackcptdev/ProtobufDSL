package protobufdsl.parse.tree;

import protobufdsl.common.Utils;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Feb 24, 2014 10:49:11 AM
 * 
 */
public class StatementList extends Node {

    private final Statement[] statementList;

    public StatementList(Statement[] statementList) {
        if (statementList == null) {
            throw new IllegalArgumentException("StatementList is null.");
        }
        this.statementList = statementList;
    }

    public Statement[] getStatementList() {
        return statementList;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) throws AstVisitingException {
        return visitor.visitStatementList(this, context);
    }

    @Override
    public int hashCode() {
        return Utils.hashcode((Object[]) statementList);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }

        StatementList o = (StatementList) obj;

        if (this.statementList == null && o.getStatementList() == null) {
            return true;
        }

        if ((this.statementList == null && o.getStatementList() != null)
                || (this.statementList != null && o.getStatementList() == null)) {
            return false;
        }

        if ((this.statementList != null && o.getStatementList() != null)
                && (this.statementList.length != o.getStatementList().length)) {
            return false;
        }

        for (int i = 0; i < this.statementList.length; i++) {
            Statement a = this.statementList[i];
            Statement b = o.getStatementList()[i];
            if (!Utils.objEquals(a, b)) {
                return false;
            }
        }
        return true;

    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder(64);

        if (this.statementList == null) {
            builder.append("StatementList:Empty ");
        } else {
            builder.append("StatementList:{ ");
            for (int i = 0; i < this.statementList.length; i++) {
                Statement s = this.statementList[i];
                builder.append(s == null ? "null" : s.toString());
                if (i != this.statementList.length - 1) {
                    builder.append(", ");
                }
            }
            builder.append(" }");
        }
        return builder.toString();
    }

}
