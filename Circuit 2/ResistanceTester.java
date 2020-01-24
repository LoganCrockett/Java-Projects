package project4;

public class ResistanceTester {

	public static void main(String[] args) {
		
		//Declare resistors for testing
		Resistor r1 = new Resistor(3.2);
		Resistor r2 = new Resistor(4.6);
		
		//Output resistor values
		System.out.println("Resistor 1 value: " + r1.getResistance());
		System.out.println("Resistor 2 value: " + r2.getResistance());
		
		//Tests the Serial class by adding those resistors
		Serial s1 = new Serial();
		s1.addCircuit(r1);
		s1.addCircuit(r2);
		System.out.println("Series circuit resistance with those resistors: " + s1.returnResistance());
		
		//Tests the Parallel class by adding those resistors
		Parallel p1 = new Parallel();
		p1.addCircuit(r1);
		p1.addCircuit(r2);
		System.out.println("Parallel Circuit Resistance with those resitors: " + p1.returnResistance());
		
	}
	
}
