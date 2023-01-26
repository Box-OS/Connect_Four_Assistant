import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ButtonBuilder {
    Button button;

    public ButtonBuilder(String label, String task, int width, int height) {
        button = new Button();
        button.setText(label);
        button.setPadding(Insets.EMPTY);
        button.setMinSize(width, height);
        EventHandler<ActionEvent> addCircle = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                //TODO: (Core Programmer) use input to insert circles
                UI.getBoard().insertCircle("red", 1, 3);
                UI.getBoard().insertCircle("blue", 2, 3);
                UI.getBoard().insertCircle("red", 1, 4);
                UI.getBoard().insertCircle("blue", 1, 2);
                UI.getBoard().insertCircle("red", 1, 5);
                UI.getBoard().insertCircle("red", 1, 5);
                UI.getBoard().insertCircle("blue", 2, 4);
                UI.getBoard().highlightSlot();
            }

        };
        EventHandler<ActionEvent> help = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                System.out.println("no help :(");
            }

        };
        if(task.equalsIgnoreCase("input")) {
            button.setOnAction(addCircle);
        }
        if(task.equalsIgnoreCase("help")) {
            button.setOnAction(help);
        }
    }

    public Button getButton() {
        return button;
    }
}
