package week01;

import java.util.*;

public class RandomDataClass {

	public RandomDataClass() {

	}

	public static int returnRandomQuestionAndAnswerIndex() {

		Random random = new Random();

		DataHandling.assignArrayLists();

		int temporary = random.nextInt(DataHandling.words.size());

		return temporary;

	}

}
