package hexlet.code.formatters;

import hexlet.code.Differences;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Plain {
    public static String propertyValue(Object value) {
        if (value == null) {
            return "null";
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        }
        return value.toString();
    }

    public static String render(TreeMap<String, Differences> map) throws Exception {
        StringBuilder resultString = new StringBuilder("{\n");

        for (var keyS : map.entrySet()) {
            var value = keyS.getValue();
            var key = keyS.getKey();
            var type = value.getState();
            var formattedOldValue = propertyValue(value.getOldValue());
            var formattedNewValue = propertyValue(value.getNewValue());

            switch (type) {
                case "added":
                    resultString.append("Property '").append(key).append("' was added with value: ")
                            .append(formattedNewValue).append("\n");
                    break;
                case "removed":
                    resultString.append("Property '").append(key).append("' was removed")
                            .append("\n");
                    break;
                case "changed":
                    resultString.append("Property '").append(key).append("' was updated. From ")
                            .append(formattedOldValue).append(" to ").append(formattedNewValue).append("\n");
                    break;
                case "unchanged":
                    break;
                default:
                    throw new Exception("Unknown type: '" + type + "'");
            }
        }
        resultString.append("}");
        return resultString.toString();
    }
}
