package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class UserController {
    private ObservableList<ObjectFromBD> ObjectData = FXCollections.observableArrayList();


    @FXML
    private ResourceBundle resources;

    @FXML
    private Button upd;

    @FXML
    private URL location;

    @FXML
    private ImageView clientPhoto;

    @FXML
    private Label clientName;

    @FXML
    private Button quitButton;

    @FXML
    private TableView<ObjectFromBD> table_01;

    @FXML
    private TableColumn<ObjectFromBD, String> tb_1;

    @FXML
    private TableView<ObjectFromBD> table_10;

    @FXML
    private TableColumn<ObjectFromBD, String> tb_2;

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


        upd.setOnAction(event -> {
        DBWorker worker = new DBWorker();
        String inWorkSelection = "SELECT `application_id`, `comment`, `status`, `object_id`, `user_id` FROM `applications_tb` WHERE `status` = 0";
        String preWorkSelection = "SELECT `application_id`, `comment`, `status`, `object_id`, `user_id` FROM `applications_tb` WHERE `status` = 1";


        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(inWorkSelection);

            while (resultSet.next()) {
                ObjectFromBD obj = new ObjectFromBD();

                obj.setId(resultSet.getString(1));
                obj.setComment(resultSet.getString(2));
                obj.setStatus(resultSet.getString(3));
                obj.setObject_name(resultSet.getString(4));
                obj.setUser_name(resultSet.getString(5));

                ObjectData.add(new ObjectFromBD(obj.getComment(), obj.getComment(), obj.getComment(), obj.getComment(), obj.getComment(), obj.getComment()));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        tb_1.setCellValueFactory(new PropertyValueFactory<ObjectFromBD, String>("Активные"));
        table_01.setItems(ObjectData);

//        tb_2.setCellValueFactory(new PropertyValueFactory<ObjectFromBD, String>("Завершенные"));
//        table_10.setItems(ObjectData);

        });


    }
}
