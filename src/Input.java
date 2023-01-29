/** HelpButton.java
 *  Extends TextAreaBuilder.java
 *  Implements an input interface using textarea
 *
 *   @author Sina Akhavan
 */
public class Input extends TextAreaBuilder{
    public Input() {
        super(0,14);
        textArea.setWrapText(true);
    }

    public String getInputString() {
        return textArea.getText();
    }
}
