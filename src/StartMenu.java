import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class StartMenu extends SceneBuilder{
    public StartMenu() {
        super(new MenuUI().getStack());
        EventHandler<MouseEvent> event = new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                //.setScene(getScene());
            }
        };
        scene.setOnMouseClicked(event);
    }
}
