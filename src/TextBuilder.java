import javafx.scene.text.Font;
import javafx.scene.text.Text;

/** TextBuilder.java
 *  creates and customizes text
 *
 *   @author Sina Akhavan
 */
public class TextBuilder {
    Text txt;

    public TextBuilder(String t, int size) {
        txt = new Text();
        txt.setText(t);
        txt.setFont(new Font(size));
    }

    public Text getTxt() {
        return txt;
    }
}
