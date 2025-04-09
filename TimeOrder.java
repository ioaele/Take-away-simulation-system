package hw4;

import java.util.*;

/**
 * Represents a class for generating the time when an order is placed.
 */
public class TimeOrder {
    private int time; // The time when the order is placed

    /**
     * Constructs a TimeOrder object and generates a random time for placing the order.
     */
    TimeOrder() {
        Random random = new Random();
        // Generate a random time using Gaussian distribution with mean 180 and standard deviation 60
        time = (int) (random.nextGaussian() * Math.sqrt(60) + 180);
    }

    /**
     * Retrieves the time when the order was placed.
     * @return The time when the order was placed.
     */
    public int getTimeOrder() {
        return time;
    }
}
