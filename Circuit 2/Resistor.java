package project4;

/*
 * This class just gives a resistor a resistance value, and can return that value.
 * Copy of the Resitor.java class from Project3, but with modifications.
 * Uses the Resistance Interface
 */

public class Resistor implements Resistance {

	private double resistance;//Resistance for a resistor
	
	public Resistor(double x) {
		resistance = x;
		
	}
	
	public double getResistance() {//From the Resistance interface
		
		return resistance;
		
	}
	
}
