import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Circle {
    private int column, row;
    private int height, width;
    private String type;
    private ImageView img;

    public Circle(String type, int column, int row) {
        this.type = type;
        this.column = column-1;
        this.row = 6-row;
        height = 45;
        width = 45;
        img = new ImageView();
        draw();
    }
    Image redCircle = new Image("red-circle.png");
    Image blueCircle = new Image("blue-circle.png");
    //Methods


    //Getters and Setters
    public int getColumn() {return column;}
    public int getRow() {return row;}
    public int getHeight() {return height;}
    public int getWidth() {return width;}
    public ImageView getImg() {return img;}

    public void draw() {

        if (type.equals("red")) {
            img.setImage(redCircle);
        } else if (type.equals("blue")) {
            img.setImage(blueCircle);
        }
            img.setFitHeight(getHeight());
            img.setFitWidth(getWidth());
    }



}
