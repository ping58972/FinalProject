package edu.century.finalproject;
/**public class BTNode from the package edu.century.finalproject
 *
 *  Century College, CSCI 2082 Fall 2018.
 *  BTNode.java, Programming Final Project.
 *
 *  @author (Ping) Nalongsone Danddank
 *  @version 1.0
 *  @since 10/20/2018
 * */
import java.util.Scanner;


public class BTNode {

	private  String data;
	private String additionalData;
	private boolean additionalFlag;
	private BTNode left, right;

	/*public BTNode()
	 * @Descriptions
	 * 		to construct null class.
	 * @Parameter:
	 * @Precondition :
	 * @Postcondition
	 * @Return
	 * @Thorws
	 * */
	public BTNode() {
		data = null;
		left = null;
		right = null;
	}
	/*public BTNode(String data)
	 * @Descriptions
	 * 		to construct class with data.
	 * @Parameter:
	 * 		data - String.
	 * @Precondition : data not null.
	 * @Postcondition
	 * @Return
	 * @Thorws 	: null exception.
	 * */
	public BTNode(String data) {
		this.data = data;
		additionalFlag = false;
		left = null;
		right = null;
	}

	/*public BTNode(String data, String additionalData)
	 * @Descriptions
	 * 		to construct class with data and additional data.
	 * @Parameter:
	 * 		data - String.
	 * 		additionalData - String.
	 * @Precondition : data and additionalData not null.
	 * @Postcondition
	 * @Return
	 * @Thorws 	: null exception.
	 * */
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

	/* public void printAll()
	 * @Descriptions
	 * 		to print All nodes.
	 * @Parameter
	 * @Precondition
	 * @Postcondition
	 * @Return
	 * @Thorws
	 * */
	public void printAll() {
		System.out.println(data.toString());
		if(additionalFlag == true)
			System.out.println(additionalData.toString());
		if(left != null) left.printAll();
		if(right != null) right.printAll();
	}

	/* public void printYN()
	 * @Descriptions
	 * 		to print nodes follow yes and no answer.
	 * @Parameter
	 * @Precondition
	 * @Postcondition
	 * @Return
	 * @Thorws
	 * */
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

	/* public String getData()
	 * @Descriptions
	 * 		to get data from node tree.
	 * @Parameter
	 * @Precondition
	 * @Postcondition
	 * @Return : data of  node.
	 * @Thorws 	: null if node is null.
	 * */
	public String getData() {
		return data;
	}

	/* public void setData(String data)
	 * @Descriptions
	 * 		to set data to node tree.
	 * @Parameter : data - String
	 * @Precondition : data must not null.
	 * @Postcondition
	 * @Return
	 * @Thorws
	 * */
	public void setData(String data) {
		this.data = data;
	}

	/* public String getAdditionalData()
	 * @Descriptions
	 * 		to get AdditionalData from node tree.
	 * @Parameter
	 * @Precondition
	 * @Postcondition
	 * @Return : AdditionalData of  node if additional Flag is true.
	 * @Thorws
	 * */
	public String getAdditionalData() {
		if(additionalFlag == true)
			return additionalData;
		else
			return null;
	}
	/* public void setAdditionalData(String additionalData)
	 * @Descriptions
	 * 		to set AdditionalData to node tree.
	 * @Parameter : additionalData - String
	 * @Precondition : additionalData must not null.
	 * @Postcondition
	 * @Return
	 * @Thorws
	 * */
	public void setAdditionalData(String additionalData) {
		this.additionalData = additionalData;

		if(additionalData == null)
			additionalFlag = false;
		else
			additionalFlag = true;
	}
	/* public boolean getAdditionalFlag()
	 * @Descriptions
	 * 		to get additionalFlag from node tree.
	 * @Parameter
	 * @Precondition
	 * @Postcondition
	 * @Return : additionalFlag.
	 * @Thorws
	 * */
	public boolean getAdditionalFlag() {
		return additionalFlag;
	}
	/* public BTNode getLeft()
	 * @Descriptions
	 * 		to get left of BTNode from node tree.
	 * @Parameter
	 * @Precondition
	 * @Postcondition
	 * @Return : left of  node tree.
	 * @Thorws 	: null if node is null.
	 * */
	public BTNode getLeft() {
		return left;
	}

	/* public void setLeft(BTNode left)
	 * @Descriptions
	 * 		to set left node to node tree.
	 * @Parameter : left - BTNode
	 * @Precondition : left must be BTNode class.
	 * @Postcondition
	 * @Return
	 * @Thorws
	 * */
	public void setLeft(BTNode left) {
		this.left = left;
	}

	/* public BTNode getRight()
	 * @Descriptions
	 * 		to get right of BTNode from node tree.
	 * @Parameter
	 * @Precondition
	 * @Postcondition
	 * @Return : right of  node tree.
	 * @Thorws 	: null if node is null.
	 * */
	public BTNode getRight() {
		return right;
	}

	/* public void setRight(BTNode right)
	 * @Descriptions
	 * 		to set right node to node tree.
	 * @Parameter : right - BTNode
	 * @Precondition : right must be BTNode class.
	 * @Postcondition
	 * @Return
	 * @Thorws
	 * */
	public void setRight(BTNode right) {
		this.right = right;
	}




}
