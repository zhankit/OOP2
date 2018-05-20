package OOPassignment;

/**
 * subclass of Player
 * @author Lee Jin Quan
 *
 */
public class broom extends Player {
	
	/**
	 * Default Constructor
	 * HP : 100
	 * Def : 50
	 * Score : 90
	 * step_on_tiles : ' '
	 * number_of_moves : 0
	 * x : 0
	 * y : 0
	 */
	public broom() {
		super(100,50,90,0,' ',0,0,0);
	}


	 /**
	  * Constructor
	 * @param HP  Value of HP
	 * @param Atk Value of Atk
	 * @param Def Value of Def
	 * @param Score Value of Score
	 * @param step_on_tiles Symbol of the player stepped on
	 * @param number_of_moves Value of number of moves
	 * @param x  x-axis of the Player
	 * @param y  y-axis of the Player
	  */
	public broom( int HP, int Atk, int Def, int Score, char step_on_tiles, int number_of_moves, int x, int y) {
		super( HP, Atk, Def, Score, step_on_tiles, number_of_moves, x, y);
	}
	
}