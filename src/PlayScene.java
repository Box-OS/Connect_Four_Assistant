import com.sun.javafx.stage.StagePeerListener;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PlayScene extends SceneBuilder{

    public PlayScene(StageBuilder stage) {
        super(new UI(stage).getRoot());
    }
}
