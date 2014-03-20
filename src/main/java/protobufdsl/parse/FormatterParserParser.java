// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g 2014-03-24 10:10:50

package protobufdsl.parse;
import protobufdsl.parse.exception.ParsingException;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class FormatterParserParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SINT64", "SINT32", "UINT32", "SINT16", "UINT16", "SINT8", "UINT8", "DOUBLE", "FLOAT", "BYTES", "UTF8", "BASE64", "ANSI", "B8UTF", "START", "COMB_TYPE", "STMT_LIST", "STMT", "PRIM_TYPE", "RPT_COUNT", "B8UTF_VAR", "L_BRACE", "R_BRACE", "INTEGER_VALUE", "IDENT", "L_BRAKCET", "R_BRAKCET", "LS_BRAKCET", "RS_BRAKCET", "COLON", "COMMA", "DIGIT", "LETTER", "WS"
    };
    public static final int L_BRAKCET=29;
    public static final int SINT16=7;
    public static final int STMT=21;
    public static final int UINT8=10;
    public static final int STMT_LIST=20;
    public static final int LETTER=36;
    public static final int R_BRAKCET=30;
    public static final int L_BRACE=25;
    public static final int FLOAT=12;
    public static final int R_BRACE=26;
    public static final int LS_BRAKCET=31;
    public static final int EOF=-1;
    public static final int COLON=33;
    public static final int PRIM_TYPE=22;
    public static final int SINT8=9;
    public static final int WS=37;
    public static final int RS_BRAKCET=32;
    public static final int SINT64=4;
    public static final int COMB_TYPE=19;
    public static final int COMMA=34;
    public static final int B8UTF=17;
    public static final int BYTES=13;
    public static final int UINT16=8;
    public static final int DOUBLE=11;
    public static final int IDENT=28;
    public static final int START=18;
    public static final int RPT_COUNT=23;
    public static final int DIGIT=35;
    public static final int UINT32=6;
    public static final int BASE64=15;
    public static final int ANSI=16;
    public static final int SINT32=5;
    public static final int UTF8=14;
    public static final int INTEGER_VALUE=27;
    public static final int B8UTF_VAR=24;

    // delegates
    // delegators


        public FormatterParserParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public FormatterParserParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return FormatterParserParser.tokenNames; }
    public String getGrammarFileName() { return "/home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g"; }


        @Override
        protected Object recoverFromMismatchedToken(IntStream input, int tokenType, BitSet follow)
                throws RecognitionException
        {
            throw new MismatchedTokenException(tokenType, input);
        }

        @Override
        public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow)
                throws RecognitionException
        {
            throw e;
        }

        @Override
        public String getErrorMessage(RecognitionException e, String[] tokenNames)
        {
            return super.getErrorMessage(e, tokenNames);
        }


    public static class start_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "start"
    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:86:1: start : statement_list EOF -> ^( START statement_list ) ;
    public final FormatterParserParser.start_return start() throws RecognitionException {
        FormatterParserParser.start_return retval = new FormatterParserParser.start_return();
        retval.start = input.LT(1);
        int start_StartIndex = input.index();
        CommonTree root_0 = null;

        Token EOF2=null;
        FormatterParserParser.statement_list_return statement_list1 = null;


        CommonTree EOF2_tree=null;
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleSubtreeStream stream_statement_list=new RewriteRuleSubtreeStream(adaptor,"rule statement_list");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:86:6: ( statement_list EOF -> ^( START statement_list ) )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:87:5: statement_list EOF
            {
            pushFollow(FOLLOW_statement_list_in_start200);
            statement_list1=statement_list();

            state._fsp--;

            stream_statement_list.add(statement_list1.getTree());
            EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_start202);  
            stream_EOF.add(EOF2);



            // AST REWRITE
            // elements: statement_list
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 87:24: -> ^( START statement_list )
            {
                // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:87:27: ^( START statement_list )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(START, "START"), root_1);

                adaptor.addChild(root_1, stream_statement_list.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

            catch (RecognitionException re) {
                  throw new ParsingException(getErrorMessage(re, getTokenNames()), re);
            }
        finally {
        }
        return retval;
    }
    // $ANTLR end "start"

    public static class statement_list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement_list"
    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:90:1: statement_list : statement ( ',' statement )* -> ^( STMT_LIST ( statement )+ ) ;
    public final FormatterParserParser.statement_list_return statement_list() throws RecognitionException {
        FormatterParserParser.statement_list_return retval = new FormatterParserParser.statement_list_return();
        retval.start = input.LT(1);
        int statement_list_StartIndex = input.index();
        CommonTree root_0 = null;

        Token char_literal4=null;
        FormatterParserParser.statement_return statement3 = null;

        FormatterParserParser.statement_return statement5 = null;


        CommonTree char_literal4_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:91:5: ( statement ( ',' statement )* -> ^( STMT_LIST ( statement )+ ) )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:91:7: statement ( ',' statement )*
            {
            pushFollow(FOLLOW_statement_in_statement_list228);
            statement3=statement();

            state._fsp--;

            stream_statement.add(statement3.getTree());
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:91:17: ( ',' statement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==COMMA) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:91:18: ',' statement
            	    {
            	    char_literal4=(Token)match(input,COMMA,FOLLOW_COMMA_in_statement_list231);  
            	    stream_COMMA.add(char_literal4);

            	    pushFollow(FOLLOW_statement_in_statement_list233);
            	    statement5=statement();

            	    state._fsp--;

            	    stream_statement.add(statement5.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);



            // AST REWRITE
            // elements: statement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 91:34: -> ^( STMT_LIST ( statement )+ )
            {
                // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:91:37: ^( STMT_LIST ( statement )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(STMT_LIST, "STMT_LIST"), root_1);

                if ( !(stream_statement.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_statement.hasNext() ) {
                    adaptor.addChild(root_1, stream_statement.nextTree());

                }
                stream_statement.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

            catch (RecognitionException re) {
                  throw new ParsingException(getErrorMessage(re, getTokenNames()), re);
            }
        finally {
        }
        return retval;
    }
    // $ANTLR end "statement_list"

    public static class statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:94:1: statement : ( integer_number ':' identifier ':' primary_type -> ^( STMT integer_number identifier primary_type ) | integer_number ':' identifier ':' combination_type -> ^( STMT integer_number identifier combination_type ) );
    public final FormatterParserParser.statement_return statement() throws RecognitionException {
        FormatterParserParser.statement_return retval = new FormatterParserParser.statement_return();
        retval.start = input.LT(1);
        int statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token char_literal7=null;
        Token char_literal9=null;
        Token char_literal12=null;
        Token char_literal14=null;
        FormatterParserParser.integer_number_return integer_number6 = null;

        FormatterParserParser.identifier_return identifier8 = null;

        FormatterParserParser.primary_type_return primary_type10 = null;

        FormatterParserParser.integer_number_return integer_number11 = null;

        FormatterParserParser.identifier_return identifier13 = null;

        FormatterParserParser.combination_type_return combination_type15 = null;


        CommonTree char_literal7_tree=null;
        CommonTree char_literal9_tree=null;
        CommonTree char_literal12_tree=null;
        CommonTree char_literal14_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleSubtreeStream stream_combination_type=new RewriteRuleSubtreeStream(adaptor,"rule combination_type");
        RewriteRuleSubtreeStream stream_integer_number=new RewriteRuleSubtreeStream(adaptor,"rule integer_number");
        RewriteRuleSubtreeStream stream_primary_type=new RewriteRuleSubtreeStream(adaptor,"rule primary_type");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:95:5: ( integer_number ':' identifier ':' primary_type -> ^( STMT integer_number identifier primary_type ) | integer_number ':' identifier ':' combination_type -> ^( STMT integer_number identifier combination_type ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==INTEGER_VALUE) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==COLON) ) {
                    int LA2_2 = input.LA(3);

                    if ( (LA2_2==IDENT) ) {
                        int LA2_3 = input.LA(4);

                        if ( (LA2_3==COLON) ) {
                            int LA2_4 = input.LA(5);

                            if ( ((LA2_4>=SINT64 && LA2_4<=B8UTF)) ) {
                                alt2=1;
                            }
                            else if ( (LA2_4==LS_BRAKCET) ) {
                                alt2=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 2, 4, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 2, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:95:7: integer_number ':' identifier ':' primary_type
                    {
                    pushFollow(FOLLOW_integer_number_in_statement265);
                    integer_number6=integer_number();

                    state._fsp--;

                    stream_integer_number.add(integer_number6.getTree());
                    char_literal7=(Token)match(input,COLON,FOLLOW_COLON_in_statement267);  
                    stream_COLON.add(char_literal7);

                    pushFollow(FOLLOW_identifier_in_statement269);
                    identifier8=identifier();

                    state._fsp--;

                    stream_identifier.add(identifier8.getTree());
                    char_literal9=(Token)match(input,COLON,FOLLOW_COLON_in_statement271);  
                    stream_COLON.add(char_literal9);

                    pushFollow(FOLLOW_primary_type_in_statement274);
                    primary_type10=primary_type();

                    state._fsp--;

                    stream_primary_type.add(primary_type10.getTree());


                    // AST REWRITE
                    // elements: identifier, primary_type, integer_number
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 95:55: -> ^( STMT integer_number identifier primary_type )
                    {
                        // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:95:58: ^( STMT integer_number identifier primary_type )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(STMT, "STMT"), root_1);

                        adaptor.addChild(root_1, stream_integer_number.nextTree());
                        adaptor.addChild(root_1, stream_identifier.nextTree());
                        adaptor.addChild(root_1, stream_primary_type.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:96:8: integer_number ':' identifier ':' combination_type
                    {
                    pushFollow(FOLLOW_integer_number_in_statement295);
                    integer_number11=integer_number();

                    state._fsp--;

                    stream_integer_number.add(integer_number11.getTree());
                    char_literal12=(Token)match(input,COLON,FOLLOW_COLON_in_statement297);  
                    stream_COLON.add(char_literal12);

                    pushFollow(FOLLOW_identifier_in_statement299);
                    identifier13=identifier();

                    state._fsp--;

                    stream_identifier.add(identifier13.getTree());
                    char_literal14=(Token)match(input,COLON,FOLLOW_COLON_in_statement301);  
                    stream_COLON.add(char_literal14);

                    pushFollow(FOLLOW_combination_type_in_statement303);
                    combination_type15=combination_type();

                    state._fsp--;

                    stream_combination_type.add(combination_type15.getTree());


                    // AST REWRITE
                    // elements: combination_type, identifier, integer_number
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 96:59: -> ^( STMT integer_number identifier combination_type )
                    {
                        // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:96:62: ^( STMT integer_number identifier combination_type )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(STMT, "STMT"), root_1);

                        adaptor.addChild(root_1, stream_integer_number.nextTree());
                        adaptor.addChild(root_1, stream_identifier.nextTree());
                        adaptor.addChild(root_1, stream_combination_type.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

            catch (RecognitionException re) {
                  throw new ParsingException(getErrorMessage(re, getTokenNames()), re);
            }
        finally {
        }
        return retval;
    }
    // $ANTLR end "statement"

    public static class combination_type_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "combination_type"
    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:99:1: combination_type : '[' statement_list ']' ( '(' repeated_count ')' )? -> ^( COMB_TYPE statement_list ( repeated_count )? ) ;
    public final FormatterParserParser.combination_type_return combination_type() throws RecognitionException {
        FormatterParserParser.combination_type_return retval = new FormatterParserParser.combination_type_return();
        retval.start = input.LT(1);
        int combination_type_StartIndex = input.index();
        CommonTree root_0 = null;

        Token char_literal16=null;
        Token char_literal18=null;
        Token char_literal19=null;
        Token char_literal21=null;
        FormatterParserParser.statement_list_return statement_list17 = null;

        FormatterParserParser.repeated_count_return repeated_count20 = null;


        CommonTree char_literal16_tree=null;
        CommonTree char_literal18_tree=null;
        CommonTree char_literal19_tree=null;
        CommonTree char_literal21_tree=null;
        RewriteRuleTokenStream stream_L_BRAKCET=new RewriteRuleTokenStream(adaptor,"token L_BRAKCET");
        RewriteRuleTokenStream stream_R_BRAKCET=new RewriteRuleTokenStream(adaptor,"token R_BRAKCET");
        RewriteRuleTokenStream stream_RS_BRAKCET=new RewriteRuleTokenStream(adaptor,"token RS_BRAKCET");
        RewriteRuleTokenStream stream_LS_BRAKCET=new RewriteRuleTokenStream(adaptor,"token LS_BRAKCET");
        RewriteRuleSubtreeStream stream_statement_list=new RewriteRuleSubtreeStream(adaptor,"rule statement_list");
        RewriteRuleSubtreeStream stream_repeated_count=new RewriteRuleSubtreeStream(adaptor,"rule repeated_count");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:100:7: ( '[' statement_list ']' ( '(' repeated_count ')' )? -> ^( COMB_TYPE statement_list ( repeated_count )? ) )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:100:9: '[' statement_list ']' ( '(' repeated_count ')' )?
            {
            char_literal16=(Token)match(input,LS_BRAKCET,FOLLOW_LS_BRAKCET_in_combination_type334);  
            stream_LS_BRAKCET.add(char_literal16);

            pushFollow(FOLLOW_statement_list_in_combination_type336);
            statement_list17=statement_list();

            state._fsp--;

            stream_statement_list.add(statement_list17.getTree());
            char_literal18=(Token)match(input,RS_BRAKCET,FOLLOW_RS_BRAKCET_in_combination_type338);  
            stream_RS_BRAKCET.add(char_literal18);

            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:100:32: ( '(' repeated_count ')' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==L_BRAKCET) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:100:33: '(' repeated_count ')'
                    {
                    char_literal19=(Token)match(input,L_BRAKCET,FOLLOW_L_BRAKCET_in_combination_type341);  
                    stream_L_BRAKCET.add(char_literal19);

                    pushFollow(FOLLOW_repeated_count_in_combination_type343);
                    repeated_count20=repeated_count();

                    state._fsp--;

                    stream_repeated_count.add(repeated_count20.getTree());
                    char_literal21=(Token)match(input,R_BRAKCET,FOLLOW_R_BRAKCET_in_combination_type345);  
                    stream_R_BRAKCET.add(char_literal21);


                    }
                    break;

            }



            // AST REWRITE
            // elements: statement_list, repeated_count
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 100:58: -> ^( COMB_TYPE statement_list ( repeated_count )? )
            {
                // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:100:61: ^( COMB_TYPE statement_list ( repeated_count )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(COMB_TYPE, "COMB_TYPE"), root_1);

                adaptor.addChild(root_1, stream_statement_list.nextTree());
                // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:100:88: ( repeated_count )?
                if ( stream_repeated_count.hasNext() ) {
                    adaptor.addChild(root_1, stream_repeated_count.nextTree());

                }
                stream_repeated_count.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

            catch (RecognitionException re) {
                  throw new ParsingException(getErrorMessage(re, getTokenNames()), re);
            }
        finally {
        }
        return retval;
    }
    // $ANTLR end "combination_type"

    public static class primary_type_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "primary_type"
    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:103:1: primary_type : primary ( '(' repeated_count ')' )? -> ^( PRIM_TYPE primary ( repeated_count )? ) ;
    public final FormatterParserParser.primary_type_return primary_type() throws RecognitionException {
        FormatterParserParser.primary_type_return retval = new FormatterParserParser.primary_type_return();
        retval.start = input.LT(1);
        int primary_type_StartIndex = input.index();
        CommonTree root_0 = null;

        Token char_literal23=null;
        Token char_literal25=null;
        FormatterParserParser.primary_return primary22 = null;

        FormatterParserParser.repeated_count_return repeated_count24 = null;


        CommonTree char_literal23_tree=null;
        CommonTree char_literal25_tree=null;
        RewriteRuleTokenStream stream_L_BRAKCET=new RewriteRuleTokenStream(adaptor,"token L_BRAKCET");
        RewriteRuleTokenStream stream_R_BRAKCET=new RewriteRuleTokenStream(adaptor,"token R_BRAKCET");
        RewriteRuleSubtreeStream stream_primary=new RewriteRuleSubtreeStream(adaptor,"rule primary");
        RewriteRuleSubtreeStream stream_repeated_count=new RewriteRuleSubtreeStream(adaptor,"rule repeated_count");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:104:5: ( primary ( '(' repeated_count ')' )? -> ^( PRIM_TYPE primary ( repeated_count )? ) )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:104:7: primary ( '(' repeated_count ')' )?
            {
            pushFollow(FOLLOW_primary_in_primary_type378);
            primary22=primary();

            state._fsp--;

            stream_primary.add(primary22.getTree());
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:104:15: ( '(' repeated_count ')' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==L_BRAKCET) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:104:16: '(' repeated_count ')'
                    {
                    char_literal23=(Token)match(input,L_BRAKCET,FOLLOW_L_BRAKCET_in_primary_type381);  
                    stream_L_BRAKCET.add(char_literal23);

                    pushFollow(FOLLOW_repeated_count_in_primary_type383);
                    repeated_count24=repeated_count();

                    state._fsp--;

                    stream_repeated_count.add(repeated_count24.getTree());
                    char_literal25=(Token)match(input,R_BRAKCET,FOLLOW_R_BRAKCET_in_primary_type385);  
                    stream_R_BRAKCET.add(char_literal25);


                    }
                    break;

            }



            // AST REWRITE
            // elements: repeated_count, primary
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 104:41: -> ^( PRIM_TYPE primary ( repeated_count )? )
            {
                // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:104:44: ^( PRIM_TYPE primary ( repeated_count )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PRIM_TYPE, "PRIM_TYPE"), root_1);

                adaptor.addChild(root_1, stream_primary.nextTree());
                // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:104:64: ( repeated_count )?
                if ( stream_repeated_count.hasNext() ) {
                    adaptor.addChild(root_1, stream_repeated_count.nextTree());

                }
                stream_repeated_count.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

            catch (RecognitionException re) {
                  throw new ParsingException(getErrorMessage(re, getTokenNames()), re);
            }
        finally {
        }
        return retval;
    }
    // $ANTLR end "primary_type"

    public static class repeated_count_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "repeated_count"
    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:107:1: repeated_count : ( integer_number -> ^( RPT_COUNT integer_number ) | identifier -> ^( RPT_COUNT identifier ) );
    public final FormatterParserParser.repeated_count_return repeated_count() throws RecognitionException {
        FormatterParserParser.repeated_count_return retval = new FormatterParserParser.repeated_count_return();
        retval.start = input.LT(1);
        int repeated_count_StartIndex = input.index();
        CommonTree root_0 = null;

        FormatterParserParser.integer_number_return integer_number26 = null;

        FormatterParserParser.identifier_return identifier27 = null;


        RewriteRuleSubtreeStream stream_integer_number=new RewriteRuleSubtreeStream(adaptor,"rule integer_number");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:108:5: ( integer_number -> ^( RPT_COUNT integer_number ) | identifier -> ^( RPT_COUNT identifier ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==INTEGER_VALUE) ) {
                alt5=1;
            }
            else if ( (LA5_0==IDENT) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:108:7: integer_number
                    {
                    pushFollow(FOLLOW_integer_number_in_repeated_count415);
                    integer_number26=integer_number();

                    state._fsp--;

                    stream_integer_number.add(integer_number26.getTree());


                    // AST REWRITE
                    // elements: integer_number
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 108:22: -> ^( RPT_COUNT integer_number )
                    {
                        // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:108:25: ^( RPT_COUNT integer_number )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RPT_COUNT, "RPT_COUNT"), root_1);

                        adaptor.addChild(root_1, stream_integer_number.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:109:7: identifier
                    {
                    pushFollow(FOLLOW_identifier_in_repeated_count431);
                    identifier27=identifier();

                    state._fsp--;

                    stream_identifier.add(identifier27.getTree());


                    // AST REWRITE
                    // elements: identifier
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 109:18: -> ^( RPT_COUNT identifier )
                    {
                        // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:109:21: ^( RPT_COUNT identifier )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RPT_COUNT, "RPT_COUNT"), root_1);

                        adaptor.addChild(root_1, stream_identifier.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

            catch (RecognitionException re) {
                  throw new ParsingException(getErrorMessage(re, getTokenNames()), re);
            }
        finally {
        }
        return retval;
    }
    // $ANTLR end "repeated_count"

    public static class primary_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "primary"
    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:113:1: primary : ( DOUBLE | FLOAT | BYTES ( L_BRACE integer_number R_BRACE ) -> ^( BYTES integer_number ) | UTF8 | BASE64 | ANSI | B8UTF ( L_BRACE integer_number R_BRACE ) -> ^( B8UTF integer_number ) | SINT64 | SINT32 | UINT32 | SINT16 | UINT16 | SINT8 | UINT8 );
    public final FormatterParserParser.primary_return primary() throws RecognitionException {
        FormatterParserParser.primary_return retval = new FormatterParserParser.primary_return();
        retval.start = input.LT(1);
        int primary_StartIndex = input.index();
        CommonTree root_0 = null;

        Token DOUBLE28=null;
        Token FLOAT29=null;
        Token BYTES30=null;
        Token L_BRACE31=null;
        Token R_BRACE33=null;
        Token UTF834=null;
        Token BASE6435=null;
        Token ANSI36=null;
        Token B8UTF37=null;
        Token L_BRACE38=null;
        Token R_BRACE40=null;
        Token SINT6441=null;
        Token SINT3242=null;
        Token UINT3243=null;
        Token SINT1644=null;
        Token UINT1645=null;
        Token SINT846=null;
        Token UINT847=null;
        FormatterParserParser.integer_number_return integer_number32 = null;

        FormatterParserParser.integer_number_return integer_number39 = null;


        CommonTree DOUBLE28_tree=null;
        CommonTree FLOAT29_tree=null;
        CommonTree BYTES30_tree=null;
        CommonTree L_BRACE31_tree=null;
        CommonTree R_BRACE33_tree=null;
        CommonTree UTF834_tree=null;
        CommonTree BASE6435_tree=null;
        CommonTree ANSI36_tree=null;
        CommonTree B8UTF37_tree=null;
        CommonTree L_BRACE38_tree=null;
        CommonTree R_BRACE40_tree=null;
        CommonTree SINT6441_tree=null;
        CommonTree SINT3242_tree=null;
        CommonTree UINT3243_tree=null;
        CommonTree SINT1644_tree=null;
        CommonTree UINT1645_tree=null;
        CommonTree SINT846_tree=null;
        CommonTree UINT847_tree=null;
        RewriteRuleTokenStream stream_L_BRACE=new RewriteRuleTokenStream(adaptor,"token L_BRACE");
        RewriteRuleTokenStream stream_R_BRACE=new RewriteRuleTokenStream(adaptor,"token R_BRACE");
        RewriteRuleTokenStream stream_B8UTF=new RewriteRuleTokenStream(adaptor,"token B8UTF");
        RewriteRuleTokenStream stream_BYTES=new RewriteRuleTokenStream(adaptor,"token BYTES");
        RewriteRuleSubtreeStream stream_integer_number=new RewriteRuleSubtreeStream(adaptor,"rule integer_number");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:114:7: ( DOUBLE | FLOAT | BYTES ( L_BRACE integer_number R_BRACE ) -> ^( BYTES integer_number ) | UTF8 | BASE64 | ANSI | B8UTF ( L_BRACE integer_number R_BRACE ) -> ^( B8UTF integer_number ) | SINT64 | SINT32 | UINT32 | SINT16 | UINT16 | SINT8 | UINT8 )
            int alt6=14;
            switch ( input.LA(1) ) {
            case DOUBLE:
                {
                alt6=1;
                }
                break;
            case FLOAT:
                {
                alt6=2;
                }
                break;
            case BYTES:
                {
                alt6=3;
                }
                break;
            case UTF8:
                {
                alt6=4;
                }
                break;
            case BASE64:
                {
                alt6=5;
                }
                break;
            case ANSI:
                {
                alt6=6;
                }
                break;
            case B8UTF:
                {
                alt6=7;
                }
                break;
            case SINT64:
                {
                alt6=8;
                }
                break;
            case SINT32:
                {
                alt6=9;
                }
                break;
            case UINT32:
                {
                alt6=10;
                }
                break;
            case SINT16:
                {
                alt6=11;
                }
                break;
            case UINT16:
                {
                alt6=12;
                }
                break;
            case SINT8:
                {
                alt6=13;
                }
                break;
            case UINT8:
                {
                alt6=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:114:9: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    DOUBLE28=(Token)match(input,DOUBLE,FOLLOW_DOUBLE_in_primary459); 
                    DOUBLE28_tree = (CommonTree)adaptor.create(DOUBLE28);
                    adaptor.addChild(root_0, DOUBLE28_tree);


                    }
                    break;
                case 2 :
                    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:115:9: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    FLOAT29=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_primary469); 
                    FLOAT29_tree = (CommonTree)adaptor.create(FLOAT29);
                    adaptor.addChild(root_0, FLOAT29_tree);


                    }
                    break;
                case 3 :
                    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:116:9: BYTES ( L_BRACE integer_number R_BRACE )
                    {
                    BYTES30=(Token)match(input,BYTES,FOLLOW_BYTES_in_primary479);  
                    stream_BYTES.add(BYTES30);

                    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:116:15: ( L_BRACE integer_number R_BRACE )
                    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:116:16: L_BRACE integer_number R_BRACE
                    {
                    L_BRACE31=(Token)match(input,L_BRACE,FOLLOW_L_BRACE_in_primary482);  
                    stream_L_BRACE.add(L_BRACE31);

                    pushFollow(FOLLOW_integer_number_in_primary484);
                    integer_number32=integer_number();

                    state._fsp--;

                    stream_integer_number.add(integer_number32.getTree());
                    R_BRACE33=(Token)match(input,R_BRACE,FOLLOW_R_BRACE_in_primary486);  
                    stream_R_BRACE.add(R_BRACE33);


                    }



                    // AST REWRITE
                    // elements: integer_number, BYTES
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 116:49: -> ^( BYTES integer_number )
                    {
                        // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:116:52: ^( BYTES integer_number )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_BYTES.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_integer_number.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 4 :
                    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:117:9: UTF8
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    UTF834=(Token)match(input,UTF8,FOLLOW_UTF8_in_primary506); 
                    UTF834_tree = (CommonTree)adaptor.create(UTF834);
                    adaptor.addChild(root_0, UTF834_tree);


                    }
                    break;
                case 5 :
                    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:118:9: BASE64
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    BASE6435=(Token)match(input,BASE64,FOLLOW_BASE64_in_primary516); 
                    BASE6435_tree = (CommonTree)adaptor.create(BASE6435);
                    adaptor.addChild(root_0, BASE6435_tree);


                    }
                    break;
                case 6 :
                    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:119:9: ANSI
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    ANSI36=(Token)match(input,ANSI,FOLLOW_ANSI_in_primary526); 
                    ANSI36_tree = (CommonTree)adaptor.create(ANSI36);
                    adaptor.addChild(root_0, ANSI36_tree);


                    }
                    break;
                case 7 :
                    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:120:9: B8UTF ( L_BRACE integer_number R_BRACE )
                    {
                    B8UTF37=(Token)match(input,B8UTF,FOLLOW_B8UTF_in_primary536);  
                    stream_B8UTF.add(B8UTF37);

                    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:120:15: ( L_BRACE integer_number R_BRACE )
                    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:120:16: L_BRACE integer_number R_BRACE
                    {
                    L_BRACE38=(Token)match(input,L_BRACE,FOLLOW_L_BRACE_in_primary539);  
                    stream_L_BRACE.add(L_BRACE38);

                    pushFollow(FOLLOW_integer_number_in_primary541);
                    integer_number39=integer_number();

                    state._fsp--;

                    stream_integer_number.add(integer_number39.getTree());
                    R_BRACE40=(Token)match(input,R_BRACE,FOLLOW_R_BRACE_in_primary543);  
                    stream_R_BRACE.add(R_BRACE40);


                    }



                    // AST REWRITE
                    // elements: integer_number, B8UTF
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 120:49: -> ^( B8UTF integer_number )
                    {
                        // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:120:52: ^( B8UTF integer_number )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_B8UTF.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_integer_number.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 8 :
                    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:121:9: SINT64
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    SINT6441=(Token)match(input,SINT64,FOLLOW_SINT64_in_primary565); 
                    SINT6441_tree = (CommonTree)adaptor.create(SINT6441);
                    adaptor.addChild(root_0, SINT6441_tree);


                    }
                    break;
                case 9 :
                    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:122:9: SINT32
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    SINT3242=(Token)match(input,SINT32,FOLLOW_SINT32_in_primary575); 
                    SINT3242_tree = (CommonTree)adaptor.create(SINT3242);
                    adaptor.addChild(root_0, SINT3242_tree);


                    }
                    break;
                case 10 :
                    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:123:9: UINT32
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    UINT3243=(Token)match(input,UINT32,FOLLOW_UINT32_in_primary585); 
                    UINT3243_tree = (CommonTree)adaptor.create(UINT3243);
                    adaptor.addChild(root_0, UINT3243_tree);


                    }
                    break;
                case 11 :
                    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:124:9: SINT16
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    SINT1644=(Token)match(input,SINT16,FOLLOW_SINT16_in_primary595); 
                    SINT1644_tree = (CommonTree)adaptor.create(SINT1644);
                    adaptor.addChild(root_0, SINT1644_tree);


                    }
                    break;
                case 12 :
                    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:125:9: UINT16
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    UINT1645=(Token)match(input,UINT16,FOLLOW_UINT16_in_primary605); 
                    UINT1645_tree = (CommonTree)adaptor.create(UINT1645);
                    adaptor.addChild(root_0, UINT1645_tree);


                    }
                    break;
                case 13 :
                    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:126:9: SINT8
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    SINT846=(Token)match(input,SINT8,FOLLOW_SINT8_in_primary615); 
                    SINT846_tree = (CommonTree)adaptor.create(SINT846);
                    adaptor.addChild(root_0, SINT846_tree);


                    }
                    break;
                case 14 :
                    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:127:9: UINT8
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    UINT847=(Token)match(input,UINT8,FOLLOW_UINT8_in_primary625); 
                    UINT847_tree = (CommonTree)adaptor.create(UINT847);
                    adaptor.addChild(root_0, UINT847_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

            catch (RecognitionException re) {
                  throw new ParsingException(getErrorMessage(re, getTokenNames()), re);
            }
        finally {
        }
        return retval;
    }
    // $ANTLR end "primary"

    public static class integer_number_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "integer_number"
    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:131:1: integer_number : INTEGER_VALUE ;
    public final FormatterParserParser.integer_number_return integer_number() throws RecognitionException {
        FormatterParserParser.integer_number_return retval = new FormatterParserParser.integer_number_return();
        retval.start = input.LT(1);
        int integer_number_StartIndex = input.index();
        CommonTree root_0 = null;

        Token INTEGER_VALUE48=null;

        CommonTree INTEGER_VALUE48_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:132:5: ( INTEGER_VALUE )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:132:7: INTEGER_VALUE
            {
            root_0 = (CommonTree)adaptor.nil();

            INTEGER_VALUE48=(Token)match(input,INTEGER_VALUE,FOLLOW_INTEGER_VALUE_in_integer_number645); 
            INTEGER_VALUE48_tree = (CommonTree)adaptor.create(INTEGER_VALUE48);
            adaptor.addChild(root_0, INTEGER_VALUE48_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

            catch (RecognitionException re) {
                  throw new ParsingException(getErrorMessage(re, getTokenNames()), re);
            }
        finally {
        }
        return retval;
    }
    // $ANTLR end "integer_number"

    public static class identifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "identifier"
    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:135:1: identifier : IDENT ;
    public final FormatterParserParser.identifier_return identifier() throws RecognitionException {
        FormatterParserParser.identifier_return retval = new FormatterParserParser.identifier_return();
        retval.start = input.LT(1);
        int identifier_StartIndex = input.index();
        CommonTree root_0 = null;

        Token IDENT49=null;

        CommonTree IDENT49_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:136:5: ( IDENT )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:136:7: IDENT
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT49=(Token)match(input,IDENT,FOLLOW_IDENT_in_identifier666); 
            IDENT49_tree = (CommonTree)adaptor.create(IDENT49);
            adaptor.addChild(root_0, IDENT49_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

            catch (RecognitionException re) {
                  throw new ParsingException(getErrorMessage(re, getTokenNames()), re);
            }
        finally {
        }
        return retval;
    }
    // $ANTLR end "identifier"

    // Delegated rules


 

    public static final BitSet FOLLOW_statement_list_in_start200 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_statement_list228 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_COMMA_in_statement_list231 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_statement_in_statement_list233 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_integer_number_in_statement265 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_COLON_in_statement267 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_identifier_in_statement269 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_COLON_in_statement271 = new BitSet(new long[]{0x000000000003FFF0L});
    public static final BitSet FOLLOW_primary_type_in_statement274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integer_number_in_statement295 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_COLON_in_statement297 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_identifier_in_statement299 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_COLON_in_statement301 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_combination_type_in_statement303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LS_BRAKCET_in_combination_type334 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_statement_list_in_combination_type336 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_RS_BRAKCET_in_combination_type338 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_L_BRAKCET_in_combination_type341 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_repeated_count_in_combination_type343 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_R_BRAKCET_in_combination_type345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_primary_type378 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_L_BRAKCET_in_primary_type381 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_repeated_count_in_primary_type383 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_R_BRAKCET_in_primary_type385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integer_number_in_repeated_count415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_repeated_count431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_primary459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_primary469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTES_in_primary479 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_L_BRACE_in_primary482 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_integer_number_in_primary484 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_R_BRACE_in_primary486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UTF8_in_primary506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BASE64_in_primary516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ANSI_in_primary526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_B8UTF_in_primary536 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_L_BRACE_in_primary539 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_integer_number_in_primary541 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_R_BRACE_in_primary543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SINT64_in_primary565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SINT32_in_primary575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UINT32_in_primary585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SINT16_in_primary595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UINT16_in_primary605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SINT8_in_primary615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UINT8_in_primary625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_VALUE_in_integer_number645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_identifier666 = new BitSet(new long[]{0x0000000000000002L});

}