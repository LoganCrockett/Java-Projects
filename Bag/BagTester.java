package project4;

/*
 * This class test the bag class, by adding items and outputting them
 * with their quantity as well.
 */

public class BagTester {

	public static void main(String args[]) {
		
		Bag b1 = new Bag();
		
		//Add items into the bag
		b1.add("candy");
		b1.add("apple");
		b1.add("pizza");
		b1.add("candy");
		b1.add("bread");
		b1.add("apple");
		b1.add("cola");
		b1.add("acai berry");
		b1.add("crab");

		
		System.out.println(b1.toString());//Prints the contents of the bag
		
	}
}
