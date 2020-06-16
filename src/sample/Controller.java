package sample;
        import java.io.IOException;
        import java.net.URL;
        import java.util.ResourceBundle;
        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.fxml.Initializable;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.ChoiceBox;
        import javafx.scene.control.PasswordField;
        import javafx.scene.control.TextField;
        import javafx.stage.Stage;

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

        authButton.setOnAction(event -> {
            String loginText = loginField.getText().trim();
            String passText =  passwordField.getText().trim();

            if(!loginText.equals("") && !passText.equals("")){
                logininigUser(loginText, passText);
            }else {
                System.out.println("Error!!! Pass & login is empty");
            }

        });

        signOutButton.setOnAction(event->{
            System.out.println("регистрация в системе");
            signOutButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("SignUpVision.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

    }

    private void logininigUser(String loginText, String passText) {

        if(typeCheckBox.getValue().equals("Строитель")) {
            System.out.println("Вход в систему как "+typeCheckBox.getValue());
            signOutButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("buildView.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        }else{
            if (typeCheckBox.getValue().equals("Клиент")){
                System.out.println("Вход в систему как "+typeCheckBox.getValue());
                signOutButton.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("UserView.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
            }else{
                System.out.println("Вход в систему как "+typeCheckBox.getValue()+" пока запрещен");
            }
        }



    }
}
