package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane shapes = new BorderPane();
        Scene scene = new Scene(shapes, 300, 275);

        HBox hbox = new HBox(10);
        Insets padding = new Insets(10, 10, 10, 10);
        hbox.setPadding(padding);
        Rectangle rect1 = new Rectangle(30, 20);
        Rectangle rect2 = new Rectangle(10, 10);
        Rectangle rect3 = new Rectangle(50, 120);
        Slider paddingSlider = new Slider(0, 20, 10);

        hbox.getChildren().addAll(rect1, rect2, rect3, paddingSlider);
        shapes.setCenter(hbox);

        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem explodeMenuItem = new MenuItem("Booom!");
        fileMenu.getItems().add(explodeMenuItem);
        explodeMenuItem.setOnAction(event -> primaryStage.setTitle("BOOOOOM!"));
        menuBar.getMenus().add(fileMenu);

        shapes.setTop(menuBar);
        primaryStage.setTitle("HBox1 example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
