package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    private final ObservableList<String> modelList = FXCollections.observableArrayList("1");
    ;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();

        MenuBar menuBar = new MenuBar();
        Menu listMenu = new Menu("List");
        MenuItem addMenuItem = new MenuItem("Add");
        addMenuItem.setOnAction(event -> modelList.add(Integer.toString(modelList.size())));
        listMenu.getItems().add(addMenuItem);

        MenuItem removeMenuItem = new MenuItem("Remove");
        listMenu.getItems().add(removeMenuItem);
        removeMenuItem.setOnAction(event ->
        {
            if (modelList.size() > 0) {
                modelList.remove(0);
            }
        });
        menuBar.getMenus().add(listMenu);
        root.setTop(menuBar);

        // Now the view
        ListView listView = new ListView(modelList);
        root.setCenter(listView);

        primaryStage.setTitle("Lists");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
