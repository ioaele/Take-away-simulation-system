package hw4;

import java.util.ArrayList;

/**
 * Represents a kitchen where orders are processed.
 */
public class Kitchen {

	private int SouvlakiLength;
	private int SeftaliaLength;
	private int PittaLength;
	private int timeCoals;
	private int AlgorithType;
	private static int grillCap;
	private static int NumOfPans;
	private static int ServePerPans;
	private static int t;
	private static ArrayList<Orders> WaitingOrders;
	private static ArrayList<Orders> CookingOrders;
	private static ArrayList<Food> CookingFood;
	private static ArrayList<CookFries> CookingFries;
	private static ArrayList<Orders> FinishedOrders;
	private static ArrayList<Orders> UnFinishedOrders;

	private int timeReady[];
	private Orders OrdersOfTheDay[];
	private Orders currentOrder;

	/**
	 * Constructs a Kitchen object with the specified parameters.
	 *
	 * @param runOrder       Array of orders to be processed.
	 * @param NumOfPan       Number of pans available.
	 * @param ServePerPan    Number of servings per pan.
	 * @param grillCapp      Capacity of the grill.
	 * @param timeCoals      Time required for coals to be ready.
	 * @param AlgorithType   Type of algorithm to use.
	 * @param SouvlakiLength Length of Souvlaki.
	 * @param SeftaliaLength Length of Seftalia.
	 * @param PittaLength    Length of Pitta bread.
	 */
	public Kitchen(Orders runOrder[], int NumOfPan, int ServePerPan, int grillCapp, int timeCoals, int AlgorithType,
			int SouvlakiLength, int SeftaliaLength, int PittaLength) {
		// Constructor implementation

		OrdersOfTheDay = new Orders[runOrder.length];
		for (int i = 0; i < runOrder.length; i++)
			OrdersOfTheDay[i] = runOrder[i];

		this.timeCoals = timeCoals;
		this.AlgorithType = AlgorithType;
		grillCap = grillCapp;
		NumOfPans = NumOfPan;
		ServePerPans = ServePerPan;

		timeReady = new int[runOrder.length];
		WaitingOrders = new ArrayList<>();
		CookingOrders = new ArrayList<>();
		CookingFood = new ArrayList<>();
		CookingFries = new ArrayList<>();
		FinishedOrders = new ArrayList<>();
		UnFinishedOrders = new ArrayList<>();

	}

	/**
	 * Checks if the coals are ready at the specified time.
	 *
	 * @param t The time to check for coal readiness.
	 * @return True if the coals are ready, false otherwise.
	 */
	private boolean areCoalsReady(int t) {
		if (t >= timeCoals)
			return true;
		return false;

	}

	/**
	 * Calculates the remaining capacity of the grill.
	 *
	 * @return The remaining capacity of the grill.
	 */
	public static int CalculateCapacityGrill() {
		int currentCapacity = grillCap;
		for (int i = 0; i < CookingFood.size(); i++) {
			currentCapacity -= CookingFood.get(i).getCapacity();
		}

		return currentCapacity;

	}

	/**
	 * Calculates the remaining capacity of the pans.
	 *
	 * @return The remaining capacity of the pans.
	 */
	public static int CalculateCapacityPan() {
		int currentCapacity = NumOfPans * ServePerPans;
		for (int i = 0; i < CookingFries.size(); i++) {
			currentCapacity -= CookingFries.get(i).getCapacity();
		}

		return currentCapacity;

	}

	/**
	 * Gets the current simulation time.
	 *
	 * @return The current simulation time.
	 */
	public static int getTimeNow() {
		return t;
	}

