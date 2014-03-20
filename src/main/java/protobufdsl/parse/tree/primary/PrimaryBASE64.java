package protobufdsl.parse.tree.primary;

import protobufdsl.parse.tree.AstVisitingException;
import protobufdsl.parse.tree.AstVisitor;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Feb 21, 2014 6:11:35 PM
 * 
 */
public class PrimaryBASE64 extends Primary {

    public static final String name = "BASE64";

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) throws AstVisitingException {
        return visitor.visitPrimaryBASE64(this, context);
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
