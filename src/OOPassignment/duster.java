package OOPassignment;

/**
 * subclass of Player
 * @author Lee Jin Quan
 *
 */
public class duster extends Player {
	

	private Boolean isHidden;
	
	/**
	 * Default Constructor
	 * HP : 100
	 * atk : 40
	 * def : 60
	 * score : 0
	 * step_on_tiles : ' '
	 * number_of_moves : 0
	 * x : 0
	 * y : 0
	 * isHidden : true
	 */
	public duster() {
		super(100,40,60,0,' ',0,0,0);
		this.setIsHidden(true);
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
	 * @param isHidden the value of player can be seen or not
	 */
	public duster(int HP, int Atk, int Def, int Score, char step_on_tiles, int number_of_moves, int x, int y, boolean isHidden) {
		super(HP, Atk, Def, Score, step_on_tiles, number_of_moves, x, y);
		this.setIsHidden(isHidden);
	}


	/**
	 * 
	 * @return Return the value of isHidden 
	 */
	public Boolean getIsHidden() {
		return isHidden;
	}
	

	/**
	 * 
	 * @param isHidden is the player hidden
	 */
	public void setIsHidden(Boolean isHidden) {
		this.isHidden = isHidden;
	}
	

}