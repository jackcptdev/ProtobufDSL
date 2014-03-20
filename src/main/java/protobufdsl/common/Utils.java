package protobufdsl.common;

import java.util.List;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Feb 24, 2014 11:11:48 AM
 * 
 */
public class Utils {

    public static void checkNotNull(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == null) {
                throw new IllegalArgumentException(String.format("Object in index [%d] is null.", i));
            }
        }
    }

    public static int hashcode(Object... objs) {
        if (objs == null) {
            return 0;
        }
        int h = 1;
        for (int i = 0; i < objs.length; i++) {
            h = h * 31 + (objs[i] == null ? 0 : objs[i].hashCode());
        }
        return h;
    }

    @SuppressWarnings("rawtypes")
    public static int hashcode(List objs) {
        if (objs == null) {
            return 0;
        }

        int h = 1;
        for (Object o : objs) {
            h = h * 31 + (o == null ? 0 : o.hashCode());
        }
        return h;
    }

    public static boolean objEquals(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

}
