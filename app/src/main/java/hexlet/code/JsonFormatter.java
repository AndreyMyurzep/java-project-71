//package hexlet.code;
//
//import org.gradle.internal.impldep.com.fasterxml.jackson.core.JsonProcessingException;
//import org.gradle.internal.impldep.com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.io.File;
//import java.io.IOException;
//import java.net.URL;
//
//public class JsonFormatter {
//    private static final ObjectMapper map = new ObjectMapper();
//
//    private JsonFormatter() {
//    }
//
//    public static <T> T parseFromString(String jsonString, Class<T> valueType) throws JsonProcessingException {
//        return map.readValue(jsonString, valueType);
//    }
//
//    public static <T> T parseFromFile(String filePath, Class<T> valueType) throws IOException {
//        return map.readValue(new File(filePath), valueType);
//    }
//
//    public static <T> T parseFromUrl(String urlString, Class<T> valueType) throws IOException {
//        return map.readValue(new URL(urlString), valueType);
//    }
//}
