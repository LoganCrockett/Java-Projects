

/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * A basic singly linked list implementation.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class SinglyLinkedList<E> implements Cloneable, Iterable<E> {
  //---------------- nested Node class ----------------
  /**
   * Node of a singly linked list, which stores a reference to its
   * element and to the subsequent node in the list (or null if this
   * is the last node).
   */
  private static class Node<E> {

    /** The element stored at this node */
    private E element;            // reference to the element stored at this node

    /** A reference to the subsequent node in the list */
    private Node<E> next;         // reference to the subsequent node in the list

    /**
     * Creates a node with the given element and next node.
     *
     * @param e  the element to be stored
     * @param n  reference to a node that should follow the new node
     */
    public Node(E e, Node<E> n) {
      element = e;
      next = n;
    }

    // Accessor methods
    /**
     * Returns the element stored at the node.
     * @return the element stored at the node
     */
    public E getElement() { return element; }

    /**
     * Returns the node that follows this one (or null if no such node).
     * @return the following node
     */
    public Node<E> getNext() { return next; }

    // Modifier methods
    /**
     * Sets the node's next reference to point to Node n.
     * @param n    the node that should follow this one
     */
    public void setNext(Node<E> n) { next = n; }
  } //----------- end of nested Node class -----------

  // instance variables of the SinglyLinkedList
  /** The head node of the list */
  private Node<E> head = null;               // head node of the list (or null if empty)

  /** The last node of the list */
  private Node<E> tail = null;               // last node of the list (or null if empty)

  /** Number of nodes in the list */
  private int size = 0;                      // number of nodes in the list

  /** Constructs an initially empty list. */
  public SinglyLinkedList() { }              // constructs an initially empty list

  // access methods
  /**
   * Returns the number of elements in the linked list.
   * @return number of elements in the linked list
   */
  public int size() { return size; }

  /**
   * Tests whether the linked list is empty.
   * @return true if the linked list is empty, false otherwise
   */
  public boolean isEmpty() { return size == 0; }

  /**
   * Returns (but does not remove) the first element of the list
   * @return element at the front of the list (or null if empty)
   */
  public E first() {             // returns (but does not remove) the first element
    if (isEmpty()) return null;
    return head.getElement();
  }

  /**
   * Returns (but does not remove) the last element of the list.
   * @return element at the end of the list (or null if empty)
   */
  public E last() {              // returns (but does not remove) the last element
    if (isEmpty()) return null;
    return tail.getElement();
  }
  /**
   * Returns (but does not remove) the penultimate(Second to last) node of the list.
   * @return node before the end of the list - exception if size < 2 (IllegalStateException)
   */
  
  private Node<E> penultimateNode( ) throws IllegalStateException {
	  //If the size is less than two, throw an IllegalStateException
	  if (size() < 2) {throw new IllegalStateException("Size cannot be less than 2");}
	  //Otherwise, travel the list for the second-to-last element
	  else {
		  /*
		  //Create a variable for the node head
		  Node<E> desiredNode = head;//The element we will return
		  Node<E> walk = desiredNode.getNext();//Points to the next element in the list
		  //While the element is not pointing to null, walk to the next element
		  while(walk != null) {
			  //Update the node references
			  desiredNode = desiredNode.getNext();
			  walk = desiredNode.getNext();
		  }*/
		  
		  Node<E> desiredNode = head;//The Element we will return
		  /*
		   * While the desired node is not equal to the tail,
		   * travel the list.
		   */
		  while (desiredNode.getNext() != tail) {
			  desiredNode = desiredNode.getNext();//Update the reference
		  }
		  /*At this point, the variable "desiredElement" should be pointing to the second
		   * to last element, so return it.
		   */
		  return desiredNode;
	  }
	  
  }
  /**
   * Returns (but does not remove) the penultimate element of the list.
   * @return element before the end of the list - exception if size < 2 (IllegalStateException)
   */
  public E penultimate() {
	  return penultimateNode().getElement();
  }
  /**
   * Returns (but does not remove) the middle element of the list.
   * @return element before the end of the list - exception if size = 0 (IllegalStateException)
   */
  public E getMiddle() throws IllegalStateException {
	  //Test for the size of the list; if zero: throw IllegalSateException
	  if (size() == 0) {
		  throw new IllegalStateException("Size cannot be zero");
	  }
	  //Test for a size of one; if so, then return that element
	  else if (size() == 1) {return head.getElement();}
	  //Next, test for an odd number of elements, and return that element
	  else if (size() % 2 != 0) {
		  /*
		   * Since the number of elements are odd, we only have to go to the element
		   * that is given through integer division
		   */
		  Node<E> currentNode = head;//Start at the head
		  int target = size() / 2;//Index to travel to
		  //Travel the list until we reach that index
		  for (int j = 0; j != target; j++) {
			  currentNode = currentNode.getNext();//Update the node we are referencing
		  }
		  E element = currentNode.getElement();//The element to return
		  //At this point, we will have reached our target
		  //Return the target
		  return element;
	  }
	  //Otherwise, the list size is even, and we have to return the 'left' element
	  else {
		  /*
		   * Since the number of elements are even, we only have to go to the element
		   * that is one less than the number from integer division.
		   */
		  Node<E> currentNode = head;//Start at the head
		  int target = size() / 2;//Index to travel to
		  //Travel the list until we reach that index
		  for (int j = 0; j != target-1; j++) {
			  currentNode = currentNode.getNext();//Update the node we are referencing
		  }
		  E element = currentNode.getElement();//The element to return
		  //At this point, we will have reached our target
		  //Return the target
		  return element;
	  }
  }
  // update methods
  /**
   * Adds an element to the front of the list.
   * @param e  the new element to add
   */
  public void addFirst(E e) {                // adds element e to the front of the list
    head = new Node<>(e, head);              // create and link a new node
    if (size == 0)
      tail = head;                           // special case: new node becomes tail also
    size++;
  }

  /**
   * Adds an element to the end of the list.
   * @param e  the new element to add
   */
  public void addLast(E e) {                 // adds element e to the end of the list
    Node<E> newest = new Node<>(e, null);    // node will eventually be the tail
    if (isEmpty())
      head = newest;                         // special case: previously empty list
    else
      tail.setNext(newest);                  // new node after existing tail
    tail = newest;                           // new node becomes the tail
    size++;
  }
  /**
   * Adds an element to be the second of the list.
   * Throws an IllegalStateException if the list is empty
   * @param e  the new element to add
   */
  public void addSecond(E e) throws IllegalStateException { 
	  if (size() == 0) {
		  throw new IllegalStateException("List cannot be empty.");
	  }
	  else {  
		//Create a new node for the element
		  Node<E> newNode = new Node<E>(e,null);
		  //Use a temporary variable to store the reference to the next element
		  Node<E> tempRef = head.getNext();
		  
		  //Update the Surrounding nodes
		  head.setNext(newNode);//Update head to the new node
		  newNode.setNext(tempRef);//Change the point to the value in the temporary variable
		  
		  //Check if it is the last element of the list (will be equal to null)
		  //If so, then update the tail to the new element
		  if (newNode.getNext() == null) {
			  tail = newNode;
		  }
	  }
	  size++;//Update the size to reflect the change
	  return;
  }
  
  /**
   * Adds an element at the ith position in the list.
   * i is subtracted by one through to account for the correct position (like an array)
   * Throws an IndexOutOfBoundsException if i is not >= 0 and <= size
   * @param e  the new element to add.  
   */ 
  public void add(E e, int i) throws IndexOutOfBoundsException {
	  
	  /*
	   * Check if i is in between 0 and the size of the list
	   * If not, then throw an IndexOutOfBounds exception
	   */
	  if (i < 0 || i > size()) {
		  throw new IndexOutOfBoundsException("Invalid Index: " + i);
	  }
	  
	  /*
	   * If i is equal to zero,
	   * then we just need to update the head reference and the size
	   */
	  else if (i == 0) {
		  //Updates the head, and points to the previous head
		  head = new Node<>(e, head);
		  //If the new element is the only one, the set it equal to the tail as well
		    if (size == 0)
		    	//If the size is zero, the set the tail equal to the head
		      tail = head;
		    //size++;
	  }
	  /*
	   * If i-1 is equal to the size, the use the addLast() method
	   * to add it to the tail
	   */
	  else if (i == size()) {
		  addLast(e);
		  return;//Just return, since we have already handled the addition and size change
	  }
	  /*
	   * Otherwise, we will need to travel the list until we reach the
	   * node before i.
	   * Then, we will update the size
	   */
	  else {
		  Node<E> currentNode = head;//Start at the beginning of the list
		  
		  //If the reference is null, then only the head has been added
		  //Update the reference for the currentNode and the tail
		  if (currentNode.getNext() == null) {
			  Node<E> newNode = new Node<E>(e,null);
			  currentNode.setNext(newNode);
			  tail = newNode;
		  }
		  //Otherwise, we must travel the list
		  else {
			  /*
			  * Iterate through the list until we get to the desired position
			  * Subtract two from i, since we account for the size, and we want the node before
			  * the ith position.
			  */
			  for (int j = 0; j != i - 1; j++) {
				  //Update the node reference as we travel the list
				  currentNode = currentNode.getNext();
			  }
			  
			  /*At this point, we should have reached the index we are looking for
			   * First, check if the next pointer is null
			   * If so, then update the tail too
			   * Otherwise, just create the new node, and update the current one
			   */
			  if (currentNode.getNext() == null) {
				  Node<E> newNode = new Node<E>(e,null);
				  currentNode.setNext(newNode);
				  tail = newNode;
			  }
			  else {
				  Node<E> newNode = new Node<E>(e,currentNode.getNext());
				  currentNode.setNext(newNode);
			  }
		  }
	  }
	  size++;//Update the size to reflect this change
	  return;
  }

  /**
   * Removes and returns the first element of the list.
   * @return the removed element (or null if empty)
   */
  public E removeFirst() {                   // removes and returns the first element
    if (isEmpty()) return null; // nothing to remove
    E answer = head.getElement();
    head = head.getNext();                   // will become null if list had only one node
    size--;
    if (size == 0)
      tail = null;                           // special case as list is now empty
    return answer;
  }
  /**
   * Removes and returns the last element of the list.
   * @return the removed element (or null if empty)
   */
  public E removeLast() {
	  if (isEmpty()) return null; // nothing to remove
	  //If the only element is the head, just use remove first to remove the element
	  if (size() == 1) {
		  return removeFirst();
		  }
	  //Travel to the element before the tail
	  Node<E> currentNode = head;//The node we are currently at
	  for (int j = 0; j < size() -2;j++) {
		  currentNode = currentNode.getNext();
	  }
	  E element = currentNode.getNext().getElement();//Point to the element
	  currentNode.setNext(null);//Set the next reference to null
	  tail = currentNode;//Update the tail
	  size--;//Update the size
	  return element;
  }
  
  /**
   * Removes and returns the ith element of the list.
   * Throws IndexOutOfBoundsException if i is not a valid index
   * @return the removed element (or null if empty) exception i not in proper range
   */
  public E remove(int i) throws IndexOutOfBoundsException {
	
	  //If the list is empty, then just return null
	  if (isEmpty()) {return null;}
	  //If i is less than 0, or greater than the size, then throw an exception
	  else if (i < 0 || i > size()) {
		  throw new IndexOutOfBoundsException("Invalid Index: " + i);
	  }
	  //If i is 0, then use the removeFirst() method
	  //Don't have to adjust size, since it is handled in removefirst()
	  else if (i == 0) {
		 return removeFirst();
	  }
	  /*
	   * If i is equal to the size, then we can use the remove last method
	   */
	  else if (i == size()) {
		  return removeLast();
	  }
	  //Otherwise, travel the list to the previous index and remove the next element
	  //Stop at the element before i, or the element i-1
	  else {
		  Node <E> currentNode = head;
		  for (int j = 0; j < i-1; j++) {
			  currentNode = currentNode.getNext();//Update the node reference
		  }
		  //At this point, we have reached the index before i
		  //Remove i from the list now
		  Node<E> target = currentNode.next;

		  E element = null;//The element to be returned
		  //Otherwise, update the surrounding node
		  currentNode.setNext(target.next);//Update the pointer to the next node after the target
		  target.setNext(null);//Update the target reference to null
		  element = target.getElement();//Get the element from the node
		  size--;//Update the size to reflect the change
		  return element;//Return the element that was removed
	  }
  }
  
  /**
   * Reverses the order of the nodes in the list.
   * 
   */
  public void reverse() {
	  //If the size is zero or one, then just return
	  if (size() == 0 || size() == 1) {return;}
	  else {
	  
		  Node<E> tempTail = head;//Hold this node in order to update the tail reference when finished
		  Node<E> previousNode = head;//Holds the reference for the previous node
		  Node<E> currentNode = head.getNext();//the node we are currently updating the reference on
		  head.setNext(null);//Set the head pointer to null now
	  
		  //While the next node is not the tail, go through and change the node references
		  while (currentNode != tail) {
		  
			  Node<E> tempRef = currentNode.getNext();//Holds the next reference
			  currentNode.setNext(previousNode);//Update the reference to the previous node
			  //Update the nodes for the next iteration
			  previousNode = currentNode;
		  	  /*
		   	  * Set to the temporary reference variable, since we changed the reference
		   	  */
		  	  currentNode = tempRef;
	  }
	  
	  //At this point, the last element should be updated, as well as the head and tail variables
	  head = currentNode;
	  head.setNext(previousNode);
	  tail = tempTail;
	  tail.setNext(null);
	  return;
	  }
  }

  @SuppressWarnings({"unchecked"})
  public boolean equals(Object o) {
    if (o == null) return false;
    if (getClass() != o.getClass()) return false;
    SinglyLinkedList other = (SinglyLinkedList) o;   // use nonparameterized type
    if (size != other.size) return false;
    Node walkA = head;                               // traverse the primary list
    Node walkB = other.head;                         // traverse the secondary list
    while (walkA != null) {
      if (!walkA.getElement().equals(walkB.getElement())) return false; //mismatch
      walkA = walkA.getNext();
      walkB = walkB.getNext();
    }
    return true;   // if we reach this, everything matched successfully
  }

  @SuppressWarnings({"unchecked"})
  public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
    // always use inherited Object.clone() to create the initial copy
    SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone(); // safe cast
    if (size > 0) {                    // we need independent chain of nodes
      other.head = new Node<>(head.getElement(), null);
      Node<E> walk = head.getNext();      // walk through remainder of original list
      Node<E> otherTail = other.head;     // remember most recently created node
      while (walk != null) {              // make a new node storing same element
        Node<E> newest = new Node<>(walk.getElement(), null);
        otherTail.setNext(newest);     // link previous node to this one
        otherTail = newest;
        walk = walk.getNext();
      }
    }
    return other;
  }

  public int hashCode() {
    int h = 0;
    for (Node walk=head; walk != null; walk = walk.getNext()) {
      h ^= walk.getElement().hashCode();      // bitwise exclusive-or with element's code
      h = (h << 5) | (h >>> 27);              // 5-bit cyclic shift of composite code
    }
    return h;
  }

  /**
   * Produces a string representation of the contents of the list.
   * This exists for debugging purposes only.
   */
  public String toString() {
    StringBuilder sb = new StringBuilder("(");
    Node<E> walk = head;
    while (walk != null) {
      sb.append(walk.getElement());
      if (walk != tail)
        sb.append(", ");
      walk = walk.getNext();
    }
    sb.append(")");
    return sb.toString();
  }
	 /**
	 * Implements java.lang.Iterable<T>
	 */
	public java.util.Iterator<E> iterator() {
		return new ForwardIterator();
	}
	private class ForwardIterator implements java.util.Iterator<E> {
		//***** Define appropriate instance variables here *****//
		Node<E> currentNode = head;//The node we are currently at; Start at the head

		public boolean hasNext() {
			//IF the size is zero, then there is not a next; return false
			if (size() == 0) {return false;}
			/*
			 * Try to get the next element; If it succeeds, then there is
			 * another element, and we can return true.
			 * Otherwise, it points to null, and there is not another element,
			 * so we return false
			 */
			try {
				currentNode.getNext();
			} catch (Exception NullPointerException) {
				return false;
			}
			return true;
		}

		// Note: this method has undefined behavior if hasNext() return false
		public E next() {
			//Get the next node before updating the current node reference
			/*
			Node<E> nextNode = currentNode.getNext();
			currentNode = nextNode;
			nextNode = nextNode.getNext();
			return currentNode.getElement();//Return the element
			*/
			E element = currentNode.getElement();
			currentNode = currentNode.getNext();
			return element;
		}
		
	}
}
