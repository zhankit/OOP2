package OOPassignment;
import java.util.*;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Rectangle;

/** Main Menu of the game
 *  Mini-Rogue-Like
 * @author Chia Ding Zhan (0331460), Lee Jin Quan, Chang Choon Kit (0331184)
 * @version 1.0
 */

public class menu extends Application {
 
	/** 
	 * Scanner
	 */
	private static Scanner input;
        public map current_game;
        public Exception e;
	/**
	 * Main  function
	 * @param args no args taken
	 */
	public static void main(String[] args) {
                launch(args);
		game_start();
	}
        
        @Override
        public void start(Stage primaryStage) {        
                
            current_game = new map("b","e");
            
            TilePane tile = new TilePane();
            tile.setVgap(0);
            tile.setHgap(0);
            tile.setPrefColumns(21);
            //tile.setPrefRows(11);
            System.out.println("PLAYER " + current_game.Player_Location_X());
            // Set the tiles to specific background
            for( int i = current_game.Player_Location_X() - 10 ; i <= current_game.Player_Location_X() + 10 ; i++ ) {
                    for( int j = current_game.Player_Location_Y() - 10; j <= current_game.Player_Location_Y() + 10 ; j++ ) {
                        
                        Rectangle circle = new Rectangle();
                        circle.setWidth(20);
                        circle.setHeight(20);

                        try {
                            char value = current_game.map_layout[i][j];
                            switch (current_game.map_layout[i][j]) {
                                case '@':
                                    circle.setFill(Color.SLATEGREY);
                                    break;
                                case '#':
                                    circle.setFill(Color.BROWN);
                                    break;
                                case '+':
                                    circle.setFill(Color.BROWN);
                                    break;
                                case '|':
                                    circle.setFill(Color.BLACK);
                                    break;
                                case '-':
                                    circle.setFill(Color.BLACK);
                                    break;
                                case 'G':
                                    circle.setFill(Color.GOLD);
                                    break;
                                case ' ':
                                    circle.setFill(Color.GRAY);
                                    break;
                                case '.' :
                                    circle.setFill(Color.WHITE);
                                    break;  
                                case 'A' :
                                    circle.setFill(Color.DEEPPINK);
                                    break;
                                case 'B' :
                                    circle.setFill(Color.DEEPPINK);
                                    break;
                                case 'P':
                                    circle.setFill(Color.DEEPPINK);
                                    break;
                                default:
                                    circle.setFill(Color.CYAN);
                                    break;
                            }

                        } catch (Exception e) {
                            circle.setFill(Color.GREY);
                        }
                  
                        tile.getChildren().add(circle);
                    }
            }
            System.out.println("DONE");

            tile.setOnKeyPressed((e) -> {
                if (e.getCode() == KeyCode.UP) {
                        if ( this.current_game.isMovement("no") ) {
                            this.current_game.movement("no");
                            this.current_game.enemyMovement(true);
                        }
                }
                else if (e.getCode() == KeyCode.DOWN) {
                        if ( this.current_game.isMovement("so") ) {
                            this.current_game.movement("so");
                            this.current_game.enemyMovement(true);
                        }  
                }
                else if (e.getCode() == KeyCode.LEFT) {
                    if ( this.current_game.isMovement("we") ) {
                            this.current_game.movement("we");
                            this.current_game.enemyMovement(true);
                        } 
                }
                else if (e.getCode() == KeyCode.RIGHT) {
                    if ( this.current_game.isMovement("ea") ) {
                            this.current_game.movement("ea");
                            this.current_game.enemyMovement(true);
                        }  
                }
                else {
                    System.out.println("nothing click");
                        return;
                }
            
                
                System.out.println("PLAYER " + current_game.Player_Location_X());

                
                tile.getChildren().clear();
                for( int i = current_game.Player_Location_X() - 10 ; i <= current_game.Player_Location_X() + 10 ; i++ ) {
                    for( int j = current_game.Player_Location_Y() - 10; j <= current_game.Player_Location_Y() + 10 ; j++ ) {
                        
                        Rectangle circle = new Rectangle();
                        circle.setWidth(20);
                        circle.setHeight(20);

                        try {
                            char value = current_game.map_layout[i][j];
                            switch (current_game.map_layout[i][j]) {
                                case '@':
                                    circle.setFill(Color.SLATEGREY);
                                    break;
                                case '#':
                                    circle.setFill(Color.BROWN);
                                    break;
                                case '+':
                                    circle.setFill(Color.BROWN);
                                    break;
                                case '|':
                                    circle.setFill(Color.BLACK);
                                    break;
                                case '-':
                                    circle.setFill(Color.BLACK);
                                    break;
                                case 'G':
                                    circle.setFill(Color.GOLD);
                                    break;
                                case ' ':
                                    circle.setFill(Color.GRAY);
                                    break;
                                case '.' :
                                    circle.setFill(Color.WHITE);
                                    break;  
                                case 'A' :
                                    circle.setFill(Color.DEEPPINK);
                                    break;
                                case 'B' :
                                    circle.setFill(Color.DEEPPINK);
                                    break;
                                case 'P':
                                    circle.setFill(Color.DEEPPINK);
                                    break;
                                default:
                                    circle.setFill(Color.CYAN);
                                    break;
                            }

                        } catch ( Exception error ) {
                            circle.setFill(Color.GREY);
                        }
                        
                        tile.getChildren().add(circle);
                    }
                }

            
            });
            
            Scene scene = new Scene(tile, 420, 420);
            primaryStage.setScene(scene);
            primaryStage.show();
            tile.requestFocus();

        
        }
 
