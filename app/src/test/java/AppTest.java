import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class AppTest {

    private final String filePath1 = "src/test/resources/Json1.json";
    private final String filePath2 = "src/test/resources/Json2.json";

    private final String filePath3 = "src/test/resources/Yaml1.yaml";
    private final String filePath4 = "src/test/resources/Yaml2.yaml";

    @Test
    public void testCallJson() throws Exception {
        var path = Paths.get("src/test/resources/Stylish").toAbsolutePath().normalize();
        String expectedResults = Files.readString(path).trim();
        String format = "stylish";
        String actual = Differ.generate(filePath1, filePath2, format);
        assertEquals(expectedResults, actual);
    }

    @Test
    public void testCallYaml() throws Exception {
        var path = Paths.get("src/test/resources/Stylish").toAbsolutePath().normalize();
        String expectedResults = Files.readString(path).trim();
        String format = "stylish";
        String actual = Differ.generate(filePath3, filePath4, format);
        assertEquals(expectedResults, actual);
    }

    @Test
    public void testCallJsonPlain() throws Exception {
        var path = Paths.get("src/test/resources/Plain").toAbsolutePath().normalize();
        String expectedResults = Files.readString(path).trim();
        String format = "plain";
        String actual = Differ.generate(filePath1, filePath2, format);
        assertEquals(expectedResults, actual);
    }

    @Test
    public void testCallYamlPlain() throws Exception {
        var path = Paths.get("src/test/resources/Plain").toAbsolutePath().normalize();
        String expectedResults = Files.readString(path).trim();
        String format = "plain";
        String actual = Differ.generate(filePath3, filePath4, format);
        assertEquals(expectedResults, actual);
    }

    @Test
    public void testJsonToJson() throws Exception {
        var path = Paths.get("src/test/resources/Json").toAbsolutePath().normalize();
        String expectedResults = Files.readString(path).trim();
        String format = "json";
        String actual = Differ.generate(filePath1, filePath2, format);
        assertEquals(expectedResults, actual);
    }

    @Test
    public void testYamlToJson() throws Exception {
        var path = Paths.get("src/test/resources/Json").toAbsolutePath().normalize();
        String expectedResults = Files.readString(path).trim();
        String format = "json";
        String actual = Differ.generate(filePath3, filePath4, format);
        assertEquals(expectedResults, actual);
    }

    @Test
    public void testNoFormatDiffJson() throws Exception {
        var path = Paths.get("src/test/resources/Stylish").toAbsolutePath().normalize();
        String expectedResults = Files.readString(path).trim();
        String actual = Differ.generate(filePath1, filePath2);
        assertEquals(expectedResults, actual);
    }

    @Test
    public void testNoFormatDiffYaml() throws Exception {
        var path = Paths.get("src/test/resources/Stylish").toAbsolutePath().normalize();
        String expectedResults = Files.readString(path).trim();
        String actual = Differ.generate(filePath3, filePath4);
        assertEquals(expectedResults, actual);
    }
}
