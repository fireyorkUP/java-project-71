package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String render(List<Map<String, Object>> list) throws Exception {
        StringBuilder resultString = new StringBuilder("{\n");

        for (var keyS : list) {
            var key = keyS.get("key");
            var type = keyS.get("changeType").toString();
            var oldValue = keyS.get("oldValue");
            var newValue = keyS.get("newValue");

            switch (type) {
                case "unchanged" -> resultString.append("    ").append(key).append(": ").append(oldValue).append("\n");
                case "changed" -> resultString.append("  - ").append(key).append(": ").append(oldValue).append("\n")
                        .append("  + ").append(key).append(": ").append(newValue).append("\n");
                case "removed" -> resultString.append("  - ").append(key).append(": ").append(oldValue).append("\n");
                case "added" -> resultString.append("  + ").append(key).append(": ").append(newValue).append("\n");
                default -> throw new Exception("Unknown type: '" + type + "'");
            }
        }

        resultString.append("}");
        return resultString.toString();
    }
}
