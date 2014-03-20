package protobufdsl.parse.tree;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.BufferedTreeNodeStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.TreeNodeStream;
import org.junit.Assert;
import org.junit.Test;

import protobufdsl.parse.FormatterParserBuilder;
import protobufdsl.parse.FormatterParserBuilder.start_return;
import protobufdsl.parse.FormatterParserLexer;
import protobufdsl.parse.FormatterParserParser;
import protobufdsl.parse.exception.ParsingException;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Feb 24, 2014 5:48:53 PM
 * 
 */
public class TestLexerParser {

    public void parse(String input) throws RecognitionException {

        FormatterParserLexer lexer = new FormatterParserLexer(new ANTLRStringStream(input));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        FormatterParserParser parser = new FormatterParserParser(tokenStream);
        CommonTree tree = (CommonTree) parser.start().getTree();
        // System.out.println(tree.toStringTree());

        TreeNodeStream treeStream = new BufferedTreeNodeStream(tree);
        FormatterParserBuilder treeBuilder = new FormatterParserBuilder(treeStream);

        start_return ret = treeBuilder.start();
        Start value = ret.value;
        // System.out.println(value.toString());
    }

    public void testLexerParser() throws RecognitionException {
        String input = "1:message:[1:age:sint64(2), 2:name:utf8, 3:favor:utf8(3)](10)";
        input = "1:name:uint32(10)dd,1:name:uint32(10)";
        this.parse(input);

        input = "1:message:[1:age:sint64(2), 2:name:utf8, 3:favor:utf8(3), 1:message:[1:age:sint64(2), 2:name:utf8, 3:favor:utf8(3)](100) ]";
        this.parse(input);
    }

    public void assertParse(String name, String input, boolean flag) {
        boolean f = true;
        try {
            this.parse(input);
        } catch (RecognitionException e) {
            System.out.println(name + ": " + e.getMessage());
            f = false;
        } catch (ParsingException t) {
            System.out.println(name + ": " + t.getMessage());
            f = false;
        } catch (Throwable t) {
            t.printStackTrace();
            f = false;
        }
        Assert.assertTrue(f == flag);
    }

    @Test
    public void testExceptionParse() {
        assertParse("1", "1", false);
        assertParse("2", "1:", false);
        assertParse("3", "1:name", false);
        assertParse("4", "1:name:", false);
        assertParse("5", "1:name:uint16", true);
        assertParse("6", "1:dd:sint64", true);
        assertParse("7", "1::uint32", false);
        assertParse("8", "1:name:uint16:dd", false);
        assertParse("9", "2:age:sint64,44:", false);
        assertParse("10", "1:message:[", false);
        assertParse("11", "1:message:[]", false);
        assertParse("12", "1:message:[2:age:utf8]", true);
        assertParse("13", "1:message:[2:age:utf8,    \t\n2:age:utf8]", true);
        assertParse("14", "1:message:[2:age:utf8,    \t\n2:age:utf8(100)]", true);
        assertParse("15", "2:age:sint64()", false);
        assertParse("16", "2:age:sint64(100)", true);
        assertParse("17", "2:age:sint64(dd)", true);
        assertParse("18", "1:message:[2:age:utf8, 1:message:[2:age:utf8]]", true);
        assertParse("19", "1:message:[2:age:utf8, 1:message:[2:age:utf8](13)]", true);
        assertParse("20", "1:message:[2:age:utf8, 1:message:[2:age:utf8]()]", false);
        assertParse("21", "1:skip:[2:age:utf8, 1:message:[2:age:utf8](dddsfs)]", true);
        assertParse("22",
                "1:skip:[2:age:utf8, 1:message:[2:age:utf8,1:message:[2:age:utf8, 1:message:[2:age:utf8]]](44)]", true);
        assertParse("23", "2:age:sint64(100),1:name:b8utf{123}(10)", true);
        assertParse("24", "2:age:sint64(100),1:name:bytes{123}(10)", true);
        assertParse("25", "2:age:sint64(100),1:name:bytes{123(10)", false);
    }

}
