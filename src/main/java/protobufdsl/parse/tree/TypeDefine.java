package protobufdsl.parse.tree;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Feb 24, 2014 10:53:19 AM
 * 
 */
public abstract class TypeDefine extends Node {

    // private final int repeatedCount;
    private final RepeatedCount repeatedCount;

    public TypeDefine(RepeatedCount repeatedCount) {
        this.repeatedCount = repeatedCount;
    }

    public RepeatedCount getRepeatedCount() {
        return repeatedCount;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) throws AstVisitingException {
        return visitor.visitTypeDefine(this, context);
    }

}
