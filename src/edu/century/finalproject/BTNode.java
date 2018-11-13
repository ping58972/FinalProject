package edu.century.finalproject;

import java.util.Scanner;


public class BTNode {
//	private T position;
	private  String data;
	private String additionalData;
	private boolean additionalFlag;
//	private BTNode<T> left, right;
	private BTNode left, right;
//	public BTNode(T initPos, T initData) {
//		position = initPos;
//		data = initData;
//	}
	
	public BTNode() {
		data = null;
		left = null;
		right = null;
	}
	
	public BTNode(String data) {
		this.data = data;
		additionalFlag = false;
		left = null;
		right = null;
	}
	
	public BTNode(String data, String additionalData) {
		this.data = data;
		this.additionalData = additionalData;
		if(additionalData != null)
			additionalFlag = true;
		else{
			additionalFlag = false;
		}
		left = null;
		right = null;
	}
//	public void insert(T headPos, T leftPos,
//			T leftData, T rightPos, T rightData){
//		if(position.equals(headPos)) {
//			left = new BTNode<>(leftPos, leftData);
//			right = new BTNode<>(rightPos, rightData);
//			return;
//		}else {
//		if(left != null) 
//			left.insert(headPos,leftPos,
//					leftData, rightPos, rightData);	
//		if(right != null)
//			right.insert(headPos,leftPos,
//					leftData, rightPos, rightData);	
//		}
//		
//	}
	public void printAll() {
													
		System.out.println(data.toString());
		if(additionalFlag == true)
			System.out.println(additionalData.toString());
		
		if(left != null) left.printAll();
		if(right != null) right.printAll();
		
	}

	public void printYN() {
		Character yn = 'q';
		
		System.out.println(data.toString());
		if(additionalFlag == true)
			System.out.println(additionalData.toString());
		
		Scanner input = new Scanner(System.in);
		yn = input.next().charAt(0);
		if(yn.equals('y') ) {
			if(left!=null)
			left.printYN();
		}
		if(yn.equals('n')) {
			if (right!=null)
				right.printYN();
		}
		input.close();
		
	}

//	public T getPosition() {
//		return position;
//	}
//
//	public void setPosition(T position) {
//		this.position = position;
//	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public String getAdditionalData() {
		if(additionalFlag == true)
			return additionalData;
		else
			return null;
	}
	
	public void setAdditionalData(String additionalData) {
		this.additionalData = additionalData;
		
		if(additionalData == null)
			additionalFlag = false;
		else
			additionalFlag = true;
	}
	
	public boolean getAdditionalFlag() {
		return additionalFlag;
	}

//	public BTNode<T> getLeft() {
	public BTNode getLeft() {
		return left;
	}

//	public void setLeft(BTNode<T> left) {
	public void setLeft(BTNode left) {
		this.left = left;
	}

//	public BTNode<T> getRight() {
	public BTNode getRight() {
		return right;
	}

//	public void setRight(BTNode<T> right) {
	public void setRight(BTNode right) {
		this.right = right;
	}
			
	
		

}
