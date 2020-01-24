package Project2;

import java.util.Scanner;

public class Fraction {

	private int numerator;
	private int denominator;
	
	//Returns the fraction as a string
	public String toString() {
		
		return numerator + "/" + denominator;
	}
	//Constructor
	public Fraction() {//Sets the value to a default value of 0/1
		numerator = 0;
		denominator = 1;
	}
	
	//Constructor thats sets the values of numerator & denominator to given values
	public Fraction (int num, int denom) {
		
		numerator = num;//Sets numerator to a given value
		denominator = denom;//Sets denominator to a given value
		
	}
	
	/*
	 * Constructor
	 * Sets the values to values from another abject of the Fraction class
	 */
	public Fraction (Fraction toCopy) {
		
		this.numerator = toCopy.numerator;
		this.denominator = toCopy.denominator;
		
	}
	
	//Returns the Numerator
	public int getNumerator() {
		return numerator;
	}
	
	//Returns the denominator
	public int getDenominator() {
		return denominator;
	}
	
	//Sets the fraction to a new value
	public Fraction set(int num, int denom) {
		
		numerator = num;
		denominator = denom;
		return this;
		
	}
	
	//Adds two fractions together; If the denominators are different,
	//then it changes them to a multiple to be added
	public Fraction add(Fraction f) {
		
		if (this.denominator != f.denominator) {
			//Multiplies each fraction by the others denominator if they aren't equal
			//numerators
			this.numerator = this.numerator * f.denominator;
			f.numerator = f.numerator * this.denominator;
			this.numerator = this.numerator + f.numerator;
			//Denominator
			int tempDenom = f.denominator;//Stores the value of the denominator so it will multiply right
			f.denominator = f.denominator * this.denominator;
			this.denominator = this.denominator * tempDenom;
			
			
		}
		
		else {//If they are equal, then just simply add them
			
			this.numerator = this.numerator + f.numerator;
			
		}
		
		return this;
	}
	
	//Multiplies two fractions together
	public Fraction multiply(Fraction a) {
		
		this.numerator = this.numerator * a.numerator;
		this.denominator = this.denominator * a.denominator;
		
		return this;
	}
	
	//Checks if two objects are equal
	//In this case, it will be two fractions
	public boolean equals (Object o) {
		
		//Creates a fraction object equal to 'o' so it can be tested
			Fraction a = (Fraction) o;
			if (this.numerator == a.numerator && this.denominator == a.denominator)
				return true;
		
		else {
			return false;
		}
		
	}
	
	//Reduces a fraction
	public Fraction reduce() {
		
		//Uses divisibility rules to simplify
		int simplify = 10;//Digit to simply with
		while (simplify > 1) {
			
			if (this.numerator % simplify == 0 && this.denominator % simplify == 0) {
				//If they both simplify, then reduce them
				this.numerator = this.numerator / simplify;
				this.denominator = this.denominator / simplify;
				return this;
			}
			else 
				simplify--;
			
		}
		//If it is not able to be simplified, then just return original fraction
		return this;
	}
	
	/*
	 * Will compare two objects of the Fraction class
	 * Returns:
	 * -1 if less than
	 * 0 if equal
	 * 1 if greater than
	 */
	public int compareTo(Fraction a) {
		
		if (this.numerator == a.numerator && this.denominator == a.denominator)
			return 0;//They are equal in this case
		else if (this.numerator < a.numerator || this.denominator < a.denominator)
			return -1;//Less than in this case
		else
			return 1;//If the other two are false, then it is greater than
		
	}
	
	public static Fraction parse(String input) {
		
		Scanner s = new Scanner(input).useDelimiter("[\\/\\t\\n]");
		int num = s.nextInt();
		int denom = s.nextInt();
		s.close();
		return new Fraction(num,denom);
		
	}
	
	
	//Tests the methods in the Fraction class
	public static void main(String args[]) throws java.lang.Exception {
		
	/*	Fraction g = new Fraction();
		System.out.println("Fraction g: " + g);//Prints the fraction
		*/
		int userNum = 2;//Numerator given by user
		int userDenom = 3;//Denominator given by user
		Fraction h = new Fraction(userNum, userDenom);//Creates a new object of the Fraction class
	//	System.out.println("Fraction h: " + h);//Prints the fraction
		
		Fraction i = new Fraction(h);//Creates a new fraction equal to another fraction
		//System.out.println("Fraction i: " + i);//Prints the fraction
	
		//Tests the getter and setter methods, and prints result
	//	System.out.println("Fraction h numerator: " + h.getNumerator());//Accessor
		//System.out.println("Fraction h denominator: " + h.getDenominator());//Accessor
		userNum = 4;//New value for a different test
		userDenom = 5;//New value for a different test
		h.set(userNum, userDenom);
	/*	System.out.println("Fraction h's new numerator: " + userNum);
		System.out.println("Fraction h's new denominator: " + userDenom);
		System.out.println("Fraction h's new value: " + h.toString());//Prints the new fraction
		*/
		//Adds two fractions, then multiplies them
		Fraction x = new Fraction(1,2);//For test of multiplication
		System.out.println("Fraction h: " + h.toString());
		System.out.println("Fraction i: " + i.toString());
		System.out.println("Fraction x: " + x.toString());
		System.out.println("H + I * X: " + h.add(i).multiply(x).reduce()); 
		
	/*	//Tests for equality between two fractions
		System.out.println("Fraction h = fraction i: " + h.equals(i));
		userNum = 4;//New value for a different test
		userDenom = 5;//New value for a different test
		h.set(userNum, userDenom);
		System.out.println("h's new value: " + h.toString());
		System.out.println("Fraction h = fraction i: " + h.equals(i));
		
		//Tests for comparison between fractions
		System.out.println("Fraction h greater than i: " + h.compareTo(i));
		i = new Fraction(h);//Changes 'i' for next comparison
		System.out.println("Fraction h equal to i: " + h.compareTo(i));
		h.set(2, 3);//Changes value of h for next comparison
		System.out.println("Fraction h less than i: " + h.compareTo(i));
		*/
		
	/*	//Tests the parse method
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter a fraction: ");
		Fraction x = Fraction.parse(in.next());
		System.out.println("Fraction x: " + x.toString());
		
		System.out.print("Please enter a fraction: ");
		Fraction y = Fraction.parse(in.next());
		System.out.println("Fraction y: " + y.toString());
		
		System.out.print("Please enter a fraction: ");
		Fraction z = Fraction.parse(in.next());
		System.out.println("Fraction z: " + z.toString());
		in.close();
		*/
	}
}