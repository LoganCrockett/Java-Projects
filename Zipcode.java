package Project2;

import java.util.Scanner;//For user input

public class Zipcode {

	//Instance variables
	private static int digit1;
	private static int digit2;
	private static int digit3;
	private static int digit4;
	private static int digit5;
	private static int checkDigit;
	
	/*
	 * Since this is a constructor, code will be added to go ahead and get the check digit
	 * as well.
	 */
	public static void getZipCode() {
		
		Scanner in = new Scanner(System.in);//For user input
		System.out.println("Please enter a zipcode: ");
		String code = in.next();
		
		
		digit1 = Integer.parseInt(code.substring(0, 1));
		digit2 = Integer.parseInt(code.substring(1, 2));
		digit3 = Integer.parseInt(code.substring(2, 3));
		digit4 = Integer.parseInt(code.substring(3, 4));
		digit5 = Integer.parseInt(code.substring(4, 5));
		
		/*
		 * This gets the value of the check digit.
		 * Since every zipcode plus the check digit is divisible by ten,
		 * this will subtract the difference between a counter variable and the sum
		 * until it is either less then ten, or is zero.
		 * It starts at 50, since the highest combination is 9 * 5 == 45
		 */
		int sum = digit1 + digit2 + digit3 + digit4 + digit5;
		for (int i = 50; i >= 0; i = i - 10) {
			checkDigit = i - sum;
			if (checkDigit < 10) {
				break;//If the difference is less than ten,then
				//the check digit has been found
			}
			
		}
		in.close();
	}
	
	public static void printZero() {
		
		//Prints the Number Zero in barcode format
		System.out.print("| | : : :");
	}
	
	public static void printOne() {
		
		//Prints the Number One in barcode format
		System.out.print(": : : | |");
	}
	
	public static void printTwo() {
		
		//Prints the Number Two in barcode format
		System.out.print(": : | : |");
	}
	
	public static void printThree() {
		
		//Prints the Number Three in barcode format
		System.out.print(": : | | :");
	}
	
	public static void printFour() {
		
		//Prints the Number Four in barcode format
		System.out.print(": | : : |");
	}
	
	public static void printFive() {
		
		//Prints the Number Five in barcode format
		System.out.print(": | : | :");
	}
	
	public static void printSix() {
		
		//Prints the Number Six in barcode format
		System.out.print(": | | : :");
	}
	
	public static void printSeven() {
		
		//Prints the Number Seven in barcode format
		System.out.print("| : : : |");
	}
	
	public static void printEight() {
		
		//Prints the Number Eight in barcode format
		System.out.print("| : : | :");
	}
	
	public static void printNine() {
		
		//Prints the Number Nine in barcode format
		System.out.print("| : | : :");
	}
	//Displays the zip code in barcode format
	//Each barcode starts and ends with a frame bar: '|'
	public static void displayZip() {
		
		System.out.print("|");
		
		switch (digit1) {
		case 1: Zipcode.printOne();break;
		case 2: Zipcode.printTwo();break;
		case 3: Zipcode.printThree();break;
		case 4: Zipcode.printFour();break;
		case 5: Zipcode.printFive();break;
		case 6: Zipcode.printSix();break;
		case 7: Zipcode.printSeven();break;
		case 8: Zipcode.printEight();break;
		case 9: Zipcode.printNine();break;
		default: Zipcode.printZero();break;
		}
		
		switch (digit2) {
		case 1: Zipcode.printOne();break;
		case 2: Zipcode.printTwo();break;
		case 3: Zipcode.printThree();break;
		case 4: Zipcode.printFour();break;
		case 5: Zipcode.printFive();break;
		case 6: Zipcode.printSix();break;
		case 7: Zipcode.printSeven();break;
		case 8: Zipcode.printEight();break;
		case 9: Zipcode.printNine();break;
		default: Zipcode.printZero();break;
		}
		
		switch (digit3) {
		case 1: Zipcode.printOne();break;
		case 2: Zipcode.printTwo();break;
		case 3: Zipcode.printThree();break;
		case 4: Zipcode.printFour();break;
		case 5: Zipcode.printFive();break;
		case 6: Zipcode.printSix();break;
		case 7: Zipcode.printSeven();break;
		case 8: Zipcode.printEight();break;
		case 9: Zipcode.printNine();break;
		default: Zipcode.printZero();break;
		}
		
		switch (digit4) {
		case 1: Zipcode.printOne();break;
		case 2: Zipcode.printTwo();break;
		case 3: Zipcode.printThree();break;
		case 4: Zipcode.printFour();break;
		case 5: Zipcode.printFive();break;
		case 6: Zipcode.printSix();break;
		case 7: Zipcode.printSeven();break;
		case 8: Zipcode.printEight();break;
		case 9: Zipcode.printNine();break;
		default: Zipcode.printZero();break;
		}
		
		switch (digit5) {
		case 1: Zipcode.printOne();break;
		case 2: Zipcode.printTwo();break;
		case 3: Zipcode.printThree();break;
		case 4: Zipcode.printFour();break;
		case 5: Zipcode.printFive();break;
		case 6: Zipcode.printSix();break;
		case 7: Zipcode.printSeven();break;
		case 8: Zipcode.printEight();break;
		case 9: Zipcode.printNine();break;
		default: Zipcode.printZero();break;
		}
		
		switch (checkDigit) {
		case 1: Zipcode.printOne();break;
		case 2: Zipcode.printTwo();break;
		case 3: Zipcode.printThree();break;
		case 4: Zipcode.printFour();break;
		case 5: Zipcode.printFive();break;
		case 6: Zipcode.printSix();break;
		case 7: Zipcode.printSeven();break;
		case 8: Zipcode.printEight();break;
		case 9: Zipcode.printNine();break;
		default: Zipcode.printZero();break;
		}
		
		System.out.print("|");
	}
	
	
	public static void main(String args[]) {
		
		Zipcode.getZipCode();
		Zipcode.displayZip();
		
	}
	
}

