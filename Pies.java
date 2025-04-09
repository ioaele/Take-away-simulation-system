package hw4;

/**
 * Represents a class responsible for handling pies.
 */
public class Pies {

    private PiesFactory ArrayOfPies; // Array of pies

    /**
     * Constructs a Pies object with the given array of pies.
     * @param ArrayOfPies The array of pies.
     */
    Pies(PiesFactory ArrayOfPies) {
        this.ArrayOfPies = ArrayOfPies;
    }

    /**
     * Determines the number of pies to be prepared.
     * @param CurrentArraySize The current size of the array of pies.
     * @return The number of pies to be prepared.
     */
    public int NumOfPies(int CurrentArraySize) {
        int random = (int) (Math.random() * (CurrentArraySize ));
        int howManyPies = ArrayOfPies.getElement(random);
        ArrayOfPies.removeElement(random);

        return howManyPies;
    }
}
