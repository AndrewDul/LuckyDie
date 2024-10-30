package lib;

/**
 * Class representing a single die, which can roll a random number between 1 and a specified number of sides.
 * This class allows for flexible dice sizes, so you can use dice with any number of sides, such as 6-sided or 10-sided dice.
 */
public class Dice {

    private int sides;

    /**
     * Constructor for Dice with a specified number of sides.
     * 
     * @param sides the number of sides on the die (e.g., 6 for a standard die)
     */
    public Dice(int sides) {
        this.sides = sides;
    }

    /**
     * Rolls the die and returns a random number between 1 and the number of sides.
     * 
     * @return a random integer representing the result of the roll, from 1 to the number of sides
     */
    public int roll() {
        return (int) (Math.random() * sides) + 1;
    }
    
    /**
     * Returns the number of sides of the die.
     * 
     * @return the number of sides on the die
     */
    public int getSides() {
        return sides;
    }
}
