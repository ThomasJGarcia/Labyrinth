public class Score implements Comparable<Score> {
	private String name;
	private Time time;

	public Score(String name, Time time) {
		this.name = name;
		this.time = time;
	}
	
	public String getName() {
		return name;
	}
	
	public Time getTime() {
		return time;
	}

	public int compareTo(Score score) {
		return time.compareTo(score.getTime());
	}
}
