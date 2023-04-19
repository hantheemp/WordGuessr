package week01;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MainMenu extends JFrame {
	
	private GUI gameGUI;

	private JFrame infoFrame;

	private JButton playButton;

	private JButton howToPlayButton;

	private JButton exitButton;

	private JPanel buttonHolderPanel;

	private ImageIcon playButtonIcon;

	private ImageIcon howToPlayButtonIcon;

	private ImageIcon exitButtonIcon;

	public MainMenu() {
		
		this.gameGUI = new GUI();

		this.infoFrame = new JFrame();

		createDefaultWindow();

		this.playButton = new JButton("Play");
		
		this.playButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				gameGUI.displayFrame(true);
				
			}
		});

		this.howToPlayButton = new JButton("How to Play");

		this.howToPlayButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				howToPlay();

			}
		});

		this.exitButton = new JButton("Quit");

		this.exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				exit(infoFrame);
				
				exit(gameGUI);

				exit();

			}
		});

		this.buttonHolderPanel = new JPanel();

		this.buttonHolderPanel.setLayout(new GridLayout(3, 1));

		this.buttonHolderPanel.add(playButton);

		this.buttonHolderPanel.add(howToPlayButton);

		this.buttonHolderPanel.add(exitButton);

		setLayout(new BorderLayout());

		add(buttonHolderPanel, BorderLayout.CENTER);

		setVisible(true);

	}

	public void createDefaultWindow() {

		setSize(400, 300);

		setResizable(false);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLocationRelativeTo(null);

		setVisible(true);

	}

	public void howToPlay() { // Info frame is created to explain player how to play the game.

		infoFrame.setSize(400, 300);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JLabel infoLabel = new JLabel(
				"<html><div style='text-align: center;'>This game is a mind training puzzle based on your language skills. "
						+ "Each round, you will encounter a different word randomly selected from our database. "
						+ "Your main goal is to try to guess where the word comes from which language. "
						+ "</div></html>");

		infoLabel.setFont(new Font("Arial", Font.BOLD, 16));

		infoFrame.setLayout(new BorderLayout());

		infoFrame.add(infoLabel);
		
		infoFrame.setResizable(false);

		infoFrame.setLocationRelativeTo(null);

		infoFrame.setVisible(true);

	}

	public void exit() { // This method is used for closing the related JFrame Objects.

		super.dispose();

	}

	public void exit(JFrame frame) { // This overriden method helps us to clear all JFrame object if user clicks Quit
										// Button.

		frame.dispose();

	}

}
