package hw4;

/**
 * Represents a type of Seftalia.
 */
public class Seftalia extends Food {
    private int lengthSmila; // Length of Seftalia pieces in Smila units
    private int AmountOfSeftalia; // Amount of Seftalia pieces

    /**
     * Constructs a Seftalia object with specified order time, length of Seftalia pieces, and amount of Seftalia.
     * @param timeOrder The time the order was placed.
     * @param lengthSmila The length of Seftalia pieces in Smila units.
     * @param AmountOfSeftalia The amount of Seftalia pieces.
     */
    Seftalia(int timeOrder, int lengthSmila, int AmountOfSeftalia) {
        super(timeOrder);
        this.lengthSmila = lengthSmila;
        this.AmountOfSeftalia = AmountOfSeftalia * 2; // Each Seftalia order has 2 smiles
    }

    /**
     * Calculates and returns the capacity of the Seftalia based on its length and amount.
     * @return The capacity of the Seftalia.
     */
    public int getCapacity() {
        return (AmountOfSeftalia * lengthSmila);
    }

    /**
     * Gets the execution time required for cooking the Seftalia.
     * @return The cooking time of the Seftalia.
     */
    public int ExecTime() {
        return super.cookTime;
    }
}
