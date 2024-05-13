package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        final String firstFileAbsolutePath = getAbsolutePath(filepath1);
        final String secondFileAbsolutePath = getAbsolutePath(filepath2);

        Map<String, Object> data1 = getData(firstFileAbsolutePath, filepath1);
        Map<String, Object> data2 = getData(secondFileAbsolutePath, filepath2);

        Set<String> keys = new TreeSet<>();
        keys.addAll(data1.keySet());
        keys.addAll(data2.keySet());

        TreeMap<String, Differences> result = new TreeMap<>();

        for (String key : keys) {
            Object oldValue = data1.get(key);
            Object newValue = data2.get(key);
            String changeType = "unchanged";

            if (oldValue == null && !data1.containsKey(key)) {
                changeType = "added";
            } else if (newValue == null && !data2.containsKey(key)) {
                changeType = "removed";
            } else if (!Objects.equals(oldValue, newValue)) {
                changeType = "changed";
            }

            result.put(key, new Differences(oldValue, newValue, changeType));
        }

        return Formatter.formatter(result, format);
    }

    private static String getAbsolutePath(String filepath) throws Exception {
        try {
            Path path = Paths.get(filepath).toAbsolutePath().normalize();
            return Files.readString(path);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private static Map<String, Object> getData(String content, String filepath) throws Exception {
        try {
            return Parser.parse(content, filepath);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
