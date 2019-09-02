package a1;

import java.util.Scanner;

public class A1Adept
{
	public static void main(String[] args)
	{
		//Create our scanner and necessary outside variables:
		//A pair of parallel arrays to keep track of each item and its' price
		//A variable to hold number of items in store (size of arrays)
		//Number of customers for the loop to cycle through
		//Strings to hold data about the biggest and smallest customers, and a master string to be output
		//Variables to hold the average purchase and total amount of purchases
		//Variables to hold the current largest and smallest spenders' purchase amounts
		Scanner input = new Scanner(System.in);
		String[] itemNames;
		double[] itemPrices;
		int numOfItemsInStore, numOfCustomers;
		String biggestCustomer = "", smallestCustomer = "", output;
		double average, totalPurchases = 0, biggestNum = 0, smallestNum = -1;
		
		//Record number of items in the store, and create arrays to hold data on each item
		numOfItemsInStore = input.nextInt();
		itemNames = new String[numOfItemsInStore];
		itemPrices = new double[numOfItemsInStore];
		
		//Initialize the arrays with the name and price of each item
		for(int x = 0; x < numOfItemsInStore; ++x)
		{
			itemNames[x] = input.next();
			itemPrices[x] = input.nextDouble();
		}
		
		//Record number of customers and use it to control how many times the main loop gets run.
		//This loop gathers data about customer purchases.
		numOfCustomers = input.nextInt();
		for(int y = 0; y < numOfCustomers; ++y)
		{
			//Necessary local variables:
			//Total purchase and individual item price; these get reset after each purchase
			//Number of items bought (to collect data on)
			//Variables to hold name of customer
			double totalPrice = 0, itemPrice = 0;
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
				
				//This loop cross-references the named item with each item in the parallel array
				//to find the index of the item's price.
				for(int a = 0; a < numOfItemsInStore; ++a)
				{
					if(itemNames[a].equals(nameOfItem))
					{
						itemPrice = itemPrices[a];
						a = numOfItemsInStore;
					}
				}
				
				//Finally, add quantity with the item's price, and accumulate it onto the total order price.
				totalPrice += quantityOfItem * itemPrice;
			}
			
			//Add this customer's purchase to the total purchase price (among all customers)
			totalPurchases += totalPrice;
			
			//The first customer who is entered will have their purchase total be assigned to the smallest order amount.
			//After this, this "if" will be ignored.
			if(smallestNum == -1)
			{
				smallestNum = totalPrice;
				smallestCustomer = "Smallest: " + firstName + " " + lastName + " (" + String.format("%.2f", totalPrice) + ")";
			}
			
			//If this customer's order is the new smallest, their data will be written down.
			if(totalPrice < smallestNum)
			{
				smallestNum = totalPrice;
				smallestCustomer = "Smallest: " + firstName + " " + lastName + " (" + String.format("%.2f", totalPrice) + ")";
			}
			
			//If this customer's order is the new largest, their data will be written down.
			if(totalPrice > biggestNum)
			{
				biggestNum = totalPrice;
				biggestCustomer = "Biggest: " + firstName + " " + lastName + " (" + String.format("%.2f", totalPrice) + ")";
			}
		}
		
		//Compute average by taking total revenue over the amount of customers
		average = totalPurchases / numOfCustomers;
		
		//Add the output for the biggest and smallest customers together with the average data to compute final text output.
		output = biggestCustomer + "\n" + smallestCustomer + "\n" + "Average: " + String.format("%.2f", average);
		
		//Output analysis of data to console and close input.
		System.out.println(output);
		input.close();
	}
}
