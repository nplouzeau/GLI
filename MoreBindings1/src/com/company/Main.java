package com.company;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        final DoubleProperty radiusOfSphere = new SimpleDoubleProperty(10.0);

        DoubleBinding volumeOfSphere = new DoubleBinding() {
            {
                super.bind(radiusOfSphere);
            }
            /**
             * Calculates the current value of this binding.
             * <p/>
             * Classes extending {@code DoubleBinding} have to provide an implementation
             * of {@code computeValue}.
             *
             * @return the current value
             */
            @Override
            protected double computeValue() {
                return (4.0 / 3.0 * Math.PI * Math.pow(radiusOfSphere.get(), 3));
            }

        };

        Logger.getGlobal().info(String.format("Volume of sphere of radius %f is %f.",radiusOfSphere.get(),volumeOfSphere.get()));

        volumeOfSphere.addListener((obsValue, oldValue, newValue) -> {
            Logger.getGlobal().info(String.format("Volume of sphere of radius %f is %f.",radiusOfSphere.get(),volumeOfSphere.get()));

        });
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        radiusOfSphere.set(20.0);
    }
}
