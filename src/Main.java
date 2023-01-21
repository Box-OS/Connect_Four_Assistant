import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class Main extends Application {
        Board board = new Board();

        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) {
            board.insertCircle("red",1,3);
            board.insertCircle("blue",2,3);
            board.insertCircle("red",1,4);
            board.insertCircle("blue",1,2);

            //Main Scene
            Scene main = new Scene(board.getRoot(), board.getCOLS() * 50, board.getROWS() * 50);
            main.setRoot(board.getRoot());

            //TODO: Start Menu Scene
            Canvas canvas = new Canvas(500,200);
            GraphicsContext pen = canvas.getGraphicsContext2D();

            Group root = new Group();
            Scene start = new Scene(root);
            root.getChildren().add(canvas);
            start.setRoot(root);

            //Stage
            primaryStage.setScene(main);
            primaryStage.setTitle("Connect 4 Assistant");
            primaryStage.show();
            primaryStage.setMinHeight(325);
            primaryStage.setMinWidth(600);
        }
    };