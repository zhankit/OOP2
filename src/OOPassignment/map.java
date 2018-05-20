
package OOPassignment;

import java.io.*;
import java.util.*;


/**
 * main class for game
 * @author Ding Zhan Chia, Lee Jin Quan, Chang Choon Kit
 *
 */
public class map {

	/**
	 * @param map_layout    : An array of char to store the map layout
	 * @param curr_player 	: A class with the Player
	 * @param listofenemy  	: An ArrayList of Enemy
	 * @param listofItem 	: An ArrayList of Potion
	 * @param listofGold    : An ArrayList of Gold
	 * @param map 			: An initialize for the InputStream
	 * @param isWander      : Value if the enemy can wander around
	 * @param difficulty	: difficulty of the game
	 */
	char[][] map_layout;
	private Player curr_player ;
	private ArrayList < Enemy > listofenemy ;
	private ArrayList < Potion > listofItem ;
	private ArrayList < Gold > listofGold ;
	private boolean isWander;
	private String difficulty;
	
	/**
	 * m
	 */
	public map() {}
	
	/**
	 * 
	 * @param job the job that can be chosen 1.'v' 2.'b' 3.'d'
	 * @param difficulty the difficulty that can be chosen 1.'easy' 2.'medium' 3.'hard'
	 */
	public map(String job, String difficulty) {
		
		// isWander to be false
		this.isWander = true;
		
		// Initialize the map_layout first
		this.map_layout = new char[25][80];
		String map[] = new String[25];
		map[0]="|-----------------------------------------------------------------------------|";
		map[1]="|                                                                             |";
		map[2]="| |--------------------------|        |-----------------------|               |";
		map[3]="| |..........................|        |.......................|               |";
		map[4]="| |..........................+########+.......................|-------|       |";
		map[5]="| |..........................|  #     |...............................|--|    |";
		map[6]="| |..........................|  #     |..................................|--| |";
		map[7]="| |----------+---------------|  #     |----+----------------|...............| |";
		map[8]="|            #                 #############                |...............| |";
		map[9]="|            #                 #     |-----+------|         |...............| |";
		map[10]="|            #                 #     |............|         |...............| |";
		map[11]="|            ###################     |............|   ######+...............| |";
		map[12]="|            #                 #     |............|   #     |...............| |";
		map[13]="|            #                 #     |-----+------|   #     |--------+------| |";
		map[14]="|  |---------+-----------|     #           #          #              #        |";
		map[15]="|  |.....................|     #           #          #         |----+------| |";
		map[16]="|  |.....................|     ########################         |...........| |";
		map[17]="|  |.....................|     #           #                    |...........| |";
		map[18]="|  |.....................|     #    |------+--------------------|...........| |";
		map[19]="|  |.....................|     #    |.......................................| |";
		map[20]="|  |.....................+##########+.......................................| |";
		map[21]="|  |.....................|          |.......................................| |";
		map[22]="|  |---------------------|          |---------------------------------------| |";
		map[23]="|                                                                             |";
		map[24]="|-----------------------------------------------------------------------------|";
		

		for( int i = 0 ; i < 25 ; i++ ) {
			for( int j = 0 ; j < 79 ; j++ ) {
				this.map_layout[i][j] = map[i].charAt(j);
			}
		}


		// Set the difficulty of the level
		if ( difficulty.equals("e") ) {
			this.difficulty = "Easy";
		} else if ( difficulty.equals("m") ) {
			this.difficulty = "Medium";
		} else if ( difficulty.equals("d") ) {
			this.difficulty = "Hard";
		} 
		
		// Initialize the monster variable and allocate address
		int[] monster_chamber_counter = new int[5];
		this.listofenemy = new ArrayList <Enemy> ();
		int enemy_index = 0;
                int x, y;

		// Spawn Monster until the size is 16
		while( this.listofenemy.size() != 16 ) {
		        
			Enemy spawn;

	        int random = (int)(Math.random() * 9 );
	        
	        if ( random <= 2 ){
	          spawn = new aluminum();
	        }
	        else if ( random <= 5 ){
	          spawn = new paper();
	        }
	        else {
	          spawn = new bottle();
	        }
		        
	        // first there're 5 chambers in the map. First find a random number from 1-5 
	      
	        int randomChamber = (int)( Math.random() * 5 );
	        
	        // Chamber 1
	        if ( randomChamber == 0 && monster_chamber_counter[0] < 4 ) {
		          x = 3 + (int)( Math.random() * 3 );  
		          y = 3 + (int)( Math.random() * 25 );  
		          if ( this.ifLocationEmpty(x, y) ) {
			           this.set_tiles(x, y , spawn.getDisplay());
			           this.listofenemy.add(spawn);
			           this.listofenemy.get(enemy_index).setX(x);
			           this.listofenemy.get(enemy_index).setY(y);
			           enemy_index++;
			           monster_chamber_counter[0]++;
		          }
	        }

	        // Chamber 2
	        else if(randomChamber == 1 && monster_chamber_counter[1] < 4 ){
		          x = 15 + (int)( Math.random() * 6 );  
		          y = 4 + (int)( Math.random() * 20 );  
		          if ( this.ifLocationEmpty(x, y) ) {
			           this.set_tiles(x, y , spawn.getDisplay());
			           this.listofenemy.add(spawn);
			           this.listofenemy.get(enemy_index).setX(x);
			           this.listofenemy.get(enemy_index).setY(y);
			           enemy_index++;
			           monster_chamber_counter[1]++;
		          }
	        }
		         
	        // Chamber 3
	        else if(randomChamber == 2 && monster_chamber_counter[2] < 3 ){
		          x = 10 + (int)( Math.random() * 2 ); 
		          y = 38 + (int)( Math.random() * 11 );  
		          if ( this.ifLocationEmpty(x, y) ) {
			           this.set_tiles(x, y , spawn.getDisplay());
			           this.listofenemy.add(spawn);
			           this.listofenemy.get(enemy_index).setX(x);
			           this.listofenemy.get(enemy_index).setY(y);
			           enemy_index++;
			           monster_chamber_counter[2]++;
		          }
	        }
		          
	        // Chamber 4
	        else if(randomChamber == 3 && monster_chamber_counter[3] < 4 ) {
		          int randomBox_c4 = 0 + (int)( Math.random() * 10 );
		          if( randomBox_c4 >= 0 && randomBox_c4 <= 4 ){
			            x = 16 + (int)( Math.random() * 2 ); 
			            y = 65 + (int)( Math.random() * 11 ); 
		          }
		          else {
			            x = 19 + (int)( Math.random() * 2 );  
			            y = 37 + (int)( Math.random() * 39 );  
		          }
		          
			      if ( this.ifLocationEmpty(x, y) ) {
				           this.set_tiles(x, y , spawn.getDisplay() );
				           this.listofenemy.add(spawn);
				           this.listofenemy.get(enemy_index).setX(x);
				           this.listofenemy.get(enemy_index).setY(y);
				           enemy_index++;
				           monster_chamber_counter[3]++;
				  }   
	        }
		        
	        // Chamber 5
	        else if( randomChamber == 4 && monster_chamber_counter[4] < 5 ){
	        	
		          int randomBox_c5 = 0 + (int)( Math.random() * 4 );
		          if (randomBox_c5 == 0 ) {
		        	  x = 3 + (int)( Math.random() * 2 );  
		        	  y = 40 + (int)( Math.random() * 33 );  
			      } else if (randomBox_c5 == 1 ) {
			    	  x = 5 ; 
			    	  y = 40 + (int)( Math.random() * 31 );  
		          } else if (randomBox_c5 == 2 ) {
		        	  x = 6; 
		        	  y = 40 + (int)( Math.random() * 34 ); 
		          } else {
		              x = 7 + (int)( Math.random() * 5 );  
		        	  y = 40 + (int)( Math.random() * 36 );  
		          }
		          if ( this.ifLocationEmpty(x, y) ) {
		        	  this.set_tiles(x, y , spawn.getDisplay() );
		        	  this.listofenemy.add(spawn);
		        	  this.listofenemy.get(enemy_index).setX(x);
		        	  this.listofenemy.get(enemy_index).setY(y);
		        	  enemy_index++;
		        	  monster_chamber_counter[4]++;
		          }
	        }
		}

		// Spawn Player
		if (job.equals("b")) {
			this.curr_player = new broom();	
		} else if (job.equals("v")) {
			this.curr_player = new vacumm();
		} else if (job.equals("d")) {
			this.curr_player = new duster();
		}
				
		boolean spawnCounter = true;
		int m = (int) (Math.random() * 24);
		int n = (int) (Math.random() * 80);
		
		while(spawnCounter) {
			if (this.ifLocationEmpty(m, n)) {
				this.set_tiles(m, n, '@');
				this.curr_player.setX(m);
				this.curr_player.setY(n);
				this.curr_player.setTiles('.');
				spawnCounter = false;
			}
			else {
				m = (int) (Math.random() * 24) ;
				n = (int) (Math.random() * 80) ;
			}
		}
				
		// Spawn Potion
		this.listofItem = new ArrayList <Potion> ();
		m = (int) (Math.random() * 24);
		n = (int) (Math.random() * 80) ;
		Potion new_potion;
		while( this.listofItem.size() != 10) {
			
			if (this.ifLocationEmpty(m, n)) {
				this.set_tiles(m, n, '!');
				
				// There is 6 kind of Potion 
				int z = (int) (Math.random() * 6);
				if (z == 0 ) {
					new_potion = new Potion(30,"RH",m,n);
				} else if (z == 1 ) {
					new_potion = new Potion(10,"BA",m,n);
				} else if (z == 2 ) {
					new_potion = new Potion(10,"BD",m,n);
				} else if (z == 3 ) {
					new_potion = new Potion(15,"PH",m,n);
				} else if (z == 4 ) {
					new_potion = new Potion(5,"WA",m,n);
				} else {
					new_potion = new Potion(5,"WD",m,n);
				} 
				this.listofItem.add(new_potion);
			} else {
				m = (int) (Math.random() * 24);
				n = (int) (Math.random() * 80);
			}
		}
		
		this.listofGold = new ArrayList < Gold > ();
		m = (int) (Math.random() * 24);
		n = (int) (Math.random() * 80) ;
		Gold new_gold;
		while( this.listofGold.size() != 5) {
			
			if (this.ifLocationEmpty(m, n)) {
				this.set_tiles(m, n, 'G');
				int z = (int) (Math.random() * 100);
				new_gold = new Gold(m,n, z);
				this.listofGold.add(new_gold);
			} else {
				m = (int) (Math.random() * 24);
				n = (int) (Math.random() * 80);
			}
		}

	}


