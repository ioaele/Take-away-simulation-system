package hw4;

import java.util.ArrayList;

/**
 * A factory class for generating fries orders.
 */
public class FriesFactory implements Factory {
	private static ArrayList<Integer> numbers; // ArrayList to store the number of fries in each order
	private int NumOfOrders; // Total number of orders
	private int TotalNumOfPies; // Total number of pies in all orders

	/**
	 * Constructs a FriesFactory object.
	 * 
	 * @param TotalNumOfPies The total number of pies in all orders.
	 * @param NumOfOrders    The total number of orders.
	 */
	FriesFactory(int TotalNumOfPies, int NumOfOrders) {
		this.NumOfOrders = NumOfOrders;
		this.TotalNumOfPies = TotalNumOfPies;
		int AllFries = NumOfOrders * TotalNumOfPies;
		numbers = new ArrayList<>();
		boolean ExactPercentagesForFries;
		// check if the Percentages are exactly
		if (((int)(0.60 * AllFries) + (int)(0.35 * AllFries) + (int)(0.05 * AllFries)) ==AllFries)
			ExactPercentagesForFries = true;
		else 
			ExactPercentagesForFries = false;
	
		// Add possibilities for different numbers of fries per pie
		addPosibility(0.60, 1, ExactPercentagesForFries); // 60% chance of 1 fry per pie
		addPosibility(0.35, 0, ExactPercentagesForFries); // 35% chance of 0 fries per pie
		addPosibility(0.05, 2, ExactPercentagesForFries); // 5% chance of 2 fries per pie
	}

	/**
	 * Adds possibilities for the number of fries per pie to the factory.
	 * 
	 * @param percentage The percentage of orders to which the possibility applies.
	 * @param FriesInP   The number of fries per pie.
	 */
	public void addPosibility(double percentage, int FriesInP, boolean ExactPercentagesForFries) {
		if (ExactPercentagesForFries == true)
			for (int i = 0; i < ((int) (NumOfOrders * TotalNumOfPies * percentage)); i++)
				numbers.add(FriesInP);
		else
			for (int i = 0; i < ((int) (NumOfOrders * TotalNumOfPies * percentage) +1); i++)
				numbers.add(FriesInP);
	}

	/**
	 * Removes an element from the list of fries numbers at the specified index.
	 * 
	 * @param index The index of the element to be removed.
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
	 * Gets the element from the list of fries numbers at the specified index.
	 * 
	 * @param index The index of the element to be retrieved.
	 * @return The number of fries at the specified index.
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public int getElement(int index) {
		if (index >= 0 && index < numbers.size()) {
			return numbers.get(index);
		} else {
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}
	}
}
