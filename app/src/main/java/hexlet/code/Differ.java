package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Differ {

    public static String generate(String filepath1, String filepath2) throws Exception {
        Map<String, Object> data1 = getData(getContent(filepath1));
        Map<String, Object> data2 = getData(getContent(filepath2));

        Set<String> keys = new TreeSet<>();
        keys.addAll(data1.keySet());
        keys.addAll(data2.keySet());

        StringBuilder result = new StringBuilder();
        result.append("{\n");

        for (var key : keys) {
            if (data1.containsKey(key) && data2.containsKey(key)) {
                if (data1.get(key).equals(data2.get(key))) {
                    result.append("    ").append(key).append(": ").append(data1.get(key)).append("\n");
                } else {
                    result.append("  - ").append(key).append(": ").append(data1.get(key)).append("\n");
                    result.append("  + ").append(key).append(": ").append(data2.get(key)).append("\n");
                }
            } else if (data1.containsKey(key) && !data2.containsKey(key)) {
                result.append("  - ").append(key).append(": ").append(data1.get(key)).append("\n");
            } else if (!data1.containsKey(key) && data2.containsKey(key)) {
                result.append("  + ").append(key).append(": ").append(data2.get(key)).append("\n");
            }
        }
        result.append("}");

        return result.toString();
    }

    private static String getContent(String filepath) throws Exception {
        try {
            Path path = Paths.get(filepath).toAbsolutePath().normalize();
            return Files.readString(path);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private static Map<String, Object> getData(String content) throws Exception {
        try {
            return Parser.parseJson(content);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
