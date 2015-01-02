public class MediumLevel extends Level {

	public MediumLevel(int width, int height, Main frame) {
		super(width, height, frame);
		changeVisibility();
	}

	public MediumLevel(String file) {
		super(file);
		Location loc = getPlayer().getLocation();
		for (int y = loc.getY() - 1; y <= loc.getY() + 1; y++)
			for (int x = loc.getX() - 1; x <= loc.getX() + 1; x++)
				setVisible(new Location(x, y), true);
	}
	
	public int getDifficulty() {
		return GamePanel.MEDIUM;
	}

	@Override
	public void changeVisibility() {
		Location loc = getPlayer().getLocation();
		setVisible(loc, true);
		recursiveSetVisible(loc.getAdjacentLocation(Location.LEFT),
				Location.LEFT);
		recursiveSetVisible(loc.getAdjacentLocation(Location.RIGHT),
				Location.RIGHT);
		recursiveSetVisible(loc.getAdjacentLocation(Location.UP), Location.UP);
		recursiveSetVisible(loc.getAdjacentLocation(Location.DOWN),
				Location.DOWN);
	}

	public void recursiveSetVisible(Location loc, int direction) {
		setVisible(loc, true);
		if (direction == Location.LEFT || direction == Location.RIGHT) {
			setVisible(loc.getAdjacentLocation(Location.UP), true);
			setVisible(loc.getAdjacentLocation(Location.DOWN), true);
		} else {
			setVisible(loc.getAdjacentLocation(Location.LEFT), true);
			setVisible(loc.getAdjacentLocation(Location.RIGHT), true);
		}
		if (!(get(loc) instanceof Wall)) {
			Location nextLoc = loc.getAdjacentLocation(direction);
			if (isValid(nextLoc))
				recursiveSetVisible(nextLoc, direction);
		}
	}

}
