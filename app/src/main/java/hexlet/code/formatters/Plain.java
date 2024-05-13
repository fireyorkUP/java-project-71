package hexlet.code.formatters;

import hexlet.code.Differences;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Plain {
    public static String propertyValue(Object value1) {
        if (value1 == null) {
            return "null";
        } else if (value1 instanceof String) {
            return "'" + value1 + "'";
        } else if (value1 instanceof Map || value1 instanceof List) {
            return "[complex value]";
        }
        return value1.toString();
    }

    public static String render(TreeMap<String, Differences> map) throws Exception {
        StringBuilder resultString = new StringBuilder("{\n");

        for (var keyS : map.entrySet()) {
            var type = keyS.getValue().tapDifferences();
            var key = keyS.getKey();
            var formattedOldValue = propertyValue(keyS.getValue().getOldValue());
            var formattedNewValue = propertyValue(keyS.getValue().getNewValue());

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
