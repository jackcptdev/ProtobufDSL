package protobufdsl.parse.tree;

import protobufdsl.common.Utils;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Feb 26, 2014 10:56:36 AM
 * 
 */
public class RepeatedCount extends Node {

    public static final int REPEATED_COUNT_TYPE_DIRECT = 1;
    public static final int REPEATED_COUNT_TYPE_REF = 2;

    private final IntegerNumber repeatedCount;
    private final Identifier repeatedCountRef;
    private final int repeatedCountType;

    public RepeatedCount(IntegerNumber value, int defaultValue) {
        this.repeatedCount = value == null ? new IntegerNumber(defaultValue) : value;
        this.repeatedCountType = REPEATED_COUNT_TYPE_DIRECT;
        this.repeatedCountRef = null;
    }

    public RepeatedCount(IntegerNumber value) {
        this(value, 1);
    }

    public RepeatedCount(Identifier identifier) {
        Utils.checkNotNull(identifier);
        this.repeatedCount = new IntegerNumber(-1);
        this.repeatedCountRef = identifier;
        this.repeatedCountType = REPEATED_COUNT_TYPE_REF;
    }

    public IntegerNumber getRepeatedCount() {
        return repeatedCount;
    }

    public Identifier getRepeatedCountRef() {
        return repeatedCountRef;
    }

    public int getRepeatedCountType() {
        return repeatedCountType;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) throws AstVisitingException {
        return visitor.visitRepeatedCount(this, context);
    }

    @Override
    public int hashCode() {
        return Utils.hashcode(this.repeatedCount, this.repeatedCountRef, this.repeatedCountType);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }

        RepeatedCount o = (RepeatedCount) obj;
        if (this.repeatedCountType != o.getRepeatedCountType()) {
            return false;
        }

        return Utils.objEquals(this.repeatedCount, o.getRepeatedCount())
                && Utils.objEquals(this.repeatedCountRef, o.getRepeatedCountRef());

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(64);
        builder.append("RepeatedCount:{ ");
        builder.append("repeatedCountType:");
        builder.append(this.repeatedCountType);
        builder.append(" , repeatedCount:");
        if (this.repeatedCount != null) {
            builder.append(this.repeatedCount.toString());
        } else {
            builder.append("null");
        }

        builder.append(" , repeatedCountRef:");
        if (this.repeatedCountRef != null) {
            builder.append(this.repeatedCountRef.toString());
        } else {
            builder.append("null");
        }
        builder.append(" }");
        return builder.toString();
    }

}
