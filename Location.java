public class Location {
	private int x;
	private int y;

	public static final int UP = 0;
	public static final int LEFT = 1;
	public static final int RIGHT = 2;
	public static final int DOWN = 3;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Location getAdjacentLocation(int direction) {
		switch (direction) {
		case UP:
			return new Location(x, y - 1);
		case LEFT:
			return new Location(x - 1, y);
		case RIGHT:
			return new Location(x + 1, y);
		case DOWN:
			return new Location(x, y + 1);
		default:
			return null;
		}
		
	}
}
