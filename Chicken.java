package hw4;

/**
 * Represents a Chicken food item.
 */
public class Chicken extends Food {
    private int lengthSmila; // Length of chicken pieces in Smila units
    private int AmountOfChicken; // Amount of chicken pieces

    /**
     * Constructs a Chicken object with specified cooking time, length of chicken pieces, and amount of chicken.
     * @param cookTime The cooking time of the chicken.
     * @param lengthSmila The length of chicken pieces in Smila units.
     * @param AmountOfChicken The amount of chicken pieces.
     */
    Chicken(int cookTime, int lengthSmila, int AmountOfChicken) {
        super(cookTime);

        this.lengthSmila = lengthSmila;
        this.AmountOfChicken = AmountOfChicken * 2; // Doubling the amount of chicken
    }

    /**
     * Gets the execution time required to cook the chicken.
     * @return The cooking time of the chicken.
     */
    public int ExecTime() {
        return super.cookTime;
    }

    /**
     * Calculates and returns the capacity of the chicken based on its length and amount.
     * @return The capacity of the chicken.
     */
    public int getCapacity() {
        return (AmountOfChicken * lengthSmila);
    }
    
    
    
}
