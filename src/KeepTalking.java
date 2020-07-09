import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Главное меню.
public class KeepTalking {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        while (true) {
            //Названия всех мини игр в Keep Talking and Nobody Explodes.
            System.out.print("[L]etters, [M]orse, [R]ed blue black, [S]imple wires, [B]uttons, " +
                    "S[y]mbols,\n[C]omplex wires, [F]our buttons, Ma[z]e, [W]ho first, S[i]mon says, " +
                    "[U]p," +
                    "\n[Q]uit: ");
            String line = "";
            try {
                line = bufferedReader.readLine().toLowerCase();
                System.out.println();
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (line) {
                case "l":
                    System.out.println("Letters. [-1] for exit to last Menu.");
                    try {
                        Letters.SolveLeters();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "m":
                    System.out.println("Morse. [-1] for exit to last Menu.");
                    try {
                        Morse.SolveMorse();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "r":
                    System.out.println("RedBlueBlack. [-1] for exit to last Menu.");
                    try {
                        RedBlueBlack.SolveRedBlueBlack();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "s":
                    System.out.println("SimpleWires. [-1] for exit to last Menu.");
                    try {
                        SimpleWires.SolveSimpleWires();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "b":
                    System.out.println("Buttons. [-1] for exit to last Menu.");
                    try {
                        Buttons.SolveButtons();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "y":
                    System.out.println("Symbols. [-1] for exit to last Menu.");
                    try {
                        Symbols.SolveSymbols();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "c":
                    System.out.println("Complex Wires. [-1] for exit to last Menu.");
                    try {
                        ComplexWires.SolveComplexWires();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "f":
                    System.out.println("Four Buttons. [-1] for exit to last Menu.");
                    try {
                        FourButtons.SolveFourButtons();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "z":
                    System.out.println("Maze. [-1] for exit to last Menu.");
                    try {
                        Maze.SolveMaze();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "w":
                    System.out.println("Who first. [-1] for exit to last Menu.");
                    try {
                        WhoFirst.SolveWhoFirst();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "i":
                    System.out.println("Simon says. [-1] for exit to last Menu.");
                    try {
                        SimonSays.SolveSimonSays();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "u":
                    System.out.println("Up. [-1] for exit to last Menu.");
                    try {
                        Up.SolveUp();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "q":
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return;
                default:
                    System.out.println("Unknown option");
                    break;
            }
            System.out.println();
        }
    }
}
