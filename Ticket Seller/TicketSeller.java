
/**
 * Using the methoeds from the TheaterSeater class, this class sells tickets
 * for seats in a theater.
 *
 * @author Logan Crockett
 * @version 11/27/18
 */

import java.util.Scanner;//For user input

public class TicketSeller
{
    
    public static void main(String args[]){
        
        final int COLUMNS = 10;//Number of columns for the ticket seating
        final int ROWS = 9;//Number of rows for the ticket seating
        Scanner in = new Scanner(System.in);//For user input
        
        boolean quit = false;//To be used to quit the program
        int selectChoice = 0;//Used to select the way the user wants to buy a seat
        
        //Array for the seating
        int[][] seatingChart = 
                       {
                        {10,10,10,10,10,10,10,10,10,10},
                        {10,10,10,10,10,10,10,10,10,10},
                        {10,10,10,10,10,10,10,10,10,10},
                        {10,10,20,20,20,20,20,20,10,10},
                        {10,10,20,20,20,20,20,20,10,10},
                        {10,10,20,20,20,20,20,20,10,10},
                        {20,20,30,30,40,40,30,30,20,20},
                        {20,30,30,40,50,50,40,30,30,20},
                        {30,40,50,50,50,50,50,50,40,30},
                    };
        //Creates an object of the TheaterSeater class
        TheaterSeater Chart1 = new TheaterSeater(seatingChart,COLUMNS,ROWS);
        
        while (quit == false) {
            
        Chart1.displaySeats();
        
        System.out.println("How would you like to purchase your ticket?");
        System.out.print("1 for seat; 2 for price, Q to quit: ");
        
        //Checks for non-integer input
        //If false, then it exits the loop.
        if (in.hasNextInt() == false) {
            quit = true;
            break;
        }
        selectChoice = in.nextInt();
        
        /*
         * There isn't a default, since logic has been added for
         * non-integer input above.
         */
        switch (selectChoice) {
            
            case 1:Chart1.sellSeat();break;
            case 2:Chart1.sellPrice();break;
            
            
        }
    }
        
    }
}
