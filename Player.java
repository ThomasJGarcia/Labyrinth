

import javax.swing.ImageIcon;

public class Player extends GameObject {
	private boolean key;

	public Player(Level level) {
		super(level, null);
		setIcon(new ImageIcon(getClass().getResource("Player.png")));
		key = false;
	}

	@Override
	public void process(Player p) {
		return;
	}

	public void move(int direction) {
		Location loc = getLocation().getAdjacentLocation(direction);
		Level level = getLevel();
		if (!level.isValid(loc))
			return;
		GameObject obj = level.get(loc);
		if (obj == null) {
			level.remove(getLocation());
			level.set(loc, this);
		} else
			obj.process(this);
		level.changeVisibility();
	}
	
	public boolean hasKey() {
		return key;
	}
	
	public void giveKey() {
		key = true;
	}
	
	public void takeKey() {
		key = false;
	}
}
