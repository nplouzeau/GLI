package converter;

/**
 * Created by plouzeau on 2014-08-06.
 */

import javafx.fxml.FXMLLoader;
import javafx.util.Callback;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

/**
 * Created by plouzeau on 2014-04-11.
 */
/*
 * Adapted from original code by Daniel Zwolenski
 * (http://www.oracle.com/technetwork/articles/java/zonski-1508195.html)
 */

public class SpringFXMLLoader {
    private ApplicationContext context;

    public SpringFXMLLoader(ApplicationContext context) {
        this.context = context;
    }

    public Object load(String url, Class<?> controllerClass) throws IOException {
        InputStream fxmlStream = null;
        try {
            fxmlStream = controllerClass.getClassLoader().getResourceAsStream(url);

            final Object instance = context.getBean(controllerClass);
            FXMLLoader loader = new FXMLLoader();
            // Define the factory for the controller
            loader.setControllerFactory(new Callback<Class<?>, Object>() {
                @Override
                public Object call(Class<?> aClass) {
                    return instance;
                }
            });
            loader.getNamespace().put("controller", instance);
            Logger.getGlobal().info(loader.getNamespace().get("controller").toString());
            return loader.load(fxmlStream);
        } finally {
            if (fxmlStream != null) {
                fxmlStream.close();
            }
        }
    }
}

