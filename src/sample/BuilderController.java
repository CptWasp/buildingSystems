package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class BuilderController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button WorksTextButton;

    @FXML
    private ProgressBar progressChecker;

    @FXML
    private ImageView clientPhoto;

    @FXML
    private Label clientName;

    @FXML
    private Button quitButton;

    @FXML
    private TextField WorksTextField;

    @FXML
    private Button WorksAdder;

    @FXML
    private TextField id_fielder;

    @FXML
    private TableView<?> worksTable;

    @FXML
    private TableColumn<?, ?> works_td;

    @FXML
    private TableView<?> doneWorksTable;

    @FXML
    private TableColumn<?, ?> doneworks_td;

    @FXML
    void initialize() {
        DBHandler handler = new DBHandler();
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

        WorksAdder.setOnAction(event -> {
            handler.dataUpdating(id_fielder.getText());
            System.out.println("update в бд");
        });

        WorksTextButton.setOnAction(event -> {
            handler.insertComment(WorksTextField.getText());
            System.out.println("Добавление процесса в бд");
        });



    }
}
