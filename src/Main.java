import Controller.ManualController;
import Controller.AutomatedController;
import Model.AutomatedTortue;
import Model.RandomTortue;
import Model.FlockingTortue;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ROCHE Gaetan & PLATTEAU Jonathan
 */
public class Main {

    public static void main(String[] args) {
        byte choice;
        System.out.println("Booting application...");
        System.out.println("1 > Manuel Mode");
        System.out.println("2 > Random Mode");
        System.out.println("3 > Flocking Mode (experimental)");

        do {
            System.out.println("Select option: ");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextByte();
            ArrayList<AutomatedTortue> tortues = new ArrayList<>();
            int number;
            // Switch construct
            switch (choice) {
                case 1:
                    new ManualController(600, 400);
                    break;
                case 2:
                    System.out.println("How many troubadours?");
                    scanner = new Scanner(System.in);
                    number = scanner.nextByte();

                    for(int i=0; i<number; i++){
                        tortues.add(new RandomTortue(600, 400));
                    }
                    new AutomatedController(tortues, 600, 400).run();
                    break;
                case 3:
                    System.out.println("Option 3 selected");  // this is where I want to call the class
                    System.out.println("How many troubadours?");
                    scanner = new Scanner(System.in);
                    number = scanner.nextByte();
                    for(int i=0; i<number; i++){
                        tortues.add(new FlockingTortue(600, 400, 90, 30, 1, 10));
                    }
                    new AutomatedController(tortues, 600, 400).run();
                    break;
                default:
                    System.out.println("Invalid selection");
                    break;
            }

        } while(choice < 1 || choice > 3);

    }
}
