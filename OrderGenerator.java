package hw4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @authors Eleni Ioannou & George Georgiadis
 * @since 18/04/2024
 * @see Order  
 * 
 * 
 * 
 * /** Generates orders, sorts them based on order time, and
 *      writes them to a file.
 */
public class OrderGenerator {
	/**
	 * Main method to generate orders.
	 * 
	 * @param args Command-line arguments. The first argument should be the number
	 *             of orders to generate.
	 */
	public static void main(String args[]) {
		int NumOfOrders = Integer.parseInt(args[0]); // Number of orders specified in the command-line argument

		Order orders[] = new Order[NumOfOrders]; // Array to store the orders
		int TotalNumOfPies = 0; // Total number of pies for all orders

		PiesFactory ArrayOfPies = new PiesFactory(NumOfOrders); // Factory to manage pie orders

		int CurrentArraySize = NumOfOrders; // Current size of the array for calculating fries
		int numOfPies[] = new int[NumOfOrders]; // Array to store the number of pies for each order

		Pies pies = new Pies(ArrayOfPies); // Object to generate pie orders
		// Generate pie orders for each order and calculate the total number of pies
		for (int i = 0; i < NumOfOrders; i++) {
			numOfPies[i] = pies.NumOfPies(CurrentArraySize);
			CurrentArraySize--;
			TotalNumOfPies += numOfPies[i];
		}

		FriesFactory ArrayOfFries = new FriesFactory(TotalNumOfPies, NumOfOrders); // Factory to manage fries orders
		CurrentArraySize = NumOfOrders * TotalNumOfPies; // Current size of the array for calculating fries

		// Generate orders based on the number of pies and fries
		for (int i = 0; i < NumOfOrders; i++) {
			orders[i] = new Order(ArrayOfFries, NumOfOrders, CurrentArraySize, numOfPies[i]);
			CurrentArraySize -= numOfPies[i];
		}

		insertionSort(orders); // Sort the orders based on order time

		try {
			// Write the orders to a file named "orders.txt"
			File file = new File("orders.txt");
			FileOutputStream fos = new FileOutputStream(file);
			PrintStream ps = new PrintStream(fos);
			// Write each order to the file
			for (int i = 0; i < NumOfOrders; i++) {
				ps.print(i + 1 + " "); // Write order number
				ps.println(orders[i]); // Write order details
			}
			ps.close();
			fos.close();
		} catch (Exception e) {
			// Handle any errors that occur during file writing
			System.out.println("An error occurred: " + e.getMessage());
		}
	}

	/**
	 * Sorts an array of orders using insertion sort based on the order time.
	 * 
	 * @param orders The array of orders to be sorted.
	 */
	public static void insertionSort(Order[] orders) {
		int n = orders.length;
		// Iterate through the array and perform insertion sort
		for (int i = 1; i < n; ++i) {
			Order temp = orders[i];
			int j = i - 1;
			// Move elements of orders[0..i-1], that are greater than temp, to one position
			// ahead of their current position
			while (j >= 0 && orders[j].getTimeOrder().getTimeOrder() > temp.getTimeOrder().getTimeOrder()) {
				orders[j + 1] = orders[j];
				j = j - 1;
			}
			orders[j + 1] = temp;
		}
	}
}
