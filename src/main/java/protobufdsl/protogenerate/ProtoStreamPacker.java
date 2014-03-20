package protobufdsl.protogenerate;

import java.io.IOException;

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
import protobufdsl.stream.DataInput;
import sun.misc.BASE64Decoder;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Mar 21, 2014 10:31:56 AM
 * 
 */
public class ProtoStreamPacker extends ProtoAbstractPacker {

    public ProtoStreamPacker(DataReaderAdapter adapter) {
        super(adapter);
    }

    private DataInput getDataInput(DataReaderAdapter context) {
        return (DataInput) context.getInputSource();
    }

    @Override
    public void init(DataReaderAdapter context) throws AstVisitingException {
        super.init(context);

        if (context.getInputSource() == null) {
            throw new ProtoGeneratingException("no input stream.");
        }

        Object input = context.getInputSource();
        if (!(input instanceof DataInput)) {
            throw new ProtoGeneratingException(
                    String.format("Invalid input stream [ %s ].", input.getClass().getName()));
        }
    }

    @Override
    public Object visitPrimaryANSI(PrimaryANSI node, DataReaderAdapter context) throws AstVisitingException {
        try {
            String v = this.getDataInput(context).readANSI();
            return ByteString.copyFrom(v, "ISO8859-1");
        } catch (IOException e) {
            throw new ProtoGeneratingException(e);
        }
    }

    @Override
    public Object visitPrimaryB8UTF(PrimaryB8UTF node, DataReaderAdapter context) throws AstVisitingException {
        try {
            byte[] bs = new byte[node.getLength().getValue()];
            this.getDataInput(context).readFully(bs);
            return new String(bs, "utf-8");
        } catch (IOException e) {
            throw new ProtoGeneratingException(e);
        }
    }

    @Override
    public Object visitPrimaryBASE64(PrimaryBASE64 node, DataReaderAdapter context) throws AstVisitingException {
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            return new String(decoder.decodeBuffer(this.getDataInput(context).readUTF8()), "utf-8");
        } catch (IOException e) {
            throw new ProtoGeneratingException(e);
        }
    }

    @Override
    public Object visitPrimaryBYTES(PrimaryBYTES node, DataReaderAdapter context) throws AstVisitingException {
        try {
            byte[] buf = new byte[node.getLength().getValue()];
            this.getDataInput(context).readFully(buf);
            return ByteString.copyFrom(buf);
        } catch (IOException e) {
            throw new ProtoGeneratingException(e);
        }
    }

    @Override
    public Object visitPrimaryDOUBLE(PrimaryDOUBLE node, DataReaderAdapter context) throws AstVisitingException {
        try {
            double doubleV = this.getDataInput(context).readDouble();
            return doubleV;
        } catch (IOException e) {
            throw new ProtoGeneratingException(e);
        }
    }

    @Override
    public Object visitPrimaryFLOAT(PrimaryFLOAT node, DataReaderAdapter context) throws AstVisitingException {
        try {
            float floatV = this.getDataInput(context).readFloat();
            return floatV;
        } catch (IOException e) {
            throw new ProtoGeneratingException(e);
        }
    }

    @Override
    public Object visitPrimarySINT16(PrimarySINT16 node, DataReaderAdapter context) throws AstVisitingException {
        try {
            short sint16 = this.getDataInput(context).readShort();
            return Integer.valueOf(sint16);
        } catch (IOException e) {
            throw new ProtoGeneratingException(e);
        }
    }

    @Override
    public Object visitPrimarySINT32(PrimarySINT32 node, DataReaderAdapter context) throws AstVisitingException {
        try {
            int sint32 = this.getDataInput(context).readInt();
            return sint32;
        } catch (IOException e) {
            throw new ProtoGeneratingException(e);
        }
    }

    @Override
    public Object visitPrimarySINT64(PrimarySINT64 node, DataReaderAdapter context) throws AstVisitingException {
        try {
            long sint64 = this.getDataInput(context).readLong();
            return sint64;
        } catch (IOException e) {
            throw new ProtoGeneratingException(e);
        }
    }

    @Override
    public Object visitPrimarySINT8(PrimarySINT8 node, DataReaderAdapter context) throws AstVisitingException {
        try {
            byte sint8 = this.getDataInput(context).readByte();
            return Integer.valueOf(sint8);
        } catch (IOException e) {
            throw new ProtoGeneratingException(e);
        }
    }

    @Override
    public Object visitPrimaryUINT16(PrimaryUINT16 node, DataReaderAdapter context) throws AstVisitingException {
        try {
            int uint16 = this.getDataInput(context).readUnsignedShort();
            return uint16;
        } catch (IOException e) {
            throw new ProtoGeneratingException(e);
        }
    }

    @Override
    public Object visitPrimaryUINT32(PrimaryUINT32 node, DataReaderAdapter context) throws AstVisitingException {
        try {
            long uint32 = this.getDataInput(context).readUnsignedInt();
            return uint32;
        } catch (IOException e) {
            throw new ProtoGeneratingException(e);
        }
    }

    @Override
    public Object visitPrimaryUINT8(PrimaryUINT8 node, DataReaderAdapter context) throws AstVisitingException {
        try {
            int uint8 = this.getDataInput(context).readUnsignedByte();
            return uint8;
        } catch (IOException e) {
            throw new ProtoGeneratingException(e);
        }
    }

    @Override
    public Object visitPrimaryUTF8(PrimaryUTF8 node, DataReaderAdapter context) throws AstVisitingException {
        try {
            String utf8 = this.getDataInput(context).readUTF8();
            return utf8;
        } catch (IOException e) {
            throw new ProtoGeneratingException(e);
        }
    }

    @Override
    protected void down() {
        // nothing to do
    }

    @Override
    protected void up() {
        // nothing to do
    }

}
