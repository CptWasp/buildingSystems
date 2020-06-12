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
    private TextField firstnameSigner;

    @FXML
    private TextField emailSigner;

    @FXML
    private PasswordField passwordSigner;

    @FXML
    private Button signUpEndButton;

    @FXML
    private TextField secondNameSigner;

    @FXML
    private TextField nameSigner;

    @FXML
    private TextField levelSigner;

    @FXML
    void initialize() {
        DBHandler handler = new DBHandler();

        signUpEndButton.setOnAction(event -> {
            System.out.println("отработало");
            handler.signUpUser(firstnameSigner.getText(), nameSigner.getText(), secondNameSigner.getText(),"РФ",
                    emailSigner.getText(), passwordSigner.getText(), levelSigner.getText());
        });
    }
}
