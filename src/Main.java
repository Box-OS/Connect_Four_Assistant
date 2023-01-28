import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

/**  Main.class
 *  Runs program and make scenes
 *
 *  @author Sina Akhavan
 */
public class Main extends Application {
    //TODO: Create a builder class for UI objects
    public static void main(String[] args) {
        launch(args);
    }
    private UI ui;

        @Override
        public void start(Stage primaryStage) {

            //Main Scene
            ui = new UI();
            Scene mainScene = new Scene(ui.getRoot(), ui.getBoardCOLS() * 50, ui.getBoardROWS() * 50);

            //TODO: Start Menu Scene
            Canvas canvas = new Canvas(ui.getBoardCOLS() * 100,200);
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

    public UI getUi() {
        return ui;
    }
};