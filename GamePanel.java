
import java.awt.BorderLayout;

import javax.swing.JPanel;


public class GamePanel extends JPanel {
	private Main frame;
	private Level level;
	private LevelPanel view;
	private ClockPanel cpanel;
	private Clock clock;
	
	public static final int EASY = 1;
	public static final int MEDIUM = 2;
	public static final int HARD = 3;

	public GamePanel(Main frame) {
		this.frame = frame;
		setLayout(new BorderLayout());
		view = new LevelPanel();
		add(view, BorderLayout.CENTER);
	}
	
	public void newGame(int difficulty) {
		switch (difficulty) {
		case EASY:
			level = new EasyLevel(20, 20, frame);
			break;
		case MEDIUM:
			level = new MediumLevel(20, 20, frame);
			break;
		case HARD:
			level = new HardLevel(20, 20, frame);
			break;
		}
		level.addObserver(view);
		view.update(level, null);
		clock = new Clock();
		level.addClock(clock);
		cpanel = new ClockPanel();
		clock.addObserver(cpanel);
		add(cpanel, BorderLayout.EAST);
		clock.start();
	}
	
	public Level getLevel() {
		return level;
	}
	
	public void start() {
		clock.start();
	}
}
