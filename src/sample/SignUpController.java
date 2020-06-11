package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nameSigner;

    @FXML
    private TextField emailSigner;

    @FXML
    private PasswordField passwordSigner;

    @FXML
    private Button signUpEndButton;

    @FXML
    void initialize() {

    }
}
