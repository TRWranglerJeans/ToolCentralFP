package application;
/**
 * The supplier of an item(s), which contains all the information of the supplier and the items
 * the supplier provides
 * @author Masrur Azmal
 *
 */

import java.util.ArrayList;

public class Supplier {
	
	/**
	 * size of the array of items it has	
	 */
    private int size;
    
    /**
     * the items the supplier provides
     */
    private Item [] items;
    
    /**
     * ID of the supplier
     */
    private int id;
    
    /**
     * company name of the supplier
     */
    private String companyName;
    
    /**
     * Address of the supplier
     */  
    private String address;
    
    /** 
     * Sales contact of the supplier
     */   
    private String salesContact;

    /**
     * Constructer sets all the information of the supplier
     * @param id of the supplier
     * @param compName company name of the supplier
     * @param address address of the supplier
     * @param contact sales contact information of the supplier
     */
    public Supplier(int id, String compName, String address, String contact) {
    this.id=id;
    size=50;
    companyName=compName;
    this.address = address;
    salesContact=contact;
    items = new Item[size];
    }

    /**
     * sets the supplier with its items it provides
     * @param allItems list of all the items in the inventory
     */
    public void supplierItems(ArrayList <Item> allItems) {
	    int k=0;
	    for(int i=0; i<allItems.size(); i++) {
		    if (id == allItems.get(i).getSupplierID()) {
			    items[k]=allItems.get(i);
			    k++;
		    }
	    }		
    }
    
    /**
     * gets the id of the supplier
     * @return the id 
     */
    public int getID() {
	    return id;
    }
    
    /**
     * Gets the company name of the supplier
     * @return the company name
     */
    public String getName() {
	    return companyName;
    }

    /**
     * sets an item to its arraylIst
     * @param newItem the new item to be added
     */
    public void setItem(Item newItem) {
	    int i=0;
	    while(items[i]!= null) {
		    i++;
	    }
	    items[i] = newItem;
    }
}

