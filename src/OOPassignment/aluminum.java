package OOPassignment;

/**
 * subclass of Enemy
 * @author Chang Choon Kit
 *
 */
public class aluminum extends Enemy {
	
	/**
	 * Default value with the following :
	 * display : 'A'
	 * hp : 70
	 * atk : 20
	 * def :80
	 * x : 0
	 * y : 0
	 */
	public aluminum(){
		super('A', 70, 20, 80, 0, 0);
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
	public aluminum( char display, int hp, int atk, int def, int x, int y){
		super( display, hp, atk, def, x, y);
	}
	
}