package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

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

    public static String render(List<Map<String, Object>> list) throws Exception {
        StringBuilder resultString = new StringBuilder();

        for (var keyS : list) {
            var key = keyS.get("key");
            var type = keyS.get("changeType").toString();
            var formattedOldValue = propertyValue(keyS.get("oldValue"));
            var formattedNewValue = propertyValue(keyS.get("newValue"));

            switch (type) {
                case "added" -> resultString.append("Property '").append(key).append("' was added with value: ")
                        .append(formattedNewValue).append("\n");
                case "removed" -> resultString.append("Property '").append(key).append("' was removed")
                        .append("\n");
                case "changed" -> resultString.append("Property '").append(key).append("' was updated. From ")
                        .append(formattedOldValue).append(" to ").append(formattedNewValue).append("\n");
                case "unchanged" -> {
                }
                default -> throw new Exception("Unknown type: '" + type + "'");
            }
        }
        if (!resultString.isEmpty()) {
            resultString.setLength(resultString.length() - System.lineSeparator().length());
        }
        return resultString.toString();
    }
}
