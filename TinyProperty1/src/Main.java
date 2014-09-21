import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;

import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        Property<String> name = new SimpleStringProperty("Klaus");
        name.addListener((observableValue, oldValue, newValue) -> {
            Logger.getGlobal().info(
                    String.format("The 'name' property has changed from %s to %s!!!",oldValue,newValue));
        });

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        name.setValue("Alonso");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        name.setValue("Brian");

    }
}
