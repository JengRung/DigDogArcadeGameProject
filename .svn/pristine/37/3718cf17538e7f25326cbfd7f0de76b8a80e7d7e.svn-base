import java.io.IOException;

public class Star extends GameObject {

	public Star(Hero hero) throws IOException{
		this.hero = hero;

		this.image = this.pictureList.get("Star");
		
	}
	
	public boolean eaten(){
		if(this.getBox().intersects(hero.getBox())){
			this.hero.changeWeapon();
			return true;
		}
		return false;
	}

	

}
