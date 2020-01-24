package moudle3;

import java.util.ArrayList;

/*
 * This class finds the resistance of a circuit that has resistors in series
 */

public class Serial extends Circuit {
	
	private ArrayList<Circuit> l1;

	//Constructor; Adds a circuit/resistor to the list for computation purposes
	public Serial () {
		
		l1 = new ArrayList<Circuit>();
		
	}
	
	//Adds a resistor or circuit in series
	public void addCircuit(Circuit c1) {
		
		l1.add(c1);
		
	}
	
	//Returns the value for the resistance in series
	//In series, it is R= r1 + r2 + ...
	public double returnResistance() {
		
		double sum = 0.0;
		for (int i = 0; i < l1.size(); i++) {
			
			sum = sum + l1.get(i).getResistance();
			
		}
		
		return sum;
	}
	
}
