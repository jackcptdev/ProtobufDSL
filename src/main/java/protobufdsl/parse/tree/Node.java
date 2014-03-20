package protobufdsl.parse.tree;

/**
 * 
 * @author jackcptdev<jackcptdev@gmail.com>
 * 
 */
public abstract class Node {
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) throws AstVisitingException {
        return visitor.visitNode(this, context);
    }

    // Force subclasses to have a proper equals and hashcode implementation
    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract String toString();
}
