import java.awt.geom.Rectangle2D;

/**
 * 
 * TODO Put here a description of what this class does.
 *
 * @author tuj.
 *         Created May 9, 2018.
 */

public class Pump {
	
	
	
	private String direction;
	private Character hero;
	private Rectangle2D pumpSize;
	private double dx;
	private double dy;
	private double pumpWidth;
	private double pumpLength;
	
	public Pump(Character character){
		this.hero = character;
		this.direction = this.hero.getDirection();
		this.pumpSize = new Rectangle2D.Double();
		this.dx = this.hero.getPosition().getX();
		this.dy = this.hero.getPosition().getY();
		this.pumpWidth = 5;
		this.pumpLength = 150;
		}
	
	public Pump(Character character, double W,double L){
		this.hero = character;
		this.direction = this.hero.getDirection();
		this.pumpSize = new Rectangle2D.Double();
		this.dx = this.hero.getPosition().getX();
		this.dy = this.hero.getPosition().getY();
		this.pumpLength = L;
		this.pumpWidth = W;
		}
	
	
	
//	Check what the direction that hero is facing to and create a Rectangle2D to that direction
	public Rectangle2D getPumpSize(){
		if(this.direction == "Left"){
			Rectangle2D newPump = new Rectangle2D.Double(this.dx - this.pumpLength,
					this.dy - this.pumpWidth/2, this.pumpLength, this.pumpWidth); 
			this.pumpSize = newPump;
			return this.pumpSize;
		}
		else if(this.direction == "Right"){
			Rectangle2D newPump = new Rectangle2D.Double(this.dx, 
					this.dy - this.pumpWidth/2, this.pumpLength, this.pumpWidth); 
			this.pumpSize = newPump;
			return this.pumpSize;
		}
		else if(this.direction == "Up"){
			Rectangle2D newPump = new Rectangle2D.Double(this.dx - this.pumpWidth/2, 
					this.dy - this.pumpLength, this.pumpWidth, this.pumpLength); 
			this.pumpSize = newPump;
			return this.pumpSize;
		}
		else if(this.direction == "Down"){
			Rectangle2D newPump = new Rectangle2D.Double(this.dx - this.pumpWidth/2, 
					this.dy, this.pumpWidth, this.pumpLength); 
			this.pumpSize = newPump;
			return this.pumpSize;
		}
		return this.pumpSize;
	}

	

}
