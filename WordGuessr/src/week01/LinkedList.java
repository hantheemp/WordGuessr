package week01;

import java.util.Random;

public class LinkedList {

	private NodeLL first; // A NodeLL variable for defining the first node of the created LinkedList
							// object.

	private NodeLL last; // A NodeLL variable for defining the last node of the created LinkedList
							// object.

	public LinkedList() { // Default constructor.

		this.first = null;

		this.last = null;

	}

	public LinkedList(NodeLL first, NodeLL last) {

		this.first = first;

		this.last = last;

	}

	// Encapsulation applied.

	public NodeLL getFirst() {
		return first;
	}

	public void setFirst(NodeLL first) {
		this.first = first;
	}

	public NodeLL getLast() {
		return last;
	}

	public void setLast(NodeLL last) {
		this.last = last;
	}

	public void addData(String question, String answer) {

		if (this.first == null) {

			this.first = this.last = new NodeLL(question, answer, null, null);

		}

		else {

			NodeLL newNode = new NodeLL(question, answer, this.last, null);

			this.last.setNext(newNode);

			this.last = newNode;

		}

	}

	public boolean deleteData(String question) {

		NodeLL current = this.first;
		
		NodeLL parent = null;
		
		while (current != null) {
			
			if (current.getAnswer().equals(question)) {
				
				current.getPrev().setNext(current.getNext());
				
				current.getNext().setPrev(current.getPrev());
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	public int countElements() {
		
		int counter = 0;
		
		NodeLL current = this.first;
		
		while (current != null) {
			
			counter++;
			
			current = current.getNext();
			
		}
		
		return counter;
		
	}
	
	public int randomNumberPicker() {
		
		Random random = new Random();
		
		int generatedRandomNumber = random.nextInt(0, countElements());
		
		return generatedRandomNumber;
		
	}
	
}















