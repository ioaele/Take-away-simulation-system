package hw4;

/**
 * Represents a cooking process for pies.
 */
public class CookPies extends Food {

    private int lengthPitta; // Length of pitta bread
    private int AmountOfPitta; // Amount of pitta bread

    /**
     * Constructs a CookPies object with specified cooking time, length of pitta bread, and amount of pitta bread.
     * @param time The cooking time for the pies.
     * @param lengthPitta The length of pitta bread in units.
     * @param AmountOfPitta The amount of pitta bread.
     */
    CookPies(int time, int lengthPitta, int AmountOfPitta) {
        super(time);
        this.lengthPitta = lengthPitta;
        this.AmountOfPitta = AmountOfPitta;
    }

    /**
     * Gets the execution time required for cooking the pies.
     * @return The cooking time for the pies.
     */
    public int ExecTime() {
        return super.cookTime;
    }

    /**
     * Calculates and returns the capacity of the pies based on their length and amount.
     * @return The capacity of the pies.
     */
    public int getCapacity() {
        return (lengthPitta * AmountOfPitta);
    }
    public String toString () {
    	return "" + AmountOfPitta;
    }
}
