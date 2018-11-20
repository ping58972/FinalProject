package edu.century.finalproject;
 /**
 * 
 * @author Sean Kaelble
 *
 */
public class ResponseNode {
 	private String question;
	private Response answer;
	private ResponseNode link;
	enum Response{YES, NO};
	
	
	/**
	 * Constructor for creating a ResponseNode object
	 * @param question the question prompted to the user.
	 * @param answer the user's response to the question.
	 * @pre	answer must be a strictly yes/no response.
	 * @post A ReponseNode will have been created with a null link.
	 */
	public ResponseNode(String question, String answer) {
		setQuestion(question);
		setAnswer(answer);
		link = null;
	}
	
	/**
	 * Sets the link of the node.
	 * @param link a reference to another ReponseNode;
	 * @pre
	 * @post The link of this node will have been set.
	 */
	public void setLink(ResponseNode link) {
		this.link = link;
	}
	
	/**
	 * Gets the link of the node.
	 * @param
	 * @pre
	 * @post The link of this node is returned.
	 */
	public ResponseNode getLink() {
		return this.link;
	}
	
	
	/**
	 * Gets the question of the node.
	 * @param
	 * @pre
	 * @post The question of the node is returned.
	 */
	public String getQuestion() {
		return this.question;
	}
	
	/**
	 * Sets the question of the node.
	 * @param question the question that was prompted to a user.
	 * @pre The question is not a null String.
	 * @post The question of the node will have been set.
	 * @throws IllegalArgumentException if the argument is null.
	 */
	public void setQuestion(String question) {
		if(question.equals(null))
			throw new IllegalArgumentException("ResponseNode Class: Cannot set a null question.");
		this.question = question;
	}
	
	/**
	 * Sets the answer of the node.
	 * @param answer the users response to a question.
	 * @pre answer must either be "yes" or "no".
	 * @post The answer of the node will have been set.
	 * @throws IllegalArgumentException if the argument is anything other than "yes" or "no".
	 */
	public void setAnswer(String answer) {
		answer.toLowerCase();
		
		if(answer.equals("yes"))
			this.answer = Response.YES;
		else if(answer.equals("no"))
			this.answer = Response.NO;
		else
			throw new IllegalArgumentException("ResponseNode Class: answer must be either Yes or No.");
	}
	
	/**
	 * Sets the answer of the node.
	 * @param answer the user's response to a question as an Enum.
	 * @pre
	 * @post The answer of the node will have been set.
	 */
	public void setAnswer(Response answer) {
		this.answer = answer;
	}
	
	/**
	 * Returns the answer of the node.
	 * @param
	 * @pre
	 * @post The answer of the node is returned as a String.
	 */
	public String getAnswer() {
		if(answer.equals(Response.YES))
			return "Yes";
		else
			return "No";
	}
	
}