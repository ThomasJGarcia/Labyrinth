import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


public class MainMenu extends JPanel {

	/**
	 * Create the panel.
	 */
	public MainMenu(Main frame) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		Component verticalStrut1 = Box.createVerticalStrut(200);
		add(verticalStrut1);
		
		JButton newGame = new JButton("New Game");
		newGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		newGame.addActionListener(frame);
		add(newGame);
		
		
		JButton instructions = new JButton("Instructions");
		instructions.setAlignmentX(Component.CENTER_ALIGNMENT);
		instructions.setAlignmentY(Component.TOP_ALIGNMENT);
		instructions.addActionListener(frame);
		
		JButton scoreboard = new JButton("Scoreboard");
		scoreboard.setAlignmentX(Component.CENTER_ALIGNMENT);
		scoreboard.setAlignmentY(Component.TOP_ALIGNMENT);
		scoreboard.addActionListener(frame);
		
		Component verticalStrut3 = Box.createVerticalStrut(20);
		add(verticalStrut3);
		
		Component verticalStrut2 = Box.createVerticalStrut(20);
		add(verticalStrut2);
		add(instructions);
		add(verticalStrut3);
		add(scoreboard);

	}

}
