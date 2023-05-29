package week01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MemorizeMode extends JFrame {
	private static ArrayList<String> wordList1 = new ArrayList<>();
	private static ArrayList<String> wordList2 = new ArrayList<>();

	private static JLabel wordLabel;
	private static JTextField textField;

	private static List<String> displayedWords = new ArrayList<>();
	private static int successfulAttempts = 0;
	private static int maxAttempts = 3;
	private static int currentAttempts = 0;
	private static boolean gameOver = false;

	public static void main(String[] args) {
		DataHandling.assignArrayLists();

		// Assuming you have already populated the word lists in the DataHandling class
		wordList1 = DataHandling.words;
		wordList2 = DataHandling.answers;

		SwingUtilities.invokeLater(() -> {
			MemorizeMode gameMode = new MemorizeMode();
			gameMode.createAndShowGUI();
		});
	}

	private void createAndShowGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Word Game");

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		wordLabel = new JLabel();
		wordLabel.setHorizontalAlignment(JLabel.CENTER);
		wordLabel.setFont(new Font("Arial", Font.BOLD, 24));

		mainPanel.add(wordLabel, BorderLayout.CENTER);

		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout());

		textField = new JTextField(20);
		inputPanel.add(textField);

		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkAnswer();
			}
		});
		inputPanel.add(submitButton);

		mainPanel.add(inputPanel, BorderLayout.SOUTH);

		add(mainPanel);
		setSize(400, 200);
		setLocationRelativeTo(null);
		setVisible(true);

		displayWords();
	}

	private static void displayWords() {
		if (wordList1.isEmpty() || wordList2.isEmpty()) {
			System.out.println("One or both word lists are empty.");
			return;
		}

		new Thread(() -> {
			while (!gameOver) {
				try {
					currentAttempts = 0;
					displayedWords.clear();

					// Display initial 3 words
					for (int i = 0; i < 3; i++) {
						String word = getRandomWord();
						displayedWords.add(word);
						SwingUtilities.invokeLater(() -> wordLabel.setText(word));
						Thread.sleep(1000);
					}

					// Clear the label
					SwingUtilities.invokeLater(() -> wordLabel.setText(""));

					// Allow user to enter answers
					gameOver = false;
					textField.setEditable(true);
					textField.requestFocus();

					// Wait for user input or game over condition
					while (!gameOver && currentAttempts < displayedWords.size()) {
						Thread.sleep(100);
					}

					// Clear the label and disable user input
					SwingUtilities.invokeLater(() -> wordLabel.setText(""));
					textField.setEditable(false);

					if (currentAttempts < displayedWords.size()) {
						successfulAttempts++;
						if (successfulAttempts % maxAttempts == 0) {
							for (int i = 0; i < successfulAttempts / maxAttempts + 3; i++) {
								displayedWords.add(getRandomWord());
							}
						}
					} else if (currentAttempts == displayedWords.size()) {
						successfulAttempts++;
						if (successfulAttempts % maxAttempts == 0) {
							for (int i = 0; i < successfulAttempts / maxAttempts + 3; i++) {
								displayedWords.add(getRandomWord());
							}
						}
					} else {
						gameOver = true;
						SwingUtilities.invokeLater(() -> wordLabel.setText("Game Over"));
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	private static String getRandomWord() {
		Random random = new Random();
		int index = random.nextInt(wordList1.size());
		return wordList1.get(index);
	}

	private static void checkAnswer() {
		if (!displayedWords.isEmpty()) {
			String userInput = textField.getText().trim();
			if (userInput.equals(displayedWords.get(currentAttempts))) {
				currentAttempts++;
				textField.setText("");
			} else {
				gameOver = true;
				SwingUtilities.invokeLater(() -> wordLabel.setText("Game Over"));
				textField.setEditable(false);
			}
		}
	}
}
