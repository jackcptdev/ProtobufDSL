package protobufdsl.protogenerate;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import protobufdsl.common.Constants;
import protobufdsl.common.Context;
import protobufdsl.common.DataReaderAdapter;
import protobufdsl.common.ProtobufUtils;
import protobufdsl.parse.ProtobufDslParseUtils;
import protobufdsl.parse.tree.AstVisitingException;
import protobufdsl.parse.tree.Start;
import protobufdsl.stream.DataInput;
import protobufdsl.stream.DataInputStreamLE;
import protobufdsl.stream.DataOutputStreamLE;

import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.DescriptorProtos.DescriptorProto;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import com.google.protobuf.Descriptors.FileDescriptor;

import sun.misc.BASE64Encoder;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Mar 21, 2014 11:39:59 AM
 * 
 */
public class TestProtoStreamPacker {

    private static Context newContext() {
        Context ctx = new Context();
        ctx.put(Constants.PROTO_OUTER_MESSAGE_NAME_KEY, "TestMessage");
        ctx.put(Constants.SPACE_COUNT_KEY, 0);
        return ctx;
    }

    public DynamicMessage _testStreamPacker(String input, byte[] data) throws RecognitionException,
            AstVisitingException, DescriptorValidationException, IOException {

        Start start = ProtobufDslParseUtils.parse(input);

        ProtoMessageStructGenerator structGenerator = new ProtoMessageStructGenerator();
        Object globalStruct = structGenerator.visitStart(start, newContext());
        FileDescriptor fileDescriptor = ProtobufUtils.createMessageProtoFile((DescriptorProto.Builder) globalStruct);
        String globalMessageName = "TestMessage";

        Descriptor testMessageDescr = fileDescriptor.findMessageTypeByName(globalMessageName);

        com.google.protobuf.DynamicMessage.Builder testMessageBuilder = ProtobufUtils
                .createMessagePackBuilder(testMessageDescr);
        DataReaderAdapter ctx = new DataReaderAdapter(this.createDataInput(data), testMessageBuilder, testMessageDescr,
                globalMessageName, structGenerator.getMaxDept());

        ProtoStreamPacker psp = new ProtoStreamPacker(ctx);
        psp.init(ctx);
        DynamicMessage m = ((com.google.protobuf.DynamicMessage.Builder) psp.visitStart(start, ctx)).build();
        System.out.println(m);
        return m;
    }

    @Test
    public void testStreamPacker() throws IOException, RecognitionException, AstVisitingException,
            DescriptorValidationException {
        _testStreamPacker("1:f1:utf8,2:f2:uint32", createBuf1());
        _testStreamPacker("1:f1:utf8,2:f2:uint32,3:f3:[1:f1:uint32,2:f2:utf8](2)", createBuf3());
        _testStreamPacker(
                "1:f1:utf8,2:f2:uint32,3:f3:[1:f1:uint32,2:f2:utf8,3:f3:[1:f1:uint16,2:f2:uint32,3:f3:utf8](3)](2)",
                createBuf4());
        _testStreamPacker("1:f1:utf8,2:f2:uint32,3:f3:utf8(f2)", createBuf5());
        _testStreamPacker("1:f1:utf8,2:f2:uint32,3:f3:[1:f1:uint32,2:f2:[1:f1:utf8,2:f2:uint32](f1)]", createBuf6());

        DynamicMessage m7 = _testStreamPacker("1:f1:ansi,2:f2:b8utf{11},3:f3:base64,4:f4:bytes{256}", createBuf7());
        Map<FieldDescriptor, Object> fields = m7.getAllFields();
        for (FieldDescriptor d : fields.keySet()) {
            System.out.println(d.getFullName());
            Object v = m7.getField(d);
            if (v instanceof ByteString) {
                ByteString bs = (ByteString) v;
                String ansi = new String(bs.toByteArray(), "utf-8");
                System.out.println(ansi);
                continue;
            }
            System.out.println(v);
        }

        System.out.println();
        _testStreamPacker(
                "1:f1:double,2:f2:float,3:f3:sint16,4:f4:sint32,5:f5:sint64,6:f6:sint8,7:f7:uint16,8:f8:uint32,9:f9:uint8,10:f10:utf8",
                createBuf8());
    }

    private byte[] createBuf8() throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(2048);
        DataOutputStreamLE dos = new DataOutputStreamLE(bos);

        dos.writeDouble(-10000000000.333333333333333);
        dos.writeFloat((float) -1000000.33333333333);
        dos.writeShort(-32768);
        dos.writeInt(-2147483648);
        dos.writeLong(-9223372036854775808L);
        dos.writeByte(-128);
        dos.writeUnsignedShort(65535);
        dos.writeUnsignedInt(4294967295L);
        dos.writeUnsignedByte(255);
        dos.writeUTF8("UTF8，你好");

