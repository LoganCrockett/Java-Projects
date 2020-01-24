package moudle3;

/*
 * This class is supposed to be used to return the resistance of a circuit
 * 
 * Created by: Logan Crockett
 * ON: 2/5/19
 * CPSC 1110
 */

public class Circuit {
	
	private double Resistance;//Resistance for  resistor
	
	//Constructor; Sets the resistance for a resistor to a zero before calculation
	public Circuit() {
		
		Resistance = 0;
		
	}
	
	//Constructor that sets the value to a specific number
	public Circuit(double y) {
		Resistance = y;
	}
	
	public double getResistance() {
		return Resistance;
		
	}
	
}
