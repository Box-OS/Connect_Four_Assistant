import javafx.application.Application;
import javafx.stage.Stage;

/**  Main.class
 *  Starts the program and makes a stage
 *
 *  @author Sina Akhavan
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

        @Override
        public void start(Stage stage) {
        GameStart.startGame();
        }

        public static class GameStart {
            private static StageBuilder primaryStage;
            private static void startGame() {

                primaryStage = new StageBuilder("Connect 4 Assistant");
                primaryStage.setWindowSettings(false, false);
            }
            public static void restartGame() {
                primaryStage.closeStage();
                startGame();
            }

        }


}