package moudle3;

/*
 * This class will become a subclass of the Rectangle class, by adding methods
 * that get the area and perimeter of the rectangle.
 * 
 * Created by: Logan Crockett
 * On: 2/5/19
 * CPSC 1110
 */

import java.awt.Rectangle;

public class BetterRectangle extends Rectangle {

	//Constructor; Uses methods from Rectangle class to set the rectangle
	public BetterRectangle(int startx, int starty, int rWidth, int rHeight) {
		
		//this.setLocation(startx, starty);
		//this.setSize(rWidth, rHeight);
		
		//Modification: Use the super Rectangle constructor
		super(startx, starty, rWidth, rHeight);
		
	}
	
	//Calculates the perimeter of the rectangle; Formula: P = 2*width + 2*height
	public double getPerimeter() {
		
		double perimeter = (2 * this.width)+ (2*this.height); 
		return perimeter;
	}
	
	//Calculates the area of the rectangle; Formula: A = width * height
	public double getArea() {
		
		double area = this.width * this.height;
		return area;
	}
	
}
