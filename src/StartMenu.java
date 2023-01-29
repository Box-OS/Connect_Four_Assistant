import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class StartMenu extends SceneBuilder{
    public StartMenu(StageBuilder stage) {
        super(new MenuUI().getRoot());

        EventHandler<MouseEvent> event = new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                stage.switchScene(stage.getPlayScene().getScene());
            }
        };
        scene.setOnMousePressed(event);
    }
}
