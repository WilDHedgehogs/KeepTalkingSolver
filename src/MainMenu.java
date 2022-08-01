import Handlers.PathHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainMenu {

    static JFrame mainMenu = new JFrame("Main menu");
    static JMenuBar menuBar = new JMenuBar();
    static JMenu file = new JMenu("File");
    static JMenuItem back = new JMenuItem("Back");
    static JMenuItem restart = new JMenuItem("Restart");
    static JMenuItem exit = new JMenuItem("Exit");
    static GridLayout mainMenuLayout = new GridLayout(4, 3);
    static JButton params = new JButton("Parameters");
    static JButton simpleWires = new JButton("Simple wires");
    static JButton bigButton = new JButton("Big button");
    static JButton keypads = new JButton("Keypads");
    static JButton simon = new JButton("Simon Says");
    static JButton whoFirst = new JButton("Who's on First");
    static JButton memory = new JButton("Memory");
    static JButton morse = new JButton("Morse Code");
    static JButton complexWires = new JButton("Complicated Wires");
    static JButton wireSequences = new JButton("Wire Sequences");
    static JButton maze = new JButton("Maze");
    static JButton password = new JButton("Password");

    public static void main(String[] args) {

        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenu.setSize(522, 696); //TODO: Возможно нужен запас по высоте для меню

        menuBar.add(file);

        file.add(back);
        file.add(restart);
        file.add(exit);

        prepareImages();

        mainMenu.setLayout(mainMenuLayout);

        ArrayList<JButton> mainMenuButtons = new ArrayList<>();
        mainMenuButtons.add(simpleWires);
        mainMenuButtons.add(bigButton);
        mainMenuButtons.add(keypads);
        mainMenuButtons.add(simon);
        mainMenuButtons.add(whoFirst);
        mainMenuButtons.add(memory);
        mainMenuButtons.add(morse);
        mainMenuButtons.add(complexWires);
        mainMenuButtons.add(wireSequences);
        mainMenuButtons.add(maze);
        mainMenuButtons.add(password);

//        mainMenu.getContentPane().add(BorderLayout.NORTH, menuBar);

        for (JButton button: mainMenuButtons) {
            configButton(button);
            mainMenu.add(button);
        }


//        mainMenuLayout.setHgap(0);
//        mainMenu.setLayout(mainMenuLayout);

        mainMenu.setVisible(true);
    }

    private static void prepareImages() {
        try {
            Image simpleWiresImage = ImageIO.read(new File(PathHandler.getPath("simpleWires")));
            Image bigButtonImage = ImageIO.read(new File(PathHandler.getPath("bigButton")));
            Image keypadsImage = ImageIO.read(new File(PathHandler.getPath("keypads")));
            Image simonImage = ImageIO.read(new File(PathHandler.getPath("simonSays")));
            Image whoFirstImage = ImageIO.read(new File(PathHandler.getPath("whoFirst")));
            Image memoryImage = ImageIO.read(new File(PathHandler.getPath("memory")));
            Image morseImage = ImageIO.read(new File(PathHandler.getPath("morse")));
            Image complexWiresImage = ImageIO.read(new File(PathHandler.getPath("complicatedWires")));
            Image wireSequencesImage = ImageIO.read(new File(PathHandler.getPath("wireSequences")));
            Image mazeImage = ImageIO.read(new File(PathHandler.getPath("maze")));
            Image passwordImage = ImageIO.read(new File(PathHandler.getPath("password")));
            simpleWires.setIcon(new ImageIcon(simpleWiresImage));
            bigButton.setIcon(new ImageIcon(bigButtonImage));
            keypads.setIcon(new ImageIcon(keypadsImage));
            simon.setIcon(new ImageIcon(simonImage));
            whoFirst.setIcon(new ImageIcon(whoFirstImage));
            memory.setIcon(new ImageIcon(memoryImage));
            morse.setIcon(new ImageIcon(morseImage));
            complexWires.setIcon(new ImageIcon(complexWiresImage));
            wireSequences.setIcon(new ImageIcon(wireSequencesImage));
            maze.setIcon(new ImageIcon(mazeImage));
            password.setIcon(new ImageIcon(passwordImage));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void configButton(JButton button) {
//        button.setBorderPainted(false);
//        button.setBorder(null);
//        button.setMargin(new Insets(0, 0, 0, 0));
        button.setText(null);
//        button.setContentAreaFilled(false);
//        button.setBounds(new Rectangle(10, 9, 50, 50));
    }

    //TODO: Количество ошибок или режим с единственной ошибкой

    public class Params {
        String serialNumber;
        String identification; //SND, CLR, CAR, IND, FRQ, SIG, NSA, MSA, TRN, BOB, FRK
        int AABatteryCount;
        int DBatteryCount;
        boolean isDVI_DPortPresent;
        boolean isParallelPortPresent;
        boolean isPS_2PortPresent;
        boolean isRJ_45PortPresent;
        boolean isSerialPortPresent;
        boolean isStereoRCAPortPresent;
    }

    public class NeedyModules {
        String ventingGas; //TODO: Скорее всего не нужен
        String capacitorDischarge; //TODO: Скорее всего не нужен
        String knobs; //UP class

    }

}
