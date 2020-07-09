import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Провода и буквы.
public class RedBlueBlack {
    public static Map<String, String> red = Stream.of(new String[][] {
            {"1", "c"}, {"2", "b"}, {"3", "a"},
            {"4", "ac"}, {"5", "b"}, {"6", "ac"},
            {"7", "abc"}, {"8", "ab"}, {"9", "b"},
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

    public static Map<String, String> blue = Stream.of(new String[][] {
            {"1", "b"}, {"2", "ac"}, {"3", "b"},
            {"4", "a"}, {"5", "b"}, {"6", "bc"},
            {"7", "c"}, {"8", "ac"}, {"9", "a"},
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

    public static Map<String, String> black = Stream.of(new String[][] {
            {"1", "abc"}, {"2", "ac"}, {"3", "b"},
            {"4", "ac"}, {"5", "b"}, {"6", "bc"},
            {"7", "ab"}, {"8", "c"}, {"9", "c"},
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

    public static void SolveRedBlueBlack() throws IOException {

        int redWire = 1;
        int blueWire = 1;
        int blackWire = 1;

        while (true) {
            System.out.print("Enter r/u/b and A/B/C: ");
            String line = KeepTalking.bufferedReader.readLine().toLowerCase().replaceAll(" ", "");
            if (line.equals("-1")) {
                return;
            }

            if (line.length() != 2) {
                continue;
            }

            char[] chars = line.toCharArray();
            String wire = String.valueOf(chars[0]);
            String connection = String.valueOf(chars[1]);

            switch (wire) {
                case "r":
                    System.out.print("[" + redWire + "] Red: ");
                    if (CompareConnection(red, redWire, connection)) {
                        System.out.println("Cut");
                    } else {
                        System.out.println("Don't cut");
                    }
                    redWire++;
                    break;
                case "u":
                    System.out.print("[" + blueWire + "] Blue: ");
                    if (CompareConnection(blue, blueWire, connection)) {
                        System.out.println("Cut");
                    } else {
                        System.out.println("Don't cut");
                    }
                    blueWire++;
                    break;
                case "b":
                    System.out.print("[" + blackWire + "] Black: ");
                    if (CompareConnection(black, blackWire, connection)) {
                        System.out.println("Cut");
                    } else {
                        System.out.println("Don't cut");
                    }
                    blackWire++;
                    break;
                default:
                    System.out.println("Wrong color");
                    break;
            }
        }
    }

    public static boolean CompareConnection(Map<String, String> map, int count, String connection) {
        String sCount = String.valueOf(count);
        if (map.get(sCount).contains(connection)){
            return true;
        } else {
            return false;
        }
    }
}
