package moudle3;

/*
 * This class just gives a resistor a resistance value, and can return that value
 */

public class Resistor extends Circuit {

	private double resistance;//Resistance for a resistor
	
	public Resistor(double x) {
		resistance = x;
		//super(x);// Added after fact to test superclass constructor
		
	}
	
	//Returns the resistance of the resistor
	public double getResistance() {
		
		return resistance;
		
	}
	
}
