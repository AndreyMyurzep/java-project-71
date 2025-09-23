//package hexlet.code;
//
//import java.util.List;
//
//public class Formatter {
//    public static String format(List<CompareResult> diff, String formatter) throws Exception {
//        return switch (formatter) {
//            case "json" -> JsonFormatter.format(diff);
//            default -> throw new RuntimeException("Unknown format" + formatter);
//        };
//    }
//}
