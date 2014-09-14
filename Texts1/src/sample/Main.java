package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;


public class Main extends Application {

    private final int maxTexts = 1000;
    private final int stageWidth = 1000;
    private final int stageHeight = 600;
    private Group root;
    private Scene scene;
    private Random randomGenerator;

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Hello World");
        root = new Group();
        scene = new Scene(root, stageWidth, stageHeight, Color.WHITE);

        randomGenerator = new Random(System.currentTimeMillis());

        scene.setOnMouseClicked((mouseEvent) -> drawTexts());
        drawTexts();
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void drawTexts() {
        root.getChildren().clear();
        for (int i = 0; i < maxTexts; i++) {
            int x = randomGenerator.nextInt((int) scene.getWidth());
            int y = randomGenerator.nextInt((int) scene.getHeight());
            int redAmount = randomGenerator.nextInt(255);
            int greenAmount = randomGenerator.nextInt(255);
            int blueAmount = randomGenerator.nextInt(255);

            Text textToDisplay = new Text(x, y, "ISTIC");
            int rotation = randomGenerator.nextInt(360);
            textToDisplay.setFont(new Font("Courier", randomGenerator.nextInt(20) + 10));
            textToDisplay.setFill(Color.rgb(redAmount, greenAmount, blueAmount, 0.50));
            textToDisplay.setRotate(rotation);
            root.getChildren().add(textToDisplay);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
