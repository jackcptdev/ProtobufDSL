package protobufdsl.parse.tree;

import protobufdsl.common.Utils;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Feb 24, 2014 4:18:05 PM
 * 
 */
public class Identifier extends Node {

    private final String identifier;

    public Identifier(String identifier) {
        Utils.checkNotNull(identifier);
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) throws AstVisitingException {
        return visitor.visitIdentifier(this, context);
    }

    @Override
    public int hashCode() {
        return identifier.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        Identifier o = (Identifier) obj;
        return this.identifier.equals(o.getIdentifier());

    }

    @Override
    public String toString() {
        return String.format("Identifier:%s", this.identifier);
    }

}
