import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * 
 * TODO Put here a description of what this class does.
 *
 * @author Jeng-Rung Tu, Jinhao Sheng Created May 5, 2018.
 */
public class Hero extends Character {

	private BufferedImage heroIm;
	private int score;
	private Soda soda;
	private Pump pump;
	private boolean weaponStatus;

	public Hero() {

		super();

		this.heroIm = this.pictureList.get("Hero");
		this.weaponStatus = false;
	}

	// the method that draw the hero on Graphics2D
	public void drawCharacter(Graphics2D g2) {
		g2 = (Graphics2D) g2.create();
		g2.drawImage(this.heroIm, this.positionX, this.positionY, 40, 40, null);
	}

	// reset hero's position and reduce hero's life by one
	public void dies() {
		this.positionX = 600;
		this.positionY = 440;
		this.heroLife -= 1;

	}

	public int getX() {
		return this.positionX;
	}

	public int getY() {
		return this.positionY;
	}

	public void addScore(int score) {
		this.score += score;
	}

	public int getScore() {
		return this.score;
	}

	public void drawPump(Graphics2D g2) {

		if (this.weaponStatus == false) {
			g2 = (Graphics2D) g2.create();
			this.pump = new Pump(this);
			g2.setPaint(Color.RED);
			g2.fill(pump.getPumpSize());
			g2.draw(pump.getPumpSize());
		} else {
			g2 = (Graphics2D) g2.create();
			soda = new Soda(this);
			g2.drawImage(soda.returnSoda(), soda.getX(), soda.getY(), soda.getWidth(), soda.getLength(), null);
			g2.dispose();
		}
	}

	public void ways2Kill(Monster1 m) {
		if (this.weaponStatus == false) {
			if (m.getBox().intersects(pump.getPumpSize())) {
				m.ways2Die();
			}
		} else {
			if (m.getBox().intersects(soda.getAttackRange())) {
				m.ways2Die();
			}
		}
	}

	public void changeWeapon() {
		this.weaponStatus = true;
	}
}
