package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import java.util.TreeMap;

public class Formatter {
    public static String formatter(TreeMap<String, Differences> map, String format) throws Exception {
        return switch (format.toLowerCase()) {
            case "stylish" -> Stylish.render(map);
            case "plain" -> Plain.render(map);
            case "json" -> Json.render(map);
            default -> throw new IllegalStateException("Unexpected value: " + format);
        };
    }
}
