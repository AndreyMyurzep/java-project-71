package hexlet.code.formatters;

import hexlet.code.CompareResult;
import hexlet.code.enums.Status;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class PlainFormatter {
    public static String format(List<CompareResult> diff) {
        StringBuilder result = new StringBuilder();
        Map<String, CompareResult> map = CompareResult.toMap(diff);
        var keys = new TreeSet<>(CompareResult.getFieldSet(diff));
        for (var key : keys) {
            Status status = map.get(key).getStatus();
            Object value1 = map.get(key).getOldValue();
            Object value2 = map.get(key).getNewValue();

            if (status.equals(Status.ADDED)) {
                result.append("Property '").append(key).append("' was added with value: ")
                        .append(formatValue(value2)).append("\n");
            } else if (status.equals(Status.REMOVED)) {
                result.append("Property '").append(key).append("' was removed\n");
            } else if (status.equals(Status.CHANGED)) {
                result.append("Property '").append(key).append("' was updated. From ")
                        .append(formatValue(value1)).append(" to ").append(formatValue(value2))
                        .append("\n");
            }
        }
        return result.substring(0, result.length() - 1);
    }

    private static String formatValue(Object value) {
        if (value == null) {
            return "null";
        }
        if (value.getClass().isArray()) {
            return "[complex value]";
        }
        if (value instanceof List || value instanceof Map || value instanceof Set) {
            return "[complex value]";
        }
        if (value instanceof String) {
            return "'" + value + "'";
        }
        if (value instanceof Boolean) {
            return value.toString().toLowerCase();
        }
        return value.toString();
    }
}
