package project5;

/*
 * This program takes command-line input, and outputs the number input,
 * along with a double or int classification next to it.
 */

public class ComandArgs {

	public static void main(String[] args) {
		
		//Goes through and outputs the input form command line
		for (int i = 0; i < args.length; i++) {
			
			System.out.print(args[i]);//Prints the number
			
			double number = Double.parseDouble(args[i]);//Converts to a decimal
			
			//If it is an integer
			if (Math.floor(number) == number) {
				System.out.println(" Int");
			}
			else {//If not
				System.out.println(" Double");
			}
			
		}
		
	}
	
}
