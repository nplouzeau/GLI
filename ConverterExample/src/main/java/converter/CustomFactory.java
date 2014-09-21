package converter;

import org.springframework.context.annotation.Bean;

/**
 * Created by plouzeau on 2014-08-06.
 */
public class CustomFactory {
//        Factory for the controller (Spring created, and not FXML created)
   @Bean
    public Controller makeController() {

        return new Controller();
    }
}
