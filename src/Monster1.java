import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.color.ColorSpace;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.util.Random;

/**
 * 
 * @author Yinzhe Zhang, Jinhao Sheng
 *
 */
public class Monster1 extends Character {
	protected BufferedImage m1;
	protected BufferedImage grayScale;
	protected long startT;
	protected static int Size = 40;
	protected int mosterSpeed = 2;
	protected int a;
	protected int X;
	protected int Y;
	protected int wall;
	protected boolean ghost;

	public Monster1(int x, int y) {
		this.positionX = x * 80;
		X = x * 80;
		this.positionY = y * 80;
		Y = y * 80;
		heroLife = 12;
		this.direction = "Left";
		startT = System.currentTimeMillis();
		Random rand = new Random();
		a = rand.nextInt(50);
		wall = 0;
		ghost = false;

		this.m1 = this.pictureList.get("m1");
		this.grayScale = this.pictureList.get("m1g");
		ColorConvertOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);

	}

	public boolean dies(Hero hero) {
		if (heroLife < 1) {
			hero.addScore(100);
			return true;
		}
		return false;
	}

	public void ways2Die() {
		heroLife--;

	}

	public boolean touchRock() {
		for (Rock r : this.RockPostion) {
			if (Math.abs(r.getX() - this.positionX) < 40 && Math.abs(r.getY() - this.positionY) < 40) {
				return true;
			}
		}
		return false;
	}

	public boolean XisAdvantage() {
		for (Rock r : this.RockPostion) {
			if (Math.abs(r.getX() - this.positionX) < 20 && Math.abs(this.positionY - r.getY()) > 25) {
				return true;
			}
			if (Math.abs(r.getX() - this.positionX) > 20 && Math.abs(this.positionY - r.getY()) < 25) {
				return false;
			}
		}
		return true;
	}

	public void moveBasic(Hero hero) throws InterruptedException {
		if (System.currentTimeMillis() - startT > 1000 * 4 + 50 * a) {
			this.move(hero);
			return;
		} else if (System.currentTimeMillis() - startT > 1000 * 1 + 100 * a) {

			this.move(hero);
			return;
		}

		if (!ghost) {
			if (positionX <= X - 80 || positionX >= X + 40)
				hitWall();
			if (this.wall % 2 == 1 && positionX < X + 40) {
				positionX++;
				Thread.sleep(mosterSpeed/2);
				return;
			} else if (this.wall % 2 == 1 && positionX > X + 40) {
				positionX--;
				Thread.sleep(mosterSpeed/2);
				return;
			}
			if (this.wall % 2 == 0 && positionX > X - 80) {
				positionX--;
				Thread.sleep(mosterSpeed/2);
				return;
			} else if (this.wall % 2 == 0 && positionX < X + 80) {
				positionX++;
				Thread.sleep(mosterSpeed/2);
				return;
			}

		}

	}

	public void hitWall() {
		wall++;

	}

	public void move(Hero hero) {
		ghost = true;
		if (this.positionX <= hero.positionX) {
			if (this.positionY <= hero.positionY) {
				if (touchRock()) {
					if (this.XisAdvantage()) {
						this.positionX++;
					} else {
						this.positionY++;
					}
				} else {
					this.positionX++;
					this.positionY++;
					try {
						Thread.sleep(mosterSpeed);
					} catch (InterruptedException e) {
					}
				}
			}
			if (this.positionY >= hero.positionY) {
				if (touchRock()) {
					if(this.XisAdvantage()){
						this.positionX++;
					}else{
						this.positionY--;
					}
				} else {
					this.positionX++;
					this.positionY--;
					try {
						Thread.sleep(mosterSpeed);
					} catch (InterruptedException e) {
					}
				}
			}
		}
		if (this.positionX >= hero.positionX) {
			if (this.positionY <= hero.positionY) {
				if (touchRock()) {
					if(this.XisAdvantage()){
						this.positionX--;
					}else{
						this.positionY++;
					}
				} else {
					this.positionX--;
					this.positionY++;
					try {
						Thread.sleep(mosterSpeed);
					} catch (InterruptedException e) {
					}
				}
			}
			if (this.positionY >= hero.positionY) {
				if (touchRock()) {
					if(this.XisAdvantage()){
						this.positionX--;
					}else{
						this.positionY--;
					}
				} else {
					this.positionX--;
					this.positionY--;
					try {
						Thread.sleep(mosterSpeed);
					} catch (InterruptedException e) {
					}
				}
			}
		}
	}

	public void ways2Kill(Hero hero) {
		if (hero.getBox().intersects(this.getBox())) {
			hero.dies();
		}
	}

	public Rectangle2D[] getBoxes() {
		Rectangle2D[] boxes = new Rectangle2D[4];
		for (int i = 0; i < 4; i++) {
			Rectangle2D box = new Rectangle2D.Double(this.positionX - 80 + 40 * i, this.positionY, Monster1.Size,
					Monster1.Size);
			boxes[i] = box;
		}

		return boxes;
	}

	// become grayscale once died
	public void drawCharacter(Graphics2D g2) {

		g2 = (Graphics2D) g2.create();
		if (heroLife < 4) {
			g2.drawImage(this.grayScale, positionX, positionY, 80, 80, null);

		} else if (heroLife < 6) {
			g2.drawImage(m1, positionX, positionY, 60, 60, null);
		} else if (heroLife < 7) {
			g2.drawImage(m1, positionX, positionY, 55, 55, null);
		} else if (heroLife < 8) {
			g2.drawImage(m1, positionX, positionY, 50, 50, null);
		} else if (heroLife < 10) {
			g2.drawImage(m1, positionX, positionY, 45, 45, null);
		} else {
			g2.drawImage(this.m1, positionX, positionY, 40, 40, null);
		}
	}

	public void drawPump(Graphics2D g2, Hero hero) {
		for (Rectangle2D r : this.getBoxes()) {
			if (hero.getBox().intersects(r)) {
				if (hero.getX() > this.positionX)
					this.setDirection("Right");
				g2 = (Graphics2D) g2.create();
				g2.setPaint(Color.BLUE);
				pump = new Pump(this, 5, 75);
				g2.fill(pump.getPumpSize());
				g2.draw(pump.getPumpSize());
				if (hero.getBox().intersects(this.pump.getPumpSize()))
					hero.dies();
			}
		}
	}

}
