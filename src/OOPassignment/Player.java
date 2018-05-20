package OOPassignment;

/**
 * Player
 * @author Lee Jin Quan
 *
 */
public abstract class Player {
	
	/**
	 * @param HP    		   : Value of HP
	 * @param ATK 			   : Value of Atk
	 * @param Def  			   : Value of Def
	 * @param Score 		   : Value of Score
	 * @param step_on_tiles    : Symbol of the player stepped on
	 * @param number_of_moves  : Value of number of moves
	 * @param x  			   : x-axis of the Player
	 * @param y            	   : y-axis of the Player
	 * @param stopdeath		   : Value of stopdeath
	 */
	/**
	 * Value of HP
	 */
	private int HP;
	
	/**
	 * Value of Atk
	 */
	private int Atk;
	
	/**
	 * Value of Def
	 */
	private int Def;
	
	/**
	 * Value of Score
	 */
	private int Score;
	
	/**
	 * Symbol of the player stepped on
	 */
	private char step_on_tiles;
	
	/**
	 * Value of number of moves
	 */
	private int number_of_moves;
	
	/**
	 * x-axis of the Player
	 */
	private int x;
	
	/**
	 * y-axis of the Player
	 */
	private int y;
	
	/**
	 *  Value of stopdeath
	 */
	private boolean stopdeath;
	
	/**
	 * Default constructor with all the variables 0
	 */
	public Player() {
		this.HP = 0;
		this.Atk = 0;
		this.Def = 0;
		this.Score = 0;
		this.number_of_moves = 0;
		this.x = 0;
		this.y = 0;
	}
	
	/**
	 * Constructor
	 * @param HP Value of HP
	 * @param Atk  Value of Atk
	 * @param Def Value of Def
	 * @param Score  Value of Score
	 * @param step_on_tiles  Symbol of the player stepped on
	 * @param number_of_moves Value of number of moves
	 * @param x  x-axis of the Player
	 * @param y  y-axis of the Player
	 * 
	 */
	public Player(int HP, int Atk, int Def, int Score, char step_on_tiles, int number_of_moves, int x, int y) {
		this.HP = HP;
		this.Atk = Atk;
		this.Def = Def;
		this.Score = Score;
		this.number_of_moves = number_of_moves;
		this.x = x;
		this.y = y;
	}
	
	/**
	 * This will alter the location of the player with specific directions
	 * @param direction direction of the player to move
	 */
	public void movement(String direction) {
		if (direction.equals("no") ) {
			this.x--;
		} else if (direction.equals("so") ) {
			this.x++;
		} else if (direction.equals("ea") ) {
			this.y++;
		} else if (direction.equals("we") ) {
			this.y--;
		} else if (direction.equals("ne") ) {
			this.y++;
			this.x--;
		} else if (direction.equals("nw") ) {
			this.y--;
			this.x--;
		} else if (direction.equals("se") ) {
			this.y++;
			this.x++;
		} else if (direction.equals("sw") ) {
			this.y--;
			this.x++;
		}
	}

	/**
	 * add 1 to the movement once it is called
	 */
	public void increasemovement() {
		this.number_of_moves++;
	}
	

	/**
	 * This will calculate the damange that Player done to the Enemy
	 * @param curr_enemy instance of current enemy class
	 * @return Return the value of the damage
	 */
	public int attack(Enemy curr_enemy) {
		int damage = (int) Math.ceil(this.getAtk() - ((100 - curr_enemy.getDef()) / 100));
		curr_enemy.setHp(curr_enemy.getHp() - damage);	
		return damage;
	}
	
	// getHP
	// void -> int
	// Usage : Get the value of HP
	/**
	 * Return the value of HP
	 * @return Return the value of HP
	 */
	public int getHP() {
		return HP;
	}

	/**
	 * Set the value of player
	 * @param hP hp of player
	 */
	public void setHP(int hP) {
		HP = hP;
	}

	/**
	 * Return the value of attack
	 * @return Return the value of attack
	 */
	public int getAtk() {
		return Atk;
	}

	/**
	 * Set the value of attack
	 * @param atk value of attack
	 */
	public void setAtk(int atk) {
		Atk = atk;
	}

	/**
	 * Return the value of defend
	 * @return Return the value of defend
	 */
	public int getDef() {
		return Def;
	}

	/**
	 * Set the value of defend
	 * @param def defend of player
	 */
	public void setDef(int def) {
		Def = def;
	}

	/**
	 * Return the value of Score
	 * @return the value of Score
	 */
	public int getScore() {
		return this.Score;
	}

	/**
	 * Set the value of score
	 * @param Score score of the game
	 */
	public void setScore(int Score) {
		this.Score = Score;
	}

	/**
	 * Return the value of x-axis 
	 * @return the value of x-axis 
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * set the value of x-axis 
	 * @param x x-axis
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Return the value of y-axis 
	 * @return Return the value of y-axis 
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * set the value of y-axis 
	 * @param y y-axis
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Return value of step_of_tiles 
	 * @return Return value of step_of_tiles 
	 */
	public char getTiles() {
		return this.step_on_tiles;
	}
	
	/**
	 * set the value of step_of_tiles 
	 * @param step_on_tiles value of tiles
	 */
	public void setTiles(char step_on_tiles) {
		this.step_on_tiles = step_on_tiles;
	}

	/**
	 * Return number of moves of the player
	 * @return Return number of moves of the player
	 */
	public int getnumber_of_moves() {
		return this.number_of_moves;
	}

	/**
	 * Return true if the player is dead
	 * @return Return true if the player is dead
	 */
	public Boolean isDeath() {
		return ( this.HP <= 0 );
	}
	
	
	/**
	 * This will update the score of the player with 100
	 */
	public void updatescore() {
		this.Score += 100;
	}


	/**
	 * Return the value of stopdeath
	 * @return Return the value of stopdeath
	 */
	public boolean isStopdeath() {
		return stopdeath;
	}


	/**
	 * set the value of stopdeath
	 * @param stopdeath value of stopdeath
	 */
	public void setStopdeath(boolean stopdeath) {
		this.stopdeath = stopdeath;
	}


}