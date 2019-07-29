import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 * 
 * TODO Put here a description of what this class does.
 *
 * @author Jeng-Rung Tu.
 *         Created May 5, 2018.
 */
public class Dirt {
	
	private Color color;
	private int x;
	private int y;
	private static final double Size = 40;
	
	
	public Dirt(int dx, int dy){
		this.color = Color.GRAY;
		this.x = dx;
		this.y = dy;
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	
	public Color getColor(){
		return this.color;
	}
	
	public void changeColor(){
		this.color = Color.BLACK;
	}
	
	public Rectangle2D getBox(){
		Rectangle2D box = new Rectangle2D.Double(this.x, this.y, this.Size, this.Size);
		return box;
	}
	
	
	protected void drawOn(Graphics2D g) {
		g.setColor(this.color);
		Rectangle2D.Double dirt = new Rectangle2D.Double(this.x, this.y, Size, Size);
		g.fill(dirt);
	}
	
	public boolean isTouchHero(Hero hero){
		return hero.getBox().intersects(this.getBox());
	}
	
	public boolean isTouchMonster(Monster1 m){
		for(Rectangle2D b:m.getBoxes()) {
			if(b.intersects(this.getBox()))return true;
		else {continue;}}
			return false;
	
	
	}
	
	
}
