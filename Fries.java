package hw4;

/**
 * Represents a class for handling fries in an order.
 */
public class Fries {
    private int TotalNumOfF; // Total number of fries in the order
    private FriesFactory ArrayOfFries; // Factory for fries

    /**
     * Constructs a Fries object with the given fries factory, number of pies, number of orders, and current array size.
     * @param ArrayOfFries The fries factory.
     * @param numOfPies The number of pies in the order.
     * @param NumOfOrders The number of orders.
     * @param CurrentArraySize The current size of the fries factory array.
     */
    Fries(FriesFactory ArrayOfFries, int numOfPies, int NumOfOrders, int CurrentArraySize) {
        this.ArrayOfFries = ArrayOfFries;
        int numOfP = numOfPies;
        TotalNumOfF = 0;
        for (int i = 0; i < numOfP; i++) {
            TotalNumOfF += HowMany(CurrentArraySize);
            CurrentArraySize--;
        }
    }

    /**
     * Retrieves the total number of fries in the order.
     * @return The total number of fries.
     */
    public int getTotalNumOfFries() {
        return TotalNumOfF;
    }

    /**
     * Determines the number of fries for a single pie based on the current array size.
     * @param CurrentArraySize The current size of the fries factory array.
     * @return The number of fries for a single pie.
     */
    public int HowMany(int CurrentArraySize) {
        int random = (int) (Math.random() * (CurrentArraySize));
        int howManyFries = ArrayOfFries.getElement(random);
        ArrayOfFries.removeElement(random);
        return howManyFries;
    }
}
