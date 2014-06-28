
public class EasyLevel extends Level {

	public EasyLevel(int width, int height, Main frame) {
		super(width, height, frame);
		for (int r = 0; r < getHeight(); r++)
			for (int c = 0; c < getWidth(); c++)
				visibleGrid[r][c] = true;
	}

	public EasyLevel(String file) {
		super(file);
		for (int r = 0; r < getHeight(); r++)
			for (int c = 0; c < getWidth(); c++)
				visibleGrid[r][c] = true;
	}

	public void changeVisibility() {
	}
	
	public int getDifficulty() {
		return GamePanel.EASY;
	}
}
