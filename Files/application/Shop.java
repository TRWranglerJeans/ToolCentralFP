package application;
/**
 * The class controls the connection between all other classes, and is the main class which calls several
 * methods of other classes for several connections.
 * @author Masrur Azmal
 * @version 1.0 
 * @since 11-24-22
 */

import java.util.ArrayList;

public class Shop {
	
    /**
     * Order which is placed when a quantity of an item goes below 40
     */
    private Order myOrder; 

    /**
     * List of suppliers for the items in the shop's inventory.
     */
    private	ArrayList <Supplier> supplier;

    /**
     * Contains all the items/tools
     */
    private	Inventory inventory;

	/**
	 * The constructor sets the inventory, suppliers, and connects the suppliers and items with each other
	 * as well as holds an order in case it needs to use it.
	 * @param inventory the inventory of the shop
	 * @param supp all the suppliers of the shop
	 * @param theOrder the order
	 */
    public Shop(Inventory inventory, ArrayList<Supplier> supply, Order theOrder) {
	    this.inventory = inventory;
	    supplier = supply;	
	    myOrder=theOrder;
	    connectSupplierItems(inventory.getItems());
	    connectItemsSuppliers();
        }
    
    /**
     * shows the quantity of all items.
     */
    public void showQuantity() {
	    inventory.itemQuantity();
    }
    
    /**
    * checks the quantity for all items	
    */

    public void checkQuantity() {
	    if(inventory.checkItems()) {
		    createOrder(inventory.getItems());
	    }
    }

    
    /** 
    * creates an order for the items 	
    * @param lowQuantity list of items.
    */

    public void createOrder(ArrayList <Item> lowQuantity) {
	    myOrder.makeOrderLines(lowQuantity);
    }

    
    /**
     * connects the suppliers with their respective items in the item list
     * @param allItems all the items in the inventory.
     */
    public void connectSupplierItems(ArrayList <Item> allItems) {
	    for(int i=0; i<supplier.size(); i++) {
		    supplier.get(i).supplierItems(allItems);
	    }
    }
    
    /**
     * connects the items with their respective supplier
     */
    
    public void connectItemsSuppliers() {
	    inventory.connect(supplier);
    }
    
    /**
     * Search for an tool given its tool name
     * @param search	name of the tool
     * @return The tool name if the tool was found or not
     */
    
    public String search(String search) {
    System.out.println("Searching...");
	Item result = inventory.searchItem(search);
	if(result == null)
		return ("The item with the given name does not exist");
	String itemFound = ("Item exists in Shop: " + result.tool());
	return itemFound;
}
    /**
     * Search for an tool given its tool id
     * @param id id number of the too.
     * @return the tool name if the tool was found or not
     */
    public String search(int id) {
	    Item result = inventory.searchItem(id);
	    if(result==null) {
		    return ("The item with the given id does not exist");
	    }
	    return ("Item exists in Shop: " + result.tool());
    }

    /**
     * CHecks if an items exists or not in the inventory.
     * @param name name of the tool
     * @return true if the item exists, otherwise returns false.
     */
    public boolean itemExist(String name) {
	    Item result = inventory.searchItem(name);
	    if (result == null)
		    return false;
	    return true;
    }
    
    /**
     * calls the inventory to decrease the quantity of an item by a specific amount
     * @param itemName the tools name which to decrease.
     * @param decreaseAmount the amount to decrease by
     */
    public String decreaseQuantity(String itemName, int decreaseAmount) {
	    return inventory.decreaseQuantity(itemName, decreaseAmount);
    }
    /**
     * Removes the tool with given name	
     * @param name of the tool to be removed
     */
    public void removeTool(String name) {
	    inventory.removeItem(name);
    }

    /**
     * Checks if it can create a new item or not, if it can, adds the item	
     * @param name name of the new item
     * @param id id of the new item
     * @param suppID supplier ID of the new ID
     */
    public void addItem(String name, int id, int suppID, int quantity, double price) {
    	System.out.println("Trying to add item");
    	System.out.println(suppID);

        for(int i=0; i<supplier.size(); i++) {
        	System.out.println(supplier.get(i).getID());
	        if(suppID ==  supplier.get(i).getID()) {
	        Item newItem = inventory.addItem(name, id, supplier.get(i), suppID, quantity, price);
	    	System.out.println(newItem);
	            if (newItem == null) {
		            return;
	            }
	        supplier.get(i).setItem(newItem);
	        System.out.println("Successfully added!");
	        
	        return;
	        }	
        }
    }
}


