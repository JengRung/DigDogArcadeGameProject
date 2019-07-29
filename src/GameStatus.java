import javax.swing.JLabel;

/**
 * 
 * TODO Put here a description of what this class does.
 *
 * @author tuj.
 *         Created May 13, 2018.
 */
public class GameStatus {
	
	private GameBoard board;
	protected JLabel label;
	
	public GameStatus(GameBoard gameBoard){
		this.board = gameBoard;
		this.label = new JLabel();
	}
	
	public void upDate(){
		
		this.label.setText("<html><span style='font-size:20px'>" + "Score:" + this.board.hero.getScore() + "<br />Life:" + this.board.getHeroLife());
		
		
		if(this.board.getHeroLife() <= 0){
			this.board.frame.dispose();
		}
	}

}
