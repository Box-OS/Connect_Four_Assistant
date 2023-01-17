import javafx.application.Application;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {
        private int ROWS = 6;
        private int COLS = 7;
        private Button[][] buttons = new Button[ROWS][COLS];

        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) {
            GridPane root = new GridPane();

            for (int row = 0; row < ROWS; row++) {
                for (int col = 0; col < COLS; col++) {
                    Button button = new Button();
                    button.setMinSize(50, 50);
                    root.add(button, col, row);
                    buttons[row][col] = button;
                }
            }

            Scene scene = new Scene(root, COLS * 50, ROWS * 50);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Connect 4 Assistant");
            primaryStage.show();
            primaryStage.setHeight(600);
            primaryStage.setWidth(800);
        }
        //TODO: Test
        public void mouseClicked() {}
    }