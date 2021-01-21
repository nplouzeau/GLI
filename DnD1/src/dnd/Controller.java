package dnd;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    // Acceptable suffixes for file payload in DnD
    private List<String> validFileSuffixes = Arrays.asList(".jpg", ".jpeg", ".gif", "png");

    @FXML
    private Pane dndTarget;

    @FXML
    private TextField messageArea;

    @FXML
    void onDndOver(DragEvent event) {

        Background dndOkBackground =
            new Background(new BackgroundFill(Paint.valueOf("green"), CornerRadii.EMPTY, Insets.EMPTY));
        Background dndErrBackground =
            new Background(new BackgroundFill(Paint.valueOf("red"), CornerRadii.EMPTY, Insets.EMPTY));
        Dragboard dragBoard = event.getDragboard();
        if (dragBoard.hasFiles()
            && (dragBoard.getFiles().size() == 1)
            && (isAnAcceptableFileType(getFileNameFromBoard(dragBoard)))) {

            messageArea.setText(getFileNameFromBoard(dragBoard));
            dndTarget.setBackground(dndOkBackground);
        } else {
            dndTarget.setBackground(dndErrBackground);
        }
    }


    private boolean isAnAcceptableFileType(String path) {
        return validFileSuffixes.stream().anyMatch(t -> path.endsWith(t));
    }

    private String getFileNameFromBoard(Dragboard dragBoard) {
        return dragBoard.getFiles().get(0).getAbsolutePath();
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

    }
}
