
/*
 * Created by:
 * On:1/13/20
 * CPSC 3200
 * 
 * Purpose: To test the methods of SinglyLinkedList.java
 */

public class SinglyLinkedListTester {
	
	/**
	 * Tests the penultimate() method
	 */
	public static void penultimateTest() {

		//Create a Singly Linked List
		SinglyLinkedList<String> L = new SinglyLinkedList<String>();
		/*
		* Tests the penultimate method
		* Should throw an exception if list size is less than 2
		 */
		//Add One element
		L.addFirst("First");
				
		//Should throw an IllegalStateException
		try {
		System.out.println(L.penultimate());
		} catch (Exception IllegalStateException) {
			System.out.println("Illegal State Exception Thrown.");
		}
				
		//Add an element and test penultimate() again
		//Should print 'First'
		L.addLast("Second");
		System.out.println(L.penultimate());
				
		//Add more elements and test one more time
		//Should print 'One'
		L.addLast("One");
		L.addLast("Two");
		System.out.println(L.penultimate());
	}

	/**
	 * Tests the reverse() method
	 */
	public static void reverseTester() {
		//Create a new SinglyLinkedList object
		SinglyLinkedList<Integer> x = new SinglyLinkedList<Integer>();
		
		/*
		 * Should print "()" since no elements have been added
		 */
		System.out.println("Testing an empty list");
		System.out.println("List before reversal: " + x);
		x.reverse();
		System.out.println("List after reversal: " + x);
		
		//Add elements 1-5
		for (int i = 1; i < 6; i++) {
			x.addLast(i);
		}
		
		//Print the list before and after reversal
		/*
		 * Should print (1,2,3,4,5) before reversal
		 * Should print (5,4,3,2,1) after reversal
		 */
		System.out.println("Testing list reversal");
		System.out.println("List before reversal: " + x);
		x.reverse();
		System.out.println("List after reversal: " + x);
		
	}
	
	/**
	 * Tests the addSecond() method
	 */
	public static void addSecondTester() {
		
		//Create a new SinglyLinkedList that holds integers
		SinglyLinkedList<Integer> L = new SinglyLinkedList<Integer>();
		
		//Test for an empty list condition
		//Should throw an IllegalStateException
		try {L.addSecond(1);}
		catch (Exception IllegalStateException) {
			System.out.println("IllegalStateException has been caught.");
		}
		
		//Add some elements using the addLast() method first
		for(int i = 1; i < 10; i = i+2) {
			L.addLast(i);
		}
		//Display the list before and after using the method
		//Should print: 1,3,5,7,9
		System.out.println("L before addSecond: " + L);
		L.addSecond(2);
		//Should print: 1,2,3,5,7,9
		System.out.println("L after adding 2 second: " + L);
		
		//Display the list size
		//Should be 6
		System.out.println("List Size: " + L.size());
		System.out.println("Expected: 6");
		
	}
	
	/**
	 * Tests the add() method
	 */
	public static void addTester() {
		//Create a SinglyLinkedList
		SinglyLinkedList<Integer> L = new SinglyLinkedList<Integer>();
		
		//Test for an out of bounds exception
		//Should print a message saying it was caught
		try {
			L.add(1, -1);
		} catch (Exception IndexOutOfBoundsException) {
			System.out.println("IndexOutOfBoundsExecpetion caught.");
		}
		/*
		 * Test for the other end of the bound
		 * Should print a message saying the exception was caught
		 */
		try {
			L.add(1, 1);
		} catch (Exception IndexOutOfBoundsException) {
			System.out.println("IndexOutOfBoundsExecpetion caught.");
		}
		
		//Add one element
		//Should print 1
		L.add(1, 0);
		System.out.println("L: " + L);
		
		//Add an element at the tail
		//Should print 1,2
		L.add(2, 1);
		System.out.println("L: " + L);
		
		//Add three more elements at the tail and print L
		//Shoud print 1,2,3,4,5
		L.add(3, 2);
		L.add(4, 3);
		L.add(5, 4);
		System.out.println("L: " + L);
		
		//Add an element in the middle of the list and print L
		//Should print 1,2,3,99,4,5
		L.add(99, 3);
		System.out.println("L: " + L);
	}
	
