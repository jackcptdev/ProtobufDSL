package protobufdsl.visit;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.BufferedTreeNodeStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.TreeNodeStream;
import org.junit.Test;

import protobufdsl.common.Constants;
import protobufdsl.common.Context;
import protobufdsl.format.Formatter;
import protobufdsl.parse.FormatterParserBuilder;
import protobufdsl.parse.FormatterParserLexer;
import protobufdsl.parse.FormatterParserParser;
import protobufdsl.parse.FormatterParserBuilder.start_return;
import protobufdsl.parse.tree.AstVisitingException;
import protobufdsl.parse.tree.Start;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Feb 26, 2014 7:00:29 PM
 * 
 */
public class TestFormatter {

    public Start parse(String input) throws RecognitionException {

        FormatterParserLexer lexer = new FormatterParserLexer(new ANTLRStringStream(input));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        FormatterParserParser parser = new FormatterParserParser(tokenStream);
        CommonTree tree = (CommonTree) parser.start().getTree();
        // System.out.println(tree.toStringTree());

        TreeNodeStream treeStream = new BufferedTreeNodeStream(tree);
        FormatterParserBuilder treeBuilder = new FormatterParserBuilder(treeStream);

        start_return ret = treeBuilder.start();
        Start value = ret.value;
        return value;
        // System.out.println(value.toString());
    }

    @Test
    public void testFormatter() throws RecognitionException {

        Start start = parse("1:f:uint16,2:f2:uint32,3:f3:[1:f:utf8,2:f2:sint64,3:f3:[1:f:uint16]],4:f4:[1:f:utf8,3:f3:[1:f:uint16,3:f3:[1:f:uint16]]],5:f5:[1:f:base64,2:f2:[ 1:f:uint16,2:f2:uint32,3:f3:[1:f:utf8,2:f2:sint64,3:f3:[1:f:uint16]],4:f4:[1:f:utf8,3:f3:[1:f:uint16,3:f3:[1:f:uint16]]],5:f5:[1:f:base64]]]");
        Context ctx = new Context();
        ctx.put(Constants.SPACE_COUNT_KEY, new Integer(0));
        Formatter formatter = new Formatter();

        try {
            String s = formatter.visitStart(start, ctx);
            System.out.println(s);
        } catch (AstVisitingException e) {
            e.printStackTrace();
        }
    }
    
    
}
