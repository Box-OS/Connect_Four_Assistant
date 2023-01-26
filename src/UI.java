import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class UI {
    //Attributes
    //Layouts
    private static GridPane root = new GridPane();
    private static Board board = new Board();
    private static AnchorPane containerOffset = new AnchorPane();
    private static HBox container = new HBox();
    private static AnchorPane itemsOffset = new AnchorPane();
    private static HBox control = new HBox();
    private static AnchorPane controlOffset = new AnchorPane();
    //Contents
    private static Input input = new Input();
    private static Output output = new Output();
    private static TextBuilder t1 = new TextBuilder("Input:");
    private static TextBuilder t2 = new TextBuilder("Output:");
    private static ButtonBuilder btnIn = new ButtonBuilder("Enter", "input",75,25);
    private static ButtonBuilder btnout = new ButtonBuilder("Help", "help",50,25);

    //Methods
    public static void initializeUI() {
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
        setAnchor(input.getTextArea(), 30.0, 0.0);
        setAnchor(t2.getTxt(), 120.0, 0.0);
        setAnchor(output.getTextArea(), 150.0, 0.0);
        setAnchor(btnIn.getButton(), 0,105.0);

        //conrol Children
        control.getChildren().addAll(controlOffset);
        container.setMinWidth(250);
        container.setVisible(true);

        //controlOffset Children
        controlOffset.getChildren().addAll(btnout.getButton());
        setAnchor(btnout.getButton(), 0.0, 0.0);

    }

    private static void setAnchor(Node node, double top, double left) {
        AnchorPane.setTopAnchor(node, top);
        AnchorPane.setLeftAnchor(node, left);
    }

    public static GridPane getRoot() {
        return root;
    }

    public static Board getBoard() {
        return board;
    }

    public static int getBoardCOLS() {
        return board.getCOLS();
    }
    public static int getBoardROWS() {
        return board.getROWS();
    }
}