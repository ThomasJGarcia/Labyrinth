
public class LockedDoor extends Door {

	public LockedDoor(Level level) {
		super(level);
	}
	
	public void process(Player p) {
		if(p.hasKey()) {
			p.takeKey();
			super.process(p);
		}
	}

}
