package GUI;

import java.util.NoSuchElementException;

/**
 * 
 * @author Sean Kaelble
 *
 */
public class ResponseLinkedQueue {
	ResponseNode front;
	ResponseNode rear;
	int nodeCount;
	
	/**
	 * Constructor for creating a ResponseQueue object.
	 * @param
	 * @pre
	 * @post A ResponseLinkedQueue object will have been created with the front and rear set to null and the count set to zero.
	 */
	public ResponseLinkedQueue() {
		front = null;
		rear = null;
		nodeCount = 0;
	}
	
	/**
	 * Adds a node to the rear of the queue.
	 * @param question the ResponseNode being added to the list.
	 * @pre question is not null.
	 * @post the node will have been added to the queue and the node count incremented by one.
	 * @throws NullPointerException if the argument is null.
	 */
	public void add(ResponseNode question) {
		if(question == null)
			throw new NullPointerException("ResponseLinkedList Class: Cannot add a null node.");
		if(isEmpty()) {
			front = question;
			rear = front;
		}else {
			rear.setLink(question);
			rear = rear.getLink();
		}
		nodeCount++;
	}
	
	
	/**
	 * Removes the front node of the queue.
	 * @param
	 * @pre The queue is not empty.
	 * @post The front node is removed from the queue and a reference to it is returned by the function.
	 * @throws NoSuchElementException if the method was called with no elements in the queue.
	 */
	public ResponseNode remove() {
		ResponseNode answer;
		
		if(isEmpty()) {
			throw new NoSuchElementException("ReponseLinkedQueue Class: Queue underflow.");
		}else {
			answer = front;
			front = front.getLink();
			nodeCount--;
			
			//If there was only one node, remove the reference from the rear to ensure it is garbage collected.
			if(isEmpty()) {
				rear = null;
			}
			return answer;
		}
	}
	
	/**
	 * Determines if the queue is empty or not.
	 * @param
	 * @pre
	 * @post true is returned if the queue is empty. false is returned if the queue is not empty.
	 */
	public boolean isEmpty() {
		if(nodeCount ==0)
			return true;
		else
			return false;
	}
	
	/**
	 * Gets the number of nodes in the queue.
	 * @param
	 * @pre
	 * @post the count of the number of nodes in the queue is returned.
	 */
	public int size() {
		return nodeCount;
	}
}
