package lib;

import java.util.Scanner;

/**
 * Class representing the main logic of the LuckyDie game, where the player guesses
 * the outcome of rolling two dice and earns points based on the accuracy of their guess.
 */
public class Game {

    private PairOfDice dicePair;
    private int targetScore;
    private int currentScore;
    private String colorDie1;
    private String colorDie2;
    private int roundsPlayed;
    private long startTime;
    private Scanner scanner;

    /**
     * Constructor for Game with specified target score, number of sides on each die,
     * and colors for each die result display.
     * 
     * @param sides the number of sides on each die (e.g., 6 for standard dice)
     * @param targetScore the score at which the game ends
     * @param colorDie1 the color for the first die's result display
     * @param colorDie2 the color for the second die's result display
     */
    public Game(int sides, int targetScore, String colorDie1, String colorDie2) {
        this.dicePair = new PairOfDice(sides);
        this.targetScore = targetScore;
        this.currentScore = 0;
        this.colorDie1 = colorDie1;
        this.colorDie2 = colorDie2;
        this.roundsPlayed = 0;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Starts the game and manages the flow of rounds until the player reaches or exceeds the target score.
     */
    public void start() {
        this.startTime = System.currentTimeMillis(); // Start timing the game
        while (currentScore < targetScore) {
            playRound();
        }

        long endTime = System.currentTimeMillis();
        double totalTime = (endTime - startTime) / 1000.0;
        
        System.out.println("Congratulations! You've reached " + currentScore + " points and won the game!");
        System.out.println("Total time: " + totalTime + " seconds");
        System.out.println("Rounds played: " + roundsPlayed);
    }

    /**
     * Plays a single round of the game, prompting the player to guess the roll of two dice,
     * calculating the score based on the guess accuracy, and updating the current score.
     */
    private void playRound() {
        System.out.print("Enter your guess for the combined roll (2 to " + (2 * dicePair.getSides()) + "): ");
        int playerGuess = scanner.nextInt();

        int[] rollResults = dicePair.rollEach();
        int actualRoll = rollResults[0] + rollResults[1];
        int pointsEarned = calculatePoints(playerGuess, actualRoll);
        currentScore += pointsEarned;
        roundsPlayed++;

        // Display each die result with color and delay
        displayDieResult(rollResults[0], colorDie1);
        displayDieResult(rollResults[1], colorDie2);

        System.out.println("The dice rolled a total of: " + actualRoll);
        System.out.println("You earned " + pointsEarned + " points this round. Total score: " + currentScore);
    }

    /**
     * Calculates the points earned based on the player's guess and the actual roll.
     * Points decrease with the difference between the guess and the actual roll.
     * 
     * @param guess the player's guessed roll total
     * @param actual the actual roll total of the dice
     * @return the number of points earned based on the accuracy of the guess
     */
    private int calculatePoints(int guess, int actual) {
        int difference = Math.abs(guess - actual);

        if (difference == 0) return 50;
        else if (difference <= 2) return 20;
        else if (difference <= 4) return 10;
        else if (difference <= 6) return 5;
        else return 0;
    }

    /**
     * Displays the result of a die roll with the specified color.
     * 
     * @param result the result of the die roll
     * @param color the color in which to display the result
     */
    private void displayDieResult(int result, String color) {
        try {
            System.out.println(getAnsiColorCode(color) + "Die result: " + result + "\033[0m"); // Reset color after display
            Thread.sleep(300); // Delay for visual effect
        } catch (InterruptedException e) {
            System.err.println("Error with display delay: " + e.getMessage());
        }
    }

    /**
     * Converts color names to ANSI escape codes for console color display.
     * 
     * @param color the color name as a string
     * @return the ANSI escape code for the specified color
     */
    private String getAnsiColorCode(String color) {
        return switch (color.toLowerCase()) {
            case "red" -> "\033[31m";
            case "blue" -> "\033[34m";
            case "green" -> "\033[32m";
            case "yellow" -> "\033[33m";
            case "purple" -> "\033[35m";
            case "cyan" -> "\033[36m";
            case "pink" -> "\033[95m";
            default -> "\033[37m"; // Default to white if color is unknown
        };
    }

    /**
     * Returns the current score of the player.
     * 
     * @return the current score
     */
    public int getCurrentScore() {
        return currentScore;
    }

    /**
     * Ends the game by closing the scanner resource.
     */
    public void endGame() {
        scanner.close();
    }
}
