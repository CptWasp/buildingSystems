package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class UserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView clientPhoto;

    @FXML
    private Label clientName;

    @FXML
    private Button quitButton;

    @FXML
    private TableView<?> table_01;

    @FXML
    private TableColumn<?, ?> tb_1;

    @FXML
    private TableView<?> table_10;

    @FXML
    private TableColumn<?, ?> tb_2;

    @FXML
    void initialize() {
        quitButton.setOnAction(event -> {
            System.out.println("Выход");
            quitButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("appSchema.fxml"));

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
}
