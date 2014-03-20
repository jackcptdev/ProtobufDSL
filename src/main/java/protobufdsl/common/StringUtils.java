package protobufdsl.common;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Feb 26, 2014 6:20:35 PM
 * 
 */
public class StringUtils {

    public static String makeSpaces(int n) {
        StringBuilder b = new StringBuilder(n < 0 ? 0 : n);
        for (int i = 0; i < n; i++) {
            b.append(' ');
        }
        return b.toString();
    }

    public static String fillSpaces(int n, String str) {
        return String.format("%s%s", makeSpaces(n), str);
    }

    public static String nestedTypeName(String name) {
        return String.format("Message%s", name);
    }

}
