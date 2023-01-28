import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/** HelpButton.java
 *  Extends ButtonBuilder.java
 *  Creates a button that upon click, shows a pop-up showing accepted inputs
 *
 *   @author Sina Akhavan
 */
public class HelpButton extends ButtonBuilder{
    public HelpButton() {
        super("Help",60,25);

        EventHandler<ActionEvent> helpPopup = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                System.out.println("help");

            }

        };
        button.setOnAction(helpPopup);
    }
}
