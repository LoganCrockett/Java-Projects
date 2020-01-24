package project4;

import java.util.ArrayList;

/*
 * This class returns the resistance value from resistors in parallel
 * Uses getResistance() from Resistance interface
 */

public class Parallel  {
	
	private ArrayList<Resistor> l1;

	//Constructor
	public Parallel() {
		
		l1 = new ArrayList<Resistor>();
		
	}
	
	//Adds a circuit to the list
	public void addCircuit(Resistor c1) {
		l1.add(c1);
	}
	
	//Formula: R = 1/ 1/r1 + 1/r2 + ...
	public double returnResistance() {
		
		double sum = 0.0;
		for (int i = 0; i < l1.size(); i++) {
			
			sum = sum + (1/l1.get(i).getResistance());
			
		}
		
		sum = 1 / sum;
		return sum;
	}
	
}
