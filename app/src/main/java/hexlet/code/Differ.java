package hexlet.code;

public class Differ {
    public static String generate(String file1, String file2) throws Exception {
        var fileContent1 = Reader.readDataJson(file1);
        var fileContent2 = Reader.readDataJson(file2);

        var file1Parsed = Parser.parse(fileContent1);
        var file2Parsed = Parser.parse(fileContent2);

        var diff = Comparator.compare(file1Parsed, file2Parsed);

        return JsonFormatter.format(diff);
    }
}
