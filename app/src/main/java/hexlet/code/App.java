package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "App 1.0",
        description = "Compares two configuration files and shows a difference.")

class App implements Callable {
    private static final int SUCCESS_EXIT_CODE = 0;
    private static final int ERROR_EXIT_CODE = 1;

    @Option(names = {"-f", "--format"}, defaultValue = "stylish", paramLabel = "format",
            description = "output format [default: ${DEFAULT-VALUE}]")
    private String format;
    @Parameters(paramLabel = "filepath1", description = "path to first file")
    private String filePath1;
    @Parameters(paramLabel = "filepath2", description = "path to second file")
    private String filePath2;
    public static void main(String[] args) throws Exception {
        Differ.generate("src/main/java/hexlet/code/JsonS/Json1.json", "src/main/java/hexlet/code/JsonS/Json2.json");
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Object call() throws Exception {
        return null;
    }

}
