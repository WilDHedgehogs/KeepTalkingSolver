import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Морзе.
public class Morse {
    public static Map<String, String> symbols = Stream.of(new String[][] {
            {"01", "a"}, {"1000", "b"}, {"1010", "c"},
            {"100", "d"}, {"0", "e"}, {"0010", "f"},
            {"110", "g"}, {"0000", "h"}, {"00", "i"},
            {"0111", "j"}, {"101", "k"}, {"0100", "l"},
            {"11", "m"}, {"10", "n"}, {"111", "o"},
            {"0110", "p"}, {"1101", "q"}, {"010", "r"},
            {"000", "s"}, {"1", "t"}, {"001", "u"},
            {"0001", "v"}, {"011", "w"}, {"1001", "x"},
            {"1011", "y"}, {"1100", "z"}, {"11111", "1"},
            {"01111", "2"}, {"00011", "3"}, {"00001", "4"},
            {"00000", "5"}, {"10000", "6"}, {"11000", "7"},
            {"11100", "8"}, {"11110", "9"},
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

    public static Map<String, String> words = Stream.of(new String[][] {
            {"shell", "3.505"}, {"halls", "3.515"},
            {"slick", "3.522"}, {"trick", "3.532"},
            {"boxes", "3.535"}, {"leaks", "3.542"},
            {"strobe", "3.545"}, {"bistro", "3.552"},
            {"flick", "3.555"}, {"bombs", "3.565"},
            {"break", "3.572"}, {"brick", "3.575"},
            {"steak", "3.582"}, {"sting", "3.592"},
            {"vector", "3.595"}, {"beats", "3.600"},
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

    public static Map<String, String> result = new HashMap<>();
    public static Map<String, String> temp;

    public static void SolveMorse() throws IOException {
        temp = new HashMap<>(words);
        while (true) {
            System.out.print("Enter Morse code (0 for dotes and 1 for dashes): ");
            String line = KeepTalking.bufferedReader.readLine();
            if (line.equals("-1")) {
                return;
            }

            String code = symbols.get(line);
            for (Map.Entry<String, String> pair : temp.entrySet()) {
                if (pair.getKey().contains(code)) {
                    result.put(pair.getKey(), pair.getValue());
                }
            }

            System.out.print("Result: " + result + "\n\n");

            temp.clear();
            temp = new HashMap<>(result);
            result.clear();
        }
    }
}
