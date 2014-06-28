
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


public abstract class Level extends Observable {
	private Main frame;
	private int width;
	private int height;
	private Player player;
	private Clock clock;
	protected Door door;
	private GameObject[][] grid;
	protected boolean[][] visibleGrid;

	public Level(int width, int height, Main frame) {
		this.frame = frame;
		this.width = width;
		this.height = height;
		grid = new GameObject[height][width];
		visibleGrid = new boolean[height][width];
		for (int r = 0; r < height; r++)
			for (int c = 0; c < width; c++)
				set(new Location(c, r), new Wall(this));
		Location playerLoc = new Location((int) (Math.random() * width),
				(int) (Math.random() * height));
		player = new Player(this);
		door = new Door(this);
		set(playerLoc, player);
		List<Location> wallList = new ArrayList<Location>();
		List<Location> adjLocs = new ArrayList<Location>();
		wallList.add(new Location(playerLoc.getX() - 1, playerLoc.getY()));
		adjLocs.add(new Location(wallList.get(wallList.size() - 1).getX() - 1,
				wallList.get(wallList.size() - 1).getY()));
		wallList.add(new Location(playerLoc.getX() + 1, playerLoc.getY()));
		adjLocs.add(new Location(wallList.get(wallList.size() - 1).getX() + 1,
				wallList.get(wallList.size() - 1).getY()));
		wallList.add(new Location(playerLoc.getX(), playerLoc.getY() - 1));
		adjLocs.add(new Location(wallList.get(wallList.size() - 1).getX(),
				wallList.get(wallList.size() - 1).getY() - 1));
		wallList.add(new Location(playerLoc.getX(), playerLoc.getY() + 1));
		adjLocs.add(new Location(wallList.get(wallList.size() - 1).getX(),
				wallList.get(wallList.size() - 1).getY() + 1));
		Location doorLoc = null;
		while (wallList.size() > 0) {
			int index = (int) (Math.random() * wallList.size());
			Location loc = wallList.get(index);
			Location nextLoc = adjLocs.get(index);
			if (get(nextLoc) instanceof Wall && get(loc) instanceof Wall && nextLoc.getX() > 0 && nextLoc.getX() < width - 1 && nextLoc.getY() > 0 && nextLoc.getY() < height - 1) {
				doorLoc = nextLoc;
				set(loc, null);
				set(nextLoc, null);
				wallList.remove(index);
				adjLocs.remove(index);
				wallList.add(new Location(nextLoc.getX() - 1, nextLoc.getY()));
				adjLocs.add(new Location(wallList.get(wallList.size() - 1)
						.getX() - 1, wallList.get(wallList.size() - 1).getY()));
				wallList.add(new Location(nextLoc.getX() + 1, nextLoc.getY()));
				adjLocs.add(new Location(wallList.get(wallList.size() - 1)
						.getX() + 1, wallList.get(wallList.size() - 1).getY()));
				wallList.add(new Location(nextLoc.getX(), nextLoc.getY() - 1));
				adjLocs.add(new Location(wallList.get(wallList.size() - 1)
						.getX(), wallList.get(wallList.size() - 1).getY() - 1));
				wallList.add(new Location(nextLoc.getX(), nextLoc.getY() + 1));
				adjLocs.add(new Location(wallList.get(wallList.size() - 1)
						.getX(), wallList.get(wallList.size() - 1).getY() + 1));
			} else {
				wallList.remove(index);
				adjLocs.remove(index);
			}
		}
		set(doorLoc, door);
	}

	public Level(String file) {
		width = 0;
		List<String> list = new ArrayList<String>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String s = in.readLine();
			while (s != null) {
				list.add(s);
				width = (s.length() > width) ? s.length() : width;
				s = in.readLine();
			}
		} catch (Exception e) {
		}
		height = list.size();
		grid = new GameObject[height][width];
		for (int r = 0; r < list.size(); r++) {
			for (int c = 0; c < list.get(r).length(); c++) {
				switch (list.get(r).charAt(c)) {
				case 'X':
					set(new Location(c, r), new Wall(this));
					break;
				case 'D':
					set(new Location(c, r), new Door(this));
					break;
				case 'P':
					player = new Player(this);
					set(new Location(c, r), player);
					break;
				}
			}
		}
		visibleGrid = new boolean[height][width];
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Player getPlayer() {
		return player;
	}

	public void addClock(Clock clock) {
		this.clock = clock;
	}

	public boolean isValid(Location loc) {
		if (loc.getX() >= 0 && loc.getX() < grid[0].length)
			if (loc.getY() >= 0 && loc.getY() < grid.length)
				return true;
		return false;
	}

	public boolean isVisible(Location loc) {
		return visibleGrid[loc.getY()][loc.getX()];
	}

	protected void setVisible(Location loc, boolean visible) {
		if (isValid(loc))
			visibleGrid[loc.getY()][loc.getX()] = visible;
		setChanged();
		notifyObservers();
	}

	public abstract void changeVisibility();

	public GameObject get(Location loc) {
		return (isValid(loc)) ? grid[loc.getY()][loc.getX()] : null;
	}

	public GameObject set(Location loc, GameObject obj) {
		if (!isValid(loc))
			return null;
		GameObject oldObj = grid[loc.getY()][loc.getX()];
		grid[loc.getY()][loc.getX()] = obj;
		if (obj != null)
			obj.setLocation(loc);
		setChanged();
		notifyObservers();
		return oldObj;
	}

	public GameObject remove(Location loc) {
		if (!isValid(loc))
			return null;
		GameObject obj = grid[loc.getY()][loc.getX()];
		grid[loc.getY()][loc.getX()] = null;
		obj.setLocation(null);
		setChanged();
		notifyObservers();
		return obj;
	}

	public void finished() {
		clock.stop();
		frame.scoreEntry(clock.getTime());
	}
	
	public abstract int getDifficulty();
}
