package hexlet.code;

import hexlet.code.format.Stylish;

import java.util.TreeMap;

public class Formatter {
    public static String formatter(TreeMap<String, Differences> map, String format) throws Exception {
        return Stylish.render(map);
    };
}
