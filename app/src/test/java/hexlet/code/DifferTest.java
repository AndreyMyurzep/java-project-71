package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;


class DifferTest {
    private static String expectedResult;
    private static String expectedResult2;
    private static String expectedResult3;

    public static Path getAbsolutePath(String fileName) {
        Path path = FileSystems.getDefault().getPath("./src/test/resources", fileName);
        return path;
    }

    public static String readFile(String fileName) throws IOException {
        Path filePath = getAbsolutePath(fileName);
        return Files.readString(filePath).trim();
    }

    @BeforeEach
    public void setUp() throws Exception {
        expectedResult = readFile("test_file1.txt");
        expectedResult2 = readFile("test_file2.txt");
        expectedResult3 = readFile("test_file.plain");
    }

//    @ParameterizedTest
    @Test
    public void testDifferWorkWithJson() throws Exception {
        String filePath1 = "src/test/resources/file1.json";
        String filePath2 = "src/test/resources/file2.json";
        String result = Differ.generate(filePath1, filePath2);
        assertEquals(expectedResult, result);
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testTwoDifferWorkWithJson() throws Exception {
        String filePath1 = "src/test/resources/file1-1.json";
        String filePath2 = "src/test/resources/file2-1.json";
        String result = Differ.generate(filePath1, filePath2);
        assertEquals(expectedResult2, result);
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testTwoDifferWorkWithYml() throws Exception {
        String filePath1 = "src/test/resources/file1-1.yml";
        String filePath2 = "src/test/resources/file2-1.yml";
        String result = Differ.generate(filePath1, filePath2);
        assertEquals(expectedResult2, result);
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testDifferWorkWithYaml() throws Exception {
        String filePath1 = "src/test/resources/file1.yaml";
        String filePath2 = "src/test/resources/file2.yaml";
        String result = Differ.generate(filePath1, filePath2);
        assertEquals(expectedResult, result);
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testDifferJsonToPlain() throws Exception {
        String filePath1 = "src/test/resources/file1-1.json";
        String filePath2 = "src/test/resources/file2-1.json";
        String result = Differ.generate(filePath1, filePath2, "plain");
        assertEquals(expectedResult3, result);
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testDifferYmlToPlain() throws Exception {
        String filePath1 = "src/test/resources/file1-1.yml";
        String filePath2 = "src/test/resources/file2-1.yml";
        String result = Differ.generate(filePath1, filePath2, "plain");
        assertEquals(expectedResult3, result);
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }
}
