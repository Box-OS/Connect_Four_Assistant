import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ReturnButton extends ButtonBuilder{
    public ReturnButton() {
        super("Return", 60, 25);
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {

            }

        };
        button.setOnAction(event);
    }
}
