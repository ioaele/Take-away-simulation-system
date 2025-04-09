package hw4;

/**
 *  Represents a type of Mix.
 */
public class Mix extends Food {
    private int porkcap; // Capacity of pork in the mix
    private int seftaliacap; // Capacity of seftalia in the mix
    private int numOfMix; // Number of mix items

    /**
     * Constructs a Mix object with specified cooking time, pork capacity, seftalia capacity, and number of mix items.
     * @param time The cooking time for the mix.
     * @param porkcap The capacity of pork in the mix.
     * @param seftaliacap The capacity of seftalia in the mix.
     * @param numOfMix The number of mix items.
     */
    Mix(int time, int porkcap, int seftaliacap, int numOfMix) {
        super(time);
        this.porkcap = porkcap;
        this.seftaliacap = seftaliacap;
        this.numOfMix = numOfMix;
    }

    /**
     * Reduces the remaining cooking time for the mix by one unit.
     */
    public void ReduceTime() {
        this.cookTime--;
    }

    /**
     * Retrieves the capacity of the mix based on pork and seftalia capacities and number of mix items.
     * @return The capacity of the mix.
     */
    public int getCapacity() {
        return (porkcap + seftaliacap) * numOfMix;
    }

    /**
     * Checks if the mix is ready (i.e., cooking time has elapsed).
     * @return True if the mix is ready, otherwise false.
     */
    public boolean IsReady() {
        return this.cookTime <= 0;
    }

    /**
     * Retrieves the execution time required for cooking the mix.
     * @return The cooking time for the mix.
     */
    public int ExecTime() {
        return super.cookTime;
    }
}
