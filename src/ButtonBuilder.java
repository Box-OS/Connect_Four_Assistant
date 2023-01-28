import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/** ButtonBuilder.java
    *  Abstract class for making a blueprint of a button
    *
    *   @author Sina Akhavan
    */
public abstract class ButtonBuilder {
    protected Button button;

    public ButtonBuilder(String label, int width, int height) {
        button = new Button();
        button.setText(label);
        button.setPadding(Insets.EMPTY);
        button.setMinSize(width, height);
    }

    public Button getButton() {
        return button;
    }
}
