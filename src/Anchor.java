import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

/** Anchor.java
 *  Creates an AnchorPane inside root and modifies its location.
 *
 *   @author Sina Akhavan
 */
public class Anchor {
    private final static boolean DEFAULT_CLICKABLE = false;
    public static AnchorPane offset;

    public static void setXY(AnchorPane root, Node node, double x, double y) {
        offset = new AnchorPane();
        AnchorPane.setLeftAnchor(offset, x);
        offset.getChildren().add(node);
        root.getChildren().add(offset);
    }
}
