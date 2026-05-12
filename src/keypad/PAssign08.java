/**
 * File: PAssign08
 * Class: 1302
 * Author: Tyrone Darby
 * Created: April 18, 2026
 * Description: Create an safe key pad using javafx.
*/

package keypad;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PAssign08 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // LCD Display
        Label statusDisplay = new Label("ENTER CODE");
        statusDisplay.setFont(new Font("Courier New", 20));
        statusDisplay.setTextFill(Color.LIME);
        statusDisplay.setStyle("-fx-background-color: black; -fx-padding: 10; -fx-border-color: #555;");
        statusDisplay.setPrefWidth(240);
        statusDisplay.setAlignment(Pos.CENTER);

        // Custom Keypad - starts at 1
        SafeKeypad safeKeypad = new SafeKeypad(statusDisplay);
        safeKeypad.setAlignment(Pos.CENTER);
        safeKeypad.setHgap(8);
        safeKeypad.setVgap(8);

        // Safe Handle
        ImageView safeHandle = new ImageView(new Image("https://cdn-icons-png.flaticon.com/512/1000/1000951.png"));
        safeHandle.setFitWidth(100);
        safeHandle.setPreserveRatio(true);

        // Main Door Layout
        VBox doorLayout = new VBox(25);
        doorLayout.setAlignment(Pos.CENTER);
        doorLayout.setStyle("-fx-background-color: #2c3e50; -fx-border-color: #1a252f; -fx-border-width: 20;");
        
        HBox body = new HBox(30, safeKeypad, safeHandle);
        body.setAlignment(Pos.CENTER);

        doorLayout.getChildren().addAll(statusDisplay, body);

        Scene scene = new Scene(doorLayout, 550, 500);
        primaryStage.setTitle("Secure Vault System v1.0");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Logic: use the default constructor (1-9) but manually 
     * swap the bottom row blanks for * and #.
     */
    class SafeKeypad extends KeyPadPane {
        private String inputAttempt = "";
        private final String CORRECT_CODE = "1234";
        private Label display;

        public SafeKeypad(Label display) {
            // Calling super() defaults to 1-9-0 layout
            super(); 
            this.display = display;
            
            // Re-organize the bottom row to include * and #
            // btnBlank1 is at (0,3), btn0 is at (1,3), btnBlank2 is at (2,3)
            this.getChildren().remove(btnBlank1);
            this.getChildren().remove(btnBlank2);
            this.add(btnAsterisk, 0, 3);
            this.add(btnPound, 2, 3);
            
            // Re-apply event handlers to the new buttons
            registerEventHandlers();
        }

        @Override
        protected void registerEventHandlers() {
            // Create an array of the active buttons we want to monitor
            Button[] activeButtons = {
                btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, 
                btn0, btnAsterisk, btnPound
            };

            for (Button btn : activeButtons) {
                btn.setOnAction(e -> {
                    String text = btn.getText().trim();
                    System.out.println("Input Received: " + text);
                    
                    if (text.equals("#")) {
                        checkCode();
                    } else if (text.equals("*")) {
                        inputAttempt = "";
                        display.setText("RESET");
                        display.setTextFill(Color.YELLOW);
                    } else {
                        inputAttempt += text;
                        display.setText("CODE: " + "*".repeat(inputAttempt.length()));
                        display.setTextFill(Color.LIME);
                    }
                });
            }
        }

        private void checkCode() {
            if (inputAttempt.equals(CORRECT_CODE)) {
                display.setText("UNLOCK");
                display.setTextFill(Color.CYAN);
                System.out.println("SUCCESS: Vault Unlocked.");
            } else {
                display.setText("ACCESS DENIED");
                display.setTextFill(Color.RED);
                System.out.println("FAILURE: Incorrect code.");
                inputAttempt = "";
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}