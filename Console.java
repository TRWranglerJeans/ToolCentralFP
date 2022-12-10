package application;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 * This class reads from the files and communicates with the user by creating a menu.
 * @author Masrur Azmal
 *
 */
public class Console {

	@SuppressWarnings("resource")
	/**
	 * main function which controls the user input/output
	 * @param args reads from the command line
	 * @throws IOException
	 */
	public static void main(String [] args) throws IOException {
		ArrayList<Item> items = new ArrayList <Item>();
		ArrayList<Supplier> suppliers = new ArrayList <Supplier>();
		
		
		/**
		 * reading of the item and supplier text files
		 */
		Scanner scan;

		items.add(new Item(1,"tool", 50, 50, 1));
		items.add(new Item(2,"tool1", 50, 50, 2));
		items.add(new Item(3,"tool2", 50, 50, 3));
		items.add(new Item(4,"tool3", 50, 50, 4));
		items.add(new Item(5,"tool4", 50, 50, 5));

		suppliers.add(new Supplier(1, "Hello", "203 saa NE", "Bob"));
		suppliers.add(new Supplier(2, "hey", "203 saa NE", "Bob"));
		suppliers.add(new Supplier(3, "ewqw", "203 saa NE", "Bob"));
		suppliers.add(new Supplier(4, "bnee", "203 saa NE", "Bob"));
		suppliers.add(new Supplier(5, "jmnioe", "203 saa NE", "Bob"));
		suppliers.add(new Supplier(6, "iuesaf", "203 saa NE", "Bob"));

	
		/**
		 * Creation of the shop and menu options.
		 */
		Order order = new Order();
		Inventory inventory = new Inventory(items);
		Shop theShop = new Shop (inventory, suppliers, order);

		System.out.println("Please select from the menu given:\n"
				+ " 1. List all tools\n"
				+ " 2. Search for tool by name\n"
				+ " 3. Search for tool by ID\n"
				+ " 4. Check item quantity\n"
				+ " 5. Decrease Item quantity\n"
				+ " 6. Remove an item\n"
				+ " 7. Add an item\n"
				+ " 8. Quit\n");		
		
		
int quit=0;
while(true) {

	//theShop.checkQuantity();
	 scan = new Scanner(System.in);	
	int menu = scan.nextInt();	
	
	if (menu == 1) {
		inventory.listTools();
	}

	
	if (menu == 2) {
		System.out.println("Please enter tool name to search for:");
		 scan = new Scanner(System.in);
		 String name = scan.nextLine();
		System.out.println(theShop.search(name));	
	}		
		
		
	if (menu == 3) {
		System.out.println("Please enter tool ID to search for: ");
		 scan = new Scanner(System.in);
		 int id = scan.nextInt();
		 System.out.println(theShop.search(id));
	}
		
		
	if (menu == 4) {
		System.out.println("Quantity for each item is as given:");
		theShop.showQuantity();		
	}

		
	if (menu == 5) {
		do {
		System.out.println("Please enter item name for which to decrease quantity or type 'end' to exit:");
		 scan = new Scanner(System.in);
		 String itemQuantityName = scan.nextLine();
		 if(itemQuantityName.equals("end"))
			 break;
		 if(theShop.itemExist(itemQuantityName) == false) {
			 System.out.println("Item doesnt exist, please try again...");
			 break;
		 }
		 System.out.println("Please enter the amount to decrease by: ");
		 scan = new Scanner(System.in);
		 int quantity = scan.nextInt();
		 theShop.decreaseQuantity(itemQuantityName, quantity);
		} while (true);
		 
		System.out.println("Successfully left decreasing amount menu!");
	}
		
	if (menu == 6) {
		System.out.println("Please enter Name of tool to delete: ");
 		scan = new Scanner(System.in);
 		String itemName = scan.nextLine();
 		theShop.removeTool(itemName);		
	}
		
	if (menu == 7) {
		System.out.println("Please enter Name of tool to add:");
		scan = new Scanner(System.in);
		 String itemName = scan.nextLine();
		 System.out.println("Please enter ID of tool to add:");
		scan = new Scanner(System.in);
		int itemID = scan.nextInt();
		System.out.println("Please enter suppliers ID number(Must be between and including 01-20");
		scan = new Scanner(System.in);
		int suppID = scan.nextInt();
		theShop.addItem(itemName, itemID, suppID, 0, 0);		
	}
	if (menu == 8) {
		scan.close();
		quit=1;	
	}	
	
	if (quit==1) {
	
		break;
	}
	System.out.println("\nPlease select another Option");
	System.out.println();
}
	
	
}
}

