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

        List<Map<String, Object>> result = new ArrayList<>();
        for (String key :  keys) {
            Map<String, Object> map = new LinkedHashMap<>();
            if (data1.containsKey(key) && !data2.containsKey(key)) {
                map.put("key", key);
                map.put("oldValue", data1.get(key));
                map.put("status", "removed");
            } else if (!data1.containsKey(key) && data2.containsKey(key)) {
                map.put("key", key);
                map.put("newValue", data2.get(key));
                map.put("status", "added");
            } else if (!Objects.equals(data1.get(key), data2.get(key))) {
                map.put("key", key);
                map.put("oldValue", data1.get(key));
                map.put("newValue", data2.get(key));
                map.put("status", "updated");
            } else {
                map.put("key", key);
                map.put("oldValue", data1.get(key));
                map.put("status", "unchanged");
            }
            result.add(map);
        }

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
