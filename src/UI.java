import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
/** UI.java
 *  Creates and places various ui elements
 *
 *   @author Sina Akhavan
 */
public class UI {
    //Layouts
    private GridPane root;
    private Board board;
    private AnchorPane containerOffset;
    private HBox container;
    private AnchorPane itemsOffset;
    private HBox control;
    private AnchorPane controlOffset;
    //Contents
    private Input input;
    private Output output;
    private TextBuilder t1;
    private TextBuilder t2;
    private InputButton btnIn;
    private HelpButton btnHelp;

    //Methods
    public UI() {
        root = new GridPane();
        board = new Board();
        containerOffset = new AnchorPane();
        container = new HBox();
        itemsOffset = new AnchorPane();
        control = new HBox();
        controlOffset = new AnchorPane();

        input = new Input();
        output = new Output();
        t1 = new TextBuilder("Input:");
        t2 = new TextBuilder("Output:");
        btnIn = new InputButton(this, input, output);
        btnHelp = new HelpButton();


        //Root Children
        root.add(board.getRoot(), 1, 0);
        root.add(containerOffset, 2, 0);
        root.setGridLinesVisible(true);

        //containerOffset Children
        containerOffset.getChildren().addAll(container, control);
        setAnchor(container, 20.0, 20.0);
        setAnchor(control, 250, 20);

        //container Children
        container.getChildren().addAll(itemsOffset);
        container.setMinWidth(250);

        //componentsOffset Children
        itemsOffset.getChildren().addAll(input.getTextArea(), t1.getTxt(), output.getTextArea(), t2.getTxt(), btnIn.getButton());
        setAnchor(t1.getTxt(), 0.0, 0.0);
        setAnchor(input.getTextArea(), 25.0, 0.0);
        setAnchor(t2.getTxt(), 95.0, 0.0);
        setAnchor(output.getTextArea(), 120.0, 0.0);
        setAnchor(btnIn.getButton(), 0,105.0);

        //conrol Children
        control.getChildren().addAll(controlOffset);
        container.setMinWidth(250);
        container.setVisible(true);

        //controlOffset Children
        controlOffset.getChildren().addAll(btnHelp.getButton());
        setAnchor(btnHelp.getButton(), 0.0, 0.0);

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

    public int getBoardCOLS() {
        return board.getCOLS();
    }
    public int getBoardROWS() {
        return board.getROWS();
    }
}