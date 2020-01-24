package project5;

/*
 * This program determines if a string is a palindrome.
 * Uses recursion to test for a palindrome
 */

public class Palindrome {
	
	public static boolean isPalindrome(String s) {
		
		//If it is of length 0 or 1, return true
		//Base case 1
		if (s.length() <= 1) 
			return true;
		//if the first and last characters don't match, return false
		//Base case 2
		if (s.charAt(0) != s.charAt(s.length() - 1)) {
			return false;
		}
		
		//Otherwise, remove the first and last letter, and check the next two
		return isPalindrome(s.substring(1,s.length() - 1));
		
	}

	public static void main(String[] args) {
		
		//Tests if a bunch of strings are palindromes, and outputs the result
		System.out.println("Is 'eve' a palindrome? " + isPalindrome("eve"));
		System.out.println("Is 'a' a palindrome? " + isPalindrome("a"));
		System.out.println("Is 'rotor' a plaindrome? " + isPalindrome("rotor"));
		System.out.println("Is 'motor' a palindrome? " + isPalindrome("motor"));
		System.out.println("Is '' a palindrome? " + isPalindrome(""));

	}

}
