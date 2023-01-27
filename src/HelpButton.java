import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HelpButton extends ButtonBuilder{
    public HelpButton() {
        super("Help",50,20);

        EventHandler<ActionEvent> helpPopup = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                System.out.println("help");

            }

        };
        button.setOnAction(helpPopup);
    }
}
