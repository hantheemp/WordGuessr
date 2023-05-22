package week01;

public class NodeLL {

	// This class is the foundation of the LinkedList structure.

	private String question; // A String variable for saving the question element while displaying GUI

	private String answer; // A String variable for saving the answer element while displaying GUI

	private NodeLL prev; // A NodeLL variable for saving the previous element of the current node. If it
							// is an empty LinkedList or 1 element list, points to null

	private NodeLL next; // A NodeLL variable for saving the previous element of the current node. If it
							// is an empty LinkedList or 1 element list, points to null

	public NodeLL() { // Default constructor

		this.question = "Default Value";

		this.answer = "Default Value";

		this.prev = null;

		this.next = null;

	}

	public NodeLL(String question, String answer) { // This constructor will be used if the data has been known
													// beforehand.

		this.question = question;

		this.answer = answer;

		this.prev = null;

		this.next = null;

	}

	public NodeLL(String question, String answer, NodeLL prev, NodeLL next) {

		this.question = question;

		this.answer = answer;

		this.prev = prev;

		this.next = next;

	}

	// Encapsulation applied.

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public NodeLL getPrev() {
		return prev;
	}

	public void setPrev(NodeLL prev) {
		this.prev = prev;
	}

	public NodeLL getNext() {
		return next;
	}

	public void setNext(NodeLL next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Question : " + this.question + "\nAnswer : " + this.answer;
	}

}
