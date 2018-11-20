package edu.century.finalproject;

public class ResponseList {

	private ResponseNode head;
	private ResponseNode tail;
	
	
	public ResponseList() {
		this.head = null;
		this.tail = tail;
	}
	
	
	public void add(ResponseNode element) {
		if(head == null) {
			head = element;
			tail = element;
		}else {
			tail.setLink(element);
			tail = element;
		}
	}
	
	
}