	/**
	 * The main controller for the game
	 */
        
	public static void game_start() {
  
		// Variable initialize
		String command;
		Boolean flag = true;
		input = new Scanner( System.in );
		
		System.out.println("==============================================");
		System.out.println("= Welcome to the Wrath of the Trash RPG Game =");
		System.out.println("==============================================");
		System.out.println("= Project by...                              =");
		System.out.println("= 1. Chia Ding Zhan                  	     =");
		System.out.println("= 2. Chang Choon Kit                         =");
		System.out.println("= 3. Lee Jin Quan                            =");
		System.out.println("==============================================");

		map current_game = new map();
		boolean isGameStart = false;

		while (flag) {
			
			// print_command depends if the game is started
			print_command(isGameStart);
			command = input.next();
			
			// Start Command
			if ( command.equals("start") ) {
				
				boolean inner_flag = true;
				String player_class = null;
				while (inner_flag) {
					
					System.out.println("\nPlease select your weapon for your character: ");
					System.out.println("1. Broom  (HP: 100, ATK: 50, DEF: 80)   [b] ");
					System.out.println("2. Vacumm (HP: 100, ATK: 50, DEF: 30)   [v] SA : Attack Range ");
					System.out.print("3. Duster (HP: 100, ATK: 40, DEF: 50)   [d] SA : Hide \n>");
					
					command = input.next();
					// Choose 3 of the classes
					if ( command.equals("b") ) {
						player_class = "b";
						inner_flag = false;
					} else if ( command.equals("v") ) {
						player_class = "v";
						inner_flag = false;
					} else if ( command.equals("d") ) {
						player_class = "d";
						inner_flag = false;
					} else {
						System.out.println("Invalid Command. Please try again");
					} // Invalid
				}
				
				inner_flag = true;
				
				while (inner_flag) {
					
					System.out.println("\nPlease Choose the difficulty of the game");
					System.out.println("1. Easy      [e] ");
					System.out.println("2. Medium    [m] ");
					System.out.print("3. Difficult [d] \n>");
					command = input.next();
					
					// Choose 3 of the difficulty
					if ( command.equals("e") ) {
						current_game = new map(player_class,"e");
						inner_flag = false;
					} else if ( command.equals("m") ) {
						current_game = new map(player_class,"m");
						inner_flag = false;
					} else if ( command.equals("d") ) {
						current_game = new map(player_class,"d");
						inner_flag = false;
					} else {
						System.out.println("Invalid Command. Please try again");
					} // Invalid
				}
					
				isGameStart = true;
				System.out.println("Game started:");
				System.out.print(current_game);			

			} 
			
			// Movement
			else if ( command.equals("u")) {
				
				String direction = input.next();
				if ( !current_game.isMovement(direction) )  { System.out.println("Invalid Command. Please try again"); } 
				else {
					if ( current_game.isWander()) { 
                                            current_game.movement(direction);
                                            current_game.enemyMovement(true); 
                                        }
					else { 
                                            current_game.movement(direction);
                                        }
                                        System.out.println(current_game); 
                                        
                                }
			} 
			
			// Attack
			else if ( command.equals("a")) {

				String direction = input.next();
				if ( !current_game.ifAttack(direction) )  {
					System.out.println("Invalid Command. Please try again");
				} else {
					if (current_game.isGameOver(false) ) {
						System.out.print("Do you want to restart the game? (y/n)\n>");
						command = input.next();
						Boolean inner_flag = true;
						
						while ( inner_flag ) {
							if ( command.equals("y") ) {
								current_game.isGameOver(true);
								isGameStart = false;
								inner_flag = false;
							} 
							else if ( command.equals("n") ) { return; } 
							else { System.out.println("Invalid Command. Please try again"); }
						}
					};
				}
			} 
			
			// Use Potion
			else if ( command.equals("p")) {
				if ( current_game.isItem() ) { current_game.useItem(); }
				else { System.out.println("Invalid Coammand. Please try again"); }				
			} 
			
			// Restart
			else if ( command.equals("r")) {
				current_game.isGameOver(true);
				isGameStart = false;
			} 
			
			// StopWander
			else if ( command.equals("sw")) {
				current_game.wander_mode();
				System.out.print(current_game);			
			} 
			
			// StopDeath
			else if ( command.equals("sd")) {
				current_game.death_mode();
				System.out.print(current_game);			
			} 
			
			// Quit
			else if ( command.equals("q")) {
				current_game.isGameOver(true);
				return ;
			} 
			
			// Invalid 1
			else if (!isGameStart){
				System.out.println("Invalid Command. Please try again");
			} 
			
			// Invalid 2
			else {
				System.out.print(current_game);			
				System.out.println("Invalid Command. Please try again");
			}
   
		} // while flag
	}
	

	/**
	 * This is a printer to print out the menu of the game
	 * @param game_started true or false
	 */
	public static void print_command(boolean game_started) {
		
		if (!game_started) {
			System.out.println("\nThe Commands are as followed :");
			System.out.println("1. Start Game [start]");
			System.out.print("Please enter the command: \n>");
		} else {
			System.out.println("\nThe Commands are as followed :");
			System.out.println("<direction> : no, so, ea, we , ne, nw, se ,sw");
			System.out.println("1. Movement    [u <direction>]");
			System.out.println("2. Attack      [a <direction>]");
			System.out.println("3. Potion      [p]");
			System.out.println("4. Restart     [r]");
			System.out.println("5. Quit Game   [q]");
			System.out.println("6. Stopwander  [sw]");
			System.out.println("7. Stopdeath   [sd]");
			System.out.print("Please enter the command: \n>");
		}
		
	}
}