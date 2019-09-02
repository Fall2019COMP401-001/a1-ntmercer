package a1;

import java.util.Scanner;

public class A1Jedi
{
	public static void main(String[] args)
	{
		//Create our scanner and necessary outside variables:
		//A set of parallel arrays to keep track of each item, its price, how many people have bought it,
		//and how many have been bought
		//A variable to hold number of items in store (size of arrays)
		//Number of customers for the loop to cycle through
		Scanner input = new Scanner(System.in);
		String[] itemNames;
		double[] itemPrices;
		int[] amountOfBuyers, numBought;
		int numOfItemsInStore, numOfCustomers;
		
		//Record number of items in the store, and create arrays to hold data on each item
		numOfItemsInStore = input.nextInt();
		itemNames = new String[numOfItemsInStore];
		itemPrices = new double[numOfItemsInStore];
		amountOfBuyers = new int[numOfItemsInStore];
		numBought = new int[numOfItemsInStore];
		
		//Initialize the arrays with the name and price of each item, OR to 0 (for easy incrementing later on)
		for(int x = 0; x < numOfItemsInStore; ++x)
		{
			itemNames[x] = input.next();
			itemPrices[x] = input.nextDouble();
			amountOfBuyers[x] = 0;
			numBought[x] = 0;
		}
		
		//Record number of customers and use it to control how many times the main loop gets run.
		//This loop gathers data about customer purchases.
		numOfCustomers = input.nextInt();
		for(int y = 0; y < numOfCustomers; ++y)
		{
			//Necessary local variables:
			//Number of items bought (to collect data on)
			//Variables to hold name of customer
			int numItemsBought;
			String firstName, lastName;
			
			//Record name and number of items bought
			firstName = input.next();
			lastName = input.next();
			numItemsBought = input.nextInt();
			
			//This loop goes through each item to record its quantity, name, and price.
			for(int z = 0; z < numItemsBought; ++z)
			{
				//Variables:
				//Quantity of item purchased as well as the name of the item.
				int quantityOfItem;
				String nameOfItem;
				
				//Record data
				quantityOfItem = input.nextInt();
				nameOfItem = input.next();
				
				//This loop cross-references the named item with each value in the parallel arrays
				//so that the amount of buyers and the total amount bought can be updated
				for(int a = 0; a < numOfItemsInStore; ++a)
				{
					if(itemNames[a].equals(nameOfItem))
					{
						amountOfBuyers[a] += 1;
						numBought[a] += quantityOfItem;
					}
				}
			}
		}
		
		//Use a loop to output analysis of data to console (once for each item) and close input.
		for(int b = 0; b < numOfItemsInStore; ++b)
		{
			if(amountOfBuyers[b] == 0)
				System.out.println("No customers bought " + itemNames[b]);
			else
				System.out.println(amountOfBuyers[b] + " customers bought " + numBought[b] + " " + itemNames[b]);
		}
		input.close();
	}
}
