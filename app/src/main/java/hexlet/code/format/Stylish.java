package hexlet.code.format;

import hexlet.code.Differences;
import java.util.TreeMap;

public class Stylish {
    public static String render(TreeMap<String, Differences> map) {
        StringBuilder resultString = new StringBuilder("{\n");

        for (var keyWithStatus : map.entrySet()) {
            var key = keyWithStatus.getKey();
            var data = keyWithStatus.getValue();

            if (data.tapDifferences().equals("unchanged")) {
                resultString.append("    ").append(key).append(": ").append(data.getOldValue()).append("\n");
            } else if (data.tapDifferences().equals("changed")) {
                resultString.append(" ".repeat(2)).append("- ").append(key).append(": ").append(data.getOldValue()).append("\n");
                resultString.append(" ".repeat(2)).append("+ ").append(key).append(": ").append(data.getNewValue()).append("\n");
            } else if (data.tapDifferences().equals("removed")) {
                resultString.append(" ".repeat(2)).append("- ").append(key).append(": ").append(data.getOldValue()).append("\n");
            } else if (data.tapDifferences().equals("added")) {
                resultString.append(" ".repeat(2)).append("+ ").append(key).append(": ").append(data.getNewValue()).append("\n");
            }
        }

        resultString.append("}");
        return resultString.toString();
    }
}