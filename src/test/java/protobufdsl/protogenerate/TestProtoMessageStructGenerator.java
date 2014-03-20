package protobufdsl.protogenerate;

import java.util.Set;

import org.antlr.runtime.RecognitionException;
import org.junit.Assert;
import org.junit.Test;

import com.google.protobuf.DescriptorProtos.DescriptorProto;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.DynamicMessage.Builder;

import protobufdsl.common.Constants;
import protobufdsl.common.Context;
import protobufdsl.common.ProtobufUtils;
import protobufdsl.parse.ProtobufDslParseUtils;
import protobufdsl.parse.tree.AstVisitingException;
import protobufdsl.parse.tree.Start;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Mar 18, 2014 3:15:02 PM
 * 
 */
public class TestProtoMessageStructGenerator {
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

    public void assertGenerating(String input, boolean willPass, String errorMessage) {
        Context ctx = newContext();
        boolean pass = false;
        String error = null;
        try {
            Start start = ProtobufDslParseUtils.parse(input);
            FileDescriptor fileDescriptor = this.buildProtoFileStruct(ctx, start);
            pass = true;
        } catch (RecognitionException e) {
            e.printStackTrace();
            error = e.getMessage();
        } catch (AstVisitingException e) {
            e.printStackTrace();
            error = e.getMessage();
        } catch (DescriptorValidationException e) {
            e.printStackTrace();
            error = e.getMessage();
        }

        Assert.assertTrue(willPass == pass);
        if (errorMessage == null) {
            Assert.assertTrue(errorMessage == error);
        } else {
            Assert.assertTrue(errorMessage.equals(error));
        }
    }

    public void testAsserts() {
        assertGenerating("1:name:uint16,2:age:utf8(name),3:favor:utf8", true, null);
        assertGenerating("1:name:uint16,2:age:utf8(name),3:favor:utf8", true, null);
        assertGenerating("1:name:uint16,2:age:utf8(name),3:favor:utf8,4:name4:base64(favor)", false,
                "[ favor ] is not countable.");

        assertGenerating("1:name:uint16,2:age:utf8(name),3:favor:utf8,4:name4:base64(name5),5:name5:uint16", false,
                "[ name5 ] does not exists before [ name4 ] in the same pack.");
        assertGenerating("1:name:uint16,1:age:uint16", false, "Duplicated field id [ 1 ] in message [ TestMessage ].");
        assertGenerating(
                "1:name:uint16,3:age:uint16,2:favor:[2:age:uint16 , 3:age1:uint16,4:favor:[1:age:uint16 , 1:age1:uint16]]",
                false, "Duplicated field id [ 1 ] in message [ TestMessage.Messagefavor.Messagefavor ].");
        assertGenerating(
                "1:name:uint16,3:age:uint16,2:favor:[2:age:uint16 , 3:age1:uint16,4:favor:[1:age:uint16 , 2:age:uint16]]",
                false, "Duplicated identifier [ age ] in message [ TestMessage.Messagefavor.Messagefavor ].");
        assertGenerating(
                "1:name:uint16,3:age:uint16,2:favor:[2:age:uint16 , 3:age1:uint16,4:favor:[1:age:uint16 , 2:age2:uint16]]",
                true, null);

        assertGenerating(
                "1:name:uint16,3:age:uint16,2:favor:[2:age:uint16 , 3:age1:uint16(favor),4:favor:[1:age:uint16 , 2:age2:uint16]]",
                false, "[ favor ] does not exists before [ age1 ] in the same pack.");
    }

    public void assertMaxDept(String input, int maxDept) throws RecognitionException, AstVisitingException {
        Start start = this.parseInput(input);
        ProtoMessageStructGenerator structGenerator = new ProtoMessageStructGenerator();
        structGenerator.visitStart(start, newContext());
        System.out.println(structGenerator.getMaxDept());
        Assert.assertTrue(maxDept == structGenerator.getMaxDept());
    }

