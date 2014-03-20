package protobufdsl.parse;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.BufferedTreeNodeStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.TreeNodeStream;

import protobufdsl.parse.FormatterParserBuilder.start_return;
import protobufdsl.parse.tree.Start;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Mar 10, 2014 3:02:16 PM
 * 
 */
public class ProtobufDslParseUtils {

    public static Start parse(String input) throws RecognitionException {

        FormatterParserLexer lexer = new FormatterParserLexer(new ANTLRStringStream(input));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        FormatterParserParser parser = new FormatterParserParser(tokenStream);
        CommonTree tree = (CommonTree) parser.start().getTree();

        TreeNodeStream treeStream = new BufferedTreeNodeStream(tree);
        FormatterParserBuilder treeBuilder = new FormatterParserBuilder(treeStream);

        start_return ret = treeBuilder.start();
        Start value = ret.value;
        return value;
    }

}
