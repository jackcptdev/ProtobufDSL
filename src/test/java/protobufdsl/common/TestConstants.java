package protobufdsl.common;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Mar 21, 2014 4:26:41 PM
 * 
 */
public class TestConstants {

    public static Context newTestContext() {
        Context ctx = new Context();
        ctx.put(Constants.PROTO_OUTER_MESSAGE_NAME_KEY, "TestMessage");
        ctx.put(Constants.SPACE_COUNT_KEY, 0);
        return ctx;
    }

}