	/**
	 * Simulates the kitchen operations.
	 */
	public void Simulation() {
		int finishedOrderCounter = 0;

		for (t = 1; t <= 360; t++) {

			boolean flag = false;

			for (int i = 0; i < OrdersOfTheDay.length; i++) {
				if (t == OrdersOfTheDay[i].getTimeOrder()) {
					WaitingOrders.add(OrdersOfTheDay[i]);

				}

			}

			if (areCoalsReady(t + 30)) {

				do {
					flag = false;


					if ((WaitingOrders.size() != 0)) {

						if (AlgorithType == 1)
							currentOrder = WaitingOrders.get(0);
						else if (AlgorithType == 2)
							currentOrder = Algorithm.Algorithm2(WaitingOrders);
						else
							currentOrder = Algorithm.Algorithm3(WaitingOrders);
						if (currentOrder.getCapacityGrill() > grillCap
								|| currentOrder.getCapacityPans() > NumOfPans * ServePerPans) {
							WaitingOrders.remove(OrdersOfTheDay[currentOrder.getOrderId() - 1]);
							flag = true;

						} else if (currentOrder.isAvailable()) {
							WaitingOrders.remove(OrdersOfTheDay[currentOrder.getOrderId() - 1]);

							CookingOrders.add(currentOrder);

							if (currentOrder.OrderHasPork())
								CookingFood.add(currentOrder.getPork());
							if (currentOrder.OrderHasChicken())
								CookingFood.add(currentOrder.getChicken());
							if (currentOrder.OrderHasSeftalia())
								CookingFood.add(currentOrder.getSeftalia());
							if (currentOrder.OrderHasMix())
								CookingFood.add(currentOrder.getMix());
							if (currentOrder.OrderHasPies())
								CookingFood.add(currentOrder.getPies());
							if (currentOrder.OrderHasFries())
								CookingFries.add(currentOrder.getFries());

							flag = true;
						}
					}

					if ((CookingOrders.size() != 0)) {

						for (int i = 0; i < CookingFood.size(); i++) {

							if (CookingFood.get(i).IsReady()) {

								CookingFood.remove(i);

								flag = true;
							}
						}
						for (int i = 0; i < CookingFries.size(); i++) {

							if (CookingFries.get(i).isReady()) {
								CookingFries.remove(i);

								flag = true;
							}
						}

						for (int i = 0; i < CookingOrders.size(); i++) {

							if (CookingOrders.get(i).isReady()) {
								timeReady[finishedOrderCounter] = t;
								FinishedOrders.add(OrdersOfTheDay[CookingOrders.get(i).getOrderId() - 1]);
								CookingOrders.remove(i);

								finishedOrderCounter++;

								flag = true;

							}
						}
					}

				} while (flag);
				for (int i = 0; i < CookingFood.size(); i++)
					CookingFood.get(i).ReduceTime();

				for (int i = 0; i < CookingFries.size(); i++)
					CookingFries.get(i).ReduceTime();

			}

		}
	}



	/**
	 * Retrieves the IDs of happy customers.
	 *
	 * @return The IDs of happy customers.
	 */
	public String HappyCustomers() {
		String str = "";
		for (int index = 0; index < FinishedOrders.size(); index++) {
			if ((timeReady[index] - FinishedOrders.get(index).getTimeReqDel()) > 0)
				str += FinishedOrders.get(index).getOrderId() + "\n";
				
		}
		return str;
	}

	/**
	 * Retrieves the IDs of unhappy customers.
	 *
	 * @return The IDs of unhappy customers.
	 */
	public String UnHappyCustomers() {
		String str = "";
		for (int index = 0; index < FinishedOrders.size(); index++)
			if ((timeReady[index] - FinishedOrders.get(index).getTimeReqDel()) < 0)
				str += FinishedOrders.get(index).getOrderId() + "\n";
		for (int index = 0; index < UnFinishedOrders.size(); index++)
			str += UnFinishedOrders.get(index).getOrderId() + "\n";

		return str;
	}

	/**
	 * Retrieves the time of delivery for the specified order index.
	 *
	 * @param index The index of the order.
	 * @return The time of delivery for the specified order.
	 */

	public int getTimeDel(int index) {
		return timeReady[index];
	}

	/**
	 * Retrieves the string representation of finished orders.
	 *
	 * @return The string representation of finished orders.
	 */
	public String toString() {
		String str = "";
		for (int index = 0; index < FinishedOrders.size(); index++)
			str += FinishedOrders.get(index).getOrderId() + " " + FinishedOrders.get(index).getTimeOrder() + " "
					+ timeReady[index] + " " + (timeReady[index] - FinishedOrders.get(index).getTimeReqDel()) + " "
					+ FinishedOrders.get(index).getPies() + " " + FinishedOrders.get(index).getFries() + "\n";

		return str;

	}
	
	/**
	 * Calculates the sum of the differences between the time each order was ready and the time it was required for delivery.
	 *
	 * @return The sum of the differences between the time each order was ready and the time it was required for delivery.
	 */
	public int getSumOfFinishedOrders() {
	    int sum = 0;

	    for (int index = 0; index < FinishedOrders.size(); index++) {
	        sum += (timeReady[index] - FinishedOrders.get(index).getTimeReqDel());
	    }

	    return sum;
	}
	
	public double getAmountOfHappyCustomers () {
		int pl=0;
		for (int index = 0; index < FinishedOrders.size(); index++) {
			if ((timeReady[index] - FinishedOrders.get(index).getTimeReqDel()) > 0)
				pl++;
		}
		return ((double)pl/FinishedOrders.size())*100;
	}

	/**
	 * Calculates the average deviation (apoklisi) of finished orders.
	 *
	 * @return The average deviation of finished orders.
	 */
	public double getApoklisi() {
	    // Ensure that division is done with double precision to avoid integer division
	    return (double) getSumOfFinishedOrders() / FinishedOrders.size();
	}

}
