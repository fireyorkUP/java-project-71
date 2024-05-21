package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String formatter(List<Map<String, Object>> list, String format) throws Exception {
        return switch (format.toLowerCase()) {
            case "stylish" -> Stylish.render(list);
            case "plain" -> Plain.render(list);
            case "json" -> Json.render(list);
            default -> throw new IllegalStateException("Unexpected value: " + format);
        };
    }
}
