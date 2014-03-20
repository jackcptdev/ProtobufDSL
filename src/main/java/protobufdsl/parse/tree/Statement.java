package protobufdsl.parse.tree;

import protobufdsl.common.Utils;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Feb 24, 2014 10:48:46 AM
 * 
 */
public class Statement extends Node {

    private final IntegerNumber protobufFieldId;
    private final Identifier identifier;
    private final TypeDefine typeDefine;

    public Statement(IntegerNumber protoInteger, Identifier identifier, TypeDefine typeDefine) {
        Utils.checkNotNull(protoInteger, identifier, typeDefine);

        this.protobufFieldId = protoInteger;
        this.identifier = identifier;
        this.typeDefine = typeDefine;
    }

    public IntegerNumber getProtobufFieldId() {
        return protobufFieldId;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public TypeDefine getTypeDefine() {
        return typeDefine;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) throws AstVisitingException {
        return visitor.visitStatement(this, context);
    }

    @Override
    public int hashCode() {
        return Utils.hashcode(this.protobufFieldId, this.identifier, this.typeDefine);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }

        Statement o = (Statement) obj;

        return this.protobufFieldId.equals(o.getProtobufFieldId()) && this.identifier.equals(o.getIdentifier())
                && this.typeDefine.equals(o.getTypeDefine());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(64);
        builder.append("Statement:{ ");
        builder.append("protobufFieldId:");
        builder.append(this.protobufFieldId.toString());
        builder.append(" , identifier:");
        builder.append(this.identifier.toString());
        builder.append(" , TypeDefine:");
        builder.append(this.typeDefine.toString());
        builder.append(" }");
        return builder.toString();
    }

}
