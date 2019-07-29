import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Picture {

	private HashMap<String, BufferedImage> pictureMap;
	
	public Picture() {
		
		this.pictureMap = new HashMap<String, BufferedImage>();
		
		try {
			BufferedImage heroIm = ImageIO.read(new File("dig_dug.png"));
			this.pictureMap.put("Hero", heroIm);
			
			BufferedImage MushIm = ImageIO.read(new File("mush1.png"));
			this.pictureMap.put("Mush", MushIm);
			
			BufferedImage FruitIm = ImageIO.read(new File("f1.png"));
			this.pictureMap.put("Fruit", FruitIm);
			
			BufferedImage RockIm = ImageIO.read(new File("rock.png"));
			this.pictureMap.put("Rock", RockIm);
			
			BufferedImage StarIm = ImageIO.read(new File("star.png"));
			this.pictureMap.put("Star", StarIm);
			
			BufferedImage SodaU = ImageIO.read(new File("sodaUp.png"));
			this.pictureMap.put("SodaUp", SodaU);
			
			BufferedImage SodaD = ImageIO.read(new File("sodaDown.png"));
			this.pictureMap.put("SodaDown", SodaD);
			
			BufferedImage SodaR = ImageIO.read(new File("sodaRight.png"));
			this.pictureMap.put("SodaRight", SodaR);
			
			BufferedImage SodaL = ImageIO.read(new File("sodaLeft.png"));
			this.pictureMap.put("SodaLeft", SodaL);
			
			BufferedImage m1Im = ImageIO.read(new File("m1.png"));
			this.pictureMap.put("m1", m1Im);
			
			BufferedImage m1ImG = ImageIO.read(new File("m1.png"));
			ColorConvertOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
			op.filter(m1ImG, m1ImG);
			this.pictureMap.put("m1g", m1ImG);
			
			BufferedImage m2Im = ImageIO.read(new File("m2.png"));
			this.pictureMap.put("m2", m2Im);
			
			BufferedImage m2ImG = ImageIO.read(new File("m2.png"));
			op.filter(m2ImG, m2ImG);
			this.pictureMap.put("m2g", m2ImG);
			
		} catch (IOException exception) {
			// TODO Auto-generated catch-block stub.
			exception.printStackTrace();
		}
		
	}
	
	public HashMap<String, BufferedImage> getMap(){
		return this.pictureMap;
	}
}
