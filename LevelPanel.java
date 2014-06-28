
import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;


public class LevelPanel extends JPanel implements Observer {
	private Level level;
	public static final int SIDE_LENGTH = 25;

	public LevelPanel() {
		setBackground(Color.BLACK);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int width = level.getWidth();
		int height = level.getHeight();
		for (int y = 0; y < height; y++)
			for (int x = 0; x < width; x++) {
				Location loc = new Location(x, y);
				if (level.isVisible(loc)) {
					GameObject obj = level.get(loc);
					if (obj != null)
						obj.getIcon().paintIcon(this, g, x * SIDE_LENGTH,
								y * SIDE_LENGTH);
					else {
						g.setColor(Color.WHITE);
						g.fillRect(x * SIDE_LENGTH, y * SIDE_LENGTH,
								SIDE_LENGTH, SIDE_LENGTH);
					}
				}
			}
	}

	@Override
	public void update(Observable o, Object obj) {
		level = (Level) o;
		repaint();
	}

}
