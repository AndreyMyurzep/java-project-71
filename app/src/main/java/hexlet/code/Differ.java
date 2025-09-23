package hexlet.code;

public class Differ {
    public static String generate(String filePath1, String filePath2, String formate) throws Exception {
        var fileContent1 = Reader.readData(filePath1);
        var fileContent2 = Reader.readData(filePath2);
        var fileFormate1 = Reader.readFormate(filePath1);
        var fileFormate2 = Reader.readFormate(filePath2);

        var file1Parsed = Parser.parse(fileContent1, fileFormate1);
        var file2Parsed = Parser.parse(fileContent2, fileFormate2);

        var diff = Comparator.compare(file1Parsed, file2Parsed);

        return Formatter.format(diff, formate);
    }
    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
}
