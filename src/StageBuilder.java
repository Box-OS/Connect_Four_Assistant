import javafx.scene.Scene;
import javafx.stage.Stage;

/** StageBuilder.java
 *  creates the main stage and its scenes
 *
 *   @author Sina Akhavan
 */
public class StageBuilder {
    private final Stage STAGE;
    private final MenuScene MENU_SCENE;
    private final PlayScene PLAY_SCENE;

    public StageBuilder(String title) {
        STAGE = new Stage();
        MENU_SCENE = new MenuScene(this);
        PLAY_SCENE = new PlayScene();

        STAGE.setScene(MENU_SCENE.getScene());
        STAGE.setTitle(title);
        STAGE.show();
    }

    public void switchScene(Scene scene) {
        STAGE.setScene(scene);
    }

    public void closeStage() {
        STAGE.close();
    }

    public void setWindowSettings(boolean maxControl, boolean resizable) {
        STAGE.setMinHeight(PLAY_SCENE.getScene().getHeight());
        STAGE.setMinWidth(PLAY_SCENE.getScene().getWidth());;
        STAGE.setMaximized(maxControl);
        STAGE.setResizable(resizable);
    }

    public MenuScene getStartMenu() {return MENU_SCENE;}
    public PlayScene getPLAY_SCENE() {return PLAY_SCENE;}
}
