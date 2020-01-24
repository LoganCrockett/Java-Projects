package project6;

import java.util.ArrayList;

/*
 * This class uses the Sieve of Eratosthenes to find prime numbers.
 * It will put the numbers into an ArrayList to make it easier to sieve through the numbers
 * 
 * Created by: Logan Crockett
 * On: 4/2/19
 * CPSC1110
 */

public class Sieve {

	public static void main(String[] args) {
		
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		
		final int N = 100;//Used for the algorithm
		int limit = (int)Math.sqrt(N);//Number to go up to in algorithm
		
		//Use this loop to fill the list
		for (int i = 1; i <= N; i++) {
			l1.add(i);
		}
		
		//Use this loop for the sieve; Start at position 1 to test from '2' and upward
		int divisor = l1.get(1);
		//Goes up to the limit for the testing
		while (divisor <= limit) {
			
			//Start testing at position 2
			for (int i = 2; i < l1.size(); i++) {
				//If it is a factor, then it is not prime. Remove it
				//If it is equal to the divisor, then keep it. Mainly for the beginning of the test
				if (l1.get(i) % divisor == 0 && divisor != l1.get(i)) {
					l1.remove(i);
				}
				
			}
			divisor++;//Increment for next loop
			
		}
		//Print the remaining list of primes
		System.out.print("Primes up to " + N + ": ");
		System.out.println(l1.toString());

	}

}
