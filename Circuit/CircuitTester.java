package moudle3;

/*
 * This class tests the classes of the circuit class.
 * 
 * Created by: Logan Crockett
 * On: 2/5/19
 * CPSC 1110
 */

public class CircuitTester {

	public static void main(String args[]) {
		
		Resistor r1 = new Resistor(2.2);
		Resistor r2 = new Resistor(10.1);
		System.out.println("Resistor 1: " + r1.getResistance() + " ohms");
		System.out.println("Resistor 2: " + r2.getResistance() + " ohms");
		
		Serial s1 = new Serial();
		s1.addCircuit(r1);
		s1.addCircuit(r2);
		
		System.out.println("Series circuit of those two resistors: " + s1.returnResistance() + " ohms");
		
		Parrallel p1 = new Parrallel();
		p1.addCircuit(r1);
		p1.addCircuit(r2);
		
		System.out.println("Parallel circuit of those two resistors: "
				+ p1.returnResistance() + " ohms");
		//We will use this circuit as a series circuit that runs parrallel to the parrallel resistors
		Circuit sc1 = new Circuit(s1.returnResistance());
		//We will use circuit as a parallel circuit that runs in series with the parallel resistors
		Circuit pc1 = new Circuit(p1.returnResistance());
		
		p1.addCircuit(sc1);//Add the series circuit to calculation
		
		System.out.println("Parallel circuit that is parallel to series circuit: " 
		+ p1.returnResistance()  + " ohms");
		
		s1.addCircuit(pc1);//Add the parallel circuit to the calculation
			
		System.out.println("Series circuit that is in series to Parallel circuit: " 
				+ s1.returnResistance()  + " ohms");
		
	}
	
}
