/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OOPassignment;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.TilePane;

/**
 *
 * @author zhank
 */
public class mapUI extends Application {
    StringBuilder builder = new StringBuilder();

   @Override
    public void start(Stage primaryStage) {        
        
        TilePane tile = new TilePane();
        tile.setVgap(0);
        tile.setHgap(0);
        ObservableList<Node> list = tile.getChildren();

        
        for (int i = 0 ; i < 23 ; i++ ) {
            for (int j = 0; j < 79 ; j++ ){
                Label view = new Label();
                view.setText( "" +  ( i*10 + j ) );
                list.add(view);
            }
        }
        Scene scene = new Scene(tile, 300, 250);
        
        primaryStage.setTitle("Lab 7");
        primaryStage.setScene(scene);
        primaryStage.show();
  }
    
}
