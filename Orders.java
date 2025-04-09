package hw4;

/**
 * Represents information about an order.
 */
public class Orders {
	// Attributes
	private int orderId; // Order ID
	private int timeOrder; // Time of order placement
	private int timeDelReq; // Time required for delivery
	private Pork porkOrder; // Pork food item in the order
	private Chicken chickenOrder; // Chicken food item in the order
	private Seftalia seftaliaOrder; // Seftalia food item in the order
	private Mix mixOrder; // Mix food item in the order
	private CookFries friesOrder; // Fries food item in the order
	private CookPies piesOrder; // Pies food item in the order

	/**
	 * Constructs an OrderInformation object with the given array of order details.
	 * 
	 * @param Orders An array containing information about the order.
	 */
	Orders(int Orders[], int SouvlakiLength, int SeftaliaLength, int PittaLength) {
		 orderId = Orders[0];
		 timeOrder = Orders[1];
		timeDelReq = Orders[2];
		int pork = Orders[3];
		int chicken = Orders[4];
		int seftalia = Orders[5];
		int mix = Orders[6];
		int fries = Orders[7];

		int randomNumber = (int) (Math.random() * 6);
		int TotalNumOfPittes = pork + chicken + seftalia + mix;
		if (pork != 0)
			porkOrder = new Pork(20 + randomNumber, SouvlakiLength, pork);
		else
			porkOrder = new Pork(-1, 0, 0);

		if (chicken != 0)
			chickenOrder = new Chicken(15 + randomNumber, SouvlakiLength, chicken);
		else
			chickenOrder = new Chicken(-1, 0, 0);

		if (seftalia != 0)
			seftaliaOrder = new Seftalia(25, SeftaliaLength, seftalia);
		else
			seftaliaOrder = new Seftalia(-1, 0, 0);

		if (mix != 0) {

			mixOrder = new Mix(25, SouvlakiLength, SeftaliaLength, mix);
		} else {

			mixOrder = new Mix(-1, 0, 0, 0);
		}
		if (fries != 0)
			friesOrder = new CookFries(20, fries);
		else
			friesOrder = new CookFries(-1, 0);

		if (TotalNumOfPittes != 0)
			piesOrder = new CookPies(5, PittaLength, TotalNumOfPittes);
		else
			piesOrder = new CookPies(-1, 0, 0);

	}

	/**
	 * Retrieves the pork food item in the order.
	 * 
	 * @return The pork food item.
	 */
	public Pork getPork() {
		return porkOrder;
	}

	/**
	 * Retrieves the Chicken food item in the order.
	 * 
	 * @return The Chicken food item.
	 */

	public Chicken getChicken() {
		return chickenOrder;
	}

	/**
	 * Retrieves the Seftalia food item in the order.
	 * 
	 * @return The Seftalia food item.
	 */

	public Seftalia getSeftalia() {
		return seftaliaOrder;
	}

	/**
	 * Retrieves the Mix food item in the order.
	 * 
	 * @return The Mix food item.
	 */

	public Mix getMix() {
		return mixOrder;
	}

	/**
	 * Retrieves the Pies food item in the order.
	 * 
	 * @return The Pies food item.
	 */

	public CookPies getPies() {
		return piesOrder;
	}

	/**
	 * Retrieves the fries food item in the order.
	 * 
	 * @return The fries food item.
	 */

	public CookFries getFries() {
		return friesOrder;
	}

	// Getter methods

	/**
	 * Retrieves the order ID.
	 * 
	 * @return The order ID.
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * Retrieves the time of order placement.
	 * 
	 * @return The time of order placement.
	 */
	public int getTimeOrder() {
		return timeOrder;
	}

	/**
	 * Retrieves the time required for delivery.
	 * 
	 * @return The time required for delivery.
	 */
	public int getTimeReqDel() {
		return timeDelReq;
	}

	/**
	 * Retrieves the total capacity required on the grill for the order.
	 * 
	 * @return The total grill capacity required.
	 */
	public int getCapacityGrill() {
		return porkOrder.getCapacity() + chickenOrder.getCapacity() + seftaliaOrder.getCapacity()
				+ mixOrder.getCapacity() + piesOrder.getCapacity();
	}

	/**
	 * Retrieves the total capacity required on the pans for the order.
	 * 
	 * @return The total pans capacity required.
	 */
	public int getCapacityPans() {
		return friesOrder.getCapacity();

	}

	/**
	 * Retrieves the maximum execution time required for the order.
	 * 
	 * @return The maximum execution time required.
	 */
	public int getExecTime() {
		// Calculation of maximum execution time
		int maxTime = 0;
		if (porkOrder.ExecTime() > maxTime)
			maxTime = porkOrder.ExecTime();
		if (chickenOrder.ExecTime() > maxTime)
			maxTime = chickenOrder.ExecTime();
		if (seftaliaOrder.ExecTime() > maxTime)
			maxTime = seftaliaOrder.ExecTime();
		if (mixOrder.ExecTime() > maxTime)
			maxTime = mixOrder.ExecTime();
		if (friesOrder.ExecTime() > maxTime)
			maxTime = friesOrder.ExecTime();
		if (piesOrder.ExecTime() > maxTime)
			maxTime = piesOrder.ExecTime();
		return maxTime;
	}

	/**
	 * Checks if the order contains pork.
	 * 
	 * @return True if the order contains pork, otherwise false.
	 */
	public boolean OrderHasPork() {
		return porkOrder.getCapacity() != 0;
	}

	/**
	 * Checks if the order contains chicken.
	 * 
	 * @return True if the order contains chicken, otherwise false.
	 */
	public boolean OrderHasChicken() {
		return chickenOrder.getCapacity() != 0;
	}

	/**
	 * Checks if the order contains seftalia.
	 * 
	 * @return True if the order contains seftalia, otherwise false.
	 */
	public boolean OrderHasSeftalia() {
		return seftaliaOrder.getCapacity() != 0;
	}

	/**
	 * Checks if the order contains a mix of meat.
	 * 
	 * @return True if the order contains a mix, otherwise false.
	 */
	public boolean OrderHasMix() {
		return mixOrder.getCapacity() != 0;
	}

	/**
	 * Checks if the order contains fries.
	 * 
	 * @return True if the order contains fries, otherwise false.
	 */
	public boolean OrderHasFries() {
		return friesOrder.getCapacity() != 0;

	}

	/**
	 * Checks if the order contains pies.
	 * 
	 * @return True if the order contains pies, otherwise false.
	 */
	public boolean OrderHasPies() {
		return piesOrder.getCapacity() != 0;

	}

	/**
	 * Checks if all food items in the order are available for cooking.
	 * 
	 * @return True if all food items are available, otherwise false.
	 */
	public boolean isAvailable() {
		return ((getCapacityGrill() < Kitchen.CalculateCapacityGrill()
				&& (getCapacityPans() < Kitchen.CalculateCapacityPan())));
	}

	/**
	 * Checks if all food items in the order are ready.
	 * 
	 * @return True if all food items are ready, otherwise false.
	 */
	public boolean isReady() {
		return porkOrder.IsReady() && chickenOrder.IsReady() && seftaliaOrder.IsReady() && mixOrder.IsReady()
				&& piesOrder.IsReady() && friesOrder.isReady();
	}

}