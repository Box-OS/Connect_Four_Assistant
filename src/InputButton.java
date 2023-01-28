import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/** InputButton.java
 *  Extends ButtonBuilder.java
 *  Creates a button that manages Input.java
 *
 *   @author Sina Akhavan
 */
public class InputButton extends ButtonBuilder{
    boolean isYourTurn = true;

    public InputButton(UI ui, Input input, Output output) {
        super("Enter", 75,20);

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {

                //TODO: Read comments (For Core Programmer)
                /*
                This is the part where input is managed according to the algo. For example when the user types
                play c1 in input, insert circle method is called. As for showing the best move, call highlightSlot().
                Here's a linear example of what that would look like without the implementation of the algorithm.
                */


                if (input.getInputString().contains("1") && isYourTurn) {
                    ui.getBoard().insertCircle("red", 1, 1);
                    output.addText("Red played in column 1");
                    output.addText("It's blue's turn now");
                    isYourTurn = false;
                } else if (input.getInputString().contains("1") && !isYourTurn) {
                    output.clearText();
                    ui.getBoard().insertCircle("blue", 2, 1);
                    output.addText("blue played in column 1.");
                    output.addText("It's your turn now, c2 would be a good move");
                    ui.getBoard().highlightSlot(2,1);
                    isYourTurn = true;
                    }
                /*
                Make sure that the logic and algo is implemented in the specialized classes you created. Only use this
                event to access those classes. That's all. Message me ASAP if you have a question or need me to implement
                something.
                 */
            }

        };

        button.setOnAction(event);
    }


}
