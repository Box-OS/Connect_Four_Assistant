import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class MenuUI {
    private StackPane root;
    private AnchorPane anchorPane;
    private Canvas canvas;
    private TextBuilder title;

    public MenuUI() {
        root = new StackPane();
        anchorPane = new AnchorPane();
        title = new TextBuilder("Connect Four Assistant", 40);
        canvas = new Canvas(400, 200);

        GraphicsContext pen = canvas.getGraphicsContext2D();
        Animation(pen);
        AnchorPane.setTopAnchor(title.getTxt(), 100.0);
        AnchorPane.setLeftAnchor(title.getTxt(), 100.0);
        anchorPane.getChildren().add(title.getTxt());

        root.getChildren().add(canvas);
        root.getChildren().add(anchorPane);
    }

    public static void Animation(GraphicsContext pen) {
    }

    public StackPane getRoot() {
        return root;
    }
}
