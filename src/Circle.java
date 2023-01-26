import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Circle {
    //Attributes
    private int height, width;
    private String type;
    private ImageView img;

    //Constructor
    public Circle(String type) {
        this.type = type;
        height = 45;
        width = 45;
        draw();
    }

    //Objects
    Image redCircle = new Image("red-circle.png");
    Image blueCircle = new Image("blue-circle.png");


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
