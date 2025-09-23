package hexlet.code;
import java.nio.file.*;

public class Reader {
    public static String readDataJson(String filePath) throws Exception {
        return Files.readString(Path.of(filePath));
    }
}
