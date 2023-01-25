import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TextBuilder {
    Text text;

    public TextBuilder(String t) {
        text = new Text();
        text.setText(t);
        text.setFont(new Font(16));
    }

    public Text getText() {
        return text;
    }
}
