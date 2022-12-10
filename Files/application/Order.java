package application;
/**
 * This class creates a text file with all the information about all the items which had a quantity less than 40
 * @author Masrur Azmal
 */

import java.util.ArrayList;
import java.io.*;

public class Order {
	
	private ArrayList<Item> orderList;
    /**
     * constructor only creates an object of orderLine.
     */
	
    public Order() {
    orderList = new ArrayList<Item>();
    }
    
    
/**
 * Creates multiple order lines which contain items with quantities less than 40
 * @param items a list of all the items in the inventory
 */
public void makeOrderLines(ArrayList <Item> items){
    for(int i=0; i< items.size(); i++) {
            orderList.add(items.get(i));
    }
    orderList.clear();
}
    }
    


