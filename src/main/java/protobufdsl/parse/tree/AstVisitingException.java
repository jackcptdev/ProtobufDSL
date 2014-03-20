package protobufdsl.parse.tree;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Mar 10, 2014 10:41:48 AM
 * 
 */
public class AstVisitingException extends Exception {

    private static final long serialVersionUID = 1L;

    public AstVisitingException() {

    }

    public AstVisitingException(String message) {
        super(message);
    }

    public AstVisitingException(Throwable t) {
        super(t);
    }

    public AstVisitingException(String message, Throwable t) {
        super(message, t);
    }
}
