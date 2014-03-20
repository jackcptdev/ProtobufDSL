package protobufdsl.parse.tree;

import protobufdsl.common.Utils;
import protobufdsl.parse.tree.primary.Primary;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Feb 24, 2014 10:42:41 AM
 * 
 */
public class PrimaryType extends TypeDefine {

    private final Primary primary;

    public PrimaryType(Primary primary, RepeatedCount repeatedCount) {
        super(repeatedCount == null ? new RepeatedCount(new IntegerNumber(1)) : repeatedCount);
        Utils.checkNotNull(primary);
        this.primary = primary;
    }

    public Primary getPrimary() {
        return primary;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) throws AstVisitingException {
        return visitor.visitPrimaryType(this, context);
    }

    @Override
    public int hashCode() {
        return Utils.hashcode(this.getRepeatedCount(), this.primary);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }

        PrimaryType o = (PrimaryType) obj;

        return this.getRepeatedCount().equals(o.getRepeatedCount()) && this.primary.equals(o.getPrimary());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(64);
        builder.append("PrimaryType:{ ");
        builder.append("repeatedCount:");
        builder.append(this.getRepeatedCount().toString());
        builder.append(" , ");
        builder.append("primary:");
        builder.append(this.primary.toString());
        builder.append(" }");
        return builder.toString();
    }

}
