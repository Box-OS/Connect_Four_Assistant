/** HelpButton.java
 *  Extends TextAreaBuilder.java
 *  Implements an output interface using textarea
 *
 *  @author Sina Akhavan
 */
public class Output extends TextAreaBuilder{

    public Output() {
        super(4,14);
        textArea.setEditable(false);
        textArea.setWrapText(true);
    }

    public void addText(String string) {
        if (!textArea.getText().isEmpty()) {
            textArea.setText(textArea.getText() + "\n" + string);
        } else {
            textArea.setText(textArea.getText() + string);
        }
    }
}
