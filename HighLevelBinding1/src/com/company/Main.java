package com.company;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        DoubleProperty width = new SimpleDoubleProperty(10.0);
        DoubleProperty height = new SimpleDoubleProperty(30.0);

        // Build a surface computation that listens to width and height properties
        DoubleBinding surface = width.multiply(height);

        surface.addListener((obsValue, oldValue, newValue) -> {
            Logger.getGlobal().info(String.format("Surface is %f, was %f", newValue,oldValue));

        });

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        width.set(40.0);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        width.set(70.0);

    }
}
