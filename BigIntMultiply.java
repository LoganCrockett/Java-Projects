
/**
 * This class reads two integers from a user, stores them as BigIntegers
 * and multiplies them.
 *
 * @author Logan Crockett
 * @version 1/8/19
 */

import java.math.BigInteger;
import java.util.Scanner;
import java.lang.String;

public class BigIntMultiply
{
    public static void main(String args[]) {
        
        //Sets up user input
        Scanner in = new Scanner(System.in);
        //Gets two BigIntegers, but as a string to begin with
        String string1;
        String string2;
        
        System.out.print("Enter two integers, separated by a space: ");
        
        string1 = in.next();
        string2 = in.next();
        
        BigInteger IntA = new BigInteger(string1);
        BigInteger IntB = new BigInteger(string2);
        
        //Multiplys them, and prints result
        BigInteger IntC = IntA.multiply(IntB);
        System.out.println("Multiplied together: " + IntC);
        
        
    }
}
