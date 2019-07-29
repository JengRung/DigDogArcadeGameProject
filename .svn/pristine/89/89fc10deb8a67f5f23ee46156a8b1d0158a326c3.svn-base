import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;

/**
 * 
 * @author Yinzhe Zhang, Jinhao Sheng
 *
 */
public class Rock {
	private int positionX;
	private int positionY;
	private int delay = 100;
	private boolean drop = false;
	private BufferedImage r1;
	private HashMap<String, BufferedImage> pictureList;

	public Rock(int x, int y) {
		this.positionX = x * 80;
		this.positionY = y * 80;
		
		Picture picture = new Picture();
		this.pictureList = picture.getMap();
		this.r1 = this.pictureList.get("Rock");
	}

	public void paintRock(Graphics2D g2) {
		g2 = (Graphics2D) g2.create();
		g2.drawImage(this.r1, this.positionX, this.positionY, 40, 40, null);
	}

	public int getX() {
		return this.positionX;
	}

	public int getY() {
		return this.positionY;
	}

	public void RockFall() {
		this.positionY += 40;
	}
	
	public Point2D.Double getPosition(){
		double x = this.positionX + 20;
		double y = this.positionY + 20;
		Point2D.Double center = new Point2D.Double(x,y);
		return center;
	}
	
	public boolean checkDelay(){
		if(this.delay > 0){
			delay--;
			return false;
		}
		else{
			this.drop = true;
			delay = 100;
			return true;
		}
	}
	
	public boolean isDropping(){
		return this.drop;
	}
	
	public void stopDropping(){
		this.drop = false;
	}
	}
