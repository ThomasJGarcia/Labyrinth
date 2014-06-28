
import javax.swing.JFrame;

public class TimeFrame extends JFrame {
	private Clock clock;
	private ClockPanel panel;
	
	public TimeFrame() {
		setTitle("Time");
		setSize(800, 600);
		clock = new Clock();
		panel = new ClockPanel();
		clock.addObserver(panel);
		getContentPane().add(panel);
		clock.start();
	}
	
	public static void main(String[] args) {
		TimeFrame frame = new TimeFrame();
		frame.setVisible(true);
	}
}
