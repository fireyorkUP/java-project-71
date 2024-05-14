import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class AppTest {

    private final String filePath1 = "src/test/resources/Json1.json";
    private final String filePath2 = "src/test/resources/Json2.json";

    private final String filePath3 = "src/test/resources/Yaml1.yaml";
    private final String filePath4 = "src/test/resources/Yaml2.yaml";

    @Test
    public void testCallJson() throws Exception {
        String expected = """
                {
                    chars1: [a, b, c]
                  - chars2: [d, e, f]
                  + chars2: false
                  - checked: false
                  + checked: true
                  - default: null
                  + default: [value1, value2]
                  - id: 45
                  + id: null
                  - key1: value1
                  + key2: value2
                    numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  + numbers2: [22, 33, 44, 55]
                  - numbers3: [3, 4, 5]
                  + numbers4: [4, 5, 6]
                  + obj1: {nestedKey=value, isNested=true}
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                  + setting3: none
                }""";
        String format = "stylish";
        String actual = Differ.generate(filePath1, filePath2, format);
        assertEquals(expected, actual);
    }

    @Test
    public void testCallYaml() throws Exception {
        String expected = """
                {
                    chars1: [a, b, c]
                  - chars2: [d, e, f]
                  + chars2: false
                  - checked: false
                  + checked: true
                  - default: null
                  + default: [value1, value2]
                  - id: 45
                  + id: null
                  - key1: value1
                  + key2: value2
                    numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  + numbers2: [22, 33, 44, 55]
                  - numbers3: [3, 4, 5]
                  + numbers4: [4, 5, 6]
                  + obj1: {nestedKey=value, isNested=true}
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                  + setting3: none
                }""";
        String format = "stylish";
        String actual = Differ.generate(filePath3, filePath4, format);
        assertEquals(expected, actual);
    }

    @Test
    public void testCallJsonPlain() throws Exception {
        String expected = """
                Property 'chars2' was updated. From [complex value] to false
                Property 'checked' was updated. From false to true
                Property 'default' was updated. From null to [complex value]
                Property 'id' was updated. From 45 to null
                Property 'key1' was removed
                Property 'key2' was added with value: 'value2'
                Property 'numbers2' was updated. From [complex value] to [complex value]
                Property 'numbers3' was removed
                Property 'numbers4' was added with value: [complex value]
                Property 'obj1' was added with value: [complex value]
                Property 'setting1' was updated. From 'Some value' to 'Another value'
                Property 'setting2' was updated. From 200 to 300
                Property 'setting3' was updated. From true to 'none'""";
        String format = "plain";
        String actual = Differ.generate(filePath1, filePath2, format);
        assertEquals(expected, actual);
    }

    @Test
    public void testCallYamlPlain() throws Exception {
        String expected = """
                Property 'chars2' was updated. From [complex value] to false
                Property 'checked' was updated. From false to true
                Property 'default' was updated. From null to [complex value]
                Property 'id' was updated. From 45 to null
                Property 'key1' was removed
                Property 'key2' was added with value: 'value2'
                Property 'numbers2' was updated. From [complex value] to [complex value]
                Property 'numbers3' was removed
                Property 'numbers4' was added with value: [complex value]
                Property 'obj1' was added with value: [complex value]
                Property 'setting1' was updated. From 'Some value' to 'Another value'
                Property 'setting2' was updated. From 200 to 300
                Property 'setting3' was updated. From true to 'none'""";
        String format = "plain";
        String actual = Differ.generate(filePath3, filePath4, format);
        assertEquals(expected, actual);
    }

    @Test
    public void testJsonToJson() throws Exception {
        String expected = """
                {
                  "chars1" : {
                    "oldValue" : [ "a", "b", "c" ],
                    "newValue" : [ "a", "b", "c" ],
                    "state" : "unchanged"
                  },
                  "chars2" : {
                    "oldValue" : [ "d", "e", "f" ],
                    "newValue" : false,
                    "state" : "changed"
                  },
                  "checked" : {
                    "oldValue" : false,
                    "newValue" : true,
                    "state" : "changed"
                  },
                  "default" : {
                    "oldValue" : null,
                    "newValue" : [ "value1", "value2" ],
                    "state" : "changed"
                  },
                  "id" : {
                    "oldValue" : 45,
                    "newValue" : null,
                    "state" : "changed"
                  },
                  "key1" : {
                    "oldValue" : "value1",
                    "newValue" : null,
                    "state" : "removed"
                  },
                  "key2" : {
                    "oldValue" : null,
                    "newValue" : "value2",
                    "state" : "added"
                  },
                  "numbers1" : {
                    "oldValue" : [ 1, 2, 3, 4 ],
                    "newValue" : [ 1, 2, 3, 4 ],
                    "state" : "unchanged"
                  },
                  "numbers2" : {
                    "oldValue" : [ 2, 3, 4, 5 ],
                    "newValue" : [ 22, 33, 44, 55 ],
                    "state" : "changed"
                  },
                  "numbers3" : {
                    "oldValue" : [ 3, 4, 5 ],
                    "newValue" : null,
                    "state" : "removed"
                  },
                  "numbers4" : {
                    "oldValue" : null,
                    "newValue" : [ 4, 5, 6 ],
                    "state" : "added"
                  },
                  "obj1" : {
                    "oldValue" : null,
                    "newValue" : {
                      "nestedKey" : "value",
                      "isNested" : true
                    },
                    "state" : "added"
                  },
                  "setting1" : {
                    "oldValue" : "Some value",
                    "newValue" : "Another value",
                    "state" : "changed"
                  },
                  "setting2" : {
                    "oldValue" : 200,
                    "newValue" : 300,
                    "state" : "changed"
                  },
                  "setting3" : {
                    "oldValue" : true,
                    "newValue" : "none",
                    "state" : "changed"
                  }
                }""";
        String format = "json";
        String actual = Differ.generate(filePath1, filePath2, format);
        assertEquals(expected, actual);
    }
}
