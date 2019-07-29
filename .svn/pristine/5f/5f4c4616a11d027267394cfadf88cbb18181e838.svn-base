import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComponent;

/**
 * 
 * @author0 Jeng-Rung Tu, Yinzhe Zhang, Jinhao Sheng
 *
 */

public class GameComponent extends JComponent {

	private Rectangle2D.Double backGround;
	private ArrayList<Dirt> dirtList = new ArrayList<Dirt>();
	private ArrayList<Dirt> dirtRemove = new ArrayList<Dirt>();
	private ArrayList<Dirt> dirtExist = new ArrayList<Dirt>();
	private ArrayList<Monster1> M1List = new ArrayList<Monster1>();
	private ArrayList<Monster1> M11List = new ArrayList<Monster1>();
	private ArrayList<Rock> R1List = new ArrayList<Rock>();
	private ArrayList<GameObject> GOList = new ArrayList<GameObject>();
	private ArrayList<GameObject> GOListEaten = new ArrayList<GameObject>();
	private Hero hero;
	private int[][] lev;
	private boolean isPaused;
	private boolean check;
	private GameStatus status;
	private int dy = 0;
	private int waitTime = 0;
	private GameBoard board;
	private boolean initialize = false;

	public GameComponent(int[][] lev, GameBoard board, Hero hero) {
		this.backGround = new Rectangle2D.Double(0, 0, 1200, 1200);
		this.hero = hero;
		this.lev = lev;
		this.isPaused = false;
		this.check = true;
		this.status = board.getStatus();
		this.board = board;
	}

	public boolean levelClear() {
		return M1List.isEmpty();
	}

	public void updateState() throws IOException {
		setDirt();
		setStartPath();
		setObject();
	}

	public void setDirt() {
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 30; j++) {
				this.dirtList.add(new Dirt(40 * i, 40 * j));
			}
		}
	}

	// dirt will change to black once digged by Hero
	public void removeDirt() {
		for (Dirt dirt : this.dirtList) {
			if (dirt.isTouchHero(this.hero)) {
				if (dirt.getColor() == Color.BLACK) {
					return;
				}
				dirt.changeColor();
				this.dirtRemove.add(dirt);
			}
		}
	}

	public void removeDirtforMonster(Monster1 m) {
		for (Dirt dirt : this.dirtList) {
			if (dirt.isTouchMonster(m)) {
				if (dirt.getColor() == Color.BLACK) {
					continue;
				}
				dirt.changeColor();
				dirtRemove.add(dirt);
			}
		}

	}

	public boolean checkSpaceToFall(Rock r) {
		for (Dirt d : this.dirtRemove) {
			if (r.getX() == d.getX() && r.getY() + 40 == d.getY()) {
				if (r.checkDelay() || r.isDropping()) {
					return true;
				}
			}
		}
		r.stopDropping();
		return false;

	}

	public boolean getPause() {
		return this.isPaused;
	}

	public void setPause(boolean b) {
		this.isPaused = b;
	}

	// remove the dirt in the middle
	public void setStartPath() {
		for (Dirt dirt : this.dirtList) {
			if ((dirt.getX() == 600 && dirt.getY() <= 460)) {
				dirt.changeColor();
				dirtRemove.add(dirt);
			}
		}
		for (Monster1 m : this.M1List) {
			removeDirtforMonster(m);
		}
	}

	public void createM1(int i, int j) {
		Monster1 m = new Monster1(i, j);
		M1List.add(m);
	}

	public void createRock(int i, int j) {
		Rock r = new Rock(i, j);
		R1List.add(r);
		this.hero.RockPostion(r);
		for (Monster1 m : this.M1List) {
			m.RockPostion(r);
		}
	}

	public void checkDirtExist() {
		for (Dirt dirt : this.dirtList) {
			if (dirt.getColor() == Color.GRAY) {
				this.dirtExist.add(dirt);
			}
		}
	}

	// create 3 fruit, 1 star and 1 mushroom in to GOList
	public void setObject() throws IOException {
		for (int i = 0; i < 2; i++) {
			Fruit f1 = new Fruit(this.hero);
			this.GOList.add(f1);
		}
		Mushroom M = new Mushroom(this.hero);
		this.GOList.add(M);
		Star S = new Star(this.hero);
		this.GOList.add(S);
	}

	public void addWaitTime() {
		this.waitTime += (Math.random() * 20);
	}

	protected void paintComponent(Graphics g) {
		while (isPaused) {
			try {
				Thread.sleep(10000);
				break;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		if (this.check == true) {
			g2.setPaint(Color.BLACK);
			g2.fill(this.backGround);
			for (int i = 0; i < 8; i += 2) {
				this.createM1(lev[0][i], lev[0][i + 1]);
			}
			for (int i = 0; i < 8; i += 2) {
				this.createM2(lev[2][i], lev[2][i + 1]);
			}
			try {
				updateState();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			for (Dirt dirt : this.dirtList)
				dirt.drawOn(g2);
			check = false;
		}

		for (Dirt dirt : this.dirtList)
			dirt.drawOn(g2);
		this.removeDirt();
		for (Dirt dirt : this.dirtRemove) {
			dirt.drawOn(g2);
		}

		// update life, score...etc. Call the function in GameStatus class
		this.status.upDate();

		// draw hero on the Graphics2D
		this.hero.drawCharacter(g2);

		for (Monster1 m : this.M1List) {
			try {
				m.moveBasic(hero);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (m.dies(hero) == false) {
				M11List.add(m);
			}
		}
		ArrayList<Monster1> tem = M1List;
		M1List = M11List;
		M11List = tem;
		M11List.clear();
		for (Monster1 m : this.M1List) {
			m.drawCharacter(g2);
		}

		// every two int from the 1st line of the array is
		// position of a monster

		// wait for a while and draw the gameObject
		if (this.waitTime < 2000) {
			addWaitTime();
		} else {
			for (GameObject GO : this.GOList) {
				GO.drawObject(g2);
				if (GO.eaten() == false) {
					this.GOListEaten.add(GO);
				}
			}

			ArrayList<GameObject> test = GOList;
			GOList = GOListEaten;
			GOListEaten = test;
			GOListEaten.clear();
		}
		//

		if (this.initialize == false) {
			System.out.println("0");
			for (int i = 0; i < 8; i += 2) {
				this.createRock(lev[1][i], lev[1][i + 1]);
			}
			this.initialize = true;
		}

		for (Rock r : this.R1List) {
			while (this.checkSpaceToFall(r)) {
				r.RockFall();
				if (hero.getX() == r.getX() && this.hero.getY() == r.getY()) {
					hero.dies();
				}
				for (Monster1 m : this.M1List) {
					if (m.getPosition() == r.getPosition()) {
						m.ways2Die();
					}
				}
			}
			r.paintRock(g2);
		}

		for (Monster1 m : this.M1List) {
			// if(m.checkPumpStatus()==true)
			m.drawPump(g2, hero);
			m.ways2Kill(hero);

		}

		if (this.hero.checkPumpStatus() == true) {
			this.hero.drawPump(g2);
			for (Monster1 m : this.M1List)
				this.hero.ways2Kill(m);
		}

		if (levelClear()) {
			this.board.upgradeLevel();
		}
		repaint();
		g2.dispose();

	}

	private void createM2(int i, int j) {
		Monster2 m = new Monster2(i, j);
		M1List.add(m);
	}
}
