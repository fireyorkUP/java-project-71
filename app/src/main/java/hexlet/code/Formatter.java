package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import java.util.TreeMap;

public class Formatter {
    public static String formatter(TreeMap<String, Differences> map, String format) throws Exception {
        return switch (format) {
            case "stylish" -> Stylish.render(map);
            case "plain" -> Plain.render(map);
            default -> throw new IllegalStateException("Unexpected value: " + format);
        };
    }
}
