# Restaurant simulator
Your restaurant simulator will work with a dataset of customers. Each row in this dataset represents a single dining party. Each dining party has five data values:

the name of the customer attempting to get a table for her/his dining party
the time the dining party arrives (0 is the start of the simulation, 1000 is latest possible arrival time)
the amount of time the dining party will take to finish their meal (between 10 and 60)
the size of the dining party (between 2 and 8)
the dining party's VIP level of priority (between 0 and 99, higher is more important)
The file is sorted by the arrival times.

You'll need to create a DiningParty class to manage information about each individual dining party in the simulation. 
You should also create a RestaurantSimulator class that manages the execution of the simulation itself. Since your restaurant has three tables (hey, I told you it was exclusive), your class should have 3 associated priority queue data structures. Table 1 has room for four, Table 2 has room for six, and Table 3 has room for eight.

Each priority queue stores the set of dining parties that are waiting for that table. Your simulation should use each dining party's priority to determine which dining party gets the table when it becomes free. Your simulation should also keep track of the total elapsed number of simulation timesteps and handle the processing of the data file to add new dining parties to the queues when appropriate.

The RestaurantSimulator should have a method that performs the main simulation. This will include a loop that executes once for each timestep in the simulation.
Once the loop finishes and the simulation is complete, then the RestaurantSimulator should report the average waiting time for all dining parties.

If you truly value your most important customers, then you could implement your simulator to remove lower priority dining parties in the middle of their meal when higher priority dining parties arrive. If you choose to implement the simulation this way, then be sure to consider the moral ramifications. 
