import javax.swing.ImageIcon;



public abstract class GameObject {
	private Location loc;
	private Level level;
	private ImageIcon icon;

	public GameObject(Level level, ImageIcon icon) {
		this.loc = null;
		this.level = level;
		this.icon = icon;
	}

	public Location getLocation() {
		return loc;
	}
	
	public Level getLevel() {
		return level;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setLocation(Location loc) {
		this.loc = loc;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	public abstract void process(Player p);
}
