package week01;

import java.util.ArrayList;
import java.util.Collections;
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

	public boolean checkIfEmpty() { // Method checks if the created LinkedList object has values assigned to it or
									// not.

		if (this.first == null) {

			return true;

		}

		return false;

	}

	public void displayData() { // Method displays whole list.

		NodeLL current = this.first;

		while (current != null) {

			System.out.println("Question : " + current.getQuestion() + "\nAnswer : " + current.getAnswer());

			current = current.getNext();

		}

	}

	public void addData(String question, String answer) { // Method adds data to LinkedList structure.

		if (this.first == null) {

			this.first = this.last = new NodeLL(question, answer, null, null);

		}

		else {

			NodeLL newNode = new NodeLL(question, answer, this.last, null);

			this.last.setNext(newNode);

			this.last = newNode;

		}

	}

	public boolean deleteData(String question) { // Method checks the list and compares every data with the user data.
													// If there is a matching sequence, it removes the corresponding
													// NodeLL object from the list.

		NodeLL current = this.first;

		NodeLL parent = null;

		while (current != null) {

			if (current.getQuestion().equals(question)) {

				current.getPrev().setNext(current.getNext());

				current.getNext().setPrev(current.getPrev());

				return true;

			}

			else {

				current = current.getNext();

			}

		}

		return false;

	}

	public int countElements() { // Methods counts the number of elements in the created LinkedList object.

		int counter = 0;

		NodeLL current = this.first;

		while (current != null) {

			counter++;

			current = current.getNext();

		}

		return counter;

	}

	public int randomNumberPicker() { // This method is a helper for other method. It helps to pick a random data from
										// the LinkedList object.

		Random random = new Random();

		int generatedRandomNumber = random.nextInt(0, countElements());

		return generatedRandomNumber;

	}

	public NodeLL printKnownData(int knownFactor) { // This method is a helper method for printing random element.

		if (!checkIfEmpty()) {

			NodeLL current = this.first;

			int counter = knownFactor;

			while (current != null && counter > 0) {

				current = current.getNext();

				counter--;

			}

			return current;

		}

		return null;

	}

	public NodeLL printRandomData(int randomFactor) { // This method is designed for printing a random element from the
														// LinkedList Structure.

		if (!checkIfEmpty()) {

			return printKnownData(randomFactor);

		}

		else {

			return null;

		}

	}

	public ArrayList<String> addQuestionsToArrayList() { // Method convert question list from LinkedList form to
															// ArrayList form.

		ArrayList<String> questionArr = new ArrayList<String>();

		NodeLL current = this.first;

		while (current != null) {

			questionArr.add(current.getQuestion());

			current = current.getNext();

		}

		return questionArr;

	}

	public ArrayList<String> addAnswersToArrayList() { // Method convert question list from LinkedList form to ArrayList
														// form.

		ArrayList<String> answersArr = new ArrayList<String>();

		NodeLL current = this.first;

		while (current != null) {

			answersArr.add(current.getAnswer());

			current = current.getNext();

		}

		return answersArr;

	}

	public void sortArrayList(ArrayList<String> arr) { // This method organizes the data for the desired attribute.

		Collections.sort(arr);

	}

}
