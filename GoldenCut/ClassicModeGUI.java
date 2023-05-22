package week01;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class ClassicModeGUI extends JFrame implements MouseListener {

	private RandomDataClass rdc;

	private ArrayList<String> words;

	private ArrayList<String> answers;

	private JLabel questionLabel;

	private JLabel checkingLabel;

	private JLabel livesLabel;

	private JLabel scoreLabel;

	private JButton submitButton;

	private JTextField userInputTextField;

	private JPanel panelForQuestionChecking;

	private JPanel panelForLivesScoreAndButton;

	private GameOverScreen gos;

	private int userLives = 3;

	private int userScore = 0;

	private int randomIndexForQANDA = RandomDataClass.returnRandomQuestionAndAnswerIndex();

	public ClassicModeGUI() {

		this.rdc = new RandomDataClass();

		this.gos = new GameOverScreen();

		this.words = new ArrayList<String>();

		this.answers = new ArrayList<String>();

		DataHandling.readFile(DataHandling.filePath, words, answers);

		this.questionLabel = new JLabel("Default Question");

		this.checkingLabel = new JLabel("");

		this.livesLabel = new JLabel("Lives : " + this.userLives);

		this.scoreLabel = new JLabel("Score : " + this.userScore);

		this.submitButton = new JButton("Submit");

		this.submitButton.addMouseListener(this);

		this.userInputTextField = new JTextField("Enter your answer...");

		this.panelForQuestionChecking = new JPanel();

		this.panelForLivesScoreAndButton = new JPanel();

		panelForQuestionChecking.setLayout(new FlowLayout());

		panelForLivesScoreAndButton.setLayout(new FlowLayout());

		panelForQuestionChecking.add(questionLabel);

		panelForQuestionChecking.add(checkingLabel);

		panelForLivesScoreAndButton.add(scoreLabel);

		panelForLivesScoreAndButton.add(livesLabel);

		panelForLivesScoreAndButton.add(submitButton);

		setLayout(new BorderLayout());

		add(panelForQuestionChecking, BorderLayout.NORTH);

		add(userInputTextField, BorderLayout.CENTER);

		add(panelForLivesScoreAndButton, BorderLayout.SOUTH);

		createDefaultWindow();

	}

	public void createDefaultWindow() {

		updateQuestionLabel();

		setSize(400, 300);

		setResizable(false);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLocationRelativeTo(null);

		setVisible(false);

	}

	public void resetLives() {

		this.livesLabel.setText("Lives : " + this.userLives);

	}

	public void resetScore() {

		this.scoreLabel.setText("Score : " + this.userScore);

	}

	public void displayFrame(boolean var) {

		if (var == true) {

			this.setVisible(true);

		}

		else {

			this.setVisible(false);

		}

	}

	public void increaseUserScore(boolean bool) {

		if (bool) {

			this.userScore += 10;

			this.scoreLabel.setText(this.userScore + "");

		}

	}

	public void decreaseUserLives(boolean bool) {

		if (bool) {

			this.userLives--;

			this.livesLabel.setText(this.userLives + "");

		}

	}

	public void updateQuestionLabel() {

		this.questionLabel.setText(DataHandling.words.get(this.randomIndexForQANDA));

	}

	public int getUserLives() {
		return userLives;
	}

	public void setUserLives(int userLives) {
		this.userLives = userLives;
	}

	public int getUserScore() {
		return userScore;
	}

	public void setUserScore(int userScore) {
		this.userScore = userScore;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getSource() == this.submitButton) {

			if (this.userLives > 1) {

				String userAnswer = this.userInputTextField.getText();

				if (userAnswer.equals(DataHandling.answers.get(this.randomIndexForQANDA))) {

					this.checkingLabel.setText("Correct!");

					this.randomIndexForQANDA = RandomDataClass.returnRandomQuestionAndAnswerIndex();

					increaseUserScore(true);

					updateQuestionLabel();

				}

				else {

					this.checkingLabel.setText("Incorrect!");

					this.randomIndexForQANDA = RandomDataClass.returnRandomQuestionAndAnswerIndex();

					decreaseUserLives(true);

					updateQuestionLabel();

				}

			}

			else {

				dispose();

				gos.setVisible(true);

			}

		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
