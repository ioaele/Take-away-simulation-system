package hw4;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a factory for managing pie orders.
 */
public class PiesFactory implements Factory {
	private static ArrayList<Integer> numbers; // List to store the possibilities of pies in an order
	private int NumOfOrders; // Total number of orders

	/**
	 * Constructs a PiesFactory object with the given number of orders.
	 * 
	 * @param NumOfOrders The total number of orders.
	 */
	PiesFactory(int NumOfOrders) {
		this.NumOfOrders = NumOfOrders;
		numbers = new ArrayList<>();
		boolean ExactPercentagesForPies;
		// check if the Percentages are exactly
		if (((int)(0.20 * NumOfOrders) + (int)(0.35 * NumOfOrders) +(int)(0.10 * NumOfOrders)+(int)(0.20 * NumOfOrders)+(int)(0.15 * NumOfOrders)) == NumOfOrders)
			ExactPercentagesForPies = true;
		else
			ExactPercentagesForPies = false;
		
		// Add possibilities of pies based on percentages
		addPosibility(0.20, 1, ExactPercentagesForPies);
		addPosibility(0.35, 2, ExactPercentagesForPies);
		addPosibility(0.10, 3, ExactPercentagesForPies);
		addPosibility(0.20, 4, ExactPercentagesForPies);
		addPosibility(0.15, 5, ExactPercentagesForPies);
	}

	/**
	 * Removes the possibility at the specified index from the factory.
	 * 
	 * @param index The index of the possibility to be removed.
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public void removeElement(int index) {
		if (index >= 0 && index < numbers.size()) {
			numbers.remove(index);
		} else {
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}
	}

	/**
	 * Retrieves the value of the possibility at the specified index from the
	 * factory.
	 * 
	 * @param index The index of the possibility.
	 * @return The value of the possibility.
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public int getElement(int index) {
		if (index >= 0 && index < numbers.size()) {
			return numbers.get(index);
		} else {
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}
	}

	/**
	 * Adds a possibility with the given percentage and number of pies in an order
	 * to the factory.
	 * 
	 * @param percentage  The percentage of the possibility.
	 * @param PiesInOrder The number of pies in an order.
	 */
	public void addPosibility(double percentage, int PiesInOrder, boolean ExactPercentagesForPies) {
		if (ExactPercentagesForPies == true) {
			if (PiesInOrder == 5) {
				// Add random number of pies between 5 and 20
				for (int i = 0; i < (int) (NumOfOrders * percentage); i++) {
					Random rand = new Random();
					int randomNumber = rand.nextInt(16) + 5;
					numbers.add(randomNumber);
				}
			} else {
				// Add fixed number of pies
				for (int i = 0; i < (int) (NumOfOrders * percentage); i++) {
					numbers.add(PiesInOrder);
				}
			}
		} else {
			if (PiesInOrder == 5) {
				// Add random number of pies between 5 and 20
				for (int i = 0; i < (int) (NumOfOrders * percentage) + 1; i++) {
					Random rand = new Random();
					int randomNumber = rand.nextInt(16) + 5;
					numbers.add(randomNumber);
				}
			} else {
				// Add fixed number of pies
				for (int i = 0; i < (int) (NumOfOrders * percentage) + 1; i++) {
					numbers.add(PiesInOrder);
				}
			}
		}
	}
}
