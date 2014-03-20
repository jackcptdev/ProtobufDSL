package protobufdsl.protogenerate;

import org.antlr.runtime.RecognitionException;
import org.junit.Assert;
import org.junit.Test;

import protobufdsl.common.Constants;
import protobufdsl.common.Context;
import protobufdsl.parse.ProtobufDslParseUtils;
import protobufdsl.parse.exception.ParsingException;
import protobufdsl.parse.tree.AstVisitingException;
import protobufdsl.parse.tree.Start;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Mar 10, 2014 2:59:41 PM
 * 
 */
public class TestProtoRuleGenerator {

    public void testGenerator() throws RecognitionException {
        Context ctx = new Context();
        ctx.put(Constants.PROTO_OUTER_MESSAGE_NAME_KEY, "TestMessage");
        ctx.put(Constants.SPACE_COUNT_KEY, 0);

        String dsl = "1:name:uint16,3:age:uint16,2:favor:[1:game:uint16,1:name:uint16,2:favorDept:[1:game:uint16,1:name:uint16,1:name:uint16,3:age:uint16,2:favor:[1:game:uint16,1:name:uint16,2:favorDept:[1:game:uint16,1:name:uint16 ] ] ] ]";
        // String dsl = "1:name:uint16,3:age:uint16";
        dsl = "1:name:uint16,3:age:uint16,2:favor:[2:age:uint16 , 3:age1:uint16,4:favor:[1:age:uint16 , 1:age1:uint16]]";

        Start start = ProtobufDslParseUtils.parse(dsl);

        ProtoRuleGenerator g = new ProtoRuleGenerator();
        try {
            String result = g.visitStart(start, ctx);
            System.out.println(result);
        } catch (AstVisitingException e) {
            e.printStackTrace();
        }
    }

    private void assertGenerating(String input, String errorMessage, Context ctx, boolean willPassRecognition) {

        boolean passRec = true;
        String errMsg = null;
        try {
            Start start = ProtobufDslParseUtils.parse(input);
            ProtoRuleGenerator g = new ProtoRuleGenerator();
            String r = g.visitStart(start, ctx);
            System.out.println(r);
        } catch (AstVisitingException e) {
            errMsg = e.getMessage();
        } catch (RecognitionException e) {
            passRec = false;
        } catch (ParsingException e) {
            passRec = false;
        }

        Assert.assertTrue(passRec == willPassRecognition);
        if (errMsg == null) {
            Assert.assertTrue(errMsg == errorMessage);
        } else {

            Assert.assertTrue(errMsg.equals(errorMessage));
        }
    }

    @Test
    public void testGenerating() {

        assertGenerating("1:name:uint16,3:age:uint16", null, newContext(), true);
        assertGenerating("1:name:uint16,1:age:uint16", "Duplicated field id [ 1 ] in message [ TestMessage ].",
                newContext(), true);

        assertGenerating(
                "1:name:uint16,3:age:uint16,2:favor:[2:age:uint16 , 3:age1:uint16,4:favor:[1:age:uint16 , 1:age1:uint16]]",
                "Duplicated field id [ 1 ] in message [ TestMessage.favor.favor ].", newContext(), true);

        assertGenerating(
                "1:name:uint16,3:age:uint16,2:favor:[2:age:uint16 , 3:age1:uint16,4:favor:[1:age:uint16 , 2:age:uint16]]",
                "Duplicated identifier [ age ] in message [ TestMessage.favor.favor ].", newContext(), true);

        assertGenerating(
                "1:name:uint16,3:age:uint16,2:favor:[2:age:uint16 , 3:age1:uint16,4:favor:[1:age:uint16 , 2:age2:uint16]]",
                null, newContext(), true);

        assertGenerating("", null, newContext(), false);

    }

    private Context newContext() {
        Context ctx = new Context();
        ctx.put(Constants.PROTO_OUTER_MESSAGE_NAME_KEY, "TestMessage");
        ctx.put(Constants.SPACE_COUNT_KEY, 0);
        return ctx;
    }

}
