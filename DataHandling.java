package week01;

import java.io.*;
import java.util.ArrayList;

public class DataHandling {

	public static ArrayList<String> words = new ArrayList<String>();

	public static ArrayList<String> answers = new ArrayList<String>();

	public static String filePath = "C:\\Users\\Murat Kağan\\eclipse-workspace\\WordGuessr\\src\\week01\\WORDS_AND_ANSWERS.txt";

	public static void readFile(String fileName, ArrayList<String> words, ArrayList<String> answers) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = reader.readLine()) != null) {
				line = line.trim(); // remove leading and trailing spaces
				if (!line.isEmpty()) { // skip empty lines
					String[] parts = line.split("-");
					if (parts.length == 2) {
						words.add(parts[0].trim());
						answers.add(parts[1].trim());
					} else {
						System.err.println("Invalid line format: " + line);
					}
				}
			}
			reader.close();
		} catch (IOException e) {
			System.err.println("Error reading file " + fileName + ": " + e.getMessage());
		}
	}

	public static void assignArrayLists() {

		readFile(filePath, words, answers);

	}

	public static void writeFile(ArrayList<String> lines, String fileName) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

			if (!isFileEmpty(fileName)) {

				writer.newLine();

			}

			for (String line : lines) {
				writer.write(line);
				writer.newLine();
			}
			writer.close();
			System.out.println("File written successfully: " + fileName);
		} catch (IOException e) {
			System.err.println("Error writing file " + fileName + ": " + e.getMessage());
		}
	}

	public static boolean isFileEmpty(String fileName) {
		File file = new File(fileName);
		if (file.length() == 0) {
			return true;
		} else {
			return false;
		}
	}
}
