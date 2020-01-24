package moudle3;

/*
 * This class will test the methods of the subclass: BetterRectangle
 * after it has had the superclass modification to the constructor
 * 
 * Created by: Logan Crockett
 * On: 2/5/19
 * CPSC 1110
 */

public class BetterRectangleTester2 {

	public static void main(String args[]) {
		
		//Rectangle dimensions; used for a random assignment for testing
		int x = 3;
		int y = 5;
		int width = 2;
		int height = 4;
		
		//Output values before outputting test
		System.out.println(" Set value of x in rectangle: " + x);
		System.out.println(" Set value of y in rectangle: " + y);
		System.out.println(" Set value of width in rectangle: " + width);
		System.out.println(" Set value of height in rectangle: " + height);
		
		//Create an object of the BetterRectangle Class
		BetterRectangle r1 = new BetterRectangle(x,y,width,height);
		
		//Output the values of the rectangle
		System.out.println("Value of x from rectangle: " + r1.getX());
		System.out.println("Value of y from rectangle: " + r1.getY());
		System.out.println("Value of width from rectangle: " + r1.getWidth());
		System.out.println("Value of height from rectangle: " + r1.getHeight());
		
		
	}
	
}
