import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreBoard {
	private List<Score> scores;
	private String file;
	
	public ScoreBoard(String file) {
		scores = new ArrayList<Score>();
		this.file = file;
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String s = in.readLine();
			while (s != null) {
				String name = s;
				String time = in.readLine();
				int minutes = Integer.parseInt(time.substring(0, time.indexOf(":")));
				int seconds = Integer.parseInt(time.substring(time.indexOf(":") + 1, time.indexOf(".")));
				int centis = Integer.parseInt(time.substring(time.indexOf(".") + 1));
				scores.add(new Score(name, new Time(minutes, seconds, centis)));
				s = in.readLine();
			}
		} catch (Exception e) {
		}
		Collections.sort(scores);
	}

	public void add(Score s) {
		scores.add(s);
		Collections.sort(scores);
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
			out.append(s.getName());
			out.newLine();
			out.append(s.getTime().toString());
			out.newLine();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Score get(int index) {
		return scores.get(index);
	}

	public int size() {
		return scores.size();
	}
	
	public String toString() {
		String s = "Name\tTime\n";
		for(Score score : scores)
			s += score.getName() + "\t" + score.getTime() + "\n";
		return s;
	}

}
