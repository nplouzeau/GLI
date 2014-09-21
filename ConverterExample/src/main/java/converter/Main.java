package converter;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {


        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(CustomFactory.class);
        SpringFXMLLoader loader = new SpringFXMLLoader(context);
        Parent root = (Parent) loader.load("converter.fxml", Controller.class);

        primaryStage.setTitle("Converter example");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
