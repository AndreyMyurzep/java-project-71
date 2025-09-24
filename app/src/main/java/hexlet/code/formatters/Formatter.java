package hexlet.code.formatters;

import hexlet.code.CompareResult;

import java.io.IOException;
import java.util.List;

public class Formatter {

    private Formatter() {
    }

    public static String format(List<CompareResult> diff, String format) throws IOException {
        return switch (format) {
            case "plain" -> PlainFormatter.format(diff);
            case "stylish" -> StylishFormatter.format(diff);
            case "json" -> JsonFormatter.format(diff);
            default -> throw new RuntimeException("Unknown format" + format);
        };
    }
}
