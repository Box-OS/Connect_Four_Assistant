import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

/** SelectPlayerNodes.java
 *  Makes the UI for selecting player
 *
 *  @author Sina Akhavan
 */
public class SelectPlayerNodes {
    private StackPane root;
    private AnchorPane buttonContainer;
    private AnchorPane textContainer;

    public SelectPlayerNodes(StageBuilder parentStage) {
        root = new StackPane();
        buttonContainer = new AnchorPane();
        textContainer = new AnchorPane();

        Circle redPlayer = new Circle("red", 200);
        Circle bluePlayer = new Circle("blue", 200);
        TextBuilder title = new TextBuilder("Select Player", 30);
        TextBuilder txtPlayer1 = new TextBuilder("Player 1", 25);
        TextBuilder txtPlayer2 = new TextBuilder("Player 2", 25);

        Anchor.setXY(buttonContainer, redPlayer.getImg(), 80, 80);
        Anchor.setXY(buttonContainer, bluePlayer.getImg(), 320, 80);
        Anchor.setXY(textContainer, title.getText(), 220, 50);
        Anchor.setXY(textContainer, txtPlayer1.getText(), 140, 190);
        Anchor.setXY(textContainer, txtPlayer2.getText(), 380, 190);

        textContainer.setMouseTransparent(true);
        root.getChildren().add(buttonContainer);
        root.getChildren().add(textContainer);

        redPlayer.getImg().setOnMouseClicked(checkClick(parentStage, redPlayer));
        bluePlayer.getImg().setOnMouseClicked(checkClick(parentStage, bluePlayer));
    }

    public StackPane getRoot() {return root;}

    public static EventHandler<MouseEvent> checkClick(StageBuilder stage, Circle btn) {

        EventHandler<MouseEvent> redClicked = new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                stage.switchScene(stage.getPlayScene().getScene());
                System.out.println("hi");
                //TODO: (Core-Programmer) - What happens if p1 is selected
            }
        };
        EventHandler<MouseEvent> blueClicked = new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                stage.switchScene(stage.getPlayScene().getScene());
                //TODO: (Core-Programmer) - What happens if p2 is selected
            }
        };

        if (btn.getImg().toString().contains("red")) {
            return redClicked;
        } else {
            return blueClicked;
        }
    }
}
