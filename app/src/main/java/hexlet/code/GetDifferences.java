package hexlet.code;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class GetDifferences {
    public static List<Map<String, Object>> getDifferences(
            Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> keys = new TreeSet<>();
        keys.addAll(data1.keySet());
        keys.addAll(data2.keySet());

        List<Map<String, Object>> resultList = new ArrayList<>();

        for (String key : keys) {
            Map<String, Object> map = new LinkedHashMap<>();
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

            map.put("key", key);
            map.put("oldValue", oldValue);
            map.put("newValue", newValue);
            map.put("changeType", changeType);

            resultList.add(map);
        }
        return resultList;
    }
}
