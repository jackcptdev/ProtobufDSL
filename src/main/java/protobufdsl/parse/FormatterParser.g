grammar FormatterParser;

options {
  output       = AST;
  ASTLabelType = CommonTree;
  language     = Java;
  memoize=true;
}

tokens {
SINT64 ;
SINT32 ;
UINT32 ;
SINT16 ;
UINT16 ;
SINT8 ;
UINT8 ;
DOUBLE ;
FLOAT ;
BYTES ;
UTF8 ;
BASE64 ;
ANSI ;
B8UTF ;
START ;
COMB_TYPE ;
STMT_LIST ;
STMT ;
PRIM_TYPE ;
RPT_COUNT ;
B8UTF_VAR ;
L_BRACE ;
R_BRACE ;
}


@header {
package protobufdsl.parse;
import protobufdsl.parse.exception.ParsingException;
}

@lexer::header {
package protobufdsl.parse;
import protobufdsl.parse.exception.ParsingException;
}


@members {
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
} 

@rulecatch {
    catch (RecognitionException re) {
          throw new ParsingException(getErrorMessage(re, getTokenNames()), re);
    }
}


@lexer::members {
    @Override
    public void reportError(RecognitionException e)
    {
        throw new ParsingException(getErrorMessage(e, getTokenNames()), e);
    }
}


start:
    statement_list EOF -> ^(START statement_list)
    ;

statement_list 
    : statement (',' statement)* -> ^(STMT_LIST statement+)
    ;
    
statement
    : integer_number ':' identifier ':'  primary_type -> ^(STMT integer_number identifier primary_type)
    |  integer_number ':' identifier ':' combination_type -> ^(STMT integer_number identifier combination_type)
    ;

combination_type
      : '[' statement_list ']' ('(' repeated_count ')')? -> ^(COMB_TYPE statement_list repeated_count?)
      ;

primary_type 
    : primary ('(' repeated_count ')')? -> ^(PRIM_TYPE primary repeated_count?)
    ;

repeated_count
    : integer_number -> ^(RPT_COUNT integer_number)
    | identifier -> ^(RPT_COUNT identifier)
    ;


primary
      : DOUBLE
      | FLOAT
      | BYTES (L_BRACE integer_number R_BRACE ) -> ^(BYTES integer_number)
      | UTF8
      | BASE64
      | ANSI
      | B8UTF (L_BRACE integer_number R_BRACE ) -> ^(B8UTF integer_number ) 
      | SINT64
      | SINT32
      | UINT32
      | SINT16
      | UINT16
      | SINT8
      | UINT8
      ;


integer_number
    : INTEGER_VALUE
    ;
    
identifier
    : IDENT
    ;
    
    
SINT64 : 'sint64';
SINT32 : 'sint32';
UINT32 : 'uint32';
SINT16 : 'sint16';
UINT16 : 'uint16';
SINT8 : 'sint8';
UINT8 : 'uint8';
DOUBLE : 'double';
FLOAT : 'float';
BYTES : 'bytes';
UTF8 : 'utf8';
BASE64 : 'base64';
ANSI : 'ansi';
B8UTF : 'b8utf';
L_BRAKCET : '(';
R_BRAKCET : ')';
LS_BRAKCET : '[';
RS_BRAKCET : ']';
COLON : ':' ;
COMMA : ',' ;
L_BRACE : '{' ;
R_BRACE : '}' ;


INTEGER_VALUE
    : DIGIT+
    ;
    
IDENT
    : (LETTER) (LETTER | DIGIT | '_' )*
    ;    

fragment DIGIT
    : '0'..'9'
    ;

fragment LETTER
    : ('A'..'Z' | 'a'..'z')
    ;

WS
    : (' ' | '\t' | '\n' | '\r')+ { $channel=HIDDEN; }
    ;
    