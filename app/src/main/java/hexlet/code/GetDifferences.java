package hexlet.code;


import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class GetDifferences {
    public static TreeMap<String, Differences> getDifferences(
            Map<String, Object> data1, Map<String, Object> data2) {
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
        return result;
    }
}
