import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Простые провода.
public class SimpleWires {
    public static List<String[]> threeWireConditions = new ArrayList<String[]>(Arrays.<String[]>asList(
            new String[] {"no red wires", "cut SECOND wire"},
            new String[] {"last wire is white", "cut LAST wire"},
            new String[] {"more than one blue wire", "cut LAST BLUE wire"},
            new String[] {"cut LAST wire"}));

    public static List<String[]> fourWireConditions = new ArrayList<String[]>(Arrays.<String[]>asList(
            new String[] {"more than one red wire", "last digit is odd", "cut the LAST RED wire"},
            new String[] {"last wire if yellow", "no red wires", "cut the FIRST wire"},
            new String[] {"one blue wire", "cut the FIRST wire"},
            new String[] {"more than one yellow wire", "cut the LAST wire"},
            new String[] {"cut the SECOND wire"}));

    public static List<String[]> fiveWireConditions = new ArrayList<String[]>(Arrays.<String[]>asList(
            new String[] {"last wire is black", "last digit is odd", "cut the FOURTH wire"},
            new String[] {"one red wire", "more than one yellow wire", "cut the FIRST wire"},
            new String[] {"no black wires", "cut the SECOND wire"},
            new String[] {"cut the FIRST wire"}));

    public static List<String[]> sixWireConditions = new ArrayList<String[]>(Arrays.<String[]>asList(
            new String[] {"no yellow wires", "last digit is odd", "cut the THIRD wire"},
            new String[] {"one yellow wire", "more than one white wire", "cut the FOURTH wire"},
            new String[] {"no red wires", "cut the LAST wire"},
            new String[] {"cut the FOURTH wire"}));

    public static void SolveSimpleWires() throws IOException {
        System.out.print("Enter the number of wires: ");
        String wireCount = KeepTalking.bufferedReader.readLine();

        switch (wireCount) {
            case "3":
                ConditionCheck(new ArrayList<>(threeWireConditions));
                break;
            case "4":
                ConditionCheck(new ArrayList<>(fourWireConditions));
                break;
            case "5":
                ConditionCheck(new ArrayList<>(fiveWireConditions));
                break;
            case "6":
                ConditionCheck(new ArrayList<>(sixWireConditions));
                break;
            default:
                System.out.println("Wrong number of wires!");
        }
    }

    public static void ConditionCheck(List<String[]> wires) throws IOException {
        int count = 0;
        boolean answerFound = false;

        while (true) {
            for (int i = 0; i < wires.get(count).length - 1; i++){
                System.out.print(wires.get(count)[i] + " (y/n): ");

                String line = KeepTalking.bufferedReader.readLine().toLowerCase();
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
            if (answerFound) {
                System.out.println(wires.get(count)[wires.get(count).length - 1]);
                return;
            } else {
                count++;
            }

            if (count == wires.size() - 1) {
                System.out.println(wires.get(count)[wires.get(count).length - 1]);
                return;
            }
        }
    }
}
