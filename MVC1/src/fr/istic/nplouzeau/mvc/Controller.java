package fr.istic.nplouzeau.mvc;

import fr.istic.nplouzeau.mvc.model.Candidate;
import fr.istic.nplouzeau.mvc.model.Engine;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private Engine engine;

    @FXML
    private ListView<String> candidatesView;


    @FXML
    private ListView<String> selectedOnesView;

    private ObservableList<String> candidates;

    private ObservableList<String> selectedOnes;

    @FXML
    public void quitApplication() {
        Platform.exit();
    }


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


        // Load the controller's list of data
        for (Iterator<Candidate> candidateIterator = engine.getCandidatesIterator();
             candidateIterator.hasNext(); ) {
            candidates.add(candidateIterator.next().getName());
        }
        for (Iterator<Candidate> candidateIterator = engine.getSelectedOnesIterator();
             candidateIterator.hasNext(); ) {
            selectedOnes.add(candidateIterator.next().getName());
        }

        candidatesView.setItems(candidates);
        selectedOnesView.setItems(selectedOnes);
    }
}
