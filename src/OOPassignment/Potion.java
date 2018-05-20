package OOPassignment;

/**
 * subclass of item
 * @author Ding Zhan Chia 
 *
 */
public class Potion extends item {

	/** Type of the Potion
	 */
	private String type;
	
	/** The value of Potion is found in the map or not
	 */
	private boolean isFound;
	
	/** Default Constructor
	 * 
	 */
	public Potion() {
		super();
		this.type = "";
		this.setFound(false);
	}
	
	/**
	 * Constructor
	 * @param value value of the potion
	 * @param type type of the potion
	 * @param x x-axis 
	 * @param y y-axis 
	 */
	public Potion(int value, String type, int x, int y) {
		this.setValue(value);
		this.type = type;
		this.setFound(false);
		this.setX(x);
		this.setY(y);
	}


	/**
	 * Add the effect and value of the potion to the player accordingly
	 * @param curr_player instance for player
	 * 
	 */
	public void use_Potion(Player curr_player) {
		if (this.type.equals("RH")) {
			curr_player.setHP(curr_player.getHP() + this.getValue());
		} else if (this.type.equals("BA")) {
			curr_player.setAtk(curr_player.getAtk() + this.getValue());
		}  else if (this.type.equals("BD")) {
			curr_player.setDef(curr_player.getDef() + this.getValue());
		}  else if (this.type.equals("PH")) {
			curr_player.setHP(curr_player.getHP() - this.getValue());
		}  else if (this.type.equals("WA")) {
			curr_player.setAtk(curr_player.getAtk() - this.getValue());
		}  else if (this.type.equals("WD")) {
			curr_player.setDef(curr_player.getDef() - this.getValue());
		}  
	}


	/**
	 * Return the value of isFound
	 * @return Return the value of isFound
	 */
	public boolean isFound() {
		return isFound;
	}


	/**
	 * Set the value of isFound
	 * @param isFound The value of Potion is found in the map or not
	 */
	public void setFound(boolean isFound) {
		this.isFound = isFound;
	}

	/**
	 * Return the value of potion type
	 * @return Return the value of potion type
	 */
	public String getPotionType() {
		return this.type;
	}

	/**
	 * Set the value of type
	 * @param type of the Potion
	 *
	 */
	public void setPotionType(String type) {
		this.type = type;
	}

}
