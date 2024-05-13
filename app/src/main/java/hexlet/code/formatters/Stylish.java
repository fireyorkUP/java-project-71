package hexlet.code.formatters;

import hexlet.code.Differences;
import java.util.TreeMap;

public class Stylish {
    public static String render(TreeMap<String, Differences> map) throws Exception {
        StringBuilder resultString = new StringBuilder("{\n");

        for (var keyS : map.entrySet()) {
            var key = keyS.getKey();
            var value = keyS.getValue();
            var type = value.getState();
            var oldValue = value.getOldValue();
            var newValue = value.getNewValue();

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