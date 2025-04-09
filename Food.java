package hw4;

/**
 * Represents an abstract class for food items.
 */
public abstract class Food {
    protected int cookTime; // Cooking time for the food item

    /**
     * Constructs a Food object with the given cooking time.
     * @param cookTime The cooking time for the food item.
     */
    public Food(int cookTime) {
        this.cookTime = cookTime;
    }

    /**
     * Reduces the remaining cooking time for the food item by one unit.
     */
    public void ReduceTime() {
        cookTime--;
    }

    /**
     * Checks if the food item is ready (i.e., cooking time has elapsed).
     * @return True if the food item is ready, otherwise false.
     */
    public boolean IsReady() {
        return cookTime <= 0;
    }

    /**
     * Abstract method to retrieve the capacity of the food item.
     * @return The capacity of the food item.
     */
    public abstract int getCapacity();

    /**
     * Abstract method to retrieve the execution time required for cooking the food item.
     * @return The cooking time for the food item.
     */
    public abstract int ExecTime();
}
