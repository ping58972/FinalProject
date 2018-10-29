package fileReader;

/**
 * 
 * @author William T Schussler
 *
 * @param <T>
 */
public class Stack<T> implements Cloneable{
	
	private Node<T> head;
	private int count;
	
	/**
	 * @Description
	 * 	creates a new empty stack
	 * @Postcondition
	 * 	there is a new empty stack in memory
	 */
	public Stack() {
		count = 0;
		head = null;
	}
	
	
	/**
	 * 
	 * @Description
	 * 	pushes new data to the stack
	 * @Precondition
	 * 	
	 * @param element
	 * 	the new data that you want to add to the stack
	 * @Postcondition
	 * 	count will be incremented by 1 and element will be added to the stack
	 *  as a new node and head will be changed to the new node
	 */
	public void push(T element) {
		head = new Node<T>(element, head);
		count++;
	}
	
	/**
	 * @Description
	 * 	removes the top of the stack and returns the value
	 * @Precondition
	 * @return
	 * 	returns the top of the stack or null if the stack is empty
	 * @Postcondition
	 * 	the stack is one smaller and the top is removed exposing the next value
	 */
	public T pop() {
		if (head == null)
			return null;
		T data = head.getData();
		head = head.getLink();
		count--;
		return data;
	}
	
	
	/**
	 * @Description
	 * 	returns the value of the top of the stack
	 * @Precondition
	 * @return
	 * 	the value of the top of the stack
	 */
	public T peek() {
		if (head == null) {
			return null;
		}
		return head.getData();
	}
	
	
	/**
	 * @Description
	 * 	returns the number of items in the stack
	 * @Precondition
	 * @return
	 * 	count
	 */
	public int getCount() {
		return count;
	}
	
	
	/**
	 * @Description
	 * 	returns a reversed clone of the stack
	 * @Precondition
	 * @return
	 * 	a reversed clone of the stack
	 */
	public Stack<T> getReversed() {
		Stack<T> reversed = new Stack<T>();
		Node<T> cursor;
		
		for (cursor = head; cursor != null; cursor = cursor.getLink()) {
			reversed.push(cursor.getData());
		}
		
		return reversed;
	}
	
	
	public Stack<T> clone(){
		Stack<T> clone = this.getReversed();
		clone = clone.getReversed();
		return clone;
	}
	
	
	public String toString() {
		Node<T> cursor;
		String output = "";
		
		for (cursor = head; cursor != null; cursor = cursor.getLink()) {
			output += cursor.getData() + "\n";
		}
		
		return output;
	}
	
	
	/**
	 * 
	 * @author 
	 * 	William T Schussler
	 * @param <t>
	 * @Description
	 * 	A simple generic Node class for use in single-link linked lists
	 */
	private class Node<t>{
		
		private t data;
		private Node<t> link;
		
		public Node(t data, Node<t> link) {
			this.data = data;
			this.link = link;
		}
		
		public t getData() {
			return data;
		}
		
		public Node<t> getLink(){
			return link;
		}
	}
}
