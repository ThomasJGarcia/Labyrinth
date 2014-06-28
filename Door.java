import javax.swing.ImageIcon;


public class Door extends GameObject {

	public Door(Level level) {
		super(level, null);
		setIcon(new ImageIcon(getClass().getResource("Door.png")));
	}

	@Override
	public void process(Player p) {
		getLevel().remove(p.getLocation());
		getLevel().set(getLocation(), p);
		getLevel().finished();
	}

}
