import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * TODO Put here a description of what this class does.
 *
 * @author tuj. Created May 14, 2018.
 */
public abstract class Character {
	protected int positionX;
	protected int positionY;
	protected ArrayList<Rock> RockPostion = new ArrayList<Rock>();
	protected ArrayList<Dirt> DirtPostion = new ArrayList<Dirt>();
	protected String direction;
	protected int heroLife;
	private boolean pumpStatus;
	protected Pump pump;
	protected HashMap<String, BufferedImage> pictureList;

	public Character() {
		this.positionX = 600;
		this.positionY = 440;
		this.direction = "Down";
		this.pumpStatus = false;
		pump = new Pump(this);
		this.heroLife = 3;
		Picture picture = new Picture();
		this.pictureList = picture.getMap();

	}

	// return the center of the hero
	public Point2D.Double getPosition() {
		double x = this.positionX + 20;
		double y = this.positionY + 20;
		Point2D.Double center = new Point2D.Double(x, y);
		return center;
	}

	// move hero by the given variables
	public void moveHero(int x, int y) {
		this.positionX += x;
		this.positionY += y;
	}

	// return hero's direction
	public String getDirection() {
		return this.direction;
	}

	// change the direction that hero is facing to
	public void setDirection(String direction) {
		this.direction = direction;
	}

	// the method that draw the hero on Graphics2D
	public abstract void drawCharacter(Graphics2D g2);

	// add rock's position to the rock arraylist
	public void RockPostion(Rock r) {
		this.RockPostion.add(r);
	}

	public void DirtPostion(Dirt r) {
		this.DirtPostion.add(r);
	}

	/**
	 * Check if the next move of hero would touch the rock. If so, return true.
	 * Else, return false.
	 *
	 * @return
	 */
	// hero stop when it's position is same as rock
	public boolean avoidRock() {
		for (Rock r : this.RockPostion) {
			if (this.positionX == r.getX() && this.positionY == r.getY()) {
				return true;
			}
		}
		return false;
	}

	// return the area that hero is coverd
	public Rectangle2D getBox() {
		Rectangle2D box = new Rectangle2D.Double(this.positionX, this.positionY, 40, 40);
		return box;
	}

	// return hero's life
	public int getHeroLife() {
		return this.heroLife;
	}

	// return the status of pump either true or false
	public boolean checkPumpStatus() {
		return this.pumpStatus;
	}

	// change the pump's status by given boolean
	public void changePumpStatus(boolean status) {
		this.pumpStatus = status;
	}

	public void changeX(int dx) {
		this.positionX = dx;
	}

	public void changeY(int dy) {
		this.positionY = dy;
	}

}
