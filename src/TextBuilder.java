import javafx.scene.text.Font;
import javafx.scene.text.Text;

/** TextBuilder.java
 *  Makes text
 *
 *   @author Sina Akhavan
 */
public class TextBuilder {
    Text text;

    public TextBuilder(String t, int size) {
        text = new Text();
        text.setText(t);
        text.setFont(new Font(size));
        text.setMouseTransparent(true);
    }

    public Text getText() {return text;}
}
