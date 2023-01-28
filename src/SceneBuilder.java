import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

public abstract class SceneBuilder {
    Scene scene;
    public SceneBuilder(Parent root) {
        scene = new Scene(root);
    }

    public Scene getScene() {
        return scene;
    }
}
