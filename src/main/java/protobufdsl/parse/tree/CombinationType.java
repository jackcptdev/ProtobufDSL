package protobufdsl.parse.tree;

import protobufdsl.common.Utils;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Feb 24, 2014 10:48:17 AM
 * 
 */
public class CombinationType extends TypeDefine {

    private final StatementList statementList;

    public CombinationType(StatementList statementList, RepeatedCount repeatedCount) {
        super(repeatedCount == null ? new RepeatedCount(new IntegerNumber(1)) : repeatedCount);
        Utils.checkNotNull(statementList);
        this.statementList = statementList;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) throws AstVisitingException {
        return visitor.visitCombinationType(this, context);
    }

    public StatementList getStatementList() {
        return statementList;
    }

    @Override
    public int hashCode() {
        return Utils.hashcode(this.getRepeatedCount(), this.statementList);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }

        CombinationType o = (CombinationType) obj;

        return this.getRepeatedCount().equals(o.getRepeatedCount()) && this.statementList.equals(o.getStatementList());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(64);
        builder.append("CombinationType:{ ");
        builder.append("repeatedCount:");
        builder.append(this.getRepeatedCount().toString());
        builder.append(" , ");
        builder.append("statementList:");
        builder.append(this.statementList.toString());
        builder.append(" }");
        return builder.toString();
    }

}
