package hw4;

/**
 * Represents an order for food items.
 */
public class Order {

    private TimeOrder timeOrder; // Time when the order was placed
    private TimeReqDel timeDel; // Time required for delivery
    private Meat meat; // Meat items in the order
    private Fries fries; // Fries in the order

    /**
     * Constructs an Order object with the given fries factory, number of orders, temperature, and number of pies.
     * @param ArrayOfFries The fries factory.
     * @param NumOfOrders The number of orders.
     * @param temp The temperature.
     * @param numOfPies The number of pies.
     */
    Order(FriesFactory ArrayOfFries, int NumOfOrders, int temp, int numOfPies) {
        timeOrder = new TimeOrder();
        timeDel = new TimeReqDel(numOfPies, timeOrder);
        meat = new Meat(numOfPies);
        fries = new Fries(ArrayOfFries, numOfPies, NumOfOrders, temp);
    }

    /**
     * Returns a string representation of the order.
     * @return The string representation of the order.
     */
    public String toString() {
        return timeOrder.getTimeOrder() + " " + timeDel.getTimeReqDel() + " " +
                meat.getTypeOfMeat(0) + " " + meat.getTypeOfMeat(1) + " " +
                meat.getTypeOfMeat(2) + " " + meat.getTypeOfMeat(3) + " " +
                fries.getTotalNumOfFries();
    }

    /**
     * Retrieves the time when the order was placed.
     * @return The time order object.
     */
    public TimeOrder getTimeOrder() {
        return timeOrder;
    }
}
