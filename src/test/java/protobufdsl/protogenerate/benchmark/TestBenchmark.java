package protobufdsl.protogenerate.benchmark;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import org.antlr.runtime.RecognitionException;

import com.google.protobuf.ByteString;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.DescriptorProtos.DescriptorProto;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import com.google.protobuf.Descriptors.FileDescriptor;

import protobufdsl.common.Constants;
import protobufdsl.common.Context;
import protobufdsl.common.DataReaderAdapter;
import protobufdsl.common.ProtobufUtils;
import protobufdsl.parse.ProtobufDslParseUtils;
import protobufdsl.parse.tree.AstVisitingException;
import protobufdsl.parse.tree.Start;
import protobufdsl.proto.Benchmark;
import protobufdsl.proto.Benchmark.MessageT1;
import protobufdsl.proto.Benchmark.MessageT1.Builder;
import protobufdsl.protogenerate.ProtoMessageStreamPacker;
import protobufdsl.protogenerate.ProtoMessageStructGenerator;
import protobufdsl.protogenerate.ProtoRuleGenerator;
import protobufdsl.protogenerate.ProtoStreamPacker;
import protobufdsl.stream.DataInput;
import protobufdsl.stream.DataInputStreamLE;
import protobufdsl.stream.DataOutputStreamLE;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Mar 20, 2014 9:41:56 AM
 * 
 */
public class TestBenchmark {

    private static int count = 3000000;

