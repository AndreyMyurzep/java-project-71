package hexlet.code;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;


public class CompareResult {
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

    @Override
    public String toString() {
        return String.format("Difference{field='%s', status=%s, oldValue=%s, newValue=%s}",
                getField(), getStatus(), getOldValue(), getNewValue());
    }

}
