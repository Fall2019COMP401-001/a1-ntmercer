package a1;

import java.util.Scanner;

public class A1Novice
{
	public static void main(String[] args)
	{
		//Create our scanner and necessary outside variables:
		//An "output" string to keep track of what will be pushed to the console
		//and a variable to hold the number of customers the program will count
		Scanner input = new Scanner(System.in);
		String output = "";
		int numberOfCustomers;
		
		//Record total number of customers
		numberOfCustomers = input.nextInt();
		
		//This loop runs for each customer and records their shopping data.
		for(int x = 1; x <= numberOfCustomers; ++x)
		{
			//Necessary major variables for customer data:
			//Variables to hold name
			//Variable to hold number of items to be tracked
			//A variable to hold the total price of this customer's order (resets for each customer)
			String firstName, lastName;
			int numberOfItems;
			double totalPrice = 0;

			//Three readings from the console to determine first and last name as well as number of items
			firstName = input.next();
			lastName = input.next();
			numberOfItems = input.nextInt();
			
			//This loop runs for each item the customer is buying and records it price.
			for(int y = 1; y <= numberOfItems; ++y)
			{
				//Variables:
				//One to store name of item
				//One to store how many of that item is being purchased
				//One to store the price of ONE of that item
				String itemName;
				int quantityOfItem;
				double itemPrice;
				
				//Record the amount of item, name of item, and price of item bought.
				quantityOfItem = input.nextInt();
				itemName = input.next();
				itemPrice = input.nextDouble();
				
				//Accumulate the total price of the order by adding the price of each item after the loop.
				totalPrice += quantityOfItem * itemPrice;
			}
			
			//Add a line to the output for the current customer which includes all of their data.
			//Uses the charAt method to locate the first initial of the customer,
			//and uses the String.format method to configure the final prices.
			//This runs once for each customer.
			output += firstName.charAt(0) + ". " + lastName + ": " + String.format("%.2f", totalPrice) + "\n";
		}
		
		//Display the full output to the console, and close input scanner
		System.out.print(output);
		input.close();
	}
}
