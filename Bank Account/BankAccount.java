
/**
 * A bank account has a balance that is modified through
 * withdrawals and deposits.
 *
 * @author Logan Crockett
 * @original version 9/20/18
 * @modified 10/4/18
 */
public class BankAccount
{
    private double balance;
    
    /**
     * Constructs a bank account with a zero balance.
     */
    public BankAccount() {
        balance = 0;
    }
    
    /**
     * Constructs a bank account with an initial balance.
     * @param initialBalance the initial balance
     */
    public BankAccount(double initialBalance) {
        
    balance = initialBalance;
    
    }
    
    /**
     * Deposits money into the bank account
     * @param amount the amount given to be deposited
     */
    public void deposit(double amount) {
    
        balance = balance + amount;
        
    }
    
    /**
     * Withdraws money from the bank account
     * @param amount the amount given to be withdrawn
     */
    public void withdraw(double amount) {
    
        balance = balance - amount;
        
    }
    
    /**
     * Returns the current balance of the account
     * @return the current balance
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * Calculates the interest on the current balance, and adds it to it
     * @param rate the interest rate
     */
    public void addInterest(double rate) {
    
        balance = balance + (balance * rate);
    
    }
}
