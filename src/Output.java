public class Output extends TextAreaBuilder{

    public Output() {
        super(1,12);
        textArea.setEditable(false);
    }

    public void setText(String string) {
        textArea.setText(string);
    }
}
