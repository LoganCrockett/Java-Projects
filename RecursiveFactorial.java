package project5;

/*
 * This program will calculate the factorial through the use of recursion
 * 
 * Created by: Logan Crockett
 * On:3/19/19
 * CPSC 1110
 */

public class RecursiveFactorial {
	
	public static int factorial(int n) {
		
		if (n == 0)//Returns one for the zero factorial
			return 1;
		else {
			//Calculates the factorial through recursion
			int result = n * factorial(n-1);
			return result;
		}
	}

	public static void main(String[] args) {
		
		//Create four variables to test
		int x = 6;
		int y = 7;
		int z = 4;
		int a = 0;
		
		//Calculate and output the factorials
		System.out.println(x + "! is " + factorial(x));
		System.out.println(y + "! is " + factorial(y));
		System.out.println(z + "! is " + factorial(z));
		System.out.println(a + "! is " + factorial(a));

	}

}
