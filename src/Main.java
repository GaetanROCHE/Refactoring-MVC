import Controller.ManualController;
import Controller.FlockingController;
import Controller.RandomController;

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

            // Switch construct
            switch (choice) {
                case 1:
                    new ManualController();
                    break;
                case 2:
                    System.out.println("How many troubadours?");
                    scanner = new Scanner(System.in);
                    choice = scanner.nextByte();
                    new RandomController(choice).run();
                    break;
                case 3:
                    System.out.println("Option 3 selected");  // this is where I want to call the class
                    System.out.println("How many troubadours?");
                    scanner = new Scanner(System.in);
                    choice = scanner.nextByte();
                    new FlockingController(choice).run();
                    break;
                default:
                    System.out.println("Invalid selection");
                    break;
            }

        } while(choice < 1 || choice > 3);

    }
}
