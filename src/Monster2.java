import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Monster2 extends Monster1{

	public Monster2(int x, int y) {
		super(x, y);
		this.setDirection("Down");
		
		this.m1 = this.pictureList.get("m2");
		this.grayScale = this.pictureList.get("m2g");

	}

	public void drawPump(Graphics2D g2,Hero hero){
		for(Rectangle2D r:this.getBoxes()) {
			
		if(hero.getBox().intersects(r)) {
		if(hero.getY()<this.positionY)
			this.setDirection("Up");
		g2 = (Graphics2D) g2.create();
		g2.setPaint(Color.GREEN);
		pump = new Pump(this,5,75);
		g2.fill(pump.getPumpSize());
		g2.draw(pump.getPumpSize());
		if(hero.getBox().intersects(this.pump.getPumpSize()))
			hero.dies();}}
	}
	
	public Rectangle2D[] getBoxes() {
		Rectangle2D[] boxes=new Rectangle2D[4];
		Random rand = new Random();
		int a=rand.nextInt(10);
		if(a<5) {
			for(int i=0;i<4;i++) {
		   Rectangle2D box = new Rectangle2D.Double(this.positionX, this.positionY-80+40*i, Monster2.Size, Monster2.Size);
		   boxes[i]=box;
		   }
		   
		}else{for(int i=0;i<4;i++) {Rectangle2D box = new Rectangle2D.Double(this.positionX, this.positionY-80+40*i, Monster1.Size, Monster1.Size);
			 boxes[i]=box;}}
		return boxes;
	}
	
	public void moveBasic(Hero hero) throws InterruptedException {
		
			if(!ghost) {
				if(positionY<=Y-80||positionY>=Y+40)hitWall();
				if(this.wall%2==1&&positionY<Y+40) {positionY++;
				Thread.sleep(mosterSpeed);
				
				}else if(this.wall%2==1&&positionY>Y+40) {positionY--;
				Thread.sleep(mosterSpeed);
				
				}if(this.wall%2==0&&positionY>Y-80) {positionY--;
				Thread.sleep(mosterSpeed);
				}else if(this.wall%2==0&&positionY<Y+80) {positionX++;
				Thread.sleep(mosterSpeed);
				}

		
		
			
			}

			
			
			if(System.currentTimeMillis()-startT>1000*5+500*a) {
				this.move(hero);
				return;
			}else if(System.currentTimeMillis()-startT>1000*2+1000*a) {
			
				this.move(hero);
				return;
			}
			
			
		}
	
	

}
