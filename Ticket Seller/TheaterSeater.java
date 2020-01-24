
/**
 * This class is designed to sell seats for a theater.
 * In order to avoid confusion, when the user enters the number for a seat,
 * it will be decreased by one to accomdate the array, and then reset if outputted.
 *
 * @author Logan Crockett
 * @version 11/27/18
 */

import java.util.Scanner;//For user input
import java.lang.String;

public class TheaterSeater
{
    private int[][] seats;//Array for the seats in the theater
    private int rows;//Number of rows
    private int columns;//Number of columns
    private Scanner in = new Scanner(System.in);//For user input
    
    /**
     * Initializes the array
     * @param someArray seating chart for the theater
     */
    public TheaterSeater(int[][] someArray,int columnNum, int rowNum) {
        seats = someArray;
        rows = rowNum;
        columns = columnNum;
    }
    
    /**
     * Displays the seating chart.
     */
    public void displaySeats() {
        
        System.out.print("  ");//For formatting
        //This outputs the table header
        for (int k = 1; k <= columns; k++) {
            System.out.print("(" + k + ") ");
            
        }
        System.out.println();
        //This outputs the seating chart
        for (int i = 0; i < rows; i++) {
            i++;//Adds one to correctly format table
            System.out.print(i + ")");//For formatting
            i--;//Resets the format correctly after output
            for (int j = 0; j < columns; j++) {
                System.out.printf("%3d",seats[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    
    /**
     * This sells tickets by seat. It also checks for:
     * Out-of-bounds on the array
     * Prevents duplicate transactions
     * 
     */
    public void sellSeat() {
        
        int row = 0;//Row to be sold
        int column = 0;//Column of seat to be sold
        boolean tryAgain = true;//If the user wants to attempt to buy a different seat
        
        while (tryAgain == true) {
         tryAgain = false;//Re-initialize the variable
        System.out.print("Enter the row and column of the seat, separated by a space: ");
        //Subtracts one for use in the array
        row = in.nextInt() - 1;
        column = in.nextInt() - 1;
        
        //If the number entered is greater than the value of the table
        if (row >= rows || column >= columns) {
            System.out.print("Invalid input.\n");
            return;
        }
        //If the seat has already been sold
        if (seats[row][column] == 0) {
            String choice;
            System.out.print("Seat has already been sold.");
            System.out.print("Do you want to try another seat? Y/N: ");
            choice = in.next();
            choice = choice.toUpperCase();
            
            if (choice.equals('N')) {
                return;
            }
            else
                tryAgain = true;
        }
        else {//Else, sell it
        seats[row][column] = 0;
        System.out.print("Seat has been purchased.\n");
      }
    }
 }
 
 
 /**
  * This method sells seats by price. It asks the user for a price,
  * then checks the array from the furtherest row back to 0 for a seat.
  */
 public void sellPrice() {
     
     int priceOfSeat = 0;//Price of the seat the user wants
     String choice;//To be used for a yes or no question
     
     System.out.print("Enter the price of the seat you would like: ");
     priceOfSeat = in.nextInt();
     
     /*
      * Finds the seat closest to the stage with that price, 
      * if there is one.
      */
     for (int i = rows - 1; i >= 0; i--) {//For the rows
        
        for (int j = 0; j < columns; j++) {
        
            int currentSeatPrice = seats[i][j];
            
            if (currentSeatPrice == priceOfSeat) {
            i++;//For correct output
            j++;//For correct output
            
            System.out.print("There is a seat at ");
            System.out.println("row " + i + ", seat " + j);
            System.out.print("Do you want to purchase this seat? Y/N?");
            choice = in.next();
            choice = choice.toUpperCase();
            
            i--;//Reset for logic
            j--;//Reset for logic
            
            //If they want the seat, then buy it
            if (choice.equals("Y")) {
                
                seats[i][j] = 0;//Purchase seat
                System.out.println("Seat has been purchased.");
                return;
                
             }
                
            }
            
        
        }
         
        }
        
        System.out.println("There are no seats avaliable with that price.");
    }
}
