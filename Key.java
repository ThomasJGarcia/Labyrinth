import javax.swing.ImageIcon;


public class Key extends GameObject {

	public Key(Level level) {
		super(level, null);
		setIcon(new ImageIcon(getClass().getResource("Key.png")));
	}

	@Override
	public void process(Player p) {
		p.giveKey();
		getLevel().remove(p.getLocation());
		getLevel().set(getLocation(), p);
	}
}