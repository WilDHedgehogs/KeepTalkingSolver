import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Перебор пяти букв.
public class Letters {
    public static List<String> words = new ArrayList<String>(Arrays.asList(
            "about", "after", "again", "below", "could",
            "every", "first", "found", "great", "house",
            "large", "learn", "never", "other", "place",
            "plant", "point", "right", "small", "sound",
            "spell", "still", "study", "their", "there",
            "these", "thing", "think", "three", "water",
            "where", "which", "world", "would", "write"));

    public static List<String> temp;
    public static List<String> result = new ArrayList<>();

    public static void SolveLeters() throws IOException {
        temp = new ArrayList<>(words);
        result.clear();
        int firstConcat = 0;
        int secondConcat = 1;

        while (true) {
            System.out.print("Enter [" + secondConcat + "] letters: ");
            String line = KeepTalking.bufferedReader.readLine().toLowerCase();
            if (line.equals("-1")) {
                return;
            }

            for (String s : temp) {
                for (int i = 0; i < line.length(); i++) {
                    if (s.substring(firstConcat, secondConcat).equals(line.substring(i, i + 1))) {
                        result.add(s);
                    }
                }
            }

            System.out.print("Result: " + result + "\n\n");

            firstConcat++;
            secondConcat++;
            temp.clear();
            temp = new ArrayList<>(result);
            result.clear();

            if (secondConcat == 6) {
                return;
            }
        }
    }
}
