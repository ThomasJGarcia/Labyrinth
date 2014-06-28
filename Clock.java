import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.Timer;

public class Clock extends Observable implements ActionListener{
	private int minutes;
	private int seconds;
	private int centis;
	private Timer timer;
	public static final int INTERVAL = 10;
	
	public Clock() {
		minutes = 0;
		seconds = 0;
		centis = 0;
		timer = new Timer(INTERVAL, this);
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
	
	public void start() {
		timer.start();
	}
	
	public void stop() {
		timer.stop();
	}
	
	public Time getTime() {
		return new Time(minutes, seconds, centis);
	}
	
	public void reset() {
		timer.stop();
		minutes = 0;
		seconds = 0;
		centis = 0;
		setChanged();
		notifyObservers();
	}
	
	public void actionPerformed(ActionEvent e){
		centis++;
		if(centis >= 100) {
			seconds++;
			centis -= 100;
			if(seconds >= 60)
			{
				minutes++;
				seconds -= 60;
			}
		}
		setChanged();
		notifyObservers();
	}
}
