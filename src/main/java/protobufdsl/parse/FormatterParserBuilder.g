tree grammar FormatterParserBuilder;


options {
  language = Java;
  tokenVocab = FormatterParser;
  ASTLabelType = CommonTree;
  output       = AST;
}


@header {
package protobufdsl.parse;
import protobufdsl.parse.tree.primary.*;
import protobufdsl.parse.tree.*;
import protobufdsl.parse.exception.*;
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
}
 
@rulecatch {
    catch (RecognitionException re) {
        throw new ParsingException("bad tree from parser: " + getErrorMessage(re, getTokenNames()), re);
    }
}
 
start returns [Start value]
    : ^(START statement_list) { $value = new Start($statement_list.value); }
    ;

statement_list returns [StatementList value]
    : ^(STMT_LIST { List<Statement> smList = new ArrayList<Statement>(); } (statement { smList.add($statement.value); } )+  { $value = new StatementList(smList.toArray(new Statement[0])); }  )
    ;
    
statement returns [Statement value]
    : ^(STMT integer_number identifier primary_type) { $value = new Statement($integer_number.value, $identifier.value, $primary_type.value ); }
    | ^(STMT integer_number identifier combination_type) { $value = new Statement($integer_number.value, $identifier.value, $combination_type.value ); }
    ;

combination_type returns [TypeDefine value]
      : ^(COMB_TYPE statement_list (repeatedCount=repeated_count)?) { $value = new CombinationType($statement_list.value, $repeatedCount.value); }
      ;
       
       
repeated_count returns [RepeatedCount value]
    : ^(RPT_COUNT integer_number) { $value = new RepeatedCount($integer_number.value, 1); }
    | ^(RPT_COUNT identifier) { $value = new RepeatedCount($identifier.value); }
    ;
       

primary_type returns [TypeDefine value]
    : ^(PRIM_TYPE primary (repeatedCount=repeated_count)?) { $value = new PrimaryType($primary.value, $repeatedCount.value);}
    ;
    
    

primary returns [Primary value]
      : DOUBLE  { $value = new PrimaryDOUBLE() ; }
      | FLOAT   { $value = new PrimaryFLOAT(); }
      | ^(BYTES length=integer_number)  { $value = new PrimaryBYTES($length.value); }
      | UTF8    { $value = new PrimaryUTF8(); }
      | BASE64  { $value = new PrimaryBASE64(); }
      | ANSI    { $value = new PrimaryANSI(); }
      | ^(B8UTF length=integer_number ) { $value = new PrimaryB8UTF($length.value); } 
      | SINT64  { $value = new PrimarySINT64(); } 
      | SINT32  { $value = new PrimarySINT32(); }
      | UINT32  { $value = new PrimaryUINT32(); }
      | SINT16  { $value = new PrimarySINT16(); }
      | UINT16  { $value = new PrimaryUINT16(); }
      | SINT8   { $value = new PrimarySINT8(); } 
      | UINT8   { $value = new PrimaryUINT8(); }
      ;
       
      
integer_number returns [IntegerNumber value]
    : INTEGER_VALUE { $value = new IntegerNumber(Integer.valueOf($INTEGER_VALUE.text)) ;}
    ;
    
    
identifier returns [Identifier value]
    : IDENT  { $value = new Identifier($IDENT.text) ; }
    ;