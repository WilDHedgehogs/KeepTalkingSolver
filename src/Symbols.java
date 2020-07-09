import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Символы.
public class Symbols {
    public static List<String> firstColumn = new ArrayList<>(Arrays.asList(
            "o", "at", "l", "hp", "oct", "n", "eh"));

    public static List<String> secondColumn = new ArrayList<>(Arrays.asList(
            "yo", "o", "eh", "pig", "blank", "n", "q"));

    public static List<String> thirdColumn = new ArrayList<>(Arrays.asList(
            "copy", "ass", "pig", "zh", "z", "l", "blank"));

    public static List<String> fourthColumn = new ArrayList<>(Arrays.asList(
            "b", "w", "yat", "oct", "zh", "q", "smile"));

    public static List<String> fifthColumn = new ArrayList<>(Arrays.asList(
            "t", "smile", "yat", "sigma", "w", "snake", "full"));

    public static List<String> sixthColumn = new ArrayList<>(Arrays.asList(
            "b", "yo", "bob", "ae", "t", "i", "god"));

    public static List<List<String>> columns = new ArrayList<>();

    //Большинство символов не отображается в консоле Windows.
    public static Map<String, String> allSymbols = Stream.of(new String[][]{
            {"Ⓒ", "copy"}, {"ᴂ", "ae"}, {"ῶ", "ass"}, {"Ѣ", "yat"},
            {"Ω", "god"}, {"Ѧ", "at"}, {"Ѭ", "oct"}, {"ϗ", "n"},
            {"Ϙ", "o"}, {"¿", "q"}, {"¶", "w"}, {"ƛ", "l"},
            {"ψ", "t"}, {"ϟ", "hp"}, {"Ͼ", "sigma"}, {"Ͽ", "eh"},
            {"б", "b"}, {"Ѯ", "snake"}, {"҂", "bob"}, {"ӭ", "yo"},
            {"☆", "blank"}, {"★", "full"}, {"φ", "pig"}, {"ټ", "smile"},
            {"Й", "i"}, {"Ж", "zh"}, {"З", "z"},
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

    public static void SolveSymbols() throws IOException {
        System.out.println(allSymbols);
        System.out.print("Enter 4 symbols: ");
        String line = KeepTalking.bufferedReader.readLine().toLowerCase();
        if (line.equals("-1")) {
            return;
        }

        String[] symbols = InitializeSybmols(line);

        boolean columnFinded = false;
        InitializeColumns();

        for (List<String> list : columns) {
            for (String s : symbols) {
                if (!list.contains(s)) {
                    columnFinded = false;
                    break;
                } else {
                    columnFinded = true;
                }
            }
            if (columnFinded) {
                PrintResult(list, symbols);
                break;
            }
        }
        System.out.println();
    }

    public static void PrintResult(List<String> column, String[] symbols) {
        System.out.print("Result: ");
        for (String col : column) {
            for (String symb : symbols) {
                if (col.equals(symb)) {
                    System.out.print(col + " ");
                }
            }
        }
    }

    public static void InitializeColumns() {
        columns.add(firstColumn);
        columns.add(secondColumn);
        columns.add(thirdColumn);
        columns.add(fourthColumn);
        columns.add(fifthColumn);
        columns.add(sixthColumn);
    }

    public static String[] InitializeSybmols(String line) {

        String[] symbols = new String[4];
        try {
            symbols[0] = line.substring(0, line.indexOf(" "));
            symbols[3] = line.substring(line.lastIndexOf(" ") + 1);

            line = line.substring(line.indexOf(" ") + 1, line.lastIndexOf(" "));

            symbols[1] = line.substring(0, line.indexOf(" "));
            symbols[2] = line.substring(line.lastIndexOf(" ") + 1);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Wrong number of symbols" );
        }
        return symbols;
    }
}
