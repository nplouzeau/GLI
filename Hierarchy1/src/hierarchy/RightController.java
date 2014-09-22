package hierarchy;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * Created by plouzeau on 2014-09-22.
 */
public class RightController implements Initializable {
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
        Logger.getGlobal().info("Right controller initialized");
    }
}
