package hw4;

import java.util.Comparator;

// Define your class that implements Comparator
public class OrderComparator2 implements Comparator<Orders> {
	// Define your class that implements Comparator
	public int compare(Orders o1, Orders o2) {

		int min = Integer.MAX_VALUE;
		// Compare based on your conditions
		if ((min > o1.getExecTime()) && o1.isAvailable()) {
			if ((min > o2.getExecTime()) && o2.isAvailable()) {
				return 0; // Both satisfy condition
			} else {
				return -1; // o1 satisfies condition, but o2 doesn't
			}
		} else {
			if ((min > o2.getExecTime()) && o2.isAvailable()) {
				return 1; // o2 satisfies condition, but o1 doesn't
			} else {
				return 0; // Neither satisfy condition
			}
		}

	}

}
