package hw4;

/**
 * Represents the time required for delivery based on the number of pies ordered and the time of order placement.
 */
public class TimeReqDel {
    private int timeReq; // Time required for delivery

    /**
     * Constructs a TimeReqDel object based on the number of pies and the time of order placement.
     * @param numOfPies The number of pies ordered.
     * @param timeOrder The time of order placement.
     */
    TimeReqDel(int numOfPies, TimeOrder timeOrder) {
        int numP = numOfPies; // Number of pies in the order
        int timeOrd = timeOrder.getTimeOrder(); // Time of order placement

        // Calculate the time required for delivery based on the number of pies and the time of order placement
        if (numP < 10) {
            int minRegTime = 30 + timeOrd; // Minimum regular delivery time
            int maxRegTime = 180 + timeOrd; // Maximum regular delivery time
            // Generate a random delivery time within the regular range
            timeReq = (int) (Math.random() * (maxRegTime - minRegTime + 1)) + minRegTime;
        } else {
            int minRegTime = 60 + timeOrd; // Minimum regular delivery time for large orders
            int maxRegTime = 180 + timeOrd; // Maximum regular delivery time for large orders
            // Generate a random delivery time within the regular range for large orders
            timeReq = (int) (Math.random() * (maxRegTime - minRegTime + 1)) + minRegTime;
        }
    }

    /**
     * Gets the time required for delivery.
     * @return The time required for delivery.
     */
    public int getTimeReqDel() {
        return timeReq;
    }
}
