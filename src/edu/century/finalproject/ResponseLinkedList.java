package edu.century.finalproject;

/**
 * 
 * @author Sean Kaelble
 *
 */
public class ResponseLinkedList {
	ResponseNode head;
	ResponseNode tail;
	int count;
	
	/**
	 * Constructor for creating a ResponseLinkedList object.
	 * @param
	 * @pre
	 * @post A ReponseLinkedList will have been created with the head and tail set to null and the count set to zero.
	 */
	public ResponseLinkedList() {
		head = null;
		tail = null;
		count = 0;
	}
	
	/**
	 * Adds a ReponseNode to the tail of the list.
	 * @param question the ResponseNode being added to the list.
	 * @pre question is not null.
	 * @post the ReponseNode will have been added to the list and the count incremented by one.
	 * @throws NullPointerException if the argument is null.
	 */
	public void add(ResponseNode question) {
		if(question == null)
			throw new IllegalArgumentException("ResponseLinkedList Class: Cannot add a null node.");
		if(count == 0) {
			head = question;
			tail = question;
		}else {
			tail.setLink(question);
			tail = question;
		}
		count++;
	}
}
