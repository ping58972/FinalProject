package edu.century.finalproject;

public class ResponseList {

	private ResponseNode head;
	private ResponseNode tail;
	private int nodeCount;
	
	
	public ResponseList() {
		this.head = null;
		this.tail = tail;
		nodeCount = 0;
	}
	
	
	public void add(ResponseNode element) {
		if(head == null) {
			head = element;
			tail = element;
		}else {
			tail.setLink(element);
			tail = element;
		}
		nodeCount++;
		
	}
	
	public ResponseNode getHead() {
		return this.head;
	}
	
	public int size() {
		return nodeCount;
	}
	public boolean isEmpty() {
		if(nodeCount ==0)
			return true;
		else
			return false;
	}
}
