import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class InputButton extends ButtonBuilder{
    public InputButton(UI ui) {
        super("Enter", 75,20);

        EventHandler<ActionEvent> insertCircle = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                ui.getBoard().insertCircle("red", 1, 3);
                ui.getBoard().insertCircle("blue", 2, 3);
                ui.getBoard().insertCircle("red", 1, 4);
                ui.getBoard().insertCircle("blue", 1, 2);
                ui.getBoard().insertCircle("red", 1, 5);
                ui.getBoard().insertCircle("red", 1, 5);
                ui.getBoard().insertCircle("blue", 2, 4);
                ui.getBoard().highlightSlot();

            }

        };

        button.setOnAction(insertCircle);
    }


}
