package dnd;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class DnDController implements Initializable {

    @FXML
    private Group textsGroup;

    @FXML
    private Parent root;

    private Random randomGenerator;
    private final int initialNumberOfTexts = 10;

    @FXML
    void generateTexts(ActionEvent event) {
        for (int i = 0; i < initialNumberOfTexts; i++) {
            int x = randomGenerator.nextInt((int) root.getScene().getWidth());
            int y = randomGenerator.nextInt((int) root.getScene().getHeight());
        }

    }

    @FXML
    void closeApplication(ActionEvent event) {

        Platform.exit();
    }

    @FXML
    void showAboutScene(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        randomGenerator = new Random(System.currentTimeMillis());
    }
}
