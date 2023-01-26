import javafx.scene.control.TextArea;

public abstract class TextAreaBuilder {
    protected TextArea textArea;
        public TextAreaBuilder(int width, int length) {
            textArea = new TextArea();
            textArea.setPrefRowCount(width);
            textArea.setPrefColumnCount(length);
        }

    public TextArea getTextArea() {
        return textArea;
    }
}
