package OOPassignment;

/**
 * Enemy
 * @author Chang Choon Kit
 * 
 *  
*/
public abstract class Enemy{

	private char display;
	private int hp;
	private int atk;
	private int def;
	private int x;
	private int y;
	private char step_on_tiles;
	
	/**
	 *  Default constructor
	 */
	public Enemy(){
		this.display = ' ';
		this.hp = 0;
		this.atk = 0;
		this.def = 0;
		this.x = 0;
		this.y = 0;
	}
	
	/**
	 * Constructor
	 * @param display 	 Display for the enemy
	 * @param hp  value of the hp
	 * @param atk  value of the attack
	 * @param def  value of the defend
	 * @param x  x-axis of the Enemy
	 * @param y y-axis of the Enemy
	 */
	public Enemy(char display, int hp, int atk, int def, int x, int y){
		this.display = display;
		this.hp = hp;
		this.atk = atk;
		this.def = def;
		this.x = x;
		this.y = y;
	}

	
	/**
	 *  It will randomize the movement of the enemymove
	 */
	public void enemyMove(){
		int random = (int)(Math.random()*8);
		
		if(random == 0){
			//move north
			this.x--;
		}
		
		if(random == 1){
			//move south
			this.x++;
		}
		
		if(random == 2){
			//move east
			this.y++;
		}
		
		if(random == 3){
			//move west
			this.y--;
		}
		
		if(random == 4){
			//move north east
			this.y++;
			this.x--;
			
		}
		
		if(random == 5){
			//move north west
			this.y--;
			this.x--;
		}
		
		if(random == 6){
			//move south east
			this.y++;
			this.x++;
		}
		
		if(random == 7){
			//move south west
			this.y--;
			this.x++;
		}
		
	}
	
	/**
	 * Return true if the Enemy is death, otherwise return false
	 * @return Return true if the Enemy is death, otherwise return false
	 */
	public Boolean isDeath() {
		return ( this.hp <= 0 );
	}

	/**
	 * Return the value of display
	 * @return Return the value of display
	 */
	public char getDisplay(){
		return display;
	}
	
	/**
	 * Set the value of display
	 * @param display value of display
	 */
	public void setDisplay(char display){
		this.display = display;
	}
	
	/**
	 * Return the value of hp
	 * @return Return the value of hp
	 */
	public int getHp(){
		return hp;
	}
	
	/**
	 * Set the value of hp
	 * @param hp value of hp
	 */
	public void setHp(int hp){
		this.hp = hp;
	}
	
	/**
	 * Return the value of attack
	 * @return Return the value of attack
	 */
	public int getAtk(){
		return atk;
	}

	/**
	 * Set the value of atk
	 * @param atk value of atk
	 */
	public void setAtk(int atk){
		this.atk = atk;
	}
	
	/**
	 * Return the value of defend
	 * @return Return the value of defend
	 */
	public int getDef(){
		return def;
	}
	

	/**
	 * Set the value of def
	 * @param def value of defend
	 */
	public void setDef(int def){
		this.def = def;
	}
	
	/**
	 * Return the value of x
	 * @return Return the value of x
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Set the value of x
	 * @param x X-axis
	 */
	public void setX(int x) {
		this.x = x;
	}
	

	/**
	 * Return the value of y
	 * @return Return the value of y
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * Set the value of y
	 * @param y y-axis
	 */
	public void setY(int y) {
		this.y = y;
	}


	/**
	 * Return the value of step_on_tiles
	 * @return Return the value of step_on_tiles
	 */
	public char getETiles() {
		return this.step_on_tiles;
	}


	/**
	 * Set the value of step_on_tiles
	 * @param step_on_tiles value of tiles
	 */
	public void setETiles(char step_on_tiles) {
		this.step_on_tiles = step_on_tiles;
	}
	
	/**
	 * Change the value of curr_player after the attack
	 * @param curr_player instance of current player
	 * @return Return the damage done
	 */
	public int eAttack(Player curr_player) {
	    int damage = (int) Math.ceil(this.getAtk() - ((100 - curr_player.getDef()) / 100));
	    int total = curr_player.getHP() - damage;
	    curr_player.setHP(total);
	    return damage;
	  }

		
}