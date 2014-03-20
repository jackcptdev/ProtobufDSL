// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g 2014-03-24 10:10:50

package protobufdsl.parse;
import protobufdsl.parse.exception.ParsingException;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class FormatterParserLexer extends Lexer {
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
    public static final int SINT64=4;
    public static final int WS=37;
    public static final int RS_BRAKCET=32;
    public static final int COMB_TYPE=19;
    public static final int COMMA=34;
    public static final int B8UTF=17;
    public static final int BYTES=13;
    public static final int UINT16=8;
    public static final int DOUBLE=11;
    public static final int START=18;
    public static final int IDENT=28;
    public static final int RPT_COUNT=23;
    public static final int ANSI=16;
    public static final int BASE64=15;
    public static final int UINT32=6;
    public static final int DIGIT=35;
    public static final int UTF8=14;
    public static final int SINT32=5;
    public static final int B8UTF_VAR=24;
    public static final int INTEGER_VALUE=27;

        @Override
        public void reportError(RecognitionException e)
        {
            throw new ParsingException(getErrorMessage(e, getTokenNames()), e);
        }


    // delegates
    // delegators

    public FormatterParserLexer() {;} 
    public FormatterParserLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public FormatterParserLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g"; }

    // $ANTLR start "SINT64"
    public final void mSINT64() throws RecognitionException {
        try {
            int _type = SINT64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:140:8: ( 'sint64' )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:140:10: 'sint64'
            {
            match("sint64"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SINT64"

    // $ANTLR start "SINT32"
    public final void mSINT32() throws RecognitionException {
        try {
            int _type = SINT32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:141:8: ( 'sint32' )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:141:10: 'sint32'
            {
            match("sint32"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SINT32"

    // $ANTLR start "UINT32"
    public final void mUINT32() throws RecognitionException {
        try {
            int _type = UINT32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:142:8: ( 'uint32' )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:142:10: 'uint32'
            {
            match("uint32"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UINT32"

    // $ANTLR start "SINT16"
    public final void mSINT16() throws RecognitionException {
        try {
            int _type = SINT16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:143:8: ( 'sint16' )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:143:10: 'sint16'
            {
            match("sint16"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SINT16"

    // $ANTLR start "UINT16"
    public final void mUINT16() throws RecognitionException {
        try {
            int _type = UINT16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:144:8: ( 'uint16' )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:144:10: 'uint16'
            {
            match("uint16"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UINT16"

    // $ANTLR start "SINT8"
    public final void mSINT8() throws RecognitionException {
        try {
            int _type = SINT8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:145:7: ( 'sint8' )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:145:9: 'sint8'
            {
            match("sint8"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SINT8"

    // $ANTLR start "UINT8"
    public final void mUINT8() throws RecognitionException {
        try {
            int _type = UINT8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:146:7: ( 'uint8' )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:146:9: 'uint8'
            {
            match("uint8"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UINT8"

    // $ANTLR start "DOUBLE"
    public final void mDOUBLE() throws RecognitionException {
        try {
            int _type = DOUBLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:147:8: ( 'double' )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:147:10: 'double'
            {
            match("double"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOUBLE"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:148:7: ( 'float' )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:148:9: 'float'
            {
            match("float"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "BYTES"
    public final void mBYTES() throws RecognitionException {
        try {
            int _type = BYTES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:149:7: ( 'bytes' )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:149:9: 'bytes'
            {
            match("bytes"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BYTES"

    // $ANTLR start "UTF8"
    public final void mUTF8() throws RecognitionException {
        try {
            int _type = UTF8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:150:6: ( 'utf8' )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:150:8: 'utf8'
            {
            match("utf8"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UTF8"

    // $ANTLR start "BASE64"
    public final void mBASE64() throws RecognitionException {
        try {
            int _type = BASE64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:151:8: ( 'base64' )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:151:10: 'base64'
            {
            match("base64"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BASE64"

    // $ANTLR start "ANSI"
    public final void mANSI() throws RecognitionException {
        try {
            int _type = ANSI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:152:6: ( 'ansi' )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:152:8: 'ansi'
            {
            match("ansi"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ANSI"

    // $ANTLR start "B8UTF"
    public final void mB8UTF() throws RecognitionException {
        try {
            int _type = B8UTF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:153:7: ( 'b8utf' )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:153:9: 'b8utf'
            {
            match("b8utf"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "B8UTF"

    // $ANTLR start "L_BRAKCET"
    public final void mL_BRAKCET() throws RecognitionException {
        try {
            int _type = L_BRAKCET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:154:11: ( '(' )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:154:13: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "L_BRAKCET"

    // $ANTLR start "R_BRAKCET"
    public final void mR_BRAKCET() throws RecognitionException {
        try {
            int _type = R_BRAKCET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:155:11: ( ')' )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:155:13: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "R_BRAKCET"

    // $ANTLR start "LS_BRAKCET"
    public final void mLS_BRAKCET() throws RecognitionException {
        try {
            int _type = LS_BRAKCET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:156:12: ( '[' )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:156:14: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LS_BRAKCET"

    // $ANTLR start "RS_BRAKCET"
    public final void mRS_BRAKCET() throws RecognitionException {
        try {
            int _type = RS_BRAKCET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:157:12: ( ']' )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:157:14: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RS_BRAKCET"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:158:7: ( ':' )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:158:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:159:7: ( ',' )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:159:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "L_BRACE"
    public final void mL_BRACE() throws RecognitionException {
        try {
            int _type = L_BRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:160:9: ( '{' )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:160:11: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "L_BRACE"

    // $ANTLR start "R_BRACE"
    public final void mR_BRACE() throws RecognitionException {
        try {
            int _type = R_BRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:161:9: ( '}' )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:161:11: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "R_BRACE"

    // $ANTLR start "INTEGER_VALUE"
    public final void mINTEGER_VALUE() throws RecognitionException {
        try {
            int _type = INTEGER_VALUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:165:5: ( ( DIGIT )+ )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:165:7: ( DIGIT )+
            {
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:165:7: ( DIGIT )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:165:7: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTEGER_VALUE"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:169:5: ( ( LETTER ) ( LETTER | DIGIT | '_' )* )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:169:7: ( LETTER ) ( LETTER | DIGIT | '_' )*
            {
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:169:7: ( LETTER )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:169:8: LETTER
            {
            mLETTER(); 

            }

            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:169:16: ( LETTER | DIGIT | '_' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENT"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:173:5: ( '0' .. '9' )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:173:7: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:177:5: ( ( 'A' .. 'Z' | 'a' .. 'z' ) )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:177:7: ( 'A' .. 'Z' | 'a' .. 'z' )
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:181:5: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:181:7: ( ' ' | '\\t' | '\\n' | '\\r' )+
            {
            // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:181:7: ( ' ' | '\\t' | '\\n' | '\\r' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\t' && LA3_0<='\n')||LA3_0=='\r'||LA3_0==' ') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

             _channel=HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:1:8: ( SINT64 | SINT32 | UINT32 | SINT16 | UINT16 | SINT8 | UINT8 | DOUBLE | FLOAT | BYTES | UTF8 | BASE64 | ANSI | B8UTF | L_BRAKCET | R_BRAKCET | LS_BRAKCET | RS_BRAKCET | COLON | COMMA | L_BRACE | R_BRACE | INTEGER_VALUE | IDENT | WS )
        int alt4=25;
        alt4 = dfa4.predict(input);
        switch (alt4) {
            case 1 :
                // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:1:10: SINT64
                {
                mSINT64(); 

                }
                break;
            case 2 :
                // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:1:17: SINT32
                {
                mSINT32(); 

                }
                break;
            case 3 :
                // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:1:24: UINT32
                {
                mUINT32(); 

                }
                break;
            case 4 :
                // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:1:31: SINT16
                {
                mSINT16(); 

                }
                break;
            case 5 :
                // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:1:38: UINT16
                {
                mUINT16(); 

                }
                break;
            case 6 :
                // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:1:45: SINT8
                {
                mSINT8(); 

                }
                break;
            case 7 :
                // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:1:51: UINT8
                {
                mUINT8(); 

                }
                break;
            case 8 :
                // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:1:57: DOUBLE
                {
                mDOUBLE(); 

                }
                break;
            case 9 :
                // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:1:64: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 10 :
                // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:1:70: BYTES
                {
                mBYTES(); 

                }
                break;
            case 11 :
                // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:1:76: UTF8
                {
                mUTF8(); 

                }
                break;
            case 12 :
                // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:1:81: BASE64
                {
                mBASE64(); 

                }
                break;
            case 13 :
                // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:1:88: ANSI
                {
                mANSI(); 

                }
                break;
            case 14 :
                // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:1:93: B8UTF
                {
                mB8UTF(); 

                }
                break;
            case 15 :
                // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:1:99: L_BRAKCET
                {
                mL_BRAKCET(); 

                }
                break;
            case 16 :
                // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:1:109: R_BRAKCET
                {
                mR_BRAKCET(); 

                }
                break;
            case 17 :
                // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:1:119: LS_BRAKCET
                {
                mLS_BRAKCET(); 

                }
                break;
            case 18 :
                // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:1:130: RS_BRAKCET
                {
                mRS_BRAKCET(); 

                }
                break;
            case 19 :
                // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:1:141: COLON
                {
                mCOLON(); 

                }
                break;
            case 20 :
                // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:1:147: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 21 :
                // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:1:153: L_BRACE
                {
                mL_BRACE(); 

                }
                break;
            case 22 :
                // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:1:161: R_BRACE
                {
                mR_BRACE(); 

                }
                break;
            case 23 :
                // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:1:169: INTEGER_VALUE
                {
                mINTEGER_VALUE(); 

                }
                break;
            case 24 :
                // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:1:183: IDENT
                {
                mIDENT(); 

                }
                break;
            case 25 :
                // /home/cuizhijing/work/worksphcatv10udb/protobuf-dsl-dynamic/src/main/java/protobufdsl/parse/FormatterParser.g:1:189: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA4 dfa4 = new DFA4(this);
    static final String DFA4_eotS =
        "\1\uffff\6\20\13\uffff\24\20\1\64\5\20\1\72\3\20\1\76\2\20\1\101"+
        "\1\uffff\1\20\1\103\1\104\1\20\1\106\1\uffff\1\107\1\110\1\111\1"+
        "\uffff\1\112\1\113\1\uffff\1\114\2\uffff\1\115\10\uffff";
    static final String DFA4_eofS =
        "\116\uffff";
    static final String DFA4_minS =
        "\1\11\2\151\1\157\1\154\1\70\1\156\13\uffff\2\156\1\146\1\165\1"+
        "\157\1\164\1\163\1\165\1\163\2\164\1\70\1\142\1\141\2\145\1\164"+
        "\1\151\2\61\1\60\1\154\1\164\1\163\1\66\1\146\1\60\1\64\1\62\1\66"+
        "\1\60\1\62\1\66\1\60\1\uffff\1\145\2\60\1\64\1\60\1\uffff\3\60\1"+
        "\uffff\2\60\1\uffff\1\60\2\uffff\1\60\10\uffff";
    static final String DFA4_maxS =
        "\1\175\1\151\1\164\1\157\1\154\1\171\1\156\13\uffff\2\156\1\146"+
        "\1\165\1\157\1\164\1\163\1\165\1\163\2\164\1\70\1\142\1\141\2\145"+
        "\1\164\1\151\2\70\1\172\1\154\1\164\1\163\1\66\1\146\1\172\1\64"+
        "\1\62\1\66\1\172\1\62\1\66\1\172\1\uffff\1\145\2\172\1\64\1\172"+
        "\1\uffff\3\172\1\uffff\2\172\1\uffff\1\172\2\uffff\1\172\10\uffff";
    static final String DFA4_acceptS =
        "\7\uffff\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31"+
        "\42\uffff\1\13\5\uffff\1\15\3\uffff\1\6\2\uffff\1\7\1\uffff\1\11"+
        "\1\12\1\uffff\1\16\1\1\1\2\1\4\1\3\1\5\1\10\1\14";
    static final String DFA4_specialS =
        "\116\uffff}>";
    static final String[] DFA4_transitionS = {
            "\2\21\2\uffff\1\21\22\uffff\1\21\7\uffff\1\7\1\10\2\uffff\1"+
            "\14\3\uffff\12\17\1\13\6\uffff\32\20\1\11\1\uffff\1\12\3\uffff"+
            "\1\6\1\5\1\20\1\3\1\20\1\4\14\20\1\1\1\20\1\2\5\20\1\15\1\uffff"+
            "\1\16",
            "\1\22",
            "\1\23\12\uffff\1\24",
            "\1\25",
            "\1\26",
            "\1\31\50\uffff\1\30\27\uffff\1\27",
            "\1\32",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\36",
            "\1\37",
            "\1\40",
            "\1\41",
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\57\1\uffff\1\56\2\uffff\1\55\1\uffff\1\60",
            "\1\62\1\uffff\1\61\4\uffff\1\63",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\1\73",
            "\1\74",
            "\1\75",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\1\77",
            "\1\100",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "",
            "\1\102",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\1\105",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "",
            "",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( SINT64 | SINT32 | UINT32 | SINT16 | UINT16 | SINT8 | UINT8 | DOUBLE | FLOAT | BYTES | UTF8 | BASE64 | ANSI | B8UTF | L_BRAKCET | R_BRAKCET | LS_BRAKCET | RS_BRAKCET | COLON | COMMA | L_BRACE | R_BRACE | INTEGER_VALUE | IDENT | WS );";
        }
    }
 

}