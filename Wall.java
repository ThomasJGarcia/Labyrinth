
import javax.swing.ImageIcon;

public class Wall extends GameObject {

	public Wall(Level level) {
		super(level, null);
		setIcon(new ImageIcon(getClass().getResource("Wall.png")));
	}

	@Override
	public void process(Player p) {
		return;
	}

}
