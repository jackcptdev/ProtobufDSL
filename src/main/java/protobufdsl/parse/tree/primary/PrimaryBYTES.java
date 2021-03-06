package protobufdsl.parse.tree.primary;

import protobufdsl.parse.tree.AstVisitingException;
import protobufdsl.parse.tree.AstVisitor;
import protobufdsl.parse.tree.IntegerNumber;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Feb 21, 2014 6:09:19 PM
 * 
 */
public class PrimaryBYTES extends Primary {

    public static final String name = "BYTES";

    private final IntegerNumber length;

    public PrimaryBYTES(IntegerNumber length) {
        this.length = length == null ? new IntegerNumber(0) : length;
    }

    public IntegerNumber getLength() {
        return length;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) throws AstVisitingException {
        return visitor.visitPrimaryBYTES(this, context);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
