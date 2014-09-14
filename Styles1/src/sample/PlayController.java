package sample;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.logging.Logger;

public class PlayController {

    @FXML
    private Button cancelButton;

    @FXML
    private Button doItButton;

    private Media mediaToPlay = new Media(getClass().getResource("sound.wav").toExternalForm());
    private MediaPlayer player = new MediaPlayer(mediaToPlay);

    public void playItSam(Event e) {
        Logger.getGlobal().info("Playing...");
        player.play();
    }

    public void stopItNow(Event e) {
        Logger.getGlobal().info("Stopping...");
        player.stop();
    }
}
