
/**
 * This class takes an odd integer input from the user, and constructs
 * "magic squares" based off of it.
 * For following the algorithim, the inputted number will be 'n'
 *
 * @author Logan Crockett
 * @version 1/15/19
 */

import java.util.Scanner;//For user input
import java.lang.Math;//For abs()

public class MagicSquares
{
    
    public static void main(String args[]) {
        
        int n = 0;//Inputted from user; must be odd
        Scanner in = new Scanner(System.in);
        
        while (n % 2 == 0) {//Asks for input until given an odd number
            System.out.print("Please enter an odd integer: ");
            n = in.nextInt();
        }
        
        n = Math.abs(n);//If input is negative, it will change to be positive
        
        int[][] squares = new int[n][n];//Constructs an array for the squares
        
        int row = n - 1;//Current row
        int column = n / 2;//Current Column
        int oldRow = 0;//Old value of Row
        int oldColumn = 0;//Old value of column
        
        //K will be used to fill the values of the square
        for (int k = 1; k <= (n*n); k++) {
            
            //Place k at [row][column]
            squares[row][column] = k;
            
            //Updates values for next iteration
            oldRow = row;
            oldColumn = column;
            row++;
            column++;
            
            //if the row or column is equal to n, change it to a zero
            if (row == n) {
                row = 0;
            }
            if (column == n) {
                column = 0;
            }
            
            /*If the element has already been filled in next location
             * change the row and column to the old value and decrement row
             */
            if (squares[row][column] != 0) {
                row = oldRow;
                column = oldColumn;
                row--;
            }
        }
        
        //Print the 'magic sqaure'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
                System.out.printf("%4d",squares[i][j]);
                
            }
            System.out.println();//For a new line
        }
    }
}
