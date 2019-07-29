import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;


/**
 * 
 * TODO Put here a description of what this class does.
 *
 * @author Jeng-Rung Tu, Yinzhe Zhang, Jinhao Sheng
 *         Created May 5, 2018.
 */

public class HeroListener extends JComponent implements KeyListener, ActionListener {

	private Hero hero;
	private GameComponent Component;
	private int dx,dy;
	private boolean checkPump;
	
	public HeroListener(Hero hero, GameStatus gameStatus){
		this.hero = hero;
		dx=0;
		dy=0;
		this.checkPump = false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
	
		if(key == KeyEvent.VK_UP){
			if(hero.getY()<=0){
				return;
			}
			dy=-40;
			dx=0;
			this.hero.changePumpStatus(false);
			return;
		}
		else if(key == KeyEvent.VK_DOWN){
			if(hero.getY() >= 1160){
				return;
			}
			dy=40;
			dx=0;
			this.hero.changePumpStatus(false);
			return;
		}
		else if(key == KeyEvent.VK_RIGHT){
			if(hero.getX() >= 1160){
				return;
			}
			dx=40;
			dy=0;
			this.hero.changePumpStatus(false);
			return;
		}
		else if(key == KeyEvent.VK_LEFT){
			if(hero.getX()<=0){
				return;
			}
			dx=-40;
			dy=0;
			this.hero.changePumpStatus(false);
			return;
		}
		else if(key == KeyEvent.VK_SPACE){
			this.checkPump = true;
			this.hero.changePumpStatus(checkPump);
			dx = dy = 0;
			return;	
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
            this.hero.setDirection("Left");
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        	this.hero.setDirection("Right");
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
            this.hero.setDirection("Up");
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
            this.hero.setDirection("Down");
        }
        else if(key == KeyEvent.VK_SPACE){
        	this.hero.changePumpStatus(false);
        }
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		hero.moveHero(dx,dy);
		// if there's a rock, hero will move back to the last step.
		if(hero.avoidRock()){
			hero.moveHero(-dx,-dy);
		}
	}

}
