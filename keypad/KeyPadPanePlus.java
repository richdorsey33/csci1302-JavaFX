/**
 * File: csci1302/keypad/KeyPadPanePlus.java
 * Package: keypad
 * @author Rich Dorsey
 * Created on: Mar 04, 2025
 * Description:  Small example of extending the KeyPadPane class
 * 		and accessing a protected data member within that class
 */
package keypad;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PAssign07 extends KeyPadPane {
    @Override
    public void start(Stage primaryStage) {
        // Load and display ATM image
        Image atmImage = new Image("file:atm.png"); // Ensure an image is available in the directory
        ImageView atmImageView = new ImageView(atmImage);
        atmImageView.setFitWidth(300);
        atmImageView.setPreserveRatio(true);
        
        // Label and text field to represent ATM screen
        Label screenLabel = new Label("Enter PIN:");
        TextField screenField = new TextField();
        screenField.setEditable(false);
        
        // KeyPadPane integration (assuming KeyPadPane is available in the package)
        KeyPadPane keyPad = new KeyPadPane();
        
        // Clear button
        Button clearButton = new Button("Clear");
        clearButton.setOnAction(e -> screenField.clear());
        
        // Layout setup
        VBox screenBox = new VBox(10, screenLabel, screenField);
        HBox bottomBox = new HBox(10, clearButton);
        VBox mainBox = new VBox(10, atmImageView, screenBox, keyPad, bottomBox);
        
        BorderPane root = new BorderPane();
        root.setCenter(mainBox);
        
        Scene scene = new Scene(root, 400, 600);
        primaryStage.setTitle("ATM Interface");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
