import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.util.Optional;


public class RestartButton extends ButtonBuilder{
    private Alert alert;
    public RestartButton() {
        super("Restart", 60, 25);
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                setupAlert();
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.YES) {
                    Main.GameStart.restartGame();
                }
            }

        };
        button.setOnAction(event);
    }

    private void setupAlert() {
        alert.setContentText("Are you sure you want to restart the game? All progress will be lost.");
        alert.getButtonTypes().clear();
        alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
        Button yesButton = (Button) alert.getDialogPane().lookupButton( ButtonType.YES );
        yesButton.setDefaultButton(false);
        Button noButton = (Button) alert.getDialogPane().lookupButton( ButtonType.NO );
        noButton.setDefaultButton(true);
    }
}
