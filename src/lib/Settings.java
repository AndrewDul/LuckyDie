package lib;

import java.util.Scanner;

/**
 * Settings class for the LuckyDie game, allowing the player to select colors for each die.
 * Displays an ASCII-style menu and returns to the main menu after colors are chosen.
 */
public class Settings {

    private String colorDie1 = "Default";
    private String colorDie2 = "Default";

    // Array of available colors
    private final String[] colors = {"Red", "Blue", "Green", "Yellow", "Purple", "Cyan", "Pink"};

    /**
     * Displays the settings menu, allowing the player to select colors for each die.
     * Returns to the main menu after both colors are selected.
     */
    public void displaySettingsMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n====================");
        System.out.println("  LuckyDie Settings ");
        System.out.println("====================");
        System.out.println("Select a color for each die.");

        // Select color for die 1
        colorDie1 = chooseColor(scanner, "first");

        // Select color for die 2
        colorDie2 = chooseColor(scanner, "second");

        System.out.println("Colors selected: Die 1 - " + colorDie1 + ", Die 2 - " + colorDie2);
        System.out.println("Returning to main menu...");
    }

    /**
     * Presents color options to the player and returns the chosen color.
     * 
     * @param scanner Scanner object for input
     * @param diePosition String indicating whether it's the first or second die
     * @return the chosen color as a string
     */
    private String chooseColor(Scanner scanner, String diePosition) {
        System.out.println("\nChoose a color for the " + diePosition + " die:");

        for (int i = 0; i < colors.length; i++) {
            System.out.println((i + 1) + " - " + colors[i]);
        }

        int choice;
        do {
            System.out.print("Enter a number (1 to " + colors.length + "): ");
            choice = scanner.nextInt();
            if (choice < 1 || choice > colors.length) {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (choice < 1 || choice > colors.length);

        return colors[choice - 1];
    }

    /**
     * Returns the color selected for the first die.
     * 
     * @return the color of the first die
     */
    public String getColorDie1() {
        return colorDie1;
    }

    /**
     * Returns the color selected for the second die.
     * 
     * @return the color of the second die
     */
    public String getColorDie2() {
        return colorDie2;
    }
}
