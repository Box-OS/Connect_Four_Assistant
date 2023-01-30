import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/** StartMenu.java
 *  Extends SceneBuilder. Initial scene when running stage.
 *
 *   @author Sina Akhavan
 */
public class MenuScene extends SceneBuilder{
    public MenuScene(StageBuilder stage) {
        super(new MenuUI().getRoot());

        EventHandler<MouseEvent> event = new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                stage.switchScene(stage.getSelectPScene().getScene());
            }
        };
        scene.setOnMousePressed(event);
    }
}
