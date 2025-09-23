package hexlet.code;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class JsonFormatter {
    public static String format(List<CompareResult> diff) {
        String result = "";
        Map<String, CompareResult> map = CompareResult.toMap(diff);
        var keys = new TreeSet<>(CompareResult.getFieldSet(diff));
        for (var key : keys) {
            Status status = map.get(key).getStatus();
            Object value1 = map.get(key).getOldValue();
            Object value2 = map.get(key).getNewValue();

            if (status.equals(Status.ADDED)) {
                result = result + "+ " + key + ": " + value2.toString() + "\n";
            } else if (status.equals(Status.REMOVED)) {
                result = result + "- " + key + ": " + value1.toString() + "\n";
            } else if (status.equals(Status.CHANGED)) {
                result = result + "+ " + key + ": " + value1.toString() + "\n+ " + key + ": " + value2.toString() + "\n";
            } else {
                result = result + "  " + key + ": " + value1.toString() + "\n";
            }
        }
        return result;
    }
}