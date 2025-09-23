package hexlet.code;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.List;
import java.util.stream.Collectors;


public final class CompareResult {
    private final Map<DiffKeys, Object> data;

    public CompareResult(String field, Status status, Object oldValue, Object newValue) {
        this.data = new EnumMap<>(DiffKeys.class);
        this.data.put(DiffKeys.FIELD, Objects.requireNonNull(field));
        this.data.put(DiffKeys.STATUS, Objects.requireNonNull(status));
        this.data.put(DiffKeys.OLD_VALUE, oldValue);
        this.data.put(DiffKeys.NEW_VALUE, newValue);
    }

    public String getField() {
        return (String) data.get(DiffKeys.FIELD);
    }

    public static Set<String> getFieldSet(List<CompareResult> results) {
        return results.stream()
                .map(CompareResult::getField)
                .collect(Collectors.toSet());
    }

    public Status getStatus() {
        return (Status) data.get(DiffKeys.STATUS);
    }

    public Object getOldValue() {
        return data.get(DiffKeys.OLD_VALUE);
    }

    public Object getNewValue() {
        return data.get(DiffKeys.NEW_VALUE);
    }

    public Map<DiffKeys, Object> getRawData() {
        return new EnumMap<>(data);
    }

    public static Map<String, CompareResult> toMap(List<CompareResult> results) {
        return results.stream()
                .collect(Collectors.toMap(
                        CompareResult::getField,
                        result -> result,
                        (existing, replacement) -> existing // обработка дубликатов
                ));
    }

    @Override
    public String toString() {
        return String.format("Difference{field='%s', status=%s, oldValue=%s, newValue=%s}",
                getField(), getStatus(), getOldValue(), getNewValue());
    }
}
