import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import hexlet.code.*;
public class AppTest {

    String filePath1 = "src/test/resources/JsonS/Json1.json";
    String filePath2 = "src/test/resources/JsonS/Json2.json";

    @Test
    public void testCall() throws Exception {
        String expected = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";
        String format = "Stylish";
        String actual = Differ.generate(filePath1, filePath2, format);
        assertEquals(expected, actual);
    }
}