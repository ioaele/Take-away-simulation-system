package hw4;

/**
 * Represents a type of meat used in food items.
 */
public class Meat {
    // Attributes
    private int typeOfMeat[]; // Array to store the quantities of different types of meat

    /**
     * Constructs a Meat object with randomly assigned quantities of different types of meat.
     * @param numOfPies The number of meat pies.
     */
    Meat(int numOfPies) {
        // Initialization
        typeOfMeat = new int[4]; // 0: pork, 1: chicken, 2: seftalia, 3: mix
        int j = 0;
        
        // Assign random quantities of meat types to each pie
        for (int i = 0; i < numOfPies; i++) {
            int random2 = (int) (Math.random() * 100);

            if (random2 <= 25)
                j = 0; // pork
            else if (random2 <= 50)
                j = 1; // chicken
            else if (random2 <= 75)
                j = 2; // seftalia
            else if (random2 <= 100)
                j = 3; // mix

            typeOfMeat[j]++;
        }
    }

    // Getter method

    /**
     * Retrieves the quantity of a specific type of meat.
     * @param i The index representing the type of meat (0: pork, 1: chicken, 2: seftalia, 3: mix).
     * @return The quantity of the specified type of meat.
     */
    public int getTypeOfMeat(int i) {
        return typeOfMeat[i];
    }
}
