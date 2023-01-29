import javafx.scene.Scene;
import javafx.stage.Stage;

public class StageBuilder {
    private Stage stage;
    private StartMenu startMenu;
    private PlayScene playScene;

    public StageBuilder(String title) {
        stage = new Stage();
        startMenu = new StartMenu(this);
        playScene = new PlayScene(this);

        stage.setScene(startMenu.getScene());
        stage.setTitle(title);
        stage.show();


    }

    public void switchScene(Scene scene) {
        stage.setScene(scene);
    }

    public void setWindowSettings(int minY, int minX, boolean maxControl, boolean resizable) {
        stage.setMinHeight(minY);
        stage.setMinWidth(minX);
        stage.setMaximized(maxControl);
        stage.setResizable(resizable);
    }

    public void closeStage() {
        stage.close();
    }

    public Stage getStage() {
        return stage;
    }
    public StartMenu getStartMenu() {
        return startMenu;
    }
    public PlayScene getPlayScene() {
        return playScene;
    }
}
