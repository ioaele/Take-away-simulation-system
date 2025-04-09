package hw4;

/**
 * Represents a type of Pork.
 */
public class Pork extends Food {

    private int lengthSmila; // Length of pork pieces in Smila units
    private int AmountOfPork; // Amount of pork pieces

    /**
     * Constructs a Pork object with specified cooking time, length of pork pieces, and amount of pork.
     * @param cookTime The cooking time for the pork.
     * @param lengthSmila The length of pork pieces in Smila units.
     * @param AmountOfPork The amount of pork pieces.
     */
    Pork(int cookTime, int lengthSmila, int AmountOfPork) {
        super(cookTime);
        this.lengthSmila = lengthSmila;
        this.AmountOfPork = AmountOfPork * 2; // Each Pork order has 2 smiles
    }

    /**
     * Gets the execution time required for cooking the pork.
     * @return The cooking time for the pork.
     */
    public int ExecTime() {
        return super.cookTime;
    }

    /**
     * Calculates and returns the capacity of the pork based on its length and amount.
     * @return The capacity of the pork.
     */
    public int getCapacity() {
        return (AmountOfPork * lengthSmila);
    }
}
