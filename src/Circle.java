import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/** Circle.java
 *  creates the playing tokens for player1 (red) and player2 (blue)
 *
 *   @author Sina Akhavan
 */
public class Circle {
    //Attributes
    private int height, width;
    private String type;
    private ImageView img;
    Image redCircle = new Image("red-circle.png");
    Image blueCircle = new Image("blue-circle.png");

    //Constructor
    public Circle(String type) {
        this.type = type;
        height = 45;
        width = 45;
        draw();
    }

    //Methods
    private void draw() {
        img = new ImageView();
        img.setSmooth(true);
        if (type.equals("red")) {
            img.setImage(redCircle);
        } else if (type.equals("blue")) {
            img.setImage(blueCircle);
        }
            img.setFitHeight(height);
            img.setFitWidth(width);
    }

    //Getters and Setters
    public ImageView getImg() {return img;}
}
