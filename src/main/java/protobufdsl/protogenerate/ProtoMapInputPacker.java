package protobufdsl.protogenerate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.google.protobuf.ByteString;

import protobufdsl.common.DataReaderAdapter;
import protobufdsl.parse.tree.AstVisitingException;
import protobufdsl.parse.tree.primary.PrimaryANSI;
import protobufdsl.parse.tree.primary.PrimaryB8UTF;
import protobufdsl.parse.tree.primary.PrimaryBASE64;
import protobufdsl.parse.tree.primary.PrimaryBYTES;
import protobufdsl.parse.tree.primary.PrimaryDOUBLE;
import protobufdsl.parse.tree.primary.PrimaryFLOAT;
import protobufdsl.parse.tree.primary.PrimarySINT16;
import protobufdsl.parse.tree.primary.PrimarySINT32;
import protobufdsl.parse.tree.primary.PrimarySINT64;
import protobufdsl.parse.tree.primary.PrimarySINT8;
import protobufdsl.parse.tree.primary.PrimaryUINT16;
import protobufdsl.parse.tree.primary.PrimaryUINT32;
import protobufdsl.parse.tree.primary.PrimaryUINT8;
import protobufdsl.parse.tree.primary.PrimaryUTF8;
import sun.misc.BASE64Decoder;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Mar 21, 2014 3:28:48 PM
 * 
 */
public class ProtoMapInputPacker extends ProtoAbstractPacker {

    private final Stack<Map> mapFrames = new Stack<Map>();

    public ProtoMapInputPacker(DataReaderAdapter adapter) {
        super(adapter);
    }

    @Override
    public void init(DataReaderAdapter context) throws AstVisitingException {
        super.init(context);

        Object input = context.getInputSource();

        if (input == null) {
            throw new ProtoGeneratingException("no input.");
        }

        if (!(input instanceof Map)) {
            throw new ProtoGeneratingException(String.format("Invalid map [ %s ].", input.getClass().getName()));
        }

        Map firstMap = new HashMap<Object, Object>();
        firstMap.put(context.getOuterMessageName(), input);
        this.mapFrames.push(firstMap);
    }

    private Map getCurrentMapFrame() {
        return this.mapFrames.peek();
    }

    @Override
    protected void down() {
        Map nested = (Map) getCurrentMapFrame().get(getCurrentDefineName());
        this.mapFrames.push(nested);
    }

    @Override
    protected void up() {
        this.mapFrames.pop();
    }

    @Override
    public Object visitPrimaryANSI(PrimaryANSI node, DataReaderAdapter context) throws AstVisitingException {
        try {
            Object v = this.getCurrentMapFrame().get(context.getCurrentIdentifer());
            return ByteString.copyFrom(v.toString(), "ISO8859-1");
        } catch (IOException e) {
            throw new ProtoGeneratingException(e);
        }
    }

    @Override
    public Object visitPrimaryB8UTF(PrimaryB8UTF node, DataReaderAdapter context) throws AstVisitingException {
        Object v = this.getCurrentMapFrame().get(context.getCurrentIdentifer());
        return v.toString();
    }

    @Override
    public Object visitPrimaryBASE64(PrimaryBASE64 node, DataReaderAdapter context) throws AstVisitingException {
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            return new String(decoder.decodeBuffer(this.getCurrentMapFrame().get(context.getCurrentIdentifer())
                    .toString()), "utf-8");
        } catch (IOException e) {
            throw new ProtoGeneratingException(e);
        }
    }

    @Override
    public Object visitPrimaryBYTES(PrimaryBYTES node, DataReaderAdapter context) throws AstVisitingException {
        try {
            Object v = this.getCurrentMapFrame().get(context.getCurrentIdentifer());
            return ByteString.copyFrom(v.toString(), "UTF-8");
        } catch (IOException e) {
            throw new ProtoGeneratingException(e);
        }
    }

    @Override
    public Object visitPrimaryDOUBLE(PrimaryDOUBLE node, DataReaderAdapter context) throws AstVisitingException {
        Object v = this.getCurrentMapFrame().get(context.getCurrentIdentifer());
        return Double.valueOf(v.toString());
    }

    @Override
    public Object visitPrimaryFLOAT(PrimaryFLOAT node, DataReaderAdapter context) throws AstVisitingException {
        Object v = this.getCurrentMapFrame().get(context.getCurrentIdentifer());
        return Float.valueOf(v.toString());
    }

    @Override
    public Object visitPrimarySINT16(PrimarySINT16 node, DataReaderAdapter context) throws AstVisitingException {
        Object v = this.getCurrentMapFrame().get(context.getCurrentIdentifer());
        return Integer.valueOf(v.toString());
    }

    @Override
    public Object visitPrimarySINT32(PrimarySINT32 node, DataReaderAdapter context) throws AstVisitingException {
        Object v = this.getCurrentMapFrame().get(context.getCurrentIdentifer());
        return Integer.valueOf(v.toString());
    }

    @Override
    public Object visitPrimarySINT64(PrimarySINT64 node, DataReaderAdapter context) throws AstVisitingException {
        Object v = this.getCurrentMapFrame().get(context.getCurrentIdentifer());
        return Long.valueOf(v.toString());
    }

    @Override
    public Object visitPrimarySINT8(PrimarySINT8 node, DataReaderAdapter context) throws AstVisitingException {
        Object v = this.getCurrentMapFrame().get(context.getCurrentIdentifer());
        return Integer.valueOf(v.toString());
    }

    @Override
    public Object visitPrimaryUINT16(PrimaryUINT16 node, DataReaderAdapter context) throws AstVisitingException {
        Object v = this.getCurrentMapFrame().get(context.getCurrentIdentifer());
        return Integer.valueOf(v.toString());
    }

    @Override
    public Object visitPrimaryUINT32(PrimaryUINT32 node, DataReaderAdapter context) throws AstVisitingException {
        Object v = this.getCurrentMapFrame().get(context.getCurrentIdentifer());
        return Long.valueOf(v.toString());
    }

    @Override
    public Object visitPrimaryUINT8(PrimaryUINT8 node, DataReaderAdapter context) throws AstVisitingException {
        Object v = this.getCurrentMapFrame().get(context.getCurrentIdentifer());
        return Integer.valueOf(v.toString());
    }

    @Override
    public Object visitPrimaryUTF8(PrimaryUTF8 node, DataReaderAdapter context) throws AstVisitingException {
        Object v = this.getCurrentMapFrame().get(context.getCurrentIdentifer());
        return v.toString();
    }

}
