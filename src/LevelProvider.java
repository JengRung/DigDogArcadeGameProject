import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * level.txt file contains two(for now) lines of int
 * first line: pos of monster
 * second line:pos of rock 
 *  
 * @author Yinzhe Zhang
 *
 */


public class LevelProvider {
	public static int totalLevelNumber = 10;
	private int lev;
	private int[][] level;
	

	public LevelProvider(int level) {
		this.setLev(level);
		this.level= loadLevel(level);
	}

	/*
	 * load levels from files
	 * input:lev -level
	 */
	public static int[][] loadLevel(int lev){
		int[][] level;
		File file = new File("Level"+String.valueOf(lev)+".txt");
		try{
			Scanner input = new Scanner(file);
			int lineCount = 3;
			
			/**
			 * haven't figure out how to count lines yet
			 */
	        //while (input.hasNextLine()) {
	        //    lineCount++;
	        //}
	        //System.out.print(lineCount);
			level = new int[lineCount][8];
			for(int i = 0; i<lineCount;i++){
				for(int j = 0; j<8;j++){
					level[i][j]=input.nextByte();
					System.out.print(level[i][j]);
				}
				System.out.println();
			}
			input.close();
			return level;
		}catch(FileNotFoundException e){
			System.out.println("Warning! Level not found!");
			return null;
		}
	}
	
    //get and set level
	public int getLev() {
		return this.lev;
	}

	public void setLev(int level) {
		this.lev = level;
	}

	
	public int[][] getLevel(){
		System.out.println(lev);
		return this.level;
	}

	/*
	 * return number of maps
	 * 
	 * input:
	 * return:int -count
	 */
	public int getCount(){
		return totalLevelNumber;
	}
	
	public boolean containlev(int lev){
		return lev<getCount()&&lev>=0;
	}
	


}
