import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//Мигание кнопок.
public class SimonSays {
    public static Map<String, String[]> flash = new HashMap<String, String[]>() {{
        //С гласными.
        put("y0", new String[]{"Red to Blue", "Blue to Red", "Green to Yellow", "Yellow to Green"});
        put("y1", new String[]{"Red to Yellow", "Blue to Green", "Green to Blue", "Yellow to Red"});
        put("y2", new String[]{"Red to Green", "Blue to Red", "Green to Yellow", "Yellow to Blue"});
        //Без гласных.
        put("n0", new String[]{"Red to Blue", "Blue to Yellow", "Green to Green", "Yellow to Red"});
        put("n1", new String[]{"Red to Red", "Blue to Blue", "Green to Yellow", "Yellow to Green"});
        put("n2", new String[]{"Red to Yellow", "Blue to Green", "Green to Blue", "Yellow to Red"});
    }};

    public static void SolveSimonSays() throws IOException {
        System.out.print("Contains a vowel? ");
        String line = KeepTalking.bufferedReader.readLine().toLowerCase();
        if (line.equals("-1")) {
            return;
        }

        System.out.print("How many strikes? ");
        line += KeepTalking.bufferedReader.readLine().toLowerCase();
        if (line.equals("-1")) {
            return;
        }

        System.out.println();
        for (String s : flash.get(line)) {
            System.out.println(s);
        }
    }
}
