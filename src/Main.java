import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

        private int[][] boardTile = new int[6][5];
        final private int ROWS = 6;
        final private int COLS = 7;
        final private Button[][] buttons = new Button[ROWS][COLS];

        Circle c1 = new Circle(1, 1);

        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) {
            GridPane root = new GridPane();
            Group root2 = new Group();

            for (int row = 0; row < ROWS; row++) {
                for (int col = 0; col < COLS; col++) {
                    Button button = new Button();
                    button.setMinSize(50, 50);
                    button.setMaxSize(50, 50);
                    button.setPadding(new Insets(0));
                    button.setDisable(true);
                    button.setOpacity(1);
                    root.add(button, col, row);
                    buttons[row][col] = button;
                }
            }


            Scene scene = new Scene(root, COLS * 50, ROWS * 50);
            Scene scene2 = new Scene(root2);
            Canvas canvas = new Canvas(500,200);

            final ImageView selectedImage = new ImageView();
            Image redCircle = new Image("red-circle.png");
            selectedImage.setImage(redCircle);
            selectedImage.setFitHeight(45);
            selectedImage.setFitWidth(45);

            buttons[c1.getRow()][c1.getColumn()].setGraphic(selectedImage);

            root.getChildren().add(selectedImage);
            root2.getChildren().add(canvas);
            scene.setRoot(root);
            scene2.setRoot(root2);

            primaryStage.setScene(scene);
            GraphicsContext pen = canvas.getGraphicsContext2D();

            //
            pen.setFill(Color.BLUE);
            pen.fillRect(10,10,20,20);
            //
            primaryStage.setTitle("Connect 4 Assistant");
            primaryStage.show();
            primaryStage.setMinHeight(325);
            primaryStage.setMinWidth(600);
        }

        //getters and setters
        public int[][] getBoardTile() {return boardTile;}

        public void setBoardTile(int[][] boardTile) {
            this.boardTile = boardTile;
        }
    };