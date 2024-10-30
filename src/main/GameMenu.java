package main;

import lib.Game;
import lib.GameRecord;
import lib.Settings;
import lib.Credits;

import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Main class for running the interactive menu for the LuckyDie game.
 * Allows the player to start a new game, view settings, see game credits, view records, and exit.
 */
public class GameMenu {

    private static final String RECORDS_FILE_PATH = "gameRecords.txt";
    private static final int TARGET_SCORE = 100; // Fixed target score

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Keep scanner open until the program ends
        GameRecord gameRecord = new GameRecord(Paths.get(RECORDS_FILE_PATH));
        Settings settings = new Settings();
        Credits credits = new Credits();
        boolean exit = false;

        System.out.println("Welcome to LuckyDie Game!");
        System.out.println("Try to guess the combined roll of two dice.");
        System.out.println("You need to reach " + TARGET_SCORE + " points to win!");
        
        while (!exit) {
            System.out.println("\n=======================");
            System.out.println("       Main Menu       ");
            System.out.println("=======================");
            System.out.println("1 - Start New Game");
            System.out.println("2 - Settings");
            System.out.println("3 - View Game Records");
            System.out.println("4 - Credits");
            System.out.println("5 - Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    startNewGame(scanner, gameRecord, settings);
                    break;
                case 2:
                    settings.displaySettingsMenu();
                    break;
                case 3:
                    viewRecords(gameRecord);
                    break;
                case 4:
                    credits.displayCredits();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Thank you for playing LuckyDie!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close(); // Close scanner only at the end of the program
    }

    /**
     * Starts a new game session with the fixed target score of 100 points and current settings.
     * 
     * @param scanner the scanner for player input
     * @param gameRecord the game record object to log the player's score
     * @param settings the settings object for color preferences
     */
    private static void startNewGame(Scanner scanner, GameRecord gameRecord, Settings settings) {
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        Game game = new Game(6, TARGET_SCORE, settings.getColorDie1(), settings.getColorDie2());
        game.start();
        gameRecord.addRecord(playerName, game.getCurrentScore());
    }

    /**
     * Displays all saved game records.
     * 
     * @param gameRecord the game record object used to read records
     */
    private static void viewRecords(GameRecord gameRecord) {
        System.out.println("\n--- Game Records ---");
        System.out.println(gameRecord.readAllRecords());
    }
}
