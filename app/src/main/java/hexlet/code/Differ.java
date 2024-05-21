package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;


import static hexlet.code.GetDifferences.getDifferences;


public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        final String firstFileAbsolutePath = getAbsolutePath(filepath1);
        final String secondFileAbsolutePath = getAbsolutePath(filepath2);

        Map<String, Object> data1 = getData(firstFileAbsolutePath, filepath1);
        Map<String, Object> data2 = getData(secondFileAbsolutePath, filepath2);

        return Formatter.formatter(getDifferences(data1, data2), format);
    }

    public static String generate(String filepath1, String filepath2) {
        try {
            return generate(filepath1, filepath2, "stylish");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
