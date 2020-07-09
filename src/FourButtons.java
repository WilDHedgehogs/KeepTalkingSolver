import java.io.IOException;
import java.util.*;

//Экран и четыре кнопки.
public class FourButtons {
    public static Stage firstStage;
    public static Stage secondStage;
    public static Stage thirdStage;
    public static Stage fourthStage;
    public static Stage fifthStage;
    public static LinkedList<Stage> stages = new LinkedList<>();

    public static void SolveFourButtons() throws IOException {
        stages.clear();
        InitializeStartStage();
        int level = 2;
        List<Stage> completedStages = new ArrayList<>();

        while (!stages.isEmpty()) {
            Stage currentStage = stages.poll();
            System.out.print("\nStage #" + currentStage.level + " ");
            System.out.print("displayed number: ");
            int displayedNumber = -1;

            try {
                displayedNumber = Integer.parseInt(KeepTalking.bufferedReader.readLine());
            } catch (NumberFormatException e) {
                System.out.println("No number was entered!");
            }

            if (displayedNumber == -1) {
                return;
            } else if (displayedNumber < 0 || displayedNumber > 4) {
                System.out.println("Wrong number!");
                return;
            }

            System.out.println("\n" + currentStage.description.get(displayedNumber));

            for (Stage stage : completedStages) {
                System.out.println(stage);
            }

            System.out.print("Enter Position and Label: ");
            String positionAndLabel = KeepTalking.bufferedReader.readLine();

            if (positionAndLabel.equals("-1")) {
                return;
            }

            TransformAnswers(currentStage, positionAndLabel);
            if (!(currentStage instanceof Stage)){
                return;
            }

            completedStages.add(currentStage);

            InitializeNextStages(level);
            level++;
        }
    }


    public static void InitializeStartStage() {
        Map<Integer, String> firstStageDescription = new HashMap<Integer, String>(){{
                put(1, "[2] Position");
                put(2, "[2] Position");
                put(3, "[3] Position");
                put(4, "[4] Position");
        }};
        firstStage = new Stage(firstStageDescription, 1);
        stages.add(firstStage);
    }

    public static void InitializeNextStages(int level) {
        switch (level) {
            case 2:
                Map<Integer, String> secondStageDescription = new HashMap<Integer, String>(){{
                        put(1, "Label [4]");
                        put(2, "[" + firstStage.position + "] Position");
                        put(3, "[1] Position");
                        put(4, "[" + firstStage.position + "] Position");
                }};
                secondStage = new Stage(secondStageDescription, level);
                stages.add(secondStage);
                break;
            case 3:
                Map<Integer, String> thirdStageDescription = new HashMap<Integer, String>(){{
                        put(1, "Label [" + secondStage.label + "]");
                        put(2, "Label [" + firstStage.label + "]");
                        put(3, "[3] Position");
                        put(4, "Label [4]");
                }};
                thirdStage = new Stage(thirdStageDescription, level);
                stages.add(thirdStage);
                break;
            case 4:
                Map<Integer, String> fourthStageDescription = new HashMap<Integer, String>(){{
                        put(1, "[" + firstStage.position + "] Position");
                        put(2, "[1] position");
                        put(3, "[" + secondStage.position + "] Position");
                        put(4, "[" + secondStage.position + "] Position");
                }};
                fourthStage = new Stage(fourthStageDescription, level);
                stages.add(fourthStage);
                break;
            case 5:
                Map<Integer, String> fifthStageDescription = new HashMap<Integer, String>(){{
                        put(1, "Label [" + firstStage.label + "]");
                        put(2, "Label [" + secondStage.label + "]");
                        put(3, "Label [" + fourthStage.label + "]");
                        put(4, "Label [" + thirdStage.label + "]");
                }};
                fifthStage = new Stage(fifthStageDescription, level);
                stages.add(fifthStage);
                break;
            default:
                System.out.println("Unknown level");
        }
    }

    public static Stage TransformAnswers(Stage stage, String line) {
        try {
            stage.position = Integer.parseInt(line.substring(0, line.indexOf(" ")));
            stage.label = Integer.parseInt(line.substring(line.lastIndexOf(" ") + 1));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Wrong number of parameters!");
            return null;
        } catch (NumberFormatException e) {
            System.out.println("No number was entered!");
            return null;
        }
        return stage;
    }

    static class Stage {
        Map<Integer, String> description;
        int label;
        int position;
        int level;

        public Stage(Map<Integer, String> description, int level) {
            this.description = description;
            this.level = level;
        }

        @Override
        public String toString() {
            return "Stage #" + level + " " +
                    "Position: " + position +
                    " Label: " + label;
        }
    }
}
