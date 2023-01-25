import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Region;

public class Input extends TextAreaBuilder{
    TextArea input;

    public Input() {
        //Common
        input = new TextArea();
        input.setPrefRowCount(3);
        input.setPrefColumnCount(12);
        //input.setOnMouseClicked();

        //Special
        input.setWrapText(true);
    }

    public TextArea getInput() {
        return input;
    }
}
