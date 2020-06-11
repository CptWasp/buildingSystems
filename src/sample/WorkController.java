package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;

public class WorkController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ProgressBar progressChecker;

    @FXML
    private ImageView clientPhoto;

    @FXML
    private Label clientName;

    @FXML
    private ImageView objectImage;

    @FXML
    private ListView<?> doneWorks;

    @FXML
    private ListView<?> inWorks;

    @FXML
    private Button quitButton;

    @FXML
    void initialize() {

    }
}

