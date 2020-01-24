package project4;

/*
 * This class uses the inner class, "Item," to store items into a bag, and count the number
 * of times the same item has been added.
 * Author: Logan Crockett
 * Created on: 2/26/19
 * CPSC 1110
 */

import java.util.ArrayList;

public class Bag {

	private ArrayList<Item> list;
	
	//Constructor. Uses the Item class for the list
	public Bag() {
		
		list = new ArrayList<Item>();
		
	}
	
	//Adds items to the bag, while checking for duplicates
	public void add(String name) {
		
		Item k = new Item(name);
		
		for (int i = 0; i < list.size(); i++) {
			
			//If there exists a duplicate, just add to the quantity
			if (name.equals(list.get(i).getItemName())) {
				list.get(i).addQuantity(1);
				return;
			}
			
		}
		//If a duplicate doesn't exist, then just add it to the list after sorting	
		list.add(k);
		}
		
	
	public int getCount(String name) {
		//Since duplicates are already sorted, it just finds and returns the quantity.
		//If there is no quantity, it just returns a zero
		
		int value = 0;
		for (int i = 0; i < list.size(); i++) {
			
			if (name.equals(list.get(i).getItemName())) {
				value = list.get(i).getQuantity();
				return value;
			}
			
		}
		//If not found, just return a zero
		return 0;
		
	}
	
	public void sort() {
		
		for (int i = 1; i < list.size(); i++) {
			
			String str1 = list.get(i-1).getItemName();
			String str2 = list.get(i).getItemName();
			
			if ((str1.compareTo(str2) > 0)) {
				list.add(i-1,list.get(i));
				list.remove(i+1);
				i=0;//Reset for sort process
				
			}
			}
		
	}

		
	//Prints a string representation of the list
	public String toString() {
		
		sort();//Sorts the list alphabetically
		
		//Prints the list
		for (int i = 0; i < list.size(); i++) {
			
			System.out.println(list.get(i).getItemName() + "/" + getCount(list.get(i).getItemName()));
			
		}
		return "";//Return nothing, since it will all be printed
	}
	
		
		class Item {
			
			private String itemName;//Name of the item
			private int quantity;//Number of times it is in the bag
			
			public Item(String name) {//Constructor
				
				itemName = name;
				quantity = 1;
				
			}
			//Gets the item name
			public String getItemName() {
				
				return itemName;
				
			}
			//gets the quantity
			public int getQuantity() {
				return quantity;
			}
			
			//Adds to the quantity of an item
			public void addQuantity(int x) {
				
				this.quantity = this.quantity + x;
				
			}
			
		}
		
}