    @Test
    public void testMaxDept() throws RecognitionException, AstVisitingException {
        assertMaxDept("1:f:uint16", 1);
        assertMaxDept("1:f:uint16,2:f2:uint32", 1);
        assertMaxDept("1:f:uint16,2:f2:uint32,3:f3:[1:f:utf8],4:f4:[1:f:utf8]", 2);
        assertMaxDept("1:f:uint16,2:f2:uint32,3:f3:[1:f:utf8],4:f4:[1:f:utf8],5:f5:[1:f:base64]", 2);
        assertMaxDept("1:f:uint16,2:f2:uint32,3:f3:[1:f:utf8,2:f2:sint64],4:f4:[1:f:utf8],5:f5:[1:f:base64]", 2);
        assertMaxDept(
                "1:f:uint16,2:f2:uint32,3:f3:[1:f:utf8,2:f2:sint64,3:f3:[1:f:uint16]],4:f4:[1:f:utf8,3:f3:[1:f:uint16]],5:f5:[1:f:base64]",
                3);
        assertMaxDept(
                "1:f:uint16,2:f2:uint32,3:f3:[1:f:utf8,2:f2:sint64,3:f3:[1:f:uint16]],4:f4:[1:f:utf8,3:f3:[1:f:uint16,3:f3:[1:f:uint16]]],5:f5:[1:f:base64]",
                4);
        assertMaxDept(
                "1:f:uint16,2:f2:uint32,3:f3:[1:f:utf8,2:f2:sint64,3:f3:[1:f:uint16]],4:f4:[1:f:utf8,3:f3:[1:f:uint16,3:f3:[1:f:uint16]]],5:f5:[1:f:base64],6:f6:[1:f:uint16,2:f2:uint32,3:f3:[1:f:utf8,2:f2:sint64,3:f3:[1:f:uint16]],4:f4:[1:f:utf8,3:f3:[1:f:uint16,3:f3:[1:f:uint16]]],5:f5:[1:f:base64]]",
                5);
        assertMaxDept(
                "1:f:uint16,2:f2:uint32,3:f3:[1:f:utf8,2:f2:sint64,3:f3:[1:f:uint16]],4:f4:[1:f:utf8,3:f3:[1:f:uint16,3:f3:[1:f:uint16]]],5:f5:[1:f:base64,2:f2:[ 1:f:uint16,2:f2:uint32,3:f3:[1:f:utf8,2:f2:sint64,3:f3:[1:f:uint16]],4:f4:[1:f:utf8,3:f3:[1:f:uint16,3:f3:[1:f:uint16]]],5:f5:[1:f:base64]]]",
                6);
        assertMaxDept(
                "1:f:uint16,2:f2:uint32,3:f3:[1:f:utf8,2:f2:sint64,3:f3:[1:f:uint16]],4:f4:[1:f:utf8,3:f3:[1:f:uint16,3:f3:[1:f:uint16,2:f2:[1:f:uint16,2:f2:uint32,3:f3:[1:f:utf8,2:f2:sint64,3:f3:[1:f:uint16]],4:f4:[1:f:utf8,3:f3:[1:f:uint16,3:f3:[1:f:uint16]]],5:f5:[1:f:base64],6:f6:[1:f:uint16,2:f2:uint32,3:f3:[1:f:utf8,2:f2:sint64,3:f3:[1:f:uint16]],4:f4:[1:f:utf8,3:f3:[1:f:uint16,3:f3:[1:f:uint16]]],5:f5:[1:f:base64]]]]]],5:f5:[1:f:base64],6:f6:[1:f:uint16,2:f2:uint32,3:f3:[1:f:utf8,2:f2:sint64,3:f3:[1:f:uint16]],4:f4:[1:f:utf8,3:f3:[1:f:uint16,3:f3:[1:f:uint16]]],5:f5:[1:f:base64]]",
                9);
    }

    public static void main(String[] args) throws RecognitionException, AstVisitingException,
            DescriptorValidationException {

        Context ctx = newContext();
        String input = "1:name:uint16,2:age:utf8(name), 3:favor:[ 1:first:utf8 , 2:second:uint32, 3:peek:[ 1:peak1:sint64(1), 2:peak2:base64, 3:peak3:utf8(peak1) , 4:peak4:uint32 ] ], 4:favor2:[ 1:first:utf8 , 2:second:uint32, 3:peek:[ 1:peak1:sint64(1), 2:peak2:base64, 3:peak3:utf8(peak1) , 4:peak4:uint32 ] ]";
        TestProtoMessageStructGenerator g = new TestProtoMessageStructGenerator();
        Start start = g.parseInput(input);
        System.out.println(g.generateProtoDefine(ctx, start));
        FileDescriptor fileDescr = g.buildProtoFileStruct(ctx, start);

        Descriptor testMessageDescr = fileDescr.findMessageTypeByName("TestMessage");
        Descriptor favorDescr = testMessageDescr.findNestedTypeByName("Messagefavor");

        Builder favorPackBuilder = ProtobufUtils.createMessagePackBuilder(favorDescr);
        favorPackBuilder.setField(favorDescr.findFieldByNumber(1), "first favor");

        Builder testMessagePackBuilder = ProtobufUtils.createMessagePackBuilder(testMessageDescr);
        testMessagePackBuilder.setField(testMessageDescr.findFieldByNumber(1), 111);
        testMessagePackBuilder.addRepeatedField(testMessageDescr.findFieldByNumber(2), "noage");
        testMessagePackBuilder.setField(testMessageDescr.findFieldByNumber(3), favorPackBuilder.build());

        DynamicMessage testMsg = testMessagePackBuilder.build();
        System.out.println(testMsg);

    }

}
