package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;
import java.util.logging.Logger;

/**
 * A small example to demo the generation of texts
 * and the fact that each text is an object.
 */
public class Main extends Application {

    private final int numberOfTextsToGenerate = 1000;
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

        // Refresh the scene on Shift Click in the scene
        scene.setOnMouseClicked((mouseEvent) -> {
            if (mouseEvent.isShiftDown()) {
                drawTexts();
            }
        });
        // Close the application if the user types 'q'
        scene.setOnKeyTyped(event -> {
            if (event.getCharacter().equals("q")) {
                Platform.exit();
            }
            ;
        });

        // Populate the scene with random texts
        drawTexts();

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void drawTexts() {

        final String textToDisplay = "ISTIC";
        final int minimumFontSize = 10;
        final int maximalFontSize = 30;
        final String fontName = "Courier";
        final double textOpacity = 0.5;

        // Wipe out all texts in the scene
        root.getChildren().clear();

        // Generate the text nodes
        for (int i = 0; i < numberOfTextsToGenerate; i++) {
            // Generate random coordinates that lie (at least in part) within the root node
            int x = randomGenerator.nextInt((int) scene.getWidth());
            int y = randomGenerator.nextInt((int) scene.getHeight());

            // Generate a random color
            int redAmount = randomGenerator.nextInt(255);
            int greenAmount = randomGenerator.nextInt(255);
            int blueAmount = randomGenerator.nextInt(255);

            // Create the text node
            Text textNode = new Text(x, y, textToDisplay);
            textNode.setFont(new Font(fontName,
                    randomGenerator.nextInt(maximalFontSize - minimumFontSize) + minimumFontSize));
            textNode.setFill(Color.rgb(redAmount, greenAmount, blueAmount, textOpacity));

            // Rotate the text node randomly
            int rotation = randomGenerator.nextInt(360);
            textNode.setRotate(rotation);

            // Add a click listener to demo that the text is real object, not just a bunch of pixels
            textNode.setOnMouseClicked(event -> {
                Logger.getGlobal().info("Someone clicked on me:  " + textNode.toString());
            });

            // Add the text to the scene so that it will be drawn
            root.getChildren().add(textNode);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
