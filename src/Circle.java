import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Circle {
    private int x, y;

    public Circle(int x, int y) {
        this.x = x;
        this.y = y;
        convert();
    }

    //Methods
    private void convert() {
        x = (x*50)-25;
        y = (y*50)-25;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    /*ublic void draw() {
        final int SIZE = 30;
    }*/



}
