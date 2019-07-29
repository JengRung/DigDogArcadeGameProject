import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

/**
 * 
 * TODO Put here a description of what this class does.
 *
 * @author tuj.
 *         Created May 10, 2018.
 */
public class GameObject {
	protected int positionX;
	protected int positionY;
	protected static int Size=40;
	protected BufferedImage image;
	protected int Score;
	protected Hero hero;
	protected HashMap<String, BufferedImage> pictureList;
	

	public GameObject() throws IOException{
		this.positionX = (int) (Math.random()*1160);
		this.positionY = (int) (Math.random()*800);
		Picture picture = new Picture();
		this.pictureList = picture.getMap();
	}
	
	public int getX(){
		return this.positionX;
	}
	
	public int getY(){
		return this.positionY;
	}
	public Rectangle2D getBox(){
		Rectangle2D box = new Rectangle2D.Double(this.positionX, this.positionY, 40, 40);
		return box;
	}
	public void drawObject(Graphics2D g2){
		g2 = (Graphics2D) g2.create();
		g2.drawImage(image, this.positionX, this.positionY, Size, Size, null);
	}

	public boolean eaten(){
		return false;
	}
}
