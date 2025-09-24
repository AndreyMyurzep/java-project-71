package hexlet.code.formatters;

import hexlet.code.CompareResult;

import java.util.List;

public class Formatter {
    public static String format(List<CompareResult> diff, String format) throws Exception {
        return switch (format) {
            case "plain" -> PlainFormatter.format(diff);
            case "stylish" -> StylishFormatter.format(diff);
            case "json" -> JsonFormatter.format(diff);
            default -> throw new RuntimeException("Unknown format" + format);
        };
    }
}
