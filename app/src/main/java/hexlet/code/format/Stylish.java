package hexlet.code.format;

import hexlet.code.Differences;
import java.util.TreeMap;

public class Stylish {
    public static String render(TreeMap<String, Differences> map) {
        StringBuilder resultString = new StringBuilder("{\n");

        for (var keyS : map.entrySet()) {
            var key = keyS.getKey();
            var value = keyS.getValue();

            if (value.tapDifferences().equals("unchanged")) {
                resultString.append("    ").append(key).append(": ").append(value.getOldValue()).append("\n");
            } else if (value.tapDifferences().equals("changed")) {
                resultString.append(" ".repeat(2)).append("- ").append(key).append(": ").append(value.getOldValue()).append("\n");
                resultString.append(" ".repeat(2)).append("+ ").append(key).append(": ").append(value.getNewValue()).append("\n");
            } else if (value.tapDifferences().equals("removed")) {
                resultString.append(" ".repeat(2)).append("- ").append(key).append(": ").append(value.getOldValue()).append("\n");
            } else if (value.tapDifferences().equals("added")) {
                resultString.append(" ".repeat(2)).append("+ ").append(key).append(": ").append(value.getNewValue()).append("\n");
            }
        }

        resultString.append("}");
        return resultString.toString();
    }
}