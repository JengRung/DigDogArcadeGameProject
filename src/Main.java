      /**
 * The main class for your arcade game.
 * 
 * You can design your game any way you like, but make the game start
 * by running main here.
 * 
 * Also don't forget to write javadocs for your classes and functions!
 * 
 * @author Buffalo, Yinzhe Zhang, Jeng-Rung Tu , Jinhao Sheng
 * Created May 5, 2018.
 *
 */
public class Main {
	 
	private GameBoard board;
	private GameBoardListener boardListener;
	
	public static void main(String[] args) {
		new Main();
	}
 	public Main(){
		this.board = new GameBoard(1);
		this.setBoardListener(new GameBoardListener(this.board));
		board.frame.addKeyListener(boardListener);
	}

	public GameBoardListener getBoardListener() {
		return boardListener;
	}

	public void setBoardListener(GameBoardListener boardListener) {
		this.boardListener = boardListener;
	}
}
