package hierarchy;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class TopController implements Initializable {

    /**
     * Injection points to get access to the controllers of include subviews.
     * WARNING
     * For the injection to work properly you need to:
     * 1. Add the fx:id="leftView" attribute in the fx:include tag of left.xml
     * 2. Mutatis mutandis for right view
     * 3. Name the injected attributes below xxxController, where xxx is the fx:id given
     * in the fx:include tag.
     * Remember: this is configuration by convention
     */
    @FXML
    private LeftController leftViewController;

    @FXML
    private RightController rightViewController;

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
        Logger.getGlobal().info(
                String.format("Top controller initialized with left controller %s and right controller %s.",
                        leftViewController.toString(),rightViewController.toString()));

    }
}
