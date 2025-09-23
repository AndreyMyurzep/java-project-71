package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

public class Comparator {
    public static List<CompareResult> compare(Map<String, Object> file1, Map<String, Object> file2) {
        var result = new ArrayList<CompareResult>();

        var keys = new TreeSet<String>();
        keys.addAll(file1.keySet());
        keys.addAll(file2.keySet());

        for (var key : keys) {
            var value1 = file1.get(key);
            var value2 = file2.get(key);
            if (!file1.containsKey(key)) {
                result.add(new CompareResult(key, Status.ADDED, null, value2));
            } else if (!file2.containsKey(key)) {
                result.add(new CompareResult(key, Status.REMOVED, value1, null));
            } else if (Objects.equals(value1, value2)) {
                result.add(new CompareResult(key, Status.UNCHANGED, value1, value2));
            } else {
                result.add(new CompareResult(key, Status.CHANGED, value1, value2));
            }
        }
        return result;
    }
}
