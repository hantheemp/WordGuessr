package week01;

import java.util.ArrayList;

public class UnitTest {

	public static void main(String[] args) {

		LinkedList ll = new LinkedList();

		ll.addData("Kummerspack", "German");

		ll.addData("Türk", "Türkçe");

		ll.addData("Fragile", "English");

		ll.addData("John Doe", "Jane Doe");

		System.out.println(ll.checkIfEmpty());

		ll.displayData();

		System.out.println("***************");

		System.out.println(ll.deleteData("Türk"));

		ll.displayData();

		System.out.println("****************");

		System.out.println(ll.countElements());

		System.out.println("*****************");

		ll.displayData();

		System.out.println(ll.printKnownData(0));

		System.out.println(ll.printKnownData(1));

		System.out.println(ll.printKnownData(2));

		System.out.println("******************");

		System.out.println(ll.printRandomData(ll.randomNumberPicker()));

		System.out.println("******************");

		System.out.println("******************");

		ArrayList<String> testArr1 = new ArrayList<String>();

		for (int index = 0; index < ll.addQuestionsToArrayList().size(); index++) {

			testArr1.add(ll.addQuestionsToArrayList().get(index));

		}

		for (int index = 0; index < testArr1.size(); index++) {

			System.out.println(testArr1.get(index));

		}

		System.out.println("******************");

		System.out.println("******************");

		ArrayList<String> testArr2 = new ArrayList<String>();

		for (int index = 0; index < ll.addAnswersToArrayList().size(); index++) {

			testArr2.add(ll.addAnswersToArrayList().get(index));

		}

		for (int index = 0; index < testArr2.size(); index++) {

			System.out.println(testArr2.get(index));

		}
		
		System.out.println("******************");

		System.out.println("******************");
		
		ll.sortArrayList(testArr1);
		
		for (int index = 0; index < testArr1.size(); index++) {
			
			System.out.println(testArr1.get(index));
			
		}
	}
}
