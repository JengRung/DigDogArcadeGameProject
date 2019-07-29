import java.io.IOException;
/**
 */
public class Fruit extends GameObject{
		
	
	public Fruit(Hero hero) throws IOException{
		this.hero = hero;
		this.Score = 300;		
		
		this.image = this.pictureList.get("Fruit");
		
	}	
	public boolean eaten(){
		if(this.getBox().intersects(hero.getBox())){
			this.hero.addScore(this.Score);
			return true;
		}
		return false;
	}
	
}
	