	/**
	 * 
	 * @param x X-axis
	 * @param y Y-axis
	 * @return Return true it is '.', otherwise return false
	 */
	public boolean ifLocationEmpty(int x, int y) {
		if (this.map_layout[x][y] == '.') {
				return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * 
	 * @param direction direction of the movement
	 * @return Return true if the direction is movable, return false otherwise
	 */
	public boolean movement( String direction) {
		if ( isMovement(direction) ) {
			
			int x = this.curr_player.getX();
			int y = this.curr_player.getY();
			this.curr_player.movement(direction);
			this.set_tiles( x , y, this.curr_player.getTiles() );			
			this.curr_player.setTiles(this.map_layout[ this.curr_player.getX() ][ this.curr_player.getY() ]);
			this.set_tiles(this.curr_player.getX(), this.curr_player.getY() , '@');
			this.curr_player.increasemovement();
			return true;
			
		} else { return false; }
		
	}
	

	/**
	 * 
	 * @param direction direction of the movement
	 * @return Return true if the direction is movable, return false otherwise
	 */
	public boolean isMovement(String direction) {
		
		if (direction.equals("no") ) {
			return check_location_to_move(this.curr_player.getX() - 1 , this.curr_player.getY() );
		} else if (direction.equals("so") ) {
			return check_location_to_move(this.curr_player.getX() + 1, this.curr_player.getY() );
		} else if (direction.equals("ea") ) {
			return check_location_to_move(this.curr_player.getX() , this.curr_player.getY() + 1);
		} else if (direction.equals("we") ) {
			return check_location_to_move(this.curr_player.getX() , this.curr_player.getY() - 1);
		} else if (direction.equals("ne") ) {
			return check_location_to_move(this.curr_player.getX() - 1 , this.curr_player.getY() + 1);
		} else if (direction.equals("nw") ) {
			return check_location_to_move(this.curr_player.getX() - 1 , this.curr_player.getY() - 1);
		} else if (direction.equals("se") ) {
			return check_location_to_move(this.curr_player.getX() + 1 , this.curr_player.getY() + 1);
		} else if (direction.equals("sw") ) {
			return check_location_to_move(this.curr_player.getX() + 1 , this.curr_player.getY() - 1);
		} else {
			return false;
		}
		
	}
	

	/**
	 * Condition 
	 * 1. It will check if the direction has an enemy
	 * 2. Perform a attack with the curr_player to the enemy
	 * 3. The Enemy will attack back if it is not dead yet
	 * 4. Update Score and change the tiles if the enemy is dead
	 * @param direction  direction of the movement
	 * @return Return true if enemy is found and can perform attack, otherwise false
	 */
	public boolean ifAttack ( String direction ) {
		String result1 = "";
		
		// Magician class
		if ( this.curr_player instanceof vacumm ) {
			for ( int i = 1 ; !this.isWall(direction, i) ; i++) {
				if ( isMonster(direction,i) != null ) {
					
					int dmg = this.curr_player.attack(isMonster(direction,i));

					result1 += "You Attack the enemy with " + dmg + " dmg.\n" ;

					if ( this.isMonster(direction,i).isDeath() ) {
						int x = isMonster(direction,i).getX();
						int y = isMonster(direction,i).getY();
						this.set_tiles(x, y, '.');
						this.listofenemy.remove(isMonster(direction,i));
						this.curr_player.updatescore();
						result1 += EnemyAttack();
						result1 += "Enemy Slained";
						
						int random = (int) ( Math.random() * 50);
						if ( random <= 20 ) {
									this.set_tiles(x, y, 'G');
									int z = (int) (Math.random() * 100);
									Gold new_gold = new Gold(x,y, z);
									this.listofGold.add(new_gold);
							result1 += " and it dropped Gold!\n";
						} else {
							result1 += "!\n";
						}
					} else {
						result1 += EnemyAttack();
					}
					result1 += "===============================================================================";
					System.out.println(this + result1);
					return true;
					
				} // for monster is found
			} // for loop
			
			return false;
			
		// Ninja and Warrior
		} else {
			
			// Check if the monster is in the direction
			if (isMonster(direction,1) != null) {
				
				// Check if the player is duster
				if ( this.curr_player instanceof duster ) {
					((duster) this.curr_player).setIsHidden(false);
				}
				
				int dmg = this.curr_player.attack(isMonster(direction,1));
				result1 += "You Attack the enemy with " + dmg + " dmg.\n" ;

				if (this.isMonster(direction,1).isDeath() ) {
					int x = isMonster(direction,1).getX();
					int y = isMonster(direction,1).getY();
					this.set_tiles(x, y, '.');
					this.listofenemy.remove(isMonster(direction,1));
					this.curr_player.updatescore();
					result1 += EnemyAttack() + "Enemy Slained";
					int random = (int) ( Math.random() * 50);
					if ( random <= 20 ) {
								this.set_tiles(x, y, 'G');
								int z = (int) (Math.random() * 100);
								Gold new_gold = new Gold(x,y, z);
								this.listofGold.add(new_gold);
						result1 += " and it dropped Gold!\n";
					} else {
						result1 += "!\n";
					}
		
				} else {
					result1 += EnemyAttack();
				}
				
				result1 += "===============================================================================";
				System.out.println(this.toString() + result1);
				return true;
			}
			else { 
				return false; 
			}
		}
	}
	

	/**
	 * Check if the Enemy can perform any attack to the player
	 * @return Return true if attack can be perform, return false otherwise
	 */
	public String EnemyAttack() {
		
		String result = "";
		int x = curr_player.getX();
		int y = curr_player.getY();
			  
		if ( this.curr_player instanceof duster && ((duster) this.curr_player).getIsHidden() ) {
			return result;
		}
		for ( Enemy enemyAttack : this.listofenemy ){
			if( ( x == (enemyAttack.getX() - 1 ) && y == ( enemyAttack.getY() - 1 )) || 
					(x == (enemyAttack.getX() - 1 ) && y == enemyAttack.getY() ) || 
					(x == (enemyAttack.getX() - 1 ) && y == ( enemyAttack.getY() + 1 )) ||
					(x == enemyAttack.getX() && y == ( enemyAttack.getY() - 1 )) || 
					(x == enemyAttack.getX() && y == ( enemyAttack.getY() + 1 )) || 
					(x == (enemyAttack.getX() + 1 ) && y == ( enemyAttack.getY() - 1 )) ||
					(x == (enemyAttack.getX() + 1 ) && y == enemyAttack.getY()) || 
					(x == (enemyAttack.getX() + 1 ) && y == (enemyAttack.getY() + 1 )) ){
				result += "Enemy " +  enemyAttack.getDisplay() + " attack you with " + enemyAttack.eAttack(this.curr_player) + " dmg!\n" ;
			}
		}
		return result;
	}
	

	/**
	 * 
	 * @param x X-axis
	 * @param y Y-axis
	 * @return Return true if the location x, y is movable, return false otherwise
	 */
	public boolean check_location_to_move(int x, int y) {
		if (this.map_layout[x][y] == '.' ||  this.map_layout[x][y] == '#' || this.map_layout[x][y] == '+' || this.map_layout[x][y] == '!' || this.map_layout[x][y] == 'G') {
				return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param x X-axis
	 * @param y Y-axis
	 * @return Return true if the location x, y is a wall, return false otherwise
	 */
	public boolean ifLocationWall(int x, int y) {
		if (this.map_layout[x][y] == '|' ||  this.map_layout[x][y] == '-' || this.map_layout[x][y] == '+') {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param direction direction to check
	 * @param i distance between tiles and player
	 * @return Return theEnemy if the monster exists at the direction, return null otherwise
	 */
	public Enemy isMonster(String direction, int i) {
		
		if (direction.equals("no") ) {
			return check_location_to_attack(this.curr_player.getX() - i , this.curr_player.getY() );
		} else if (direction.equals("so") ) {
			return check_location_to_attack(this.curr_player.getX() + i, this.curr_player.getY() );
		} else if (direction.equals("ea") ) {
			return check_location_to_attack(this.curr_player.getX() , this.curr_player.getY() + i);
		} else if (direction.equals("we") ) {
			return check_location_to_attack(this.curr_player.getX() , this.curr_player.getY() - i );
		} else if (direction.equals("ne") ) {
			return check_location_to_attack(this.curr_player.getX() - i , this.curr_player.getY() + i );
		} else if (direction.equals("nw") ) {
			return check_location_to_attack(this.curr_player.getX() - i , this.curr_player.getY() - i);
		} else if (direction.equals("se") ) {
			return check_location_to_attack(this.curr_player.getX() + i , this.curr_player.getY() + i);
		} else if (direction.equals("sw") ) {
			return check_location_to_attack(this.curr_player.getX() + i , this.curr_player.getY() - i);
		}else {
			return null;
		}
		
	}
	

	/**
	 * 
	 * @param direction direction to check
	 * @param i distance between tiles and player
	 * @return Return true if the direction is wall, return false otherwise
	 */
	public boolean isWall(String direction, int i) {

		if (direction.equals("no") ) {
			return ifLocationWall(this.curr_player.getX() - i , this.curr_player.getY() );
		} else if (direction.equals("so") ) {
			return ifLocationWall(this.curr_player.getX() + i, this.curr_player.getY() );
		} else if (direction.equals("ea") ) {
			return ifLocationWall(this.curr_player.getX() , this.curr_player.getY() + i);
		} else if (direction.equals("we") ) {
			return ifLocationWall(this.curr_player.getX() , this.curr_player.getY() - i);
		} else if (direction.equals("ne") ) {
			return ifLocationWall(this.curr_player.getX() - i , this.curr_player.getY() + i);
		} else if (direction.equals("nw") ) {
			return ifLocationWall(this.curr_player.getX() - i , this.curr_player.getY() - i);
		} else if (direction.equals("se") ) {
			return ifLocationWall(this.curr_player.getX() + i , this.curr_player.getY() + i);
		} else if (direction.equals("sw") ) {
			return ifLocationWall(this.curr_player.getX() + i , this.curr_player.getY() - i);
		}else {
			return false;
		}
		
	}
	

	/**
	 * 
	 * @param x X-axis
	 * @param y Y-axis
	 * @return Return the Enemy if it is found at the x,y location, return null otherwise
	 */
	public Enemy check_location_to_attack(int x, int y) {
		for ( Enemy i : this.listofenemy ) {
			if ( ( i.getX() == x ) && ( i.getY() == y ) ) {	return i;	}
		}
		return null;
	}

	/**
	 * 
	 * @param x X-axis
	 * @param y Y-axis
	 * @return Return the distance between enemy and player
	 */
	public int shortestpath( int x, int  y) {
		return (int) Math.sqrt( ( x - this.curr_player.getX() )*( x - this.curr_player.getX() ) + ( y - this.curr_player.getY() )*( y - this.curr_player.getY()) );
	}
	

	/**
	 * Adding list of direction available into a list for each enemy character.
	 * Perform the direction by choosing it randomly; Do nothing if isWander is false
	 * @param isSmart automation of bot
	 */
	public void enemyMovement( Boolean isSmart){
		
		if ( !this.isWander ) {
			return;
		}
		
		// The Enemy will perform the attack before moving
		String result = this.EnemyAttack();
		if ( result.isEmpty() ) {
			System.out.println( this + result );
		} else {
			System.out.println( this + result + "===============================================================================\n" );
		}

		for ( Enemy i : this.listofenemy ) {
			
			ArrayList < String > enemy_move = new ArrayList < String > ();
			if ( this.curr_player instanceof duster && ((duster) this.curr_player).getIsHidden() ) {
				if ( this.ifLocationEmpty(i.getX() - 1, i.getY()) ){
					enemy_move.add("no");
				}
				if ( this.ifLocationEmpty(i.getX() + 1, i.getY()) ){
					enemy_move.add("so");
				}
				if (this.ifLocationEmpty(i.getX(), i.getY() + 1)){
					enemy_move.add("ea");
				}
				if (this.ifLocationEmpty( i.getX() , i.getY() - 1)){
					enemy_move.add("we");
				}
				if (this.ifLocationEmpty( i.getX() - 1 , i.getY() + 1)){
					enemy_move.add("ne");
				}
				if (this.ifLocationEmpty( i.getX() - 1 , i.getY() - 1)){
					enemy_move.add("nw");
				}
				if (this.ifLocationEmpty( i.getX() + 1 , i.getY()+ 1)){
					enemy_move.add("se");
				}
				if (this.ifLocationEmpty( i.getX() + 1 , i.getY() - 1)){
					enemy_move.add("sw");
				}
				
				if ( enemy_move.size() != 0 ) {
					int random = ( int )( Math.random() * enemy_move.size() );
					
					if( enemy_move.get(random) == "no"){
						this.set_tiles(i.getX(), i.getY(), '.');
						this.set_EnemyTiles(i.getX() - 1, i.getY() , i);
						i.setX( i.getX() - 1 );
						i.setY( i.getY() );
					}
						
					else if( enemy_move.get(random) == "so"){
						this.set_tiles(i.getX(), i.getY(), '.');
						this.set_EnemyTiles(i.getX() + 1, i.getY() , i);
						i.setX( i.getX() + 1 );
						i.setY( i.getY() );
					}
						
					else if( enemy_move.get(random) == "ea"){
						this.set_tiles(i.getX(), i.getY(), '.');
						this.set_EnemyTiles(i.getX() , i.getY() + 1 , i);
						i.setX( i.getX()  );
						i.setY( i.getY() + 1 );
					}
						
					else if( enemy_move.get(random) == "we"){
						this.set_tiles(i.getX(), i.getY(), '.');
						this.set_EnemyTiles(i.getX(), i.getY() - 1 , i);
						i.setX( i.getX()  );
						i.setY( i.getY() - 1 );
					}
					
					else if( enemy_move.get(random) == "ne"){
						this.set_tiles(i.getX(), i.getY(), '.');
						this.set_EnemyTiles(i.getX() - 1, i.getY() + 1 , i);
						i.setX( i.getX() - 1 );
						i.setY( i.getY() + 1 );
					}
					
					else if( enemy_move.get(random) == "nw"){
						this.set_tiles(i.getX(), i.getY(), '.');
						this.set_EnemyTiles(i.getX() - 1, i.getY() - 1 , i);
						i.setX( i.getX() - 1 );
						i.setY( i.getY() - 1 );
					}
					
					else if( enemy_move.get(random) == "se"){
						this.set_tiles(i.getX(), i.getY(), '.');
						this.set_EnemyTiles(i.getX() + 1, i.getY() + 1 , i);
						i.setX( i.getX() + 1 );
						i.setY( i.getY() + 1 );
					}
					
					else if( enemy_move.get(random) == "sw"){
						this.set_tiles(i.getX(), i.getY(), '.');
						this.set_EnemyTiles(i.getX() + 1, i.getY() - 1, i);
						i.setX( i.getX() + 1 );
						i.setY( i.getY() - 1 );
					}
					continue;
				}
			}
			
			if ( isSmart ) {
				ArrayList < Integer > distance = new ArrayList < Integer > ();
				distance.add( shortestpath( i.getX() - 1, i.getY() ) );
				distance.add( shortestpath( i.getX() + 1, i.getY() ) );
				distance.add( shortestpath( i.getX() , i.getY() + 1) );
				distance.add( shortestpath( i.getX() , i.getY() - 1) );
				distance.add( shortestpath( i.getX() - 1, i.getY() + 1) );
				distance.add( shortestpath( i.getX() - 1, i.getY() - 1) );
				distance.add( shortestpath( i.getX() + 1, i.getY() + 1) );
				distance.add( shortestpath( i.getX() + 1, i.getY() - 1) );

				int minimun = distance.get(0);
				for ( int j = 1 ; j < distance.size() ; j++ ) {
					if ( minimun >= distance.get(j) ) minimun = distance.get(j);
				}
				
				if ( ( difficulty.equals("Easy") && minimun > 5) || ( difficulty.equals("Medium") && minimun > 15 ) || ( difficulty.equals("Hard") && minimun > 25)) {
					if ( this.ifLocationEmpty(i.getX() - 1, i.getY()) ){
						enemy_move.add("no");
					}
					if ( this.ifLocationEmpty(i.getX() + 1, i.getY()) ){
						enemy_move.add("so");
					}
					if (this.ifLocationEmpty(i.getX(), i.getY() + 1)){
						enemy_move.add("ea");
					}
					if (this.ifLocationEmpty( i.getX() , i.getY() - 1)){
						enemy_move.add("we");
					}
					if (this.ifLocationEmpty( i.getX() - 1 , i.getY() + 1)){
						enemy_move.add("ne");
					}
					if (this.ifLocationEmpty( i.getX() - 1 , i.getY() - 1)){
						enemy_move.add("nw");
					}
					if (this.ifLocationEmpty( i.getX() + 1 , i.getY()+ 1)){
						enemy_move.add("se");
					}
					if (this.ifLocationEmpty( i.getX() + 1 , i.getY() - 1)){
						enemy_move.add("sw");
					} 
				} else {
					
					if ( distance.get(0) == minimun && this.ifLocationEmpty(i.getX() - 1, i.getY())) {
						enemy_move.add("no");
					}
					if ( distance.get(1) == minimun && this.ifLocationEmpty(i.getX() + 1, i.getY())) {
						enemy_move.add("so");
					}				
					if ( distance.get(2) == minimun && this.ifLocationEmpty(i.getX(), i.getY() + 1) ) {
						enemy_move.add("ea");
					}				
					if ( distance.get(3) == minimun && this.ifLocationEmpty( i.getX() , i.getY() - 1)) {
						enemy_move.add("we");
					}				
					if ( distance.get(4) == minimun && this.ifLocationEmpty( i.getX() - 1 , i.getY() + 1)) {
						enemy_move.add("ne");
					}						
					if ( distance.get(5) == minimun && this.ifLocationEmpty( i.getX() - 1 , i.getY() - 1)) {
						enemy_move.add("nw");
					}
					if ( distance.get(6) == minimun && this.ifLocationEmpty( i.getX() + 1 , i.getY()+ 1) ) {
						enemy_move.add("se");
					}
					if ( distance.get(7) == minimun &&  this.ifLocationEmpty( i.getX() + 1 , i.getY() - 1) ) {
						enemy_move.add("sw");
					}
				}
						
				
			} else {
				if ( this.ifLocationEmpty(i.getX() - 1, i.getY()) ){
					enemy_move.add("no");
				}
				if ( this.ifLocationEmpty(i.getX() + 1, i.getY()) ){
					enemy_move.add("so");
				}
				if (this.ifLocationEmpty(i.getX(), i.getY() + 1)){
					enemy_move.add("ea");
				}
				if (this.ifLocationEmpty( i.getX() , i.getY() - 1)){
					enemy_move.add("we");
				}
				if (this.ifLocationEmpty( i.getX() - 1 , i.getY() + 1)){
					enemy_move.add("ne");
				}
				if (this.ifLocationEmpty( i.getX() - 1 , i.getY() - 1)){
					enemy_move.add("nw");
				}
				if (this.ifLocationEmpty( i.getX() + 1 , i.getY()+ 1)){
					enemy_move.add("se");
				}
				if (this.ifLocationEmpty( i.getX() + 1 , i.getY() - 1)){
					enemy_move.add("sw");
				}
			}
		
			// Add all the location and find the shortest path for the enemy to chase 
			// add the randomize and shortest path inside
			if ( enemy_move.size() != 0 ) {
				int random = ( int )( Math.random() * enemy_move.size() );
				
				if( enemy_move.get(random) == "no"){
					this.set_tiles(i.getX(), i.getY(), '.');
					this.set_EnemyTiles(i.getX() - 1, i.getY() , i);
					i.setX( i.getX() - 1 );
					i.setY( i.getY() );
				}
					
				else if( enemy_move.get(random) == "so"){
					this.set_tiles(i.getX(), i.getY(), '.');
					this.set_EnemyTiles(i.getX() + 1, i.getY() , i);
					i.setX( i.getX() + 1 );
					i.setY( i.getY() );
				}
					
				else if( enemy_move.get(random) == "ea"){
					this.set_tiles(i.getX(), i.getY(), '.');
					this.set_EnemyTiles(i.getX() , i.getY() + 1 , i);
					i.setX( i.getX()  );
					i.setY( i.getY() + 1 );
				}
					
				else if( enemy_move.get(random) == "we"){
					this.set_tiles(i.getX(), i.getY(), '.');
					this.set_EnemyTiles(i.getX(), i.getY() - 1 , i);
					i.setX( i.getX()  );
					i.setY( i.getY() - 1 );
				}
				
				else if( enemy_move.get(random) == "ne"){
					this.set_tiles(i.getX(), i.getY(), '.');
					this.set_EnemyTiles(i.getX() - 1, i.getY() + 1 , i);
					i.setX( i.getX() - 1 );
					i.setY( i.getY() + 1 );
				}
				
				else if( enemy_move.get(random) == "nw"){
					this.set_tiles(i.getX(), i.getY(), '.');
					this.set_EnemyTiles(i.getX() - 1, i.getY() - 1 , i);
					i.setX( i.getX() - 1 );
					i.setY( i.getY() - 1 );
				}
				
				else if( enemy_move.get(random) == "se"){
					this.set_tiles(i.getX(), i.getY(), '.');
					this.set_EnemyTiles(i.getX() + 1, i.getY() + 1 , i);
					i.setX( i.getX() + 1 );
					i.setY( i.getY() + 1 );
				}
				
				else if( enemy_move.get(random) == "sw"){
					this.set_tiles(i.getX(), i.getY(), '.');
					this.set_EnemyTiles(i.getX() + 1, i.getY() - 1, i);
					i.setX( i.getX() + 1 );
					i.setY( i.getY() - 1 );
				}
			}

			} // loop
		}
				

	/**
	 * 
	 * @return Return true if the location is an Item where the location is the curr_player, false otherwise
	 */
	public boolean isItem() {
		if ( this.curr_player.getTiles() == '!' || this.curr_player.getTiles() == 'G') { return true; } 
		else { return false; }
	}
	

	/**
	 * it will use the Item if the character have the right location
	 */
	public void useItem() {
		
		int index = 0 ;
		this.toString();
		String result1 = "";
		String result2 = "";
		int switcher = 0;
		for ( ; index < this.listofItem.size() ; index++) {
			if ( ( this.listofItem.get(index).getX() == this.curr_player.getX() ) && ( this.listofItem.get(index).getY() == this.curr_player.getY() ) ) {
				this.listofItem.get(index).use_Potion(this.curr_player);
				result2 += "Potion used! ";
				if ( this.listofItem.get(index).getPotionType().equals("RH") ) {
					result2 += "Player heal health by " + this.listofItem.get(index).getValue() + "!\n";
				} else if ( this.listofItem.get(index).getPotionType().equals("BA") ) {
					result2 += "Player boost Attack by " + this.listofItem.get(index).getValue() + "!\n";
				}  else if ( this.listofItem.get(index).getPotionType().equals("BD") ) {
					result2 += "Player boost Defend by " + this.listofItem.get(index).getValue() + "!\n";
				}  else if ( this.listofItem.get(index).getPotionType().equals("PH") ) {
					result2 += "Player poison health by " + this.listofItem.get(index).getValue()+ "!\n";
				}  else if ( this.listofItem.get(index).getPotionType().equals("WA") ) {
					result2 += "Player wound Attack by " + this.listofItem.get(index).getValue() + "!\n";
				}  else if ( this.listofItem.get(index).getPotionType().equals("WD") ) {
					result2 += "Player Wound Defend by " + this.listofItem.get(index).getValue() + "!\n";
				} 
				switcher = 1;
				break;
			}
		}
		
		if( switcher != 1 ) {
			index = 0;
			for ( ; index < this.listofGold.size() ; index++) {
				if ( ( this.listofGold.get(index).getX() == this.curr_player.getX() ) && ( this.listofGold.get(index).getY() == this.curr_player.getY() ) ) {
					this.listofGold.get(index).addGold(this.curr_player);
					result2 += "Player picked up " + this.listofGold.get(index).getValue() + " gold\n";
					switcher = 2;
					break;
				}
			}
		}
		
		result2 += "===============================================================================\n";
		
		// Remove the index
		if ( switcher == 1 ) {
			this.curr_player.setTiles('.');
			this.listofItem.remove(index);
			result1 = this.toString();
			System.out.print(result1 + result2);
		} else {
			this.curr_player.setTiles('.');
			this.listofGold.remove(index);
			result1 = this.toString();
			System.out.print(result1 + result2);
		}

	}
	
	
	/**
	 * This will read in the location x and y and replace it with the symbol if the enemy
	 * @param x X-axis
	 * @param y Y-axis
	 * @param disp instance of Enemy
	 */
	public void set_EnemyTiles(int x, int y, Enemy disp) {
		this.map_layout[x][y] = disp.getDisplay();
	}
	
	
	/**
	 * This will read in the location x and y and replace it with the symbol
	 * @param x X-axis
	 * @param y Y-axis
	 * @param symbol Symbol to be replaced
	 */
	public void set_tiles(int x, int y, char symbol) {
		this.map_layout[x][y] = symbol;
	}
	

	/**
	 * Print the class with related information
	 */
	public String toString() {

		String result = "";
		for ( int i = 0 ; i < 25 ; i++) {
			for(int j = 0 ; j < 80 ; j++) {
				result += this.map_layout[i][j] ;
			}
			result += "\n";
		}
		
		result += "===============================================================================\n" ;
		if ( this.curr_player instanceof vacumm) {
			result += " Weapon  : Vacuum\n";
		} else if ( this.curr_player instanceof broom) {
			result += " Weopon  : Broom\n";
		} else {
			result += " Weopon  : Duster\n";
		}
		result += " HP  : " + this.curr_player.getHP() + "\tAtk  : " + this.curr_player.getAtk() + "\tDEF  : " + this.curr_player.getDef();
		
		int finalscore = 0;
		if ( this.curr_player.getScore() - this.curr_player.getnumber_of_moves() >= 0 ) {
			finalscore = this.curr_player.getScore() - this.curr_player.getnumber_of_moves();
		} 
		
		result += "\tScore  : " + finalscore + "\n";
		result += " Deathmode : " + this.curr_player.isStopdeath() + "\tWanderMode : " + this.isWander + "\n";
		result += "===============================================================================" + "\n";
		for (Potion i : this.listofItem) {
			if ( ( i.getX() == this.curr_player.getX() ) && ( i.getY() == this.curr_player.getY() ) ) {
				result += "Special Event : Potion Found\n";
				result += "===============================================================================\n";
			}
		}
		for (Gold i : this.listofGold) {
			if ( ( i.getX() == this.curr_player.getX() ) && ( i.getY() == this.curr_player.getY() ) ) {
				result += "Special Event : Gold Found\n";
				result += "===============================================================================\n";
			}
		}
		
		ArrayList < String > nearby_enemy = new ArrayList < String > ();
		nearby_enemy.removeAll(nearby_enemy);
		
		// This is for the magician class
		if ( this.curr_player instanceof vacumm ) {

			
			ArrayList < String > direction = new ArrayList < String >();
			direction.add("no");
			direction.add("so");
			direction.add("ea");
			direction.add("we");
			direction.add("ne");
			direction.add("nw");
			direction.add("se");
			direction.add("sw");

			ArrayList < String > found_direction = new ArrayList < String >();
			
			for ( int j = 0 ; j <  direction.size() ; j++ ) {
				for ( int i = 1 ; !this.isWall(direction.get(j), i) ; i++) {
					if ( isMonster(direction.get(j),i) != null && !found_direction.contains(direction.get(j)) ) {
						nearby_enemy.add(direction.get(j) + " : " + " [ hp : " + isMonster(direction.get(j) ,i).getHp() + " ]");
						found_direction.add(direction.get(j));
					}
				}
			}
		} else {
			for (Enemy i : this.listofenemy) {
				if ( ( i.getX() - 1 == this.curr_player.getX() ) && ( i.getY() == this.curr_player.getY() ) ) {
					nearby_enemy.add("so : " + " [ hp : " + i.getHp() + " ]");
				} else if ( ( i.getX()  + 1 == this.curr_player.getX()) && ( i.getY() == this.curr_player.getY() ) ) {
					nearby_enemy.add("no : " + " [ hp : " + i.getHp() + " ]");
				} else if ( ( i.getX() == this.curr_player.getX()) && ( i.getY() + 1 == this.curr_player.getY() ) ) {
					nearby_enemy.add("we : " + " [ hp : " + i.getHp() + " ]");
				} else if ( ( i.getX() == this.curr_player.getX()) && ( i.getY() - 1 == this.curr_player.getY() ) ) {
					nearby_enemy.add("ea : " + " [ hp : " + i.getHp() + " ]");
				} else if ( ( i.getX() - 1  == this.curr_player.getX()) && ( i.getY() + 1 == this.curr_player.getY()) ) {
					nearby_enemy.add("sw : " + " [ hp : " + i.getHp() + " ]");
				} else if ( ( i.getX() - 1 == this.curr_player.getX()) && ( i.getY() - 1 == this.curr_player.getY()) ) {
					nearby_enemy.add("se : " + " [ hp : " + i.getHp() + " ]");
				} else if ( ( i.getX() + 1 == this.curr_player.getX()) && ( i.getY() + 1 == this.curr_player.getY() ) ) {
					nearby_enemy.add("nw : " + " [ hp : " + i.getHp() + " ]");
				} else if ( ( i.getX() + 1 == this.curr_player.getX()) && ( i.getY() - 1 == this.curr_player.getY() ) ) {
					nearby_enemy.add("ne : " + " [ hp : " + i.getHp() + " ]");
				}
			}
		}
		
		if ( !nearby_enemy.isEmpty() ) {
			result += "Nearby Enemy(s) information : \n";
			for ( String i : nearby_enemy ) {
				result += i + "\n";
			}
			result += "===============================================================================\n";
		}
		
		return result;
		
	}
	

	/**
	 * Print the result of the game
	 * @param custom_end_game the custom token to finish the game
	 * @return Return if at least one line is printed, otherwise false
	 */
	public Boolean isGameOver(Boolean custom_end_game) {
		if ( this.curr_player.isDeath() && !this.curr_player.isStopdeath()) {
			System.out.println("===============================================================================");
			System.out.println("=                             GAME OVER                                       =");
			System.out.println("===============================================================================");
			System.out.println("   Score          : " + (this.curr_player.getScore() - this.curr_player.getnumber_of_moves()) );
			System.out.println("   Monster Killed : " + ( 16 - this.listofenemy.size()) );
			System.out.println("   Potion Used    : " + ( 10 - this.listofItem.size()) );
			System.out.println("   Steps          : " + this.curr_player.getnumber_of_moves()  );
			System.out.println("===============================================================================");
			return true;
		} else if ( custom_end_game ){
			System.out.println("===============================================================================");
			System.out.println("=                             GAME OVER                                       =");
			System.out.println("===============================================================================");
			System.out.println("   Score          : " + (this.curr_player.getScore() - this.curr_player.getnumber_of_moves()) );
			System.out.println("   Monster Killed : " + ( 16 - this.listofenemy.size()) );
			System.out.println("   Potion Used    : " + ( 10 - this.listofItem.size()) );
			System.out.println("   Steps          : " + this.curr_player.getnumber_of_moves()  );
			System.out.println("===============================================================================");
			return true;
		}  else if ( this.listofenemy.size() == 0 ){
			System.out.println("===============================================================================");
			System.out.println("=                             Congratulation                                  =");
			System.out.println("===============================================================================");
			System.out.println("   Score          : " + (this.curr_player.getScore() - this.curr_player.getnumber_of_moves()) );
			System.out.println("   Monster Killed : " + ( 16 - this.listofenemy.size()) );
			System.out.println("   Potion Used    : " + ( 10 - this.listofItem.size()) );
			System.out.println("   Steps          : " + this.curr_player.getnumber_of_moves()  );
			System.out.println("===============================================================================");
			return true;
		}
		else {
			return false;
		}
	}


	/**
	 * 
	 * @return Return the value of isWander
	 */
	public boolean isWander() {
		return isWander;
	}

	/**
	 * Toggle the value of isWander
	 */
	public void wander_mode() {
		this.isWander = !this.isWander;
	}
	

	/**
	 * turn on the Cheat Stopdeath Mode
	 */
	public void death_mode() {
		this.curr_player.setStopdeath(true);
	}
        
        /* VERSION 2.0 */
        public int Player_Location_X() {
            return this.curr_player.getX();
        }
       
        /* VERSION 2.0 */
        public int Player_Location_Y() {
            return this.curr_player.getY();
        }
	
}