package lib;

/**
 * Class representing a pair of dice, each of which can roll independently.
 * This class allows rolling two dice simultaneously and provides their combined result.
 */
public class PairOfDice {

    private Dice die1;
    private Dice die2;

    /**
     * Constructor for PairOfDice with a specified number of sides on each die.
     * 
     * @param sides the number of sides on each die (e.g., 6 for standard dice)
     */
    public PairOfDice(int sides) {
        this.die1 = new Dice(sides);
        this.die2 = new Dice(sides);
    }

    /**
     * Rolls both dice and returns the combined result of the roll.
     * 
     * @return the sum of the roll results for both dice
     */
    public int rollBoth() {
        return die1.roll() + die2.roll();
    }

    /**
     * Rolls each die individually and returns their separate results.
     * 
     * @return an array of integers where the first element is the result of die1,
     *         and the second element is the result of die2
     */
    public int[] rollEach() {
        return new int[] { die1.roll(), die2.roll() };
    }

    /**
     * Returns the number of sides on each die.
     * 
     * @return the number of sides on the dice
     */
    public int getSides() {
        return die1.getSides(); // Both dice have the same number of sides
    }
}
