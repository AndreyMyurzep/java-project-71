package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;

public class Reader {
    public static String readData(String filePath) throws Exception {
        return Files.readString(Path.of(filePath));
    }

    public static String readFormate(String filePath) {
        String fileName = Path.of(filePath).getFileName().toString();
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex > 0) {
            return fileName.substring(dotIndex + 1).toLowerCase();
        }
        return "";
    }
}
