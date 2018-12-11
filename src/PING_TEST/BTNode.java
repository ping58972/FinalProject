package PING_TEST;
/**public class BTNode from the package PING_TEST;
 * 
 *  Century College, CSCI 2082 Fall 2018.
 *  BTNode.java, Programming Final Project.
 *  
 *  @author (Ping) Nalongsone Danddank
 *  @version 1.0
 *  @since 10/20/2018
 * */
import java.util.Scanner;

public class BTNode<T> {
	private T position;
	private  T data;
	private BTNode<T> left, right;
	public BTNode(T initPos, T initData) {
		position = initPos;
		data = initData;
	}
	
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
	
	/*public void insert(T headPos, T leftPos,
			T leftData, T rightPos, T rightData)
	 * @Descriptions 
	 * 		to insert. 
	 * @Parameter: 
	 * @Precondition :
	 * @Postcondition
	 * @Return
	 * @Thorws
	 * */
	public void insert(T headPos, T leftPos,
			T leftData, T rightPos, T rightData){
		if(position.equals(headPos)) {
			left = new BTNode<>(leftPos, leftData);
			right = new BTNode<>(rightPos, rightData);
			return;
		}else {
		if(left != null) 
			left.insert(headPos,leftPos,
					leftData, rightPos, rightData);	
		if(right != null)
			right.insert(headPos,leftPos,
					leftData, rightPos, rightData);	
		}
		
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
		
	}
	/* public T getPosition() 
	 * @Descriptions 
	 * 		to get position from node tree. 
	 * @Parameter
	 * @Precondition
	 * @Postcondition
	 * @Return : position of  node.
	 * @Thorws 	: null if position is null.
	 * */
	public T getPosition() {
		return position;
	}
	/* public void setPosition(T position)
	 * @Descriptions 
	 * 		to set position to node tree. 
	 * @Parameter : position - T
	 * @Precondition : position must not null.
	 * @Postcondition
	 * @Return 
	 * @Thorws 	
	 * */
	public void setPosition(T position) {
		this.position = position;
	}
	/* public T getData() {
	 * @Descriptions 
	 * 		to get data from node tree. 
	 * @Parameter
	 * @Precondition
	 * @Postcondition
	 * @Return : data of  node.
	 * @Thorws 	: null if node is null.
	 * */
	public T getData() {
		return data;
	}
	/* public void setData(T data)
	 * @Descriptions 
	 * 		to set data to node tree. 
	 * @Parameter : data - String
	 * @Precondition : data must not null.
	 * @Postcondition
	 * @Return 
	 * @Thorws 	
	 * */
	public void setData(T data) {
		this.data = data;
	}
	/* public BTNode<T> getLeft()
	 * @Descriptions 
	 * 		to get left of BTNode from node tree. 
	 * @Parameter
	 * @Precondition
	 * @Postcondition
	 * @Return : left of  node tree.
	 * @Thorws 	: null if node is null.
	 * */
	public BTNode<T> getLeft() {
		return left;
	}
	/* public void setLeft(BTNode<T> left)
	 * @Descriptions 
	 * 		to set left node to node tree. 
	 * @Parameter : left - BTNode
	 * @Precondition : left must be BTNode class.
	 * @Postcondition
	 * @Return 
	 * @Thorws 	
	 * */
	public void setLeft(BTNode<T> left) {
		this.left = left;
	}
	/* public BTNode<T> getRight()
	 * @Descriptions 
	 * 		to get right of BTNode from node tree. 
	 * @Parameter
	 * @Precondition
	 * @Postcondition
	 * @Return : right of  node tree.
	 * @Thorws 	: null if node is null.
	 * */
	public BTNode<T> getRight() {
		return right;
	}
	/* public void setRight(BTNode<T> right)
	 * @Descriptions 
	 * 		to set right node to node tree. 
	 * @Parameter : right - BTNode
	 * @Precondition : right must be BTNode class.
	 * @Postcondition
	 * @Return 
	 * @Thorws 	
	 * */
	public void setRight(BTNode<T> right) {
		this.right = right;
	}
}
