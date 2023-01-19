import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {

        private int[][] boardTile = new int[6][5];
        private int ROWS = 6;
        private int COLS = 7;
        private Button[][] buttons = new Button[ROWS][COLS];

        Circle c1 = new Circle(1, 1);

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
                    button.setMaxSize(50, 50);
                    button.setPadding(new Insets(0));
                    root.add(button, col, row);
                    buttons[row][col] = button;
                }
            }

            Scene scene = new Scene(root, COLS * 50, ROWS * 50);

            final ImageView selectedImage = new ImageView();
            Image redCircle = new Image("red-circle.png");
            selectedImage.setImage(redCircle);
            selectedImage.setFitHeight(45);
            selectedImage.setFitWidth(45);

            buttons[c1.getRow()][c1.getColumn()].setGraphic(selectedImage);

            root.getChildren().addAll(selectedImage);
            scene.setRoot(root);



            primaryStage.setScene(scene);
            primaryStage.setTitle("Connect 4 Assistant");
            primaryStage.show();
            primaryStage.setHeight(600);
            primaryStage.setWidth(800);
        }

        //TODO: Test
        public void mouseClicked() {}

        //getters and setters
        public int[][] getBoardTile() {return boardTile;}

        public void setBoardTile(int[][] boardTile) {
            this.boardTile = boardTile;

        }
    };