package protobufdsl.protogenerate;

import protobufdsl.parse.tree.AstVisitingException;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Mar 10, 2014 10:39:34 AM
 * 
 */
public class ProtoGeneratingException extends AstVisitingException {

    private static final long serialVersionUID = 1L;

    public ProtoGeneratingException() {
        super();
    }

    public ProtoGeneratingException(String msg) {
        super(msg);
    }

    public ProtoGeneratingException(Throwable t) {
        super(t);
    }

    public ProtoGeneratingException(String msg, Throwable t) {
        super(msg, t);
    }

}
