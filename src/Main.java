import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;


public class Main extends Application {
    //TODO: Create a builder class for UI objects
    public static void main(String[] args) {
        launch(args);
    }


        @Override
        public void start(Stage primaryStage) {

            //Main Scene
            UI.initializeUI();
            Scene mainScene = new Scene(UI.getRoot(), UI.getBoardCOLS() * 50, UI.getBoardROWS() * 50);

            //TODO: Start Menu Scene
            Canvas canvas = new Canvas(UI.getBoardCOLS() * 100,200);
            GraphicsContext pen = canvas.getGraphicsContext2D();

            Group root = new Group();
            Scene start = new Scene(root);
            root.getChildren().add(canvas);
            start.setRoot(root);

            //Stage
            primaryStage.setScene(mainScene);
            primaryStage.setTitle("Connect 4 Assistant");
            primaryStage.show();
            primaryStage.setMinHeight(325);
            primaryStage.setMinWidth(600);
        }
};