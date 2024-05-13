package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.util.Map;

public class Parser {
    private static final String[] FILE_TYPE = {"json", "yml", "yaml"};

    public static Map<String, Object> parse(String fileAbsolutePath, String filepath) throws Exception {
        if (findFileType(filepath).equals("json")) {
            return parseJson(fileAbsolutePath);
        } else if (findFileType(filepath).equals("yml") || findFileType(filepath).equals("yaml")) {
            return parseYML(fileAbsolutePath);
        } else {
            throw new Exception("Use formats: .json, .yml, .yaml");
        }
    }

    public static Map<String, Object> parseJson(String filepath) throws Exception  {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(filepath, new TypeReference<>() {
            });
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private static Map<String, Object> parseYML(String filepath) throws Exception {
        try {
            ObjectMapper objectmapper = new YAMLMapper();
            return objectmapper.readValue(filepath, new TypeReference<>() {
            });
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private static String findFileType(String filePath) {
        String fileType = filePath.substring(filePath.lastIndexOf('.') + 1).toLowerCase();

        if (fileType.equals(FILE_TYPE[1])) {
            return FILE_TYPE[2];
        }
        return fileType;
    }
}
