package protobufdsl.protogenerate;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import protobufdsl.common.Constants;
import protobufdsl.common.Context;
import protobufdsl.common.DataReaderAdapter;
import protobufdsl.common.ProtobufUtils;
import protobufdsl.parse.ProtobufDslParseUtils;
import protobufdsl.parse.tree.AstVisitingException;
import protobufdsl.parse.tree.Start;
import protobufdsl.proto.T1;
import protobufdsl.proto.T1.MessageT1;
import protobufdsl.stream.DataInput;
import protobufdsl.stream.DataInputStreamLE;
import protobufdsl.stream.DataOutputStreamLE;

import com.google.protobuf.DescriptorProtos.DescriptorProto;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.DynamicMessage.Builder;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Mar 19, 2014 5:33:32 PM
 * 
 */
public class TestMessageStreamPacker {

    private static Context newContext() {
        Context ctx = new Context();
        ctx.put(Constants.PROTO_OUTER_MESSAGE_NAME_KEY, "TestMessage");
        ctx.put(Constants.SPACE_COUNT_KEY, 0);
        return ctx;
    }

    public FileDescriptor buildProtoFileStruct(Context ctx, Start start) throws RecognitionException,
            AstVisitingException, DescriptorValidationException {
        ProtoMessageStructGenerator structGenerator = new ProtoMessageStructGenerator();
        Object globalStruct = structGenerator.visitStart(start, ctx);
        FileDescriptor fileDescriptor = ProtobufUtils.createMessageProtoFile((DescriptorProto.Builder) globalStruct);
        return fileDescriptor;
    }

    public Start parseInput(String input) throws RecognitionException {
        return ProtobufDslParseUtils.parse(input);
    }

    public String generateProtoDefine(Context ctx, Start start) throws RecognitionException, AstVisitingException {
        ProtoRuleGenerator g = new ProtoRuleGenerator();
        String result = g.visitStart(start, ctx);
        return result;
    }

    private byte[] createData1() throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DataOutputStreamLE dos = new DataOutputStreamLE(out);
        dos.writeUnsignedShort(100);
        dos.writeUTF("noagelengthlengthlengthlengthlengthlengthlengthlengthlengthlengthlengthlengthlengthlengthlengthlengthlength");
        dos.flush();

        byte[] data = out.toByteArray();
        return data;
    }

    private DataInput createDataInput(byte[] data) {
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        DataInputStreamLE dis = new DataInputStreamLE(bis);
        return dis;
    }

    @Test
    public void testPacker() {

        try {
            String input = "1:name:uint16,2:age:utf8(1)";
            Start start = this.parseInput(input);
            ProtoMessageStructGenerator structGenerator = new ProtoMessageStructGenerator();
            Object globalStruct = structGenerator.visitStart(start, newContext());
            FileDescriptor fileDescriptor = ProtobufUtils
                    .createMessageProtoFile((DescriptorProto.Builder) globalStruct);

            String globalMessageName = "TestMessage";

            byte[] data = this.createData1();

            Descriptor testMessageDescr = fileDescriptor.findMessageTypeByName(globalMessageName);

            Builder testMessageBuilder = ProtobufUtils.createMessagePackBuilder(testMessageDescr);
            DataReaderAdapter ctx = new DataReaderAdapter(this.createDataInput(data), testMessageBuilder,
                    testMessageDescr, globalMessageName, structGenerator.getMaxDept());

            ProtoMessageStreamPacker packer = new ProtoMessageStreamPacker();
            packer.init(ctx);

            DynamicMessage message = ((com.google.protobuf.DynamicMessage.Builder) packer.visitStart(start, ctx))
                    .build();
            System.out.println(message);

            MessageT1 t1 = T1.MessageT1.parseFrom(message.toByteArray());
            System.out.println(t1.getName());
            System.out.println(t1.getAge());
            System.out.println(t1.getAge().length());

            int count = 3000000;
            long sum = 0;
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < count; i++) {
                Builder newBuilder = testMessageBuilder.clone();
                DataReaderAdapter newCtx = new DataReaderAdapter(this.createDataInput(data), newBuilder,
                        testMessageDescr, globalMessageName, structGenerator.getMaxDept());
                ProtoMessageStreamPacker p = new ProtoMessageStreamPacker();
                p.init(newCtx);
                DynamicMessage m = (DynamicMessage) packer.visitStart(start, newCtx);
                // MessageT1 t1MSG = T1.MessageT1.parseFrom(m.toByteArray());
                // sum += t1MSG.getName();
                sum += m.toByteArray().length;
            }

            long spend = System.currentTimeMillis() - startTime;

            System.out.println("Sum: " + sum);
            System.out.println("Count: " + count);
            System.out.println("Spend: " + spend);

            System.out.println("Fields: " + count * 2);
            double fps = count * 2.0 * 1000.0 / spend;
            System.out.println("FPS: " + fps);

            double mps = count * 2.0 * 1000.0 / 10.0 / spend;
            System.out.println("MPS: " + mps);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestMessageStreamPacker p = new TestMessageStreamPacker();
        p.testPacker();
    }

}
