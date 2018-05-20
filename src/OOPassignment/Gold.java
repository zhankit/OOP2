package OOPassignment;

/**
 * subclass of item
 * @author Ding Zhan Chia 
 *
 */
public class Gold extends item {

	/**
	 * Constructor
	 */
	Gold(){
		super();
	}
	
	/**
	 * Constructor
	 * @param x X-axis
	 * @param y Y-axis
	 * @param value value for gold
	 */
	Gold(int x, int y, int value) {
		super(x,y,value);
	}
	

	/**
	 * It will add the value of gold to the player
	 * @param curr_player the instance for Player
	 */
	public void addGold( Player curr_player ) {
		curr_player.setScore( curr_player.getScore() + this.getValue() );
	};
}
