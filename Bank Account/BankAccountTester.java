
/**
 * This class tests the BankAccount class, hence the name.
 *
 * @author Logan Crockett
 * @original version (9/20/18)
 * @modified 10/4/18
 * Gets the inintial input from user
 */

import java.util.Scanner;//For user input

public class BankAccountTester
{
    
    /**
     * Tests the methods of the BankAccount class.
     * @param args not used
     */
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in); //For System input
        
        double initialBalance = 0.0; //Initial balance; to be supplied by user
        
        System.out.print("Please enter the balance for the first account: ");
        initialBalance = in.nextDouble();
        
        //Starts with a balance given by the user
        BankAccount harrysChecking = new BankAccount(initialBalance);
        System.out.print("Harry's Checking: ");
        System.out.println(harrysChecking.getBalance());
        System.out.println();
        
        System.out.print("Please enter the balance for the Second account: ");
        initialBalance = in.nextDouble();
        
        //Starts with a balance given by the user
        BankAccount logansChecking = new BankAccount(initialBalance);
        System.out.print("Logan's Checking: ");
        System.out.println(logansChecking.getBalance());
        System.out.println();
        
        System.out.print("Please enter the balance for the third account: ");
        initialBalance = in.nextDouble();
        
        //Starts with a balance given by the user
        BankAccount tylersChecking = new BankAccount(initialBalance);
        System.out.print("Tyler's Checking: ");
        System.out.println(tylersChecking.getBalance());
        System.out.println();
        
    }
}
