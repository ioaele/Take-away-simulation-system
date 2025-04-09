package hw4;

/**
 * Represents a factory interface for managing PiesFactory & FriesFactory.
 */
public interface Factory {

	/**
	 * Adds a possibility with the given percentage and value to the factories.
	 * 
	 * @param percentage The percentage of the possibility.
	 * @param InOrder    The value associated with the possibility.
	 */
	public void addPosibility(double percentage, int InOrder,boolean ExactPercentages);

	/**
	 * Removes the possibility at the specified index from the factories.
	 * 
	 * @param index The index of the possibility to be removed.
	 */
	public void removeElement(int index);

	/**
	 * Retrieves the value of the possibility at the specified index from the
	 * factories.
	 * 
	 * @param index The index of the possibility.
	 * @return The value of the possibility.
	 */
	public int getElement(int index);

}
