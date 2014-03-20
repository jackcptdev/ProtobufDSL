package protobufdsl.parse.exception;

import static java.lang.String.format;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.RecognitionException;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Feb 21, 2014 6:32:05 PM
 * 
 */
public class ParsingException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ParsingException(String message, RecognitionException cause) {
        super(message, cause);
    }

    public ParsingException(String message) {
        this(message, new RecognitionException(new ANTLRStringStream()));
    }

    @Override
    public RecognitionException getCause() {
        return (RecognitionException) super.getCause();
    }

    public int getLineNumber() {
        return getCause().line;
    }

    public int getColumnNumber() {
        return getCause().charPositionInLine + 1;
    }

    public String getErrorMessage() {
        return super.getMessage();
    }

    @Override
    public String getMessage() {
        return format("line[%s],Column[%s],Error[ %s ]", getLineNumber(), getColumnNumber(), getErrorMessage());
    }

}
