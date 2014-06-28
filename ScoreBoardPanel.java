import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class ScoreBoardPanel extends JPanel {
	JTextPane textPane;
	
	public ScoreBoardPanel(Main frame) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		textPane = new JTextPane();
		textPane.setText("");
		textPane.setEditable(false);
		add(textPane);

		JButton back = new JButton("Back");
		add(back);

		back.addActionListener(frame);
	}
	
	public void setText(ScoreBoard scoreboard) {
		textPane.setText(scoreboard.toString());
	}
}
