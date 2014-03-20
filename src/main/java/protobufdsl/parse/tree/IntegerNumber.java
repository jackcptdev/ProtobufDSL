package protobufdsl.parse.tree;

/**
 * 
 * @author jackcptdev<jackcptdev@gmail.com>
 * 
 */
public class IntegerNumber extends Node {

    private final int value;

    public IntegerNumber(Integer value, int defaultValue) {
        this.value = value == null ? defaultValue : value;
    }

    public IntegerNumber(Integer value) {
        this(value, 0);
    }

    public int getValue() {
        return value;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) throws AstVisitingException {
        return visitor.visitIntegerNumber(this, context);
    }

    @Override
    public int hashCode() {
        return this.value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        IntegerNumber o = (IntegerNumber) obj;
        return this.value == o.getValue();
    }

    @Override
    public String toString() {
        return String.format("IntegerNumber:%d", this.value);
    }

}
