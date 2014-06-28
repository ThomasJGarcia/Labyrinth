import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ScoreEntryPanel extends JPanel {
	private JTextField textField;
	private Time time;

	/**
	 * Create the panel.
	 */
	public ScoreEntryPanel(Main frame) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel lblEnterYourName = new JLabel("Enter Your Name:");
		add(lblEnterYourName);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 200));
		add(rigidArea);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);
		textField.setSize(100, 25);

		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 200));
		add(rigidArea_1);
		
		JButton btnEnter = new JButton("Enter");
		add(btnEnter);
		btnEnter.addActionListener(frame);
		
	}
	
	public void setTime(Time t) {
		time = t;
	}
	
	public Score getScore() {
		String name = textField.getText();
		textField.setText("");
		return new Score(name, time);
	}

}
