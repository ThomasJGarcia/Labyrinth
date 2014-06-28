
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClockPanel extends JPanel implements Observer{
	private Clock clock;
	private JLabel label;
	
	public ClockPanel() {
		label = new JLabel("0:00.00");
		this.add(label);
	}
	
	public void update(Observable o, Object obj) {
		clock = (Clock) o;
		String minutes = "" + clock.getMinutes();
		String seconds = (clock.getSeconds() >= 10) ? "" + clock.getSeconds() : "0" + clock.getSeconds();
		String centis = (clock.getCentis() >= 10) ? "" + clock.getCentis() : "0" + clock.getCentis();
		label.setText(minutes + ":" + seconds + "." + centis);
	}
}
