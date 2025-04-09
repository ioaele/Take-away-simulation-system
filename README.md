EPL133 Assignment 4: Take-away Simulation System

**Authors:** Eleni Ioannou & Georgos Georgiadis 
**Last Updated:** 20/04/2024 

The Take-away Simulation System is designed to emulate the workflow of a take-away restaurant. 
It includes components for order generation, food preparation, and order delivery. 
The system models different food items such as fries, pies, and various meats, each with specific preparation processes.


**Features**

- Order Generation:
  Simulates incoming customer orders with varying items and quantities.

- Food Preparation:
  Models the cooking processes for different food items, including fries, pies, and meats like chicken, pork, and seftalia.

- Order Delivery:
  Manages the dispatch and delivery of prepared orders to customers.


**Output**
- Order Generator: The program creates a file named orders.txt as output.
Contents of orders.txt:
1. The total number of orders (e.g., 1000).
2. Each line represents one order, with the following structure: num torder tdelreq; npp npc nps npm npf
  num – Order number (e.g., 1, 2, 3...).
  torder – Time the order is placed (in simulation time).
  tdelreq – Requested delivery time (relative to order time).
  npp – Number of pork portions.
  npc – Number of chicken portions.
  nps – Number of seftalia portions.
  npm – Number of pies.
  npf – Number of fries.

- Order Delivery: The program creates a file named deliveries.txt as output.
Contents of deliveries.txt:
Each line represents one order, with the following structure: total orders, average deviation from requested time, number of happy customers

**Run**
- Order Generator: Generates orders, sorts them based on order time, and writes them to a file
The command line expects one argument:A single integer representing the number of orders you want to generate.
e.g java OrderGenerator 1000 for generating 1,000 orders.

- Order Delivery: Simulates the process of cooking and delivering orders based on resource constraints like grill space, fryer count, preparation times, and available space for items. It reads orders from a file and calculates:
  > The completion time for each order
  > The deviation from the requested delivery time
  > The number of satisfied customers (those whose orders were delivered on time or earlier)

The command line expects these arguments:
java OrderDelivery M T N C x y z which are

M – Capacity of the grill (in units of space).
T – Time to prepare the charcoal (i.e., warm-up time for grill).
N – Number of fryers available.
C – Capacity of each fryer (how many portions of fries it can handle at once).
x – Space required for one skewer (e.g., pork, chicken, seftalia).
y – Space required for one pie.
z – Time (or space depending on implementation) needed to prepare one pita.

The program reads orders from the file orders.txt that the program Order Generator created.
Each order has: num torder tdelreq; npp npc nps npm npf

**Further explanation**
What the Program Does Internally:
1. Reads each order, in the order of torder.
2. Schedules preparation of all items, considering:
3. Grill space and warm-up time (T)
4. Fryer availability and capacity (N, C)
5. Cooking space taken by skewers and pies (x, y)
6. Time/space for pita preparation (z)
7. Calculates the actual delivery time (tdel).
8. Compares it to the requested time (tdelreq).
9. Marks customers as happy if tdel <= tdelreq.



