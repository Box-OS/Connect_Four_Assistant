/** HelpButton.java
 *  Extends TextAreaBuilder.java
 *  Implements an input interface using textarea
 *
 *   @author Sina Akhavan
 */
public class Input extends TextAreaBuilder{
    public Input() {
        super(1,12);
        textArea.setWrapText(true);
    }

    public String getInputString() {
        return textArea.getText();
    }
}
