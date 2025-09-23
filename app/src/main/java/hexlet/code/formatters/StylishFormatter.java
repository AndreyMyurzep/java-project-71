package hexlet.code.formatters;

import hexlet.code.CompareResult;
import hexlet.code.enums.Status;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class StylishFormatter {
    public static String format(List<CompareResult> diff) {
        String result = "{\n";
        Map<String, CompareResult> map = CompareResult.toMap(diff);
        var keys = new TreeSet<>(CompareResult.getFieldSet(diff));
        for (var key : keys) {
            Status status = map.get(key).getStatus();
            Object value1 = map.get(key).getOldValue();
            Object value2 = map.get(key).getNewValue();

            if (status.equals(Status.ADDED)) {
                result = result + "  + " + key + ": " + formatValue(value2) + "\n";
            } else if (status.equals(Status.REMOVED)) {
                result = result + "  - " + key + ": " + formatValue(value1) + "\n";
            } else if (status.equals(Status.CHANGED)) {
                result = result + "  - " + key + ": " + formatValue(value1) + "\n  + " + key
                        + ": " + formatValue(value2) + "\n";
            } else {
                result = result + "    " + key + ": " + formatValue(value1) + "\n";
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
