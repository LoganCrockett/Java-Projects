package moudle3;

import java.util.ArrayList;

/*
 * This class returns the resistance value from resistors in parallel
 */

public class Parrallel extends Circuit {
	
	private ArrayList<Circuit> l1;

	//Constructor
	public Parrallel() {
		
		l1 = new ArrayList<Circuit>();
		
	}
	
	//Adds a circuit to the list
	public void addCircuit(Circuit c1) {
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
