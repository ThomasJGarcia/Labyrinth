public class Time implements Comparable<Time> {
	private int minutes;
	private int seconds;
	private int centis;

	public Time(int minutes, int seconds, int centis) {
		this.minutes = minutes;
		this.seconds = seconds;
		this.centis = centis;
	}

	public int getMinutes() {
		return minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public int getCentis() {
		return centis;
	}

	public int compareTo(Time t) {
		if (minutes - t.getMinutes() != 0)
			return minutes - t.getMinutes();
		else if (seconds - t.getSeconds() != 0)
			return seconds - t.getSeconds();
		else
			return centis - t.getCentis();
	}
	
	public String toString() {
		String minutes = "" + getMinutes();
		String seconds = (getSeconds() >= 10) ? "" + getSeconds() : "0" + getSeconds();
		String centis = (getCentis() >= 10) ? "" + getCentis() : "0" + getCentis();
		return minutes + ":" + seconds + "." + centis;
	}
}
