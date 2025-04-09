package hw4;

import java.util.ArrayList;
import java.util.Collections;

public class Algorithm {

	public static Orders Algorithm2(ArrayList<Orders> waitingOrders) {

		Collections.sort(waitingOrders, new OrderComparator2());
		return waitingOrders.get(0);
	}

	public static Orders Algorithm3(ArrayList<Orders> waitingOrders) {

		Collections.sort(waitingOrders, new WeightComparator());
		// Now the waitingOrders ArrayList is sorted based on weights
		// You can return the first element if you want the order with the maximum
		// weight
		return waitingOrders.get(0);
	}

}