    private byte[] createBuf() throws IOException {
        String str = "s mentioned above, elements in a message description can be labeled optional. A well-formed message may or may not contain an optional element. When a message is parsed, if it does not contain an optional element, the corresponding field in the parsed object is set to the default value for that field. The default value can be specified as part of the message description. For example, let's say you want to provide a default value of 10 for a SearchRequest's result_per_page value.";
        ;

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

    private void testProtobufCompiledProto(int testi) throws IOException {
        byte[] buf = createBuf();
        long sum = 0;
        long startTime = System.currentTimeMillis();
        long msgSize = -1;
        for (int i = 0; i < count; i++) {
            ByteArrayInputStream bis = new ByteArrayInputStream(buf);
            DataInputStreamLE dis = new DataInputStreamLE(bis);
            Builder t1Builder = Benchmark.MessageT1.newBuilder();
            t1Builder.setField1(dis.readLong());
            t1Builder.setField2(dis.readInt());
            t1Builder.setField3(dis.readDouble());
            t1Builder.setField4(dis.readFloat());
            t1Builder.setField5(dis.readInt());
            t1Builder.setField6(dis.readLong());
            t1Builder.setField7(dis.readInt());
            t1Builder.setField8(dis.readLong());
            t1Builder.setField9(dis.readUTF8());
            int bytesLen = 1024;
            byte[] temp = new byte[bytesLen];
            dis.readFully(temp);
            t1Builder.setField10(ByteString.copyFrom(temp));
            MessageT1 msg = t1Builder.build();
            msgSize = msg.toByteArray().length;
            sum += msgSize;
        }

        long spent = System.currentTimeMillis() - startTime;
        cspent[testi] = spent;
        ccount[testi] = count;
        csum[testi] = sum;
        cmsgSize[testi] = msgSize;
    }

    private DataInput createDataInput(byte[] data) {
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        DataInputStreamLE dis = new DataInputStreamLE(bis);
        return dis;
    }

    private void testProtobufDsl(int testi) {
        try {
            String input = "1:field1:sint64,2:field2:sint32,3:field3:double,4:field4:float,5:field5:uint32,6:field6:sint64,7:field7:sint32,8:field8:sint64,9:field9:utf8,10:field10:bytes{1024}";
            Start start = this.parseInput(input);
            ProtoMessageStructGenerator structGenerator = new ProtoMessageStructGenerator();
            Object globalStruct = structGenerator.visitStart(start, newContext());
            FileDescriptor fileDescriptor = ProtobufUtils
                    .createMessageProtoFile((DescriptorProto.Builder) globalStruct);
            String globalMessageName = "TestMessage";

            byte[] data = this.createBuf();

            Descriptor testMessageDescr = fileDescriptor.findMessageTypeByName(globalMessageName);

            com.google.protobuf.DynamicMessage.Builder testMessageBuilder = ProtobufUtils
                    .createMessagePackBuilder(testMessageDescr);
            DataReaderAdapter ctx = new DataReaderAdapter(this.createDataInput(data), testMessageBuilder,
                    testMessageDescr, globalMessageName, structGenerator.getMaxDept());

            // ProtoMessageStreamPacker packer = new ProtoMessageStreamPacker();
            // packer.init(ctx);
            //
            // DynamicMessage message =
            // ((com.google.protobuf.DynamicMessage.Builder)
            // packer.visitStart(start, ctx))
            // .build();

            int maxDept = structGenerator.getMaxDept();
            System.out.println("MaxDept:" + maxDept);
            long sum = 0;
            long startTime = System.currentTimeMillis();
            long msgSize = -1;
            for (int i = 0; i < count; i++) {
                com.google.protobuf.DynamicMessage.Builder newBuilder = testMessageBuilder.clone();
                DataReaderAdapter newCtx = new DataReaderAdapter(this.createDataInput(data), newBuilder,
                        testMessageDescr, globalMessageName, maxDept);
                ProtoStreamPacker p = new ProtoStreamPacker(newCtx);
                p.init(newCtx);
                DynamicMessage m = ((com.google.protobuf.DynamicMessage.Builder) p.visitStart(start, newCtx)).build();
                msgSize = m.toByteArray().length;
                sum += msgSize;
            }

            long spent = System.currentTimeMillis() - startTime;
            dspent[testi] = spent;
            dcount[testi] = count;
            dsum[testi] = sum;
            dmsgSize[testi] = msgSize;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void printResult() {

        // dynamic
        long totalSpent = 0;
        long totalCount = 0;
        long totalMsgSize = 0;
        for (int i = 0; i < test; i++) {
            totalSpent += dspent[i];
            totalCount += dcount[i];
            totalMsgSize += dmsgSize[i];
        }
        double fps = totalCount * 10.0 * 1000.0 / totalSpent;
        double mps = totalCount * 1000.0 / totalSpent;

        System.out.println("Protobuf DSL Dynamic:::");
        System.out.println("Spent: " + totalSpent);
        System.out.println("Count: " + totalCount);
        System.out.println("FPS: " + fps);
        System.out.println("MPS: " + mps);
        System.out.println("MessageSize: " + totalMsgSize / test);

        System.out.println();
        // compiled
        totalSpent = 0;
        totalCount = 0;
        totalMsgSize = 0;
        for (int i = 0; i < test; i++) {
            totalSpent += cspent[i];
            totalCount += ccount[i];
            totalMsgSize += cmsgSize[i];
        }

        fps = totalCount * 10.0 * 1000.0 / totalSpent;
        mps = totalCount * 1000.0 / totalSpent;
        System.out.println("Protobuf Compiled Proto:::");
        System.out.println("Spent: " + totalSpent);
        System.out.println("Count: " + totalCount);
        System.out.println("FPS: " + fps);
        System.out.println("MPS: " + mps);
        System.out.println("MessageSize: " + totalMsgSize / test);

    }

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

    private static int test = 2;
    private static long cspent[] = new long[test];
    private static long ccount[] = new long[test];
    private static long cmsgSize[] = new long[test];
    private static long csum[] = new long[test];

    private static long dspent[] = new long[test];
    private static long dcount[] = new long[test];
    private static long dmsgSize[] = new long[test];
    private static long dsum[] = new long[test];

    public static void main(String[] args) throws IOException {
        TestBenchmark t = new TestBenchmark();
        System.out.println("Start testing...");
        for (int i = 0; i < test; i++) {
            // System.out.println("Start compied test.");
            // t.testProtobufCompiledProto(i);
            System.out.println("Start dynamic test.");
            t.testProtobufDsl(i);
        }
        t.printResult();
    }
}
