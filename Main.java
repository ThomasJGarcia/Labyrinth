import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Main extends JFrame implements ActionListener, KeyListener {
	private MainMenu mMenu;
	private DifficultyMenu diffMenu;
	private InstructionsPanel instructions;
	private ScoreBoardSelector scoreSelector;
	private ScoreBoardPanel scorePanel;
	private ScoreBoard easyScores;
	private ScoreBoard mediumScores;
	private ScoreBoard hardScores;
	private ScoreEntryPanel scoreEntry;
	private GamePanel game;

	public static final int HEIGHT_ERROR_CORRECTION = 25;

	public Main() {
		setTitle("Labyrinth");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		getContentPane().setLayout(new CardLayout());
		mMenu = new MainMenu(this);
		getContentPane().add(mMenu, "Main Menu");
		diffMenu = new DifficultyMenu(this);
		getContentPane().add(diffMenu, "Difficulty Menu");
		instructions = new InstructionsPanel(this);
		getContentPane().add(instructions, "Instructions");
		scoreSelector = new ScoreBoardSelector(this);
		getContentPane().add(scoreSelector, "Scoreboard");
		scorePanel = new ScoreBoardPanel(this);
		getContentPane().add(scorePanel, "Scores");
		easyScores = new ScoreBoard("easy.scores");
		mediumScores = new ScoreBoard("medium.scores");
		hardScores = new ScoreBoard("hard.scores");
		scoreEntry = new ScoreEntryPanel(this);
		getContentPane().add(scoreEntry, "Score Entry");
		game = new GamePanel(this);
		getContentPane().add(game, "Game Panel");
		addKeyListener(this);
	}

	public static void main(String[] args) {
		Main frame = new Main();
		frame.setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Player p = game.getLevel().getPlayer();
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			p.move(Location.UP);
			break;
		case KeyEvent.VK_LEFT:
			p.move(Location.LEFT);
			break;
		case KeyEvent.VK_DOWN:
			p.move(Location.DOWN);
			break;
		case KeyEvent.VK_RIGHT:
			p.move(Location.RIGHT);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("New Game"))
			((CardLayout) getContentPane().getLayout()).show(getContentPane(),
					"Difficulty Menu");
		else if (e.getActionCommand().equals("Instructions"))
			((CardLayout) getContentPane().getLayout()).show(getContentPane(),
					"Instructions");
		else if (e.getActionCommand().equals("Scoreboard"))
			((CardLayout) getContentPane().getLayout()).show(getContentPane(),
					"Scoreboard");
		else if (e.getActionCommand().equals("Easy")) {
			game.newGame(GamePanel.EASY);
			((CardLayout) getContentPane().getLayout()).show(getContentPane(),
					"Game Panel");
		} else if (e.getActionCommand().equals("Medium")) {
			game.newGame(GamePanel.MEDIUM);
			((CardLayout) getContentPane().getLayout()).show(getContentPane(),
					"Game Panel");
		} else if (e.getActionCommand().equals("Hard")) {
			game.newGame(GamePanel.HARD);
			((CardLayout) getContentPane().getLayout()).show(getContentPane(),
					"Game Panel");
		} else if (e.getActionCommand().equals("Back"))
			((CardLayout) getContentPane().getLayout()).show(getContentPane(),
					"Main Menu");
		else if (e.getActionCommand().equals("Easy Scores")) {
			((CardLayout) getContentPane().getLayout()).show(getContentPane(),
					"Scores");
			scorePanel.setText(easyScores);
		} else if (e.getActionCommand().equals("Medium Scores")) {
			((CardLayout) getContentPane().getLayout()).show(getContentPane(),
					"Scores");
			scorePanel.setText(mediumScores);
		} else if (e.getActionCommand().equals("Hard Scores")) {
			((CardLayout) getContentPane().getLayout()).show(getContentPane(),
					"Scores");
			scorePanel.setText(hardScores);
		}
		else if(e.getActionCommand().equals("Enter")) {
			Score s = scoreEntry.getScore();
			int difficulty = game.getLevel().getDifficulty();
			if(difficulty == GamePanel.EASY)
				easyScores.add(s);
			else if(difficulty == GamePanel.MEDIUM)
				mediumScores.add(s);
			else if(difficulty == GamePanel.HARD)
				hardScores.add(s);
			((CardLayout) getContentPane().getLayout()).show(getContentPane(),
					"Main Menu");
		}
		this.requestFocus();
	}
	
	public void scoreEntry(Time t) {
		((CardLayout) getContentPane().getLayout()).show(getContentPane(),
				"Score Entry");
		scoreEntry.setTime(t);
		this.requestFocus();
	}
}
