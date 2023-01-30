import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class MenuNodes {
    private final AnchorPane ROOT;

    public MenuNodes(int width, int height) {
        ROOT = new AnchorPane();
        TextBuilder title = new TextBuilder("Connect Four Assistant", 40, "Tahoma");
        TextBuilder subtitle = new TextBuilder("Click anywhere to continue", 16);

        AnchorPane.setTopAnchor(title.getTEXT(), 100.0);
        AnchorPane.setLeftAnchor(title.getTEXT(), 100.0);
        AnchorPane.setTopAnchor(subtitle.getTEXT(), 275.0);
        AnchorPane.setLeftAnchor(subtitle.getTEXT(), 175.0);
        ROOT.setMinWidth(width);
        ROOT.setMinHeight(height);
        ROOT.getChildren().addAll(title.getTEXT(), subtitle.getTEXT());

    }

    public AnchorPane getROOT() {
        return ROOT;
    }
}
