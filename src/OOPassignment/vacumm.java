package OOPassignment;

/**
 * subclass of Player
 * @author Lee Jin Quan
 *
 */
public class vacumm extends Player {
	
	/**
	 * Default Constructor
	 * HP : 100
	 * Def : 60
	 * Score : 40
	 * step_on_tiles : ' '
	 * number_of_moves : 0
	 * x : 0
	 * y : 0
	 */
	public vacumm() {
		super(100,60,40,0,' ',0,0,0);
	}

	/**
	 * 
	 * @param HP  Value of HP
	 * @param Atk Value of Atk
	 * @param Def Value of Def
	 * @param Score Value of Score
	 * @param step_on_tiles Symbol of the player stepped on
	 * @param number_of_moves Value of number of moves
	 * @param x  x-axis of the Player
	 * @param y  y-axis of the Player
	 */
	public vacumm(int HP, int Atk, int Def, int Score, char step_on_tiles, int number_of_moves, int x, int y) {
		super(HP, Atk, Def, Score, step_on_tiles, number_of_moves, x, y);
	}

}