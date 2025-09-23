package hexlet.code;

import java.util.List;
import java.util.Map;

public class DataType<T> {
    private Class<T> targetType;

    public DataType(Class<T> targetType) {
        this.targetType = targetType;
    }

    public String newFormat() {
        String result = "[complex value]";
        if (targetType != Map.class) {
            if (targetType != List.class) {
                if (targetType != Object.class) {
                    result = "simple class";
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "DataType{" +
                "targetType=" + targetType +
                '}';
    }
}
