package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.concurrent.Callable;

@Command(name = "App", mixinStandardHelpOptions = true, version = "App 1.0",
        description = "Compares two configuration files and shows a difference.")

class App implements Callable<Integer> {

    @Parameters(index = "0", description = "path to first file", paramLabel = "filepath1")
    private String filePath1;

    @Parameters(index = "1", description = "path to second file", paramLabel = "filepath2")
    private String filePath2;

    @Option(
            names = {"-f", "--format"},
            paramLabel = "format",
            description = "output format: stylish, plain, json [default: stylish]",
            defaultValue = "stylish"
    )
    private String format;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() {
        try {
            Path absolutePath1 = getAbsolutePath(filePath1);
            Path absolutePath2 = getAbsolutePath(filePath2);

            if (!absolutePath1.toFile().exists()) {
                throw new IllegalArgumentException("File not found: " + absolutePath1);
            }
            if (!absolutePath2.toFile().exists()) {
                throw new IllegalArgumentException("File not found: " + absolutePath2);
            }

            String diff = Differ.generate(absolutePath1.toString(), absolutePath2.toString(), format);
            System.out.println(diff);
            return 0;
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return 1;
        }
    }

    private Path getAbsolutePath(String filePath) {
        return FileSystems.getDefault().getPath("./src/main/resources/input_files", filePath);
    }
}
