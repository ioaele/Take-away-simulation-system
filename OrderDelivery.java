package hw4;

import java.io.*;

/**
 * @authors Eleni Ioannou & George Georgiadis
 * @since 18/04/2024
 * @see Kitchen  
 * 
 * 
 * 
 * /** A class responsible for simulating order deliveries
 *      based on input data.
 */
public class OrderDelivery {

    /**
     * Main method to start the order delivery simulation.
     * @param args Command line arguments containing various parameters for the simulation.
     */
    public static void main(String[] args) {
        int grillCap = Integer.parseInt(args[0]);
        int timeCoals = Integer.parseInt(args[1]);
        int NumOfPans = Integer.parseInt(args[2]);
        int ServePerPan = Integer.parseInt(args[3]);
        int SouvlakiLength = Integer.parseInt(args[4]);
        int SeftaliaLength = Integer.parseInt(args[5]);
        int PittaLength = Integer.parseInt(args[6]);
        int AlgorithmType = Integer.parseInt(args[7]);

        String fileName = "orders1000.txt";
        Orders runOrder[] = null;

        try {
            // First pass: determine the length of the array
            FileInputStream fileStream = new FileInputStream(fileName);
            InputStreamReader input = new InputStreamReader(fileStream);
            BufferedReader reader = new BufferedReader(input);

            int OrdersLength = 0;
            while (reader.readLine() != null) {
                OrdersLength++;
            }

            // Close the reader
            reader.close();

            runOrder = new Orders[OrdersLength];
            // Second pass: read data from the file and populate the array
            fileStream = new FileInputStream(fileName);
            input = new InputStreamReader(fileStream);
            reader = new BufferedReader(input);

            int i = 0;
            String line;

            while ((line = reader.readLine()) != null) {
                int[] Orders = new int[8];
                String st = "";
                int j = 0;
                for (int k = 0; k < 8; k++) {
                    st = "";
                    while ((j < line.length()) && (line.charAt(j) != ' ')) {
                        st += line.charAt(j);
                        j++;
                    }
                    j++;

                    Orders[k] = Integer.parseInt(st);
                }
                runOrder[i] = new Orders(Orders,SouvlakiLength, SeftaliaLength, PittaLength);
                i++;
            }

            // Close the reader
            reader.close();

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }

        Kitchen kitchenDone = new Kitchen(runOrder, NumOfPans, ServePerPan, grillCap, timeCoals, AlgorithmType,
                SouvlakiLength, SeftaliaLength, PittaLength);

        kitchenDone.Simulation();
        try {
            File file = new File("deliveries.txt");
            FileOutputStream fos = new FileOutputStream(file);
            PrintStream ps = new PrintStream(fos);
            ps.print("FINISHED ORDERS:");
            ps.println();
            ps.print(kitchenDone);
            ps.println();
            ps.print("HAPPY CUSTOMER'S ID:");
            ps.println();
            ps.print(kitchenDone.HappyCustomers());
            ps.print("UNHAPPY CUSTOMER'S ID:");
            ps.println();
            ps.print(kitchenDone.UnHappyCustomers());
            ps.print("APOKLSISI");
            ps.println();
            ps.printf("%.2f",Math.abs(kitchenDone.getApoklisi()));
            ps.println();
            ps.print("PERCENTAGE OF HAPPY CUSTOMERS");
            ps.println();
            ps.printf("%.2f",kitchenDone.getAmountOfHappyCustomers());
            ps.print("%");
            ps.close();
            fos.close();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
