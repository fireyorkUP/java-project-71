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
                case "unchanged":
                    resultString.append("    ").append(key).append(": ").append(oldValue).append("\n");
                    break;
                case "changed":
                    resultString.append("  - ").append(key).append(": ").append(oldValue).append("\n")
                            .append("  + ").append(key).append(": ").append(newValue).append("\n");
                    break;
                case "removed":
                    resultString.append("  - ").append(key).append(": ").append(oldValue).append("\n");
                    break;
                case "added":
                    resultString.append("  + ").append(key).append(": ").append(newValue).append("\n");
                    break;
                default:
                    throw new Exception("Unknown type: '" + type + "'");
            }
        }

        resultString.append("}");
        return resultString.toString();
    }
}