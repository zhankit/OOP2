package OOPassignment;

/**
 * subclass of Enemy
 * @author Chang Choon Kit
 *
 */
public class bottle extends Enemy {
	
	/**
	 * Default value with the following :
	 * display : 'B'
	 * hp : 70
	 * atk : 10
	 * def : 60
	 * x : 0
	 * y : 0
	 */
	public bottle(){
		super('B', 70, 10, 60, 0, 0);
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
	public bottle( char display, int hp, int atk, int def, int x, int y){
		super(display, hp, atk, def, x, y);
	}
	
}