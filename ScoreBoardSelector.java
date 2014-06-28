import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


public class ScoreBoardSelector extends JPanel {
	public ScoreBoardSelector(Main frame) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		Component verticalStrut1 = Box.createVerticalStrut(175);
		Component verticalStrut2 = Box.createVerticalStrut(20);
		Component verticalStrut3 = Box.createVerticalStrut(20);
		Component verticalStrut4 = Box.createVerticalStrut(20);
		JButton easy = new JButton("Easy Scores");
		JButton medium = new JButton("Medium Scores");
		JButton hard = new JButton("Hard Scores");
		JButton back = new JButton("Back");
		easy.addActionListener(frame);
		medium.addActionListener(frame);
		hard.addActionListener(frame);
		back.addActionListener(frame);
		easy.setAlignmentX(CENTER_ALIGNMENT);
		medium.setAlignmentX(CENTER_ALIGNMENT);
		hard.setAlignmentX(CENTER_ALIGNMENT);
		back.setAlignmentX(CENTER_ALIGNMENT);
		add(verticalStrut1);
		add(easy);
		add(verticalStrut2);
		add(medium);
		add(verticalStrut3);
		add(hard);
		add(verticalStrut4);
		add(back);
	}
}
