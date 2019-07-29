import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * TODO Put here a description of what this class does.
 *
 * @author tuj.
 *         Created May 14, 2018.
 */
public class Mushroom extends GameObject{
	
	public Mushroom(Hero hero) throws IOException{
		this.hero = hero;
		try{
			this.image = ImageIO.read(new File("mush1.png"));
		}catch(IOException e){
			throw new RuntimeException("Error drawing Mushroom: "+e);
		}
		
		
	}
	public boolean eaten(){
		if(this.getBox().intersects(hero.getBox())){
			this.hero.heroLife += 1;
			return true;
		}
		return false;
	}

}
