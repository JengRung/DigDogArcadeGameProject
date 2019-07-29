import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * 
 * @author Jeng-Rung Tu, Yinzhe Zhang
 *
 */
public class GameBoard {

	private LevelProvider levelP;
	private GameComponent component;
	private int level;
	JFrame frame;
	protected Hero hero;
	protected GameStatus gameStatus;

	public GameBoard(int lev) {
		this.level = lev;
		this.levelP = new LevelProvider(level);
		this.frame = new JFrame("Arcade Game");
		this.hero = new Hero();
		frame.setSize(1500, 1200);
		this.gameStatus = new GameStatus(this);

		this.component = new GameComponent(levelP.getLevel(), this, this.hero);

		this.frame.add(this.component, BorderLayout.CENTER);
		this.frame.add(this.gameStatus.label, BorderLayout.NORTH);

		HeroListener Hlistener = new HeroListener(this.hero, this.gameStatus);
		this.frame.addKeyListener(Hlistener);
		Timer myTimer = new Timer(160, Hlistener);
		myTimer.start();

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public int getLevel() {
		return this.level;
	}

	public int getHeroLife() {
		return this.hero.heroLife;
	}

	public GameStatus getStatus() {
		return this.gameStatus;
	}

	public void Pause() {
		if (this.component.getPause()) {
			this.component.setPause(false);
		} else if (!this.component.getPause()) {
			this.component.setPause(true);
		}
	}

	public void upgradeLevel() {
		if (this.level >= 2) {
			this.frame.dispose();
		}
		levelChange(this.getLevel() + 1);
	}

	public void levelChange(int lev) {
		this.level = lev;
		this.levelP = new LevelProvider(lev);
		this.frame.remove(component);

		this.component = new GameComponent(levelP.getLevel(), this, this.hero);
		this.frame.add(component, BorderLayout.CENTER);
		this.frame.getContentPane().validate();
		this.frame.getContentPane().repaint();

	}

}
