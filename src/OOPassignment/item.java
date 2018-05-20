package OOPassignment;

/**
 * item
 * @author Ding Zhan Chia
 *
 */
public abstract class item {
	
	/** item value
	 */
	private int value;
	
	/** x-axis 
	 */
	private int x;
	
	/** y-axis 
	 */
	private int y;
	

	/** Default Constructor
	 */
	item(){
		this.value = 0;
		this.x = 0;
		this.y = 0;
	}
	
	/**
	 * Constructor
	 * @param value value of the item
	 * @param x x-axis of the item
	 * @param y y-axis of the item
	 */
	item( int x , int y, int value ) {
		this.x = x;
		this.y = y;
		this.value = value;
	}
	
	/**
	 * value of value
	 * @return value of value
	 */
	public int getValue() {
		return value;
	}


	/**
	 *
	 * @param value Y-axis
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * value of x
	 * @return value of x
	 */
	public int getX() {
		return x;
	}
	

	/**
	 * Set the value of x
	 * @param x x-xis
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Get the value of Y
	 * @return value of Y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Set the value of y
	 * @param y y-axis
	 */
	public void setY(int y) {
		this.y = y;
	}

}
