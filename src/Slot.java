import javafx.geometry.Insets;
import javafx.scene.control.Button;

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

    //Getters and Setters
    public Button getButton() {return button;}
}