        dos.flush();
        return bos.toByteArray();
    }

    private byte[] createBuf7() throws IOException {
        String str = "hello,你好";
        String ansi = new String(str.getBytes("UTF-8"), "ISO8859-1");

        ByteArrayOutputStream bos = new ByteArrayOutputStream(2048);
        DataOutputStreamLE dos = new DataOutputStreamLE(bos);
        dos.writeANSI(ansi);
        byte[] b8utf = "OKAY,你好".getBytes();
        dos.writeFully(b8utf);

        BASE64Encoder coder = new BASE64Encoder();
        dos.writeUTF8(coder.encode("你好啊,hello".getBytes()));

        byte[] buf = new byte[256];
        for (int i = 0; i < buf.length; i++) {
            buf[i] = (byte) i;
        }

        dos.writeFully(buf);

        dos.flush();
        return bos.toByteArray();
    }

    private byte[] createBuf6() throws IOException {
        String str = "f1String";
        ByteArrayOutputStream bos = new ByteArrayOutputStream(2048);
        DataOutputStreamLE dos = new DataOutputStreamLE(bos);
        dos.writeUTF(str);
        dos.writeUnsignedInt(1033333333);

        dos.writeUnsignedInt(10);
        for (int i = 0; i < 10; i++) {
            dos.writeUTF8("string" + i);
            dos.writeUnsignedInt(i);
        }

        dos.flush();
        return bos.toByteArray();
    }

    private byte[] createBuf5() throws IOException {
        String str = "f1String";
        ByteArrayOutputStream bos = new ByteArrayOutputStream(2048);
        DataOutputStreamLE dos = new DataOutputStreamLE(bos);
        dos.writeUTF(str);
        dos.writeUnsignedInt(10);
        for (int i = 0; i < 10; i++) {
            dos.writeUTF8("string" + i);
        }
        dos.flush();
        return bos.toByteArray();
    }

    private byte[] createBuf4() throws IOException {
        String str = "f1String";
        ByteArrayOutputStream bos = new ByteArrayOutputStream(2048);
        DataOutputStreamLE dos = new DataOutputStreamLE(bos);
        dos.writeUTF(str);
        dos.writeUnsignedInt(1000000007);
        for (int i = 0; i < 2; i++) {
            dos.writeUnsignedInt(100 + i);
            dos.writeUTF8("f2string" + i);
            for (int j = 0; j < 3; j++) {
                dos.writeUnsignedShort(200 + i);
                dos.writeUnsignedInt(200 + i);
                dos.writeUTF8("f3string" + i);
            }
        }
        dos.flush();
        return bos.toByteArray();
    }

    private byte[] createBuf3() throws IOException {
        String str = "f1String";
        ByteArrayOutputStream bos = new ByteArrayOutputStream(2048);
        DataOutputStreamLE dos = new DataOutputStreamLE(bos);
        dos.writeUTF(str);
        dos.writeUnsignedInt(1000000007);
        int count = 2;
        for (int i = 0; i < count; i++) {
            dos.writeUnsignedInt(100 + i);
            dos.writeUTF8("f3string:" + i);
        }
        return bos.toByteArray();

    }

    private byte[] createBuf1() throws IOException {
        String str = "s mentioned above, elements in a message description can be labeled optional. A well-formed message may or may not contain an optional element. When a message is parsed, if it does not contain an optional element, the corresponding field in the parsed object is set to the default value for that field. The default value can be specified as part of the message description. For example, let's say you want to provide a default value of 10 for a SearchRequest's result_per_page value.";
        ByteArrayOutputStream bos = new ByteArrayOutputStream(2048);
        DataOutputStreamLE dos = new DataOutputStreamLE(bos);
        dos.writeUTF(str);
        dos.writeUnsignedInt(1000000007);
        return bos.toByteArray();
    }

    private byte[] createBuf2() throws IOException {
        String str = "s mentioned above, elements in a message description can be labeled optional. A well-formed message may or may not contain an optional element. When a message is parsed, if it does not contain an optional element, the corresponding field in the parsed object is set to the default value for that field. The default value can be specified as part of the message description. For example, let's say you want to provide a default value of 10 for a SearchRequest's result_per_page value.";
        Random r = new Random();
        byte[] buf = new byte[1024];
        for (int i = 0; i < buf.length; i++) {
            buf[i] = (byte) r.nextInt(255);
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream(2048);
        DataOutputStreamLE dos = new DataOutputStreamLE(bos);
        dos.writeLong(1000000001);
        dos.writeInt(1000000002);
        dos.writeDouble(1000000003.33333333333333);
        dos.writeFloat(1000000004.444444f);
        dos.writeInt(1000000005);
        dos.writeLong(1000000006);
        dos.writeInt(1000000007);
        dos.writeLong(1000000008);
        dos.writeUTF(str);
        dos.write(buf, 0, buf.length);
        return bos.toByteArray();
    }

    private DataInput createDataInput(byte[] data) {
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        DataInputStreamLE dis = new DataInputStreamLE(bis);
        return dis;
    }
}
