import javafx.scene.control.TextArea;

public class Output extends TextAreaBuilder{
    TextArea output;

    public Output() {
        //Common
        output = new TextArea();
        output.setPrefRowCount(3);
        output.setPrefColumnCount(12);

        //Special
        output.setEditable(false);
    }

    public TextArea getOutput() {return output;}
}
