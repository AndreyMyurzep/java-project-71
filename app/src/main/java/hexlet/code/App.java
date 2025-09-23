package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.concurrent.Callable;

@Command(name = "App", mixinStandardHelpOptions = true, version = "App 1.0",
        description = "Compares two configuration files and shows a difference.")

class App implements Callable<Integer> {

    @Parameters(index = "0", description = "The first file", paramLabel = "filepath1")
    private String filePath1;

    @Parameters(index = "1", description = "The second file", paramLabel = "filepath2")
    private String filePath2;

    @Option(
            names = {"-f", "--format"},
            paramLabel = "format",
            description = "output format [default: stylish]",
            defaultValue = "stylish"
    )
    private String format;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception { // your business logic goes here...
        var diff = Differ.generate(filePath1, filePath2);
        System.out.println(diff);
        return 0;
    }
}
