package sample;
        import java.net.URL;
        import java.util.ResourceBundle;
        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.scene.control.Button;
        import javafx.scene.control.ChoiceBox;
        import javafx.scene.control.PasswordField;
        import javafx.scene.control.TextField;

public class Controller implements Initializable {
    ObservableList<String> cb1Array = FXCollections.observableArrayList("Клиент", "Строитель", "Дизайнер");

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> typeCheckBox;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signOutButton;

    @FXML
    private Button authButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typeCheckBox.setItems(cb1Array);
        typeCheckBox.setValue("default");



        signOutButton.setOnAction(event->{
            System.out.println("регистрация в системе");
        });





    }
}
