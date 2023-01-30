/**
 *
 *
 * @author Leqi Shen
 * @version 1.30.2023
 */
public class InputHandler {

    private int columns;

    public InputHandler(int columns) {
        this.columns = columns;
    }
    public boolean checkInRange(int userInput) {
        return userInput >= 1 && userInput <=columns;
    }
}
