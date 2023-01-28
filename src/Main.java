import javafx.application.Application;
import javafx.stage.Stage;

/**  Main.class
 *  Starts the program and stage
 *
 *  @author Sina Akhavan
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    StartMenu startMenu;
    PlayScene playScene;

        @Override
        public void start(Stage primaryStage) {
            startMenu = new StartMenu();
            playScene = new PlayScene();

            //Stage
            primaryStage.setScene(playScene.getScene());
            primaryStage.setTitle("Connect 4 Assistant");
            primaryStage.setMinHeight(325);
            primaryStage.setMinWidth(600);
            primaryStage.setMaximized(false);
            primaryStage.setResizable(false);
            primaryStage.show();

        }
    }