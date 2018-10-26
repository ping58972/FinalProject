package edu.century.finalproject;

public class VateranDataStruc<T> {
	private BTNode<T> head;
	
	//int manyItems;
	public BTNode<T> getHead(){
		return head;
	}
	public VateranDataStruc(T head) {
		this.head = new BTNode<>(head);
		
		//manyItems = 1;
	}
	
	public void add(T head, T left, T right) {
		BTNode<T> curr = this.head;
		if(curr.data.equals(head)) {
			curr.left = new BTNode<>(left);
			curr.right = new BTNode<>(right);
			System.out.println(curr.data.toString());
			System.out.println(curr.left.data.toString());
			System.out.println(curr.right.data.toString()+ "\n");
			//manyItems +=2;
		}else {
			BTNode<T> currs = this.head;
		
			BTNode<T> curs = new BTNode<>(head);
			currs.travel(head, curs);
				curs.left = new BTNode<>(left); 
				curs.right = new BTNode<>(right); 
				//BTNode<T> currLeft = this.head;
				//currLeft.travel(left);
				/*if(currLeft.data.equals(left)) {
					currs.left = currLeft;
				}else*/ 
				//	currs.left = new BTNode<>(left);
				//BTNode<T> currRight = this.head;
				//currRight.travel(right);
			/*	if(currLeft.data.equals(right)) {
					currs.right = currRight;
				}else*/ 
					//currs.right = new BTNode<>(right);
			System.out.println(curs.data.toString());
			System.out.println(curs.left.data.toString());
			System.out.println(curs.right.data.toString()+ "\n");
		}
	}
	public void printOut() {
		BTNode<T> curr = this.head;
		curr.printOut();
		
	}

	private class BTNode<T>{
		public  T data;
		public BTNode<T> left;
		public BTNode<T> right;
		
		public BTNode(T initData) {
			data = initData;
			left = null;
			right = null;
		}
		public void travel(T str, BTNode<T> node) {
		if(left != null)
			left.travel(str, node);
		if(data.equals(str)) {
			node = this;
			//System.out.println(node.data.toString());
			return;
		}
			
		if(right != null)
			right.travel(str, node);
		
		}
		
		public void printOut() {
			
		if(left != null)
			left.printOut();
		
		if(right != null)
			right.printOut();
		
		}
		
		public boolean isLeaf() {
			return(left == null) && (right == null);
		}
	}
}
