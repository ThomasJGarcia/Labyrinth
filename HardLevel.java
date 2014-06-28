
public class HardLevel extends MediumLevel {

	public HardLevel(int width, int height, Main frame) {
		super(width, height, frame);
		Location doorLoc = door.getLocation();
		remove(doorLoc);
		set(doorLoc, new LockedDoor(this));
		boolean keyPlaced = false;
		while (!keyPlaced) {
			Location keyLoc = new Location((int) (Math.random() * getWidth()),
					(int) (Math.random() * getHeight()));
			if (get(keyLoc) == null) {
				set(keyLoc, new Key(this));
				keyPlaced = true;
			}
		}
	}

	public HardLevel(String file) {
		super(file);
	}

	@Override
	public void changeVisibility() {
		visibleGrid = new boolean[getHeight()][getWidth()];
		super.changeVisibility();
	}

	public int getDifficulty() {
		return GamePanel.HARD;
	}
}
