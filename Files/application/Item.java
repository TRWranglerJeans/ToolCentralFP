package application;

/**
 * Contains all the items information such as item name, supplier, item ID and quantity. Includes functions to get and set
 * the items variable.
 * @author Masrur Azmal
 *@version 1.0
 *@since 11-24-22
 */

public class Item {
	
	/**
	 * Supplier of the item
	 */
    private Supplier supplier;
    
    /**
     * supplier ID number.
     */
    private int suppID;
    
    /**
     * Tools ID number
     */
    private int toolID;
    
    /**
     * Name of the tool
     */ 
    private String toolName;
    
    /**
     * Quantity of the item in stock
     */    
    private int quantity;
    
    /**
     * price of the item given in the text.
     */
    private double price;
    
	/**
	 * Constructor Sets the local variables of the Class item
	 * @param id  ID of the tool
	 * @param name	name of the tool
	 * @param quantity quantity in stock 
	 * @param price	price of tool
	 * @param suppID	Supplier ID
	 */
    public Item(int id, String name, int quantity, double price, int suppID) {
	    toolID=id;
	    toolName=name;
	    this.quantity= quantity;
	    this.price=price;
	    this.suppID = suppID;
	
    }
    
    /**
     * Returns the tool name and tool ID
     */
    public String tool() {
    	String statement = "Tool Name: " + toolName + "\n" + "Tool ID: " + toolID 
	    		 + "\n" + "Price: " + price + "\n";
	    return statement;
    }
    
    /**
     * Gets the tool name
     * @return the tool name
     */
    public String getName() {
	    return toolName;
    }

    /**
     * Gets the tool ID
     * @return the tools ID
     */
    public int getID() {
	    return toolID;
    }

    /**
     * Sets the quantity of tool in stock
     * @param quantitySlot the amount to set the quantity to
     */
    public void setQuantity(int quantitySlot) {
	    quantity=quantitySlot;
    }
    
    /**
     * Get the quantity of this tool.
     * @return the quantity of tool
     */
    public int getQuantity() {
	    return quantity;
    }
    
    /**
     * Gets supplier ID
     * @return suppliers ID
     */
    public int getSupplierID() {
	    return suppID;
    }
    
    /**
     * Creates the connection between the item and supplier, so item knows its supplier
     * @param supply	The supplier of the item.
     */
    public void setSupplier(Supplier supply) {
	    supplier = supply;
    }
    
    /**
     * Gets the suppliers company name
     * @return the suppliers company name
     */
    public String getSupplierName() {
	    return supplier.getName();
    }
    
    /**
     * Decreases the quantity of the item in stock
     * @param decreasedNum the number for which to decrease the amount by.
     */
    public void decreaseQuantityBy(int decreasedNum) {
	    quantity = quantity - decreasedNum;
    }
}



