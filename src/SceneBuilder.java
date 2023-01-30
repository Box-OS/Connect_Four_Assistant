import javafx.scene.Parent;
import javafx.scene.Scene;

/** SceneBuilder.java
 *  Creates a scene
 *
 *   @author Sina Akhavan
 */
public abstract class SceneBuilder {
    protected Scene scene;
    public SceneBuilder(Parent root) {
        scene = new Scene(root);
    }
    public Scene getScene() {return scene;}
}
