package application;
/**
 * This class connects the controller with the rest of the logic of the application. 
 * The initial GUI is set, followed by the events upon pressing buttons.
 * @author Masrur Azmal
 */

import java.util.ArrayList;

public class Application {
	
	private Shop theShop;
	private Inventory inventory;
	private ArrayList<Item> items;
	
	public Application() {
		items = new ArrayList <Item>();
		ArrayList<Supplier> suppliers = new ArrayList <Supplier>();
		

		items.add(new Item(1,"tool", 50, 50, 1));
		items.add(new Item(2,"tool1", 50, 50, 2));
		items.add(new Item(3,"tool2", 50, 50, 3));
		items.add(new Item(4,"tool3", 50, 50, 4));
		items.add(new Item(5,"tool4", 50, 50, 5));

		suppliers.add(new Supplier(1, "Masrur", "University Drive NE", "masrur@gmail.com"));
		suppliers.add(new Supplier(2, "Bob", "205 Savannah Dr NE", "Bob@gmail.com"));
		suppliers.add(new Supplier(3, "Bill", "202 Park NE", "Bill@gmail.com"));
		suppliers.add(new Supplier(4, "Sarah", "305 Saddle Blvd NE", "s.a@gmail.com"));
		suppliers.add(new Supplier(5, "Elizabeth", "203 Queen's Way NE", "QE@gmaul.com"));
		suppliers.add(new Supplier(6, "Safwan", "209 Lane St NE", "Saf.wan@gmail.com"));

	
		/**
		 * Creation of the shop and menu options.
		 */
		Order order = new Order();
		inventory = new Inventory(items);
		theShop = new Shop (inventory, suppliers, order);
	}

	public void listAllTools() {
		inventory.listTools();
	}
	
	
	public String searchTool(String name) {
		String searchedItem = theShop.search(name);
		return searchedItem;
		
	}
	
	public String searchTool(int id) {
		String searchedItem = theShop.search(id);
		return searchedItem;
		
	}
	
	public ArrayList<Item> getTools() {
		return items;
	}
	
	public Shop getShop() {
		return theShop;
	}
	
	 public String decreaseQuantity(String itemName, int quantity) {

         if(theShop.itemExist(itemName) == false) {
             return "Item doesnt exist, please try again...";
         }
        String result = theShop.decreaseQuantity(itemName, quantity);
        return result;
         
    }
}
