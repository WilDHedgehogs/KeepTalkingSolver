import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//Позиция вверх.
public class Up {
    public static Map<String, String> upVariants = new HashMap<String, String>() {{
       put("1245", "Up"); put("24614", "Up");
       put("1455", "Down"); put("2461345", "Down");
       put("1234623", "Left"); put("123461236", "Left");
       put("246", "Right"); put("25646", "Right");
    }};

    public static void SolveUp() throws IOException {
        System.out.print("Eneter empty indexes of FIRST line: ");
        String firstLine = KeepTalking.bufferedReader.readLine().toLowerCase();
        if (firstLine.equals("-1")) {
            return;
        }

        System.out.print("Eneter empty indexes of SECOND line: ");
        String secondLine = KeepTalking.bufferedReader.readLine().toLowerCase();
        if (secondLine.equals("-1")) {
            return;
        }

        System.out.print("Result: " + upVariants.get(firstLine + secondLine) + "\n");
    }
}
