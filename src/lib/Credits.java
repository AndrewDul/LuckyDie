package lib;

/**
 * Credits class for the LuckyDie game. Displays the full game rules, scoring system,
 * and credits information.
 */
public class Credits {

    /**
     * Displays the credits, including game rules, scoring details, and information about the developer.
     */
    public void displayCredits() {
        System.out.println("\n========================");
        System.out.println("      LuckyDie Credits      ");
        System.out.println("========================");
        System.out.println("Game Rules:");
        System.out.println("In LuckyDie, you roll two dice each round and guess the combined total of the roll.");
        System.out.println("Your objective is to reach exactly 100 points by making accurate guesses.");
        System.out.println();
        System.out.println("Scoring System:");
        System.out.println(" - Exact Guess: 50 points");
        System.out.println(" - Difference of 1 to 2: 20 points");
        System.out.println(" - Difference of 3 to 4: 10 points");
        System.out.println(" - Difference of 5 to 6: 5 points");
        System.out.println();
        System.out.println("Each round, you enter your guess, and the dice are rolled.");
        System.out.println("After each roll, you'll see the results of each die in the colors you set in Settings.");
        System.out.println();
        System.out.println("Settings:");
        System.out.println("You can customize the color of each die's result display in the settings menu.");
        System.out.println("Choose from colors like red, blue, green, yellow, purple, cyan, or pink.");
        System.out.println();
        System.out.println("Developer: Andrzej Dul, Student");
        System.out.println("Thank you for playing LuckyDie!");
        System.out.println();
    }
}
