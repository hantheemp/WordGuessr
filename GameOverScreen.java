package week01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameOverScreen extends JFrame implements MouseListener {

	private MainMenu mm = new MainMenu();

	private JButton exitButton;

	private JButton mainMenuButton;

	private JButton retryButton;

	private JButton lastButtonPressed;

	public static final int EXIT = -1;

	public static final int MAIN_MENU = 0;

	public static final int RETRY = 1;

	public static int OPERATION_VALUE;

	public GameOverScreen() {

		setResizable(false);
		setTitle("Game Over");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// JLabel at the top
		JLabel gameOverLabel = new JLabel("Game Over");
		gameOverLabel.setFont(new Font("Arial", Font.BOLD, 20));
		gameOverLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(gameOverLabel, BorderLayout.NORTH);

		// JPanel for the buttons stacked in a flow layout
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());

		// Main Menu Button
		mainMenuButton = new JButton("Main Menu");
		this.mainMenuButton.addMouseListener(this);
		mainMenuButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Handle main menu button click event
				// Add your code here
			}
		});
		buttonPanel.add(mainMenuButton);

		// Retry Button
		retryButton = new JButton("Retry");
		this.retryButton.addMouseListener(this);
		retryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Handle retry button click event
				// Add your code here
			}
		});
		buttonPanel.add(retryButton);

		// Exit Button
		exitButton = new JButton("Exit");
		this.exitButton.addMouseListener(this);
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Handle exit button click event
				// Add your code here
			}
		});
		buttonPanel.add(exitButton);

		add(buttonPanel, BorderLayout.CENTER);

		pack();
		setLocationRelativeTo(null); // Center the frame on the screen
		setVisible(false);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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