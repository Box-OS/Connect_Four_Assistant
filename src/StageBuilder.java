import javafx.scene.Scene;
import javafx.stage.Stage;

/** StageBuilder.java
 *  creates the main stage and its scenes
 *
 *   @author Sina Akhavan
 */
public class StageBuilder {
    private Stage stage;
    private MenuScene menuScene;
    private PlayScene playScene;
    private SelectPlayerScene selectPScene;

    public StageBuilder(String title) {
        stage = new Stage();
        menuScene = new MenuScene(this);
        selectPScene = new SelectPlayerScene(this);
        playScene = new PlayScene();

        stage.setScene(menuScene.getScene());
        stage.setTitle(title);
        stage.show();
    }

    public void switchScene(Scene scene) {
        stage.setScene(scene);
    }

    public void closeStage() {
        stage.close();
    }

    public void setWindowSettings(int minY, int minX, boolean maxControl, boolean resizable) {
        stage.setMinHeight(minY);
        stage.setMinWidth(minX);
        stage.setMaximized(maxControl);
        stage.setResizable(resizable);
    }

    public MenuScene getStartMenu() {return menuScene;}
    public PlayScene getPlayScene() {return playScene;}
    public SelectPlayerScene getSelectPScene() {return selectPScene;}
}
