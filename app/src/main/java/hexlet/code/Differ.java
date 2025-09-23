package hexlet.code;

public class Differ {
    public static String generate(String file1, String file2) throws Exception {
        var fileContent1 = Reader.readData(file1);
        var fileContent2 = Reader.readData(file2);
        var fileFormate1 = Reader.readFormate(file1);
        var fileFormate2 = Reader.readFormate(file2);

        var file1Parsed = Parser.parse(fileContent1, fileFormate1);
        var file2Parsed = Parser.parse(fileContent2, fileFormate2);

        var diff = Comparator.compare(file1Parsed, file2Parsed);

        return JsonFormatter.format(diff);
    }
}
