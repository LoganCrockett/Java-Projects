package moudle3;

/*
 * This class will test the methods of the subclass: BetterRectangle
 * 
 * Created by: Logan Crockett
 * On: 2/5/19
 * CPSC 1110
 */

public class BetterRectangleTester {

	public static void main(String args[]) {
		
		//Rectangle dimensions; used for a random assignment for testing
		int x = 3;
		int y = 4;
		int width = 3;
		int height = 4;
		
		BetterRectangle r1 = new BetterRectangle(x,y,width,height);
		
		System.out.println("Perimeter of rectangle: " + r1.getPerimeter());
		System.out.println("Area of rectangle: " + r1.getArea());
	}
	
}
