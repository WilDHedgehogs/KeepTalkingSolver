import java.io.IOException;
import java.util.*;

//Кнопка
public class Buttons {
    //Все варианты.
    public static List<String[]> buttonConditions = new ArrayList<>(Arrays.asList(
            new String[]{"button is blue", "button says Abort", "press and say COLOR: "},
            new String[]{"more than one battery", "button says Detonate", "press and immediately RELEASE"},
            new String[]{"button is white", "indicator CAR", "press and say COLOR: "},
            new String[]{"more than two batteries", "indicator FRK", "press and immediately RELEASE"},
            new String[]{"button is yellow", "press and say COLOR: "},
            new String[]{"button is red", "button says Hold", "press and immediately RELEASE"},
            new String[]{"press and say COLOR: "}));

    //Когда отпускать кнопку.
    public static Map<String, String> releasing = new HashMap<String, String>() {{
        put("Blue", "4");
        put("White", "1");
        put("Yellow", "5");
        put("Any other", "1");
    }};

    public static void SolveButtons() throws IOException {
        int count = 0;
        boolean answerFound = false;
        String line = "";

        while (true) {
            for (int i = 0; i < buttonConditions.get(count).length - 1; i++) {
                System.out.print(buttonConditions.get(count)[i] + " (y/n): ");

                line = KeepTalking.bufferedReader.readLine().toLowerCase();
                if (line.equals("-1")) {
                    return;
                }

                if (line.equals("y")) {
                    answerFound = true;
                } else {
                    answerFound = false;
                    break;
                }
            }

            if (!answerFound) {
                if (count + 1 == buttonConditions.size() - 1) {
                    answerFound = true;
                    count++;
                }
            }

            if (answerFound) {
                String answer = buttonConditions.get(count)[buttonConditions.get(count).length - 1];
                if (answer.contains("COLOR")) {
                    for (Map.Entry<String, String> pair : releasing.entrySet()) {
                        System.out.print(pair.getKey() + " = " + pair.getValue() + "\t");
                    }
                    System.out.println();
                    System.out.print(answer);
                    line = KeepTalking.bufferedReader.readLine();
                    Releasing(line);
                } else {
                    System.out.print(answer);
                }
                return;
            } else {
                count++;
            }
        }
    }

    public static void Releasing(String color) {
        switch (color) {
            case "blue":
            case "b":
                System.out.println("Release when timer hase 4 in any position");
                break;
            case "white":
            case "w":
                System.out.println("Release when timer hase 1 in any position");
                break;
            case "yellow":
            case "y":
                System.out.println("Release when timer hase 5 in any position");
                break;
            default:
                System.out.println("Release when timer hase 1 in any position");
                break;
        }
    }
}
