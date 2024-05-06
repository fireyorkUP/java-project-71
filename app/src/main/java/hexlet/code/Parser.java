package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class Parser {
    public static Map<String, Object> parseJson(String content) throws Exception  {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(content, new TypeReference<>() {
            });
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
