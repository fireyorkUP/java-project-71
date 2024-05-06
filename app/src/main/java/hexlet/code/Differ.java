package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        Map<String, Object> data1 = getData(getContent(filepath1));
        Map<String, Object> data2 = getData(getContent(filepath2));

        Set<String> keys = new TreeSet<>();
        keys.addAll(data1.keySet());
        keys.addAll(data2.keySet());

        TreeMap<String, Differences> result = new TreeMap<>();

        for (var key : keys) {
            Object oldValue = data1.get(key);
            Object newValue = data2.get(key);

            if (oldValue == null && !data1.containsKey(key)) {
                result.put(key, new Differences(oldValue, newValue, "added"));
            } else if (newValue == null && !data2.containsKey(key)) {
                result.put(key, new Differences(oldValue, newValue, "removed"));
            } else if (!Objects.equals(oldValue, newValue)) {
                result.put(key, new Differences(oldValue, newValue, "changed"));
            } else {
                result.put(key, new Differences(oldValue, newValue, "unchanged"));
            }
        }

        return Formatter.formatter(result, format);
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
