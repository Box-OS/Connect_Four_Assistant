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

    BoardHandler b = new BoardHandler();

    public InputButton(PlayNodes ui, Input input, Output output) {
        super("Enter", 75,20);

        EventHandler<ActionEvent> event = e -> {

                //TODO: Read comments (For Core Programmer)
                /*
                This is the part where input is managed according to the algo. For example when the user types
                play c1 in input, insert circle method is called. As for showing the best move, call highlightSlot().
                Here's a linear example of what that would look like without the implementation of the algorithm.
                */

            output.clearText();
            ui.getBoard().unhighlightAll();
            int in = Integer.parseInt(input.getInputString());
            String currentColor = isYourTurn? "red":"blue";
            b.dump();   //debugging
            ui.getBoard().insertCircle(currentColor, b.lowestRow(in-1), in);
            b.dump();   //debugging
            b.placePiece(in-1, isYourTurn? 1:2);
            b.dump();   //debugging

            int nextMove = b.nextMove(isYourTurn?1:2) + 1;

            output.addText(currentColor + " played in column " + in);
            currentColor = !isYourTurn? "red":"blue";
            output.addText("It's " + currentColor + "'s turn now");

            output.addText("The current best move is column " + nextMove);

            for (int i = 1; i<7; i++) {
                ui.getBoard().highlightSlot(nextMove,i);
            }

            b.dump();   //debugging
            input.clearText();
            isYourTurn = !isYourTurn;



        };

        button.setOnAction(event);
    }


}