	/**
	 * Tests the remove() method
	 */
	public static void removeTester() {
		//Create a SinglyLinkedList
		SinglyLinkedList<Integer> L = new SinglyLinkedList<Integer>();
		
		//Test for an empty list
		//Should print null for the element and zero for the size
		System.out.println("Empty List; Element removed: " + L.remove(0));
		System.out.println("Size: " + L.size());
		
		//Add an element, and test for an improper index;should throw an IndexOutOfBoundsException
		L.addLast(1);
		try {
			L.remove(1);
		}
		catch (Exception IndexOutOfBoundsException) {
			System.out.println("IndexOutOfBounds Exception caught!");
		}
		
		//Add some elements, then remove them
		for (int i = 2; i < 7; i++) {
			L.addLast(i);
		}
		
		/*Print L and size of L before Removal,
		*and then L and size of L after removal and the element removed
		*This removal is at the head of the list
		*Should print that '1' was removed and the size went from 6 to 5
		*/
		System.out.println("L: " + L + " Size: " + L.size());
		System.out.println("Element removed: " + L.remove(0));
		System.out.println("L after removal: " + L + " Size: " + L.size());
		
		/*Print L and size of L before Removal,
		*and then L and size of L after removal and the element removed
		*This removal is at the tail of the list
		*Should print that '1' was removed and the size went from 5 to 4
		*/
		System.out.println("L: " + L + " Size: " + L.size());
		System.out.println("Element removed: " + L.remove(L.size()-1));
		System.out.println("L after removal: " + L + " Size: " + L.size());
		
		/*Print L and size of L before Removal,
		*and then L and size of L after removal and the element removed
		*This removal is in the middle of the list
		*Should print that '1' was removed and the size went from 4 to 3
		*/
		System.out.println("L: " + L + " Size: " + L.size());
		System.out.println("Element removed: " + L.remove(3));
		System.out.println("L after removal: " + L + " Size: " + L.size());
		
		//Remove the elements until the list is empty
		int n = L.size();
		for (int j = n-1; j >= 0; j--) {
			L.remove(j);
		}
		System.out.println("L: " + L);
		
		//Add some elements
		for (int j = 0; j < 6; j++) {
			L.addLast(j);
		}
		//Remove elements in reverse order
		n = L.size();
		for (int j = n-1; j >= 0; j--) {
			System.out.println("Element: " + L.removeLast());
		}
		System.out.println(L);
	}
	
	/**
	 * Tests the getMiddle() method
	 */
	public static void getMiddleTester() {
		//Create a singly linked list
		SinglyLinkedList<Integer> L = new SinglyLinkedList<Integer>();
		
		//Test for the empty list condition; should throw an IllegalStateException
		try {
			L.getMiddle();
		} catch (Exception IllegalStateException) {
			System.out.println("IllegalStateException caught!");
		}
		
		//Add an element to test a size of 1
		//Print L and the element; should print 1
		L.addFirst(1);
		System.out.println("L: " + L);
		System.out.println("Middle Element: " + L.getMiddle());
		
		//Add two more elements to test the odd size condition
		//Print L and the element; should print 2
		L.addLast(2);
		L.addLast(3);
		System.out.println("L: " + L);
		System.out.println("Middle Element: " + L.getMiddle());
		
		//Add three more elements to test the even size condition
		//Print L and the element; should print 3
		L.addLast(4);
		L.addLast(5);
		L.addLast(6);
		System.out.println("L: " + L);
		System.out.println("Middle Element: " + L.getMiddle());
		
	}
	
	public static void main(String[] args) {
		
		//Test the penultimate() method
		//SinglyLinkedListTester.penultimateTest();
		
		//Test the reverse() method
		//SinglyLinkedListTester.reverseTester();
		
		//Test the addSecond() method
		//SinglyLinkedListTester.addSecondTester();
		
		//Test the add() method
		//SinglyLinkedListTester.addTester();
		
		//Test the remove() method
		//SinglyLinkedListTester.removeTester();
		
		//Test the getMiddle() method
		//SinglyLinkedListTester.getMiddleTester();
		
	}

}
