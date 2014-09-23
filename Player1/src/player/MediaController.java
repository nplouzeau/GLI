package player;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class MediaController implements Initializable {

    final String soundFileName = "hal.wav";

    // As usual, dependency injection between view and controller
    @FXML
    private Button stopButton;

    @FXML
    private Button playItButton;

    @FXML
    private ProgressBar progressBar;

    private Media mediaToPlay = new Media(getClass().getResource(soundFileName).toExternalForm());

    @FXML
    private MediaPlayer player = new MediaPlayer(mediaToPlay);

    private ChangeListener<Duration> progressListener;


    @FXML
    public void playItSam(Event e) {
        Logger.getGlobal().info("Starting...");
        player.play();
    }

    @FXML
    public void stopItNow(Event e) {
        Logger.getGlobal().info("Stopping...");
        player.stop();
    }


    @FXML
    public void quitApplication(Event e) {
        Platform.exit();
    }

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        progressBar.setProgress(0.0D);
        playItButton.setDisable(false);
        stopButton.setDisable(true);

        player.currentTimeProperty().addListener((observableValue, oldValue, newValue)
                -> progressBar.setProgress(newValue.toSeconds() / player.getTotalDuration().toSeconds()));


        player.setOnPlaying(() -> {
            playItButton.setDisable(true);
            stopButton.setDisable(false);
        });
        player.setOnStopped(() -> {
            playItButton.setDisable(false);
            stopButton.setDisable(true);
        });

    }
}
