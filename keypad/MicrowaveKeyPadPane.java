package keypad;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class MicrowaveKeyPadPane extends GridPane {

    private static final String[][] KEYS = {
        {"1", "2", "3"},
        {"4", "5", "6"},
        {"7", "8", "9"},
        {"CLR", "0", "START"}
    };

    private KeyPressListener keyListener;

    public MicrowaveKeyPadPane() {
        setHgap(10);
        setVgap(10);
        setAlignment(Pos.CENTER);

        for (int row = 0; row < KEYS.length; row++) {
            for (int col = 0; col < KEYS[row].length; col++) {
                String key = KEYS[row][col];
                Button button = new Button(key);
                button.setPrefSize(80, 60);
                button.setStyle("-fx-font-size: 16px;");
                button.setOnAction(e -> {
                    if (keyListener != null) {
                        keyListener.onKeyPress(key);
                    }
                });
                add(button, col, row);
            }
        }
    }

    public void setOnKeyPress(KeyPressListener listener) {
        this.keyListener = listener;
    }

    public interface KeyPressListener {
        void onKeyPress(String key);
    }
}
