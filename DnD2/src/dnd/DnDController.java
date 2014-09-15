package dnd;

import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class DnDController implements Initializable {

    @FXML
    private Pane textsPane;

    @FXML
    private Parent root;

    @FXML
    private Slider textCountSlider;

    private Random randomGenerator;
    private IntegerProperty initialNumberOfTexts;

    @FXML
    void generateTexts(ActionEvent event) {
        textsPane.getChildren().clear();
        for (int i = 0; i < initialNumberOfTexts.getValue(); i++) {
            int x = randomGenerator.nextInt((int) textsPane.getWidth());
            int y = randomGenerator.nextInt((int) textsPane.getHeight());
            Text newText = new Text(x,y,Integer.toHexString(randomGenerator.nextInt()));
            newText.setFill(Color.BLACK);
            textsPane.getChildren().add(newText);
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
        initialNumberOfTexts = new SimpleIntegerProperty();
        initialNumberOfTexts.bind(textCountSlider.valueProperty());
    }
}
