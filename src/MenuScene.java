import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/** StartMenu.java
 *  Extends SceneBuilder. Initial scene when running stage.
 *
 *   @author Sina Akhavan
 */
public class MenuScene extends SceneBuilder{
    public MenuScene(StageBuilder stage) {
        super(new MenuNodes(600, 325).getROOT());

        EventHandler<MouseEvent> event = e -> stage.switchScene(stage.getPLAY_SCENE().getScene());
        scene.setOnMousePressed(event);
    }
}
