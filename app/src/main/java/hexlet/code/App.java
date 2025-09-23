package hexlet.code;//import picocli.CommandLine;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

//import java.io.File;
//import java.math.BigInteger;
//import java.nio.file.Files;
//import java.security.MessageDigest;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.concurrent.Callable;

@Command(name = "App", mixinStandardHelpOptions = true, version = "App 1.0",
        description = "Compares two configuration files and shows a difference.")

class App implements Callable<Integer> {

    @Parameters(index = "0", description = "The first file", paramLabel = "filepath1")
    private String file1;

    @Parameters(index = "1", description = "The second file", paramLabel = "filepath2")
    private String file2;

    @Option(
            names = {"-f", "--format"},
            paramLabel = "format",
            description = "output format [default: stylish]",
            defaultValue = "staylish"
    )
    private String format;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

//    @Option(names = { "-h", "--help" }, usageHelp = true, description = "Show this help message and exit.")
    //private boolean helpRequested = false;
//    @Parameters(names = { "-V", "--version"}, description = "Print version information and exit.")

    @Override
    public Integer call() throws Exception { // your business logic goes here...
        String file1 = "src/test/resources/file1.json";
        String file2 = "src/test/resources/file2.json";
        var diff = Differ.generate(file1, file2);
        System.out.println(diff);
        return 0;
    }
}
