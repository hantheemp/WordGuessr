package week01;

import javax.swing.*;

import java.awt.*;

public class GUI extends JFrame {

	private JLabel questionLabel;

	private JLabel checkingLabel;

	private JLabel livesLabel;

	private JLabel scoreLabel;

	private JButton submitButton;

	private JTextField userInputTextField;

	private JPanel panelForQuestionChecking;

	private JPanel panelForLivesScoreAndButton;

	private int userLives;

	private int userScore;

	public GUI() {

		this.questionLabel = new JLabel("Default Question");

		this.checkingLabel = new JLabel("Default Boolean");

		this.livesLabel = new JLabel("Default 3");

		this.scoreLabel = new JLabel("Default 0");

		this.submitButton = new JButton("Submit");

		this.userInputTextField = new JTextField("Default Text");
		
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

		setSize(400, 300);
		
		setResizable(false);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLocationRelativeTo(null);

		setVisible(false);

	}
	
	public void displayFrame(boolean var) {
		
		if (var == true) {
			
			this.setVisible(true);
			
		}
		
		else {
			
			this.setVisible(false);
			
		}
		
	}

}
