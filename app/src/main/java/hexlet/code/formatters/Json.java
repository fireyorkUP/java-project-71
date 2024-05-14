package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Differences;
import java.util.TreeMap;

public class Json {
    public static String render(TreeMap<String, Differences> map) throws Exception {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
