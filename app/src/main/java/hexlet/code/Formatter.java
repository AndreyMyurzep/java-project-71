package hexlet.code;

import java.util.List;

public class Formatter {
    public static String format(List<CompareResult> diff, String format) throws Exception {
        return switch (format) {
           //case "json" -> JsonFormatter.format(diff);
            case "stylish" -> StylishFormatter.format(diff);
            default -> throw new RuntimeException("Unknown format" + format);
        };
    }
}
