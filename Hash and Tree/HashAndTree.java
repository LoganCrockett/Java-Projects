package project6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/*
 * This class inserts the .txt file of "War and Peace" into both a hash and tree set,
 * and times the results.
 * 
 * Created by: Logan Crockett
 * On: 4/2/19
 * CPSC1110
 */

public class HashAndTree {

	public static void main(String[] args) throws FileNotFoundException {
		
		Set<String> h = new HashSet<String>();//Create a hashset to put the words into
		Set<String> t = new TreeSet<String>();//Create a treeset to stick the words into
		
		//Create a file input
		Scanner in = new Scanner(new File("C:\\Users\\logan\\Desktop\\WarandPeace.txt"));
		
		//To be used for the time results respectively
		long time1 = 0;//Start time
		long time2 = 0;//End time
		long result1 = 0;//Time result one
		long result2 = 0;//Time result two

		//Add to the hashset and time the result
		time1 = System.nanoTime();
		while (in.hasNext()) {
			
			h.add(in.next());
		}
		time2 = System.nanoTime();
		in.close();
		result1 = time2-time1;//Gets the first time result
		
		//Reopen the file again to start at the beginning
		in = new Scanner(new File("C:\\Users\\logan\\Desktop\\WarandPeace.txt"));
		//Add to the treeset and time the result
		time1 = System.nanoTime();
		while (in.hasNext()) {
			t.add(in.next());
		}
		time2 = System.nanoTime();
		in.close();
		
		result2 = time2 - time1;//Gets the second time result
		
		//Gets the number of words that are in the file
		in = new Scanner(new File("C:\\Users\\logan\\Desktop\\WarandPeace.txt"));
		int numOfWords = 0;//Number of words in the file
		while (in.hasNext()) {
			numOfWords++;
			in.next();
		}
		in.close();
		
		File f1 = new File("C:\\Users\\logan\\Desktop\\WarandPeace.txt");//File to be used for the file size
		
		System.out.println("File size: " + f1.length() + " bytes.");
		System.out.println("Number of words in file: " + numOfWords);
		System.out.println("HashSet time: " + result1 + " nanoseconds.");
		System.out.println("TreeSet time: " + result2 + " nanoseconds.");
	}

}
