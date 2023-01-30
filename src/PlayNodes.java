import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/** PlayNodes.java
 *  Makes the main UI
 *
 *   @author Sina Akhavan
 */
public class PlayNodes {
    private GridPane root;
    private Board board;

    public PlayNodes() {
        root = new GridPane();
        board = new Board();
        AnchorPane containerOffset = new AnchorPane();
        HBox container = new HBox();
        AnchorPane itemsOffset = new AnchorPane();
        HBox control = new HBox();
        AnchorPane controlOffset = new AnchorPane();

        Input input = new Input();
        Output output = new Output();
        TextBuilder txtInput = new TextBuilder("Input:", 16);
        TextBuilder txtOuput = new TextBuilder("Output:", 16);
        InputButton btnIn = new InputButton(this, input, output);
        HelpButton btnHelp = new HelpButton();
        RestartButton btnReturn = new RestartButton();

        //Root Children
        root.add(board.getRoot(), 1, 0);
        root.add(containerOffset, 2, 0);
        root.setStyle("-fx-background-color: #C3DBC5;");

        //containerOffset Children
        containerOffset.getChildren().addAll(container, control);
        setAnchor(container, 20.0, 20.0);
        setAnchor(control, 250, 20);

        //container Children
        container.getChildren().addAll(itemsOffset);
        container.setMinWidth(230);

        //componentsOffset Children
        itemsOffset.getChildren().addAll(input.getTextArea(), txtInput.getText(), output.getTextArea(), txtOuput.getText(), btnIn.getButton());
        setAnchor(txtInput.getText(), 0.0, 0.0);
        setAnchor(input.getTextArea(), 25.0, 0.0);
        setAnchor(txtOuput.getText(), 95.0, 0.0);
        setAnchor(output.getTextArea(), 120.0, 0.0);
        setAnchor(btnIn.getButton(), 0,140.0);

        //conrol Children
        control.getChildren().addAll(controlOffset);

        //controlOffset Children
        controlOffset.getChildren().addAll(btnHelp.getButton(), btnReturn.getButton());
        setAnchor(btnHelp.getButton(), 0.0, 0.0);
        setAnchor(btnReturn.getButton(),0.0, 75.0);

    }

    /**
     * Static method that simplifies setting anchor to top and bottom
     * @param node The node that is being adjusted
     * @param top distance from top to node
     * @param left distance from left to node
     */
    private static void setAnchor(Node node, double top, double left) {
        AnchorPane.setTopAnchor(node, top);
        AnchorPane.setLeftAnchor(node, left);
    }

    public GridPane getRoot() {
        return root;
    }
    public Board getBoard() {
        return board;
    }
}