import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Диод, звёздночка, красный и синий провода.
public class ComplexWires {

    public static Map<String, String> variants = Stream.of(new String[][]{
            {"d n n n", "DON'T cut"}, {"d s n n", "Cut if TWO or more BATTERIES"},
            {"d s r n", "Cut if TWO or more BATTERIES"}, {"d s n b", "Cut if PARALLEL port"},
            {"d s r b", "DON'T cut"}, {"d n r n", "Cut if TWO or more BATTERIES"},
            {"d n n b", "Cut if PARALLEL port"}, {"d n r b", "Cut if last digit is EVEN"},
            {"n n n n", "CUT"}, {"n s n n", "CUT"},
            {"n s r n", "CUT"}, {"n s n b", "DON'T cut"},
            {"n s r b", "Cut if PARALLEL port"}, {"n n r n", "Cut if last digit is EVEN"},
            {"n n n b", "Cut if last digit is EVEN"}, {"n n r b", "Cut if last digit is EVEN"},
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

    public static void SolveComplexWires() throws IOException {
        while (true) {
            System.out.println("Possible options: [d/n] [s/n] [r/n] [b/n]");
            System.out.print("Enter variant: ");
            String line = KeepTalking.bufferedReader.readLine().toLowerCase();
            if (line.equals("-1")) {
                return;
            }

            System.out.println(variants.get(line.toLowerCase()) + "\n");
        }
    }
}
