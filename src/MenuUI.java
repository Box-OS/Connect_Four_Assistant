import javafx.scene.layout.AnchorPane;

public class MenuUI {
    private AnchorPane root;
    private TextBuilder title;
    private TextBuilder subtitle;

    public MenuUI() {
        root = new AnchorPane();
        title = new TextBuilder("Connect Four Assistant", 40);
        subtitle = new TextBuilder("Click anywhere to continue", 16);

        Anchor.setXY(root, title.getText(), 100, 100);
        Anchor.setXY(root, subtitle.getText(), 200, 250);
    }

    public AnchorPane getRoot() {
        return root;
    }
}
