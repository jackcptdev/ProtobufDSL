package protobufdsl.protogenerate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.antlr.runtime.RecognitionException;
import org.codehaus.jackson.JsonProcessingException;
import org.junit.Test;

import com.google.protobuf.DescriptorProtos.DescriptorProto;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.DynamicMessage.Builder;

import protobufdsl.common.DataReaderAdapter;
import protobufdsl.common.JsonUtils;
import protobufdsl.common.ProtobufUtils;
import protobufdsl.common.TestConstants;
import protobufdsl.parse.ProtobufDslParseUtils;
import protobufdsl.parse.tree.AstVisitingException;
import protobufdsl.parse.tree.Start;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Mar 21, 2014 4:21:52 PM
 * 
 */
public class TestProtoMapPacker {

    @Test
    public void testProtoMapPacker() throws RecognitionException, AstVisitingException, DescriptorValidationException,
            JsonProcessingException, IOException {

        String input = "1:f1:utf8,2:f2:[1:f2f1:utf8 ,2:f2f2:[ 1:f2f2f1:utf8,2:f2f2f2:uint32 ] ],3:f3:utf8";
        // ,2:f2:uint32,3:f3f3:[1:f1:utf8,2:f2:sint64]
        Map map = new HashMap<Object, Object>();

        map.put("f1", "value1");

        Map f2f2 = new HashMap<Object, Object>();
        f2f2.put("f2f2f1", "f2f2f1value");
        f2f2.put("f2f2f2", 1000);

        Map f2 = new HashMap<Object, Object>();
        f2.put("f2f1", "f2f1value1");
        f2.put("f2f2", f2f2);
        map.put("f2", f2);

        map.put("f3", "f3value");

        String json = JsonUtils.jsonString(map);
        System.out.println(json);

        Map jsonMap = JsonUtils.jsonFrom(json, Map.class);
        map = jsonMap;

        Start start = ProtobufDslParseUtils.parse(input);
        ProtoMessageStructGenerator structGenerator = new ProtoMessageStructGenerator();
        Object globalStruct = structGenerator.visitStart(start, TestConstants.newTestContext());
        FileDescriptor fileDescriptor = ProtobufUtils.createMessageProtoFile((DescriptorProto.Builder) globalStruct);

        String globalMessageName = "TestMessage";

        Descriptor testMessageDescr = fileDescriptor.findMessageTypeByName(globalMessageName);

        Builder testMessageBuilder = ProtobufUtils.createMessagePackBuilder(testMessageDescr);
        DataReaderAdapter ctx = new DataReaderAdapter(map, testMessageBuilder, testMessageDescr, globalMessageName,
                structGenerator.getMaxDept());

        ProtoMapInputPacker pmp = new ProtoMapInputPacker(ctx);
        pmp.init(ctx);

        DynamicMessage msg = ((com.google.protobuf.DynamicMessage.Builder) pmp.visitStart(start, ctx)).build();
        System.out.println(msg);

    }

}
