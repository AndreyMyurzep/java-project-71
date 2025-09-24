package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.util.Map;


public class Parser {
    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    private static final Yaml YAML_MAPPER = new Yaml();

    public static Map<String, Object> parse(String content, String formate) throws IOException {
        return switch (formate) {
            case "json" -> parseJson(content);
            case "yml", "yaml" -> parseYaml(content);
            default -> throw new IOException("Unsupported format: " + formate);
        };
    }

    private static Map<String, Object> parseJson(String content) throws IOException {
        return JSON_MAPPER.readValue(content, new TypeReference<>() { });
    }

    private static Map<String, Object> parseYaml(String content) {
        return YAML_MAPPER.load(content);
    }
}
