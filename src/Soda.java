import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Soda {
	
	private String direction;
	private Character hero;
	private BufferedImage image;
	private int Width;
	private int Length;
	private double dx;
	private double dy;
	private Rectangle2D attackRange;
	
	
	public Soda(Character character){
		
		this.hero = character;
		this.dx = this.hero.getPosition().getX();
		this.dy = this.hero.getPosition().getY();
		this.direction = this.hero.getDirection();
		this.Length = 160;
		this.Width = 100;
		
	}
	public int getLength(){
		return this.Length;
	}
	public int getWidth(){
		return this.Width;
	}
	public int getX(){
		return (int)this.dx;
	}
	public int getY(){
		return (int)this.dy;
	}
	
	public BufferedImage returnSoda(){	
		if(this.direction == "Up"){
			try {
				this.image = ImageIO.read(new File("sodaUp.png"));
				this.Length = 160;
				this.Width = 100;
				this.dx -= 50;
				this.dy -=180;
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		if(this.direction == "Down"){
			try {
				this.image = ImageIO.read(new File("sodaDown.png"));
				this.Length = 160;
				this.Width = 100;
				this.dx -= 50;
				this.dy += 20;
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		if(this.direction == "Right"){
			try {
				this.image = ImageIO.read(new File("sodaRight.png"));
				this.Length = 100;
				this.Width = 160;
				this.dx += 20;
				this.dy -= 50;
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		if(this.direction == "Left"){
			try {
				this.image = ImageIO.read(new File("sodaLeft.png"));
				this.Length = 100;
				this.Width = 160;
				this.dx -= 180;
				this.dy -= 50;
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		return this.image;
	}

	public Rectangle2D getAttackRange(){
		this.dx = this.hero.getPosition().getX();
		this.dy = this.hero.getPosition().getY();
		this.Length = 160;
		this.Width = 40;
		if(this.direction == "Left"){
			Rectangle2D newPump = new Rectangle2D.Double(this.dx - this.Length,
					this.dy - this.Width/2, this.Length, this.Width); 
			this.attackRange = newPump;
			return this.attackRange;
		}
		else if(this.direction == "Right"){
			Rectangle2D newPump = new Rectangle2D.Double(this.dx, 
					this.dy - this.Width/2, this.Length, this.Width); 
			this.attackRange = newPump;
			return this.attackRange;
		}
		else if(this.direction == "Up"){
			Rectangle2D newPump = new Rectangle2D.Double(this.dx - this.Width/2, 
					this.dy - this.Length, this.Width, this.Length); 
			this.attackRange = newPump;
			return this.attackRange;
		}
		else if(this.direction == "Down"){
			Rectangle2D newPump = new Rectangle2D.Double(this.dx - this.Width/2, 
					this.dy, this.Width, this.Length); 
			this.attackRange = newPump;
			return this.attackRange;
		}
		return this.attackRange;
	}

}
