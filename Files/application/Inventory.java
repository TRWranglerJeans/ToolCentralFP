package application;

/**
 *  The inventory of the shop which contains all the items in the shop
 * @author Masrur Azmal
 *
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
	
	/**
	 * list of all the items in the inventory
	 */
    private ArrayList <Item> myItems;
	
    /**
     * sets all the items in the inventory
     * @param itemList List of items which are in the inventory
     */
    Inventory(ArrayList<Item> itemList){
	    myItems=itemList;	
    }
    
    /** 
     * List of the quantity for all items in the shop
     */
    public void itemQuantity() {
	    for (int i=0; i<myItems.size(); i++) {
		    System.out.println(myItems.get(i).tool() + " Quantity: " + myItems.get(i).getQuantity());
	    }
    }

    /**
     * Searches for an item in the inventory given its name
     * @param name name of the item to search for
     * @return the item if it exists.
     */
    public Item searchItem(String name) {
	    for(Item placeholder : myItems){
		    if(placeholder.getName().equals(name)) {
			    return placeholder;
		    }
	    }
	
	    return null;
    }
    
    /**
     * Searches for an item in the inventory given its id
     * @return the item if it exists.
     * @param id id of the item to search for
     */
    public Item searchItem(int id) {
	    for(Item p : myItems){
		    if(p.getID() == id)
			    return p;
	    }
	
	    return null;
    }
    
    /**
     * list all the tools in the inventory
     */
    public void listTools() {
    	
	    for (int i=0; i<myItems.size(); i++) {
		    System.out.println(myItems.get(i).tool());
	    }
    }
    
    /**
     *  Checks if there is at least one item in the shop with a quantity less than 40
     * @return true if there is, else false
     */
    public boolean checkItems() {
	    for (int i=0; i<myItems.size(); i++) {
		    if (myItems.get(i).getQuantity()<40)
			    return true;
	    }
	    return false;
    }
    
    /**
     * gets all the items in the shop
     * @return the list of items
     */
    public ArrayList<Item> getItems(){
	    return myItems;
    }
    
    /**
     * Sets the items in the inventory with their respective supplier
     * @param supply list of all the suppliers
     */
    public void connect(ArrayList<Supplier> supply) {
	    for(int i=0; i<myItems.size(); i++) {
		    for(int j=0; j<supply.size(); j++) {
			    if(supply.get(j).getID() == myItems.get(i).getSupplierID())
				    myItems.get(i).setSupplier(supply.get(j));
		    }
	    }
    }
    
    /**
     * decrease the quantity of a specific item 
     * @param itemName the name of the item to decrease the quantity
     * @param decreaseAmount the number to decrease the items quantity by
     */
    public String decreaseQuantity(String itemName, int decreaseAmount) {
	    for(int i=0; i<myItems.size(); i++) {
		    if (itemName.equals(myItems.get(i).getName())) {
			    if(myItems.get(i).getQuantity()<decreaseAmount)
				    return "The amount to be decreased by is greater than the amount in stock";
			    else {
				    myItems.get(i).decreaseQuantityBy(decreaseAmount);
				    return "Decreasing Quantity succeeeded.";
			    }
			    }
	    }
	    return "Item not found.";
    }
    
    /**
     * removes a tool with given name
     * @param name of the item to be removed
     */
    public void removeItem(String name) {
	    for(int i=0; i< myItems.size(); i++){
		    if(myItems.get(i).getName().equals(name)) {
			    myItems.remove(i);
			    System.out.println("Tool successfully removed!");
			    return;
		    }
	    }
	    System.out.println("Tool to be deleted not found...");
    }
    
    /**
     * adds a new item and connects supplier to the item
     * @param name name of item
     * @param idNum id number of item
     * @param supply supplier of the item
     * @param supplierID ID of the supplier
     * @return returns the added item, or null if failed to add
     */
    public Item addItem(String name, int idNum, Supplier supply, int supplierID, int quantity, double price) {
	    for(int i=0; i<myItems.size(); i++) {
		    if (name.equals(myItems.get(i).getName())) {
			    System.out.println("Duplicate Item name");
			    return null;
		    }
		    if(idNum == myItems.get(i).getID()) {
			    System.out.println("Duplicate ID number");
			    return null;
		    }
	    }
	    int quant = quantity;
	    Item newItem = new Item(idNum, name, quant, price, supplierID);
	    newItem.setSupplier(supply);
	    myItems.add(newItem);
	    return newItem;
    }

}



