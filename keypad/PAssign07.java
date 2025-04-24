import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * PAssign07 - Microwave Simulator
 * Author: Rich Dorsey
 * GitHub Hello World Link: https://github.com/your-username/hello-world
 */

public class PAssign07 extends Application {

    private TextField timeDisplay = new TextField();
    private Label statusLabel = new Label("Enter Cook Time:");

    @Override
    public void start(Stage primaryStage) {
        // Microwave image
        ImageView microwaveImage = new ImageView(
            new Image("https://upload.wikimedia.org/wikipedia/commons/5/55/Microwave_oven.jpg")
        );
        microwaveImage.setFitHeight(180);
        microwaveImage.setPreserveRatio(true);

        // Display area
        timeDisplay.setEditable(false);
        timeDisplay.setPrefWidth(180);
        timeDisplay.setStyle("-fx-font-size: 20px; -fx-alignment: center;");

        // Keypad
        MicrowaveKeyPadPane keypad = new MicrowaveKeyPadPane();
        keypad.setOnKeyPress(this::handleKeyPress);

        // Layout
        VBox topPane = new VBox(10, microwaveImage, statusLabel, timeDisplay);
        topPane.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();
        root.setTop(topPane);
        root.setCenter(keypad);
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 350, 500);
        primaryStage.setTitle("Microwave Keypad Interface");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleKeyPress(String key) {
        switch (key) {
            case "START":
                statusLabel.setText("Cooking for " + timeDisplay.getText() + " seconds...");
                break;
            case "CLR":
                timeDisplay.clear();
                statusLabel.setText("Enter Cook Time:");
                break;
            default:
                if (timeDisplay.getText().length() < 4)
                    timeDisplay.appendText(key);
                break;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
