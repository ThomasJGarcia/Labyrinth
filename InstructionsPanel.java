import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class InstructionsPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public InstructionsPanel(Main frame) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JTextPane textPane = new JTextPane();
		textPane.setText("Instructions:\nNavigate the maze using the arrow keys, and escape through the door.\n" +
				"In easy difficulty, you can see the entire maze. In medium difficulty, you can see what is in your current line of sight, and any part of the maze that you could see at an earlier point in time. In hard difficulty, you can only see blocks in your current line of sight, and you must find the hidden key before you can open the door.\n" +
				"Once you finish the game, enter your name and your score will be added to the scoreboard.");
		textPane.setEditable(false);
		add(textPane);

		JButton back = new JButton("Back");
		add(back);

		back.addActionListener(frame);

	}

}
