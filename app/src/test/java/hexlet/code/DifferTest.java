package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;


class DifferTest {
    private String expectedResultJson;
    private String expectedResultPlain;
    private String expectedResultStylish;

    public static Path getAbsolutePath(String fileName) {
        Path path = FileSystems.getDefault().getPath("./src/test/resources/", fileName);
        return path;
    }

    public static String readFile(String fileName) throws IOException {
        Path filePath = getAbsolutePath(fileName);
        return Files.readString(filePath).trim();
    }

    @BeforeEach
    public void setUp() throws Exception {
        expectedResultJson = readFile("expected_result/result.json");
        expectedResultStylish = readFile("expected_result/result.stylish");
        expectedResultPlain = readFile("expected_result/result.plain");
    }

    @ParameterizedTest
    @ValueSource(strings = {".json", ".yml"})
    public void testDifferWorkDefault(String fileType) throws Exception {
        var filePath1 = getAbsolutePath("input_files/file1" + fileType).toString();
        var filePath2 = getAbsolutePath("input_files/file2" + fileType).toString();
        String result = Differ.generate(filePath1, filePath2);
        assertEquals(expectedResultStylish, result);
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(strings = {".json", ".yml"})
    public void testDifferWorkStylish(String fileType) throws Exception {
        var filePath1 = getAbsolutePath("input_files/file1" + fileType).toString();
        var filePath2 = getAbsolutePath("input_files/file2" + fileType).toString();
        String result = Differ.generate(filePath1, filePath2, "stylish");
        assertEquals(expectedResultStylish, result);
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(strings = {".json", ".yml"})
    public void testDifferWorkYml(String fileType) throws Exception {
        var filePath1 = getAbsolutePath("input_files/file1" + fileType).toString();
        var filePath2 = getAbsolutePath("input_files/file2" + fileType).toString();
        String result = Differ.generate(filePath1, filePath2, "plain");
        assertEquals(expectedResultPlain, result);
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(strings = {".json", ".yml"})
    public void testDifferWorkJson(String fileType) throws Exception {
        var filePath1 = getAbsolutePath("input_files/file1" + fileType).toString();
        var filePath2 = getAbsolutePath("input_files/file2" + fileType).toString();
        String result = Differ.generate(filePath1, filePath2, "json");
        assertEquals(expectedResultJson, result);
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }
}
