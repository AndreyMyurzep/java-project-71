package hexlet.code.formatters;

import hexlet.code.CompareResult;
import hexlet.code.enums.Status;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class StylishFormatter {

    private StylishFormatter() {
    }

    public static String format(List<CompareResult> diff) {
        StringBuilder result = new StringBuilder("{\n");
        Map<String, CompareResult> map = CompareResult.toMap(diff);
        var keys = new TreeSet<>(CompareResult.getFieldSet(diff));
        for (var key : keys) {
            Status status = map.get(key).getStatus();
            Object value1 = map.get(key).getOldValue();
            Object value2 = map.get(key).getNewValue();

            if (status.equals(Status.ADDED)) {
                result.append("  + ").append(key).append(": ").append(formatValue(value2)).append("\n");
            } else if (status.equals(Status.REMOVED)) {
                result.append("  - ").append(key).append(": ").append(formatValue(value1)).append("\n");
            } else if (status.equals(Status.CHANGED)) {
                result.append("  - ").append(key).append(": ").append(formatValue(value1)).append("\n  + ")
                        .append(key).append(": ").append(formatValue(value2)).append("\n");
            } else {
                result.append("    ").append(key).append(": ").append(formatValue(value1)).append("\n");
            }
        }
        return result + "}";
    }

    private static String formatValue(Object value) {
        if (value == null) {
            return "null";
        }
        return value.toString();
    }
}
