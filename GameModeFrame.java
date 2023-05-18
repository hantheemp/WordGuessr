package week01;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class GameModeFrame extends JFrame implements MouseListener {

	private JButton classicMode;

	private JButton memorizeMode;

	private JButton duelMode;

	public GameModeFrame() {

		setLayout(new GridLayout(3, 1));

		this.classicMode = new JButton("Classic");

		this.classicMode.addMouseListener(this);

		this.memorizeMode = new JButton("Memorize!");

		this.duelMode = new JButton("Duel!");

		add(this.classicMode);

		add(this.memorizeMode);

		add(this.duelMode);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);

		setSize(400, 300);

		setTitle("Select Game Mode");

		setLocationRelativeTo(null);

		setVisible(false);

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getSource() == this.classicMode) {

			exit();

			MainMenu.gameGUI.setVisible(true);

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

	public void exit() {

		super.dispose();

	}

	public void exit(JFrame frame) {

		frame.dispose();

	}

}
