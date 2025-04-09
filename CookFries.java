package hw4;

/**
 * Represents a cooking process for fries.
 */
public class CookFries {
    private int AmountOfFries; // Amount of fries to cook
    private int cookTime; // Remaining cooking time for the fries

    /**
     * Constructs a CookFries object with specified cooking time and amount of fries.
     * @param time The initial cooking time for the fries.
     * @param AmountOfFries The amount of fries to cook.
     */
    public CookFries(int time, int AmountOfFries) {
        cookTime = time;
        this.AmountOfFries = AmountOfFries;
    }

    /**
     * Checks if the fries are ready.
     * @return True if the fries are ready (cookTime is less than or equal to 0), false otherwise.
     */
    public boolean isReady() {
        return cookTime <= 0;
    }

    /**
     * Reduces the remaining cooking time for the fries by 1.
     */
    public void ReduceTime() {
        cookTime--;
    }

    /**
     * Gets the remaining cooking time for the fries.
     * @return The remaining cooking time for the fries.
     */
    public int ExecTime() {
        return cookTime;
    }

    /**
     * Gets the capacity of the fries (amount of fries).
     * @return The amount of fries to cook.
     */
    public int getCapacity() {
        return AmountOfFries;
    }
    public String toString () {
    	return "" + AmountOfFries;
    }
}
