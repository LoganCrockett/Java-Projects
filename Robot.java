package Project2;

/*
 * This will simulate a robot moving in a 2x2 plane, with (0,0)
 * being in the middle of the plane
 * Author: Logan Crockett
 * Created on: 1/30/19
 * CPSC1110
 */

import java.awt.Point;

public class Robot {

	private Point current;
	private int direction;//N=0;E=1;S=2;W=3
	//Constructor
	public Robot() {
		
		current = new Point();
		direction = 0;//For north
	}
	//Rotates the robot to the left in direction
	public void turnLeft() {
		
		//Changes direction by subtracting 1 from direction
		direction--;
		if (direction == -1)//If it becomes negative one, it changes to 3
			direction = 3;
	}
	//Rotates robot to the right in direction.
	public void turnRight() {
		
		//Changes direction by adding 1 to direction
		direction++;
		if (direction == 4)//If it becomes 4, it changes to 0
			direction = 0;
	}
	/*Moves robot one unit, which will be 1 in our case
	 * Will start at (0,0)
	 * Has logic so that it cannot go past the boundaries in the 2x2 square
	 */
	public void move() {
		
		final int UNIT = 1;//one unit
		double x = current.getX();//Current location
		double y = current.getY();//Current location
		
		switch (this.direction) {
		case 0://North
			y = y + UNIT;
			if (y > 1) {//If moving north would cause it to go off the plane
				System.out.println("Can't go that direction.");
			}
			else {//Otherwise, change the point to that location
				current.setLocation(x,y);
			}break;
		case 1://East
			x = x + UNIT;
			if (x > 1) {//If moving east would cause it to move off the plane
				System.out.println("Can't go that direction.");
			}
			else {//Otherwise, change the point to that location
				current.setLocation(x,y);
			}break;
		case 2://South
			y = y - UNIT;
			if (y < -1) {//If moving north would cause it to go off the plane
				System.out.println("Can't go that direction.");
			}
			else {//Otherwise, change the point to that location
				current.setLocation(x,y);
			}break;
		case 3://West
			x = x - UNIT;
			if (x < -1) {//If moving east would cause it to move off the plane
				System.out.println("Can't go that direction.");
			}
			else {//Otherwise, change the point to that location
				current.setLocation(x,y);
			}break;
		}
		
	}
	//Returns the current X Y coordinates
	public Point getLocation() {
		return current;
	}
	//Returns the direction
	public String getDirection() {
		/*
		 * Don't need a default for this switch, since logic has already been implemented
		 * for direction.
		 */
		String directionString = "";
		switch (this.direction) {
		
		case 0: directionString = "N";break;
		case 1: directionString = "E";break;
		case 2: directionString = "S";break;
		case 3: directionString = "W";break;
		
		}
		return directionString;
	}
	//Prints it out like a string in X Y D format
	public String toString() {
		return current.toString() + " " + this.getDirection();
		
	}
	
	public static void main(String args[]) {
		
		Robot r1 = new Robot();//Creates new object
		//Takes robot to northwest corner
		System.out.println(r1.getLocation() + " " + r1.getDirection());
		r1.move();
		r1.turnLeft();
		r1.move();
		System.out.println(r1.toString());
		//Takes robot to southwest corner
		r1.turnLeft();
		r1.move();
		r1.move();
		System.out.println(r1.toString());
		//Takes robot to southeast corner
		r1.turnLeft();
		r1.move();
		r1.move();
		System.out.println(r1.toString());
		//Takes robot to northeast corner
		r1.turnLeft();
		r1.move();
		r1.move();
		System.out.println(r1.toString());
		//Returns robot to (0,0) from northeast corner
		r1.turnRight();
		r1.turnRight();
		r1.move();
		r1.turnRight();
		r1.move();
		System.out.println(r1.toString());
		
	}
	
}
