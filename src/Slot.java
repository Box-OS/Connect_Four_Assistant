import javafx.geometry.Insets;
import javafx.scene.control.Button;

/** Circle.java
 *  creates a slot capable of containing a circle
 *
 *   @author Sina Akhavan
 */
public class Slot {
    //Attributes
    final private int WIDTH = 50;
    final private int HEIGHT = 50;
    private Button button;
    private Circle circle;

    //Constructor
    public Slot() {
        button = new Button();
        button.setMinSize(WIDTH, HEIGHT);
        button.setMaxSize(WIDTH, HEIGHT);
        button.setPadding(new Insets(0));
        button.setDisable(true);
        button.setOpacity(1);
    }

    //Methods
    public void createCircle(String type){
        circle = new Circle(type);
        button.setGraphic(circle.getImg());
    }

    public void highlight() {
        button.setStyle(
               "-fx-outline:none;" +
                "-fx-border-color:#9ecaed;" +
               "-fx-box-shadow: inset 0 0 500px 500px #9ecaed;" +
               "-fx-background-color: lightblue;"
        );
    }


    //Getters and Setters
    public Button getButton() {return button;}
    public int getWIDTH() {
        return WIDTH;
    }
    public int getHEIGHT() {
        return HEIGHT;
    }
}
