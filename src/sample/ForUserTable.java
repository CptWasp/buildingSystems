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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ForUserTable {

    private ObservableList<ObjectFromBD> ObjectData = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<ObjectFromBD> tableMF;

    @FXML
    private TableColumn<ObjectFromBD, String> id_td;

    @FXML
    private TableColumn<ObjectFromBD, String> comment_td;

    @FXML
    private TableColumn<ObjectFromBD, String> status_td;

    @FXML
    private TableColumn<ObjectFromBD, String> user_td;

    @FXML
    private TableColumn<ObjectFromBD, String> object_td;

    @FXML
    private TableColumn<ObjectFromBD, String> url_td;

    @FXML
    private Button exit_button;

    @FXML
    void initialize() {

        exit_button.setOnAction(event -> {
            System.out.println("Выход");
            exit_button.getScene().getWindow().hide();
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







        DBWorker worker = new DBWorker();
        String iWorkSelection = "SELECT * FROM `applications_tb`";
        String inWorkSelection = "SELECT `application_id`, `comment`, `status`, `object_name`, `user_name`, `d_link` FROM `applications_tb`,`users_tb`,`objects_tb` WHERE `applications_tb`.`user_id`=`users_tb`.`user_id` AND `applications_tb`.`object_id`=`objects_tb`.`object_id`";

        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(inWorkSelection);
            System.out.println("Запрос выполнен");

            while (resultSet.next()) {
                ObjectFromBD obj = new ObjectFromBD();

//                int id = resultSet.getInt(1);
//                System.out.println(id);
                obj.setId(resultSet.getString(1));
                obj.setComment(resultSet.getString(2));
                obj.setStatus(resultSet.getString(3));
                obj.setObject_name(resultSet.getString(4));
                obj.setUser_name(resultSet.getString(5));
                obj.setLink(resultSet.getString(6));

                ObjectData.add(new ObjectFromBD(obj.getId(), obj.getComment(), obj.getStatus(), obj.getObject_name(), obj.getUser_name(), obj.getLink()));

            }

            id_td.setCellValueFactory(new PropertyValueFactory<ObjectFromBD, String>("id"));
            comment_td.setCellValueFactory(new PropertyValueFactory<ObjectFromBD, String>("comment"));
            status_td.setCellValueFactory(new PropertyValueFactory<ObjectFromBD, String>("status"));
            object_td.setCellValueFactory(new PropertyValueFactory<ObjectFromBD, String>("object_name"));
            user_td.setCellValueFactory(new PropertyValueFactory<ObjectFromBD,String>("user_name"));
            url_td.setCellValueFactory(new PropertyValueFactory<ObjectFromBD, String>("link"));

            tableMF.setItems(ObjectData);
            System.out.println("отстроилась таблица");
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }





//        initData();








        /*

        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(inWorkSelection);
            System.out.println("Запрос выполнен");

            while (resultSet.next()) {
                ObjectFromBD obj = new ObjectFromBD();

                obj.setId(resultSet.getString(1));
                obj.setComment(resultSet.getString(2));
                obj.setStatus(resultSet.getString(3));
                obj.setObject_name(resultSet.getString(4));
                obj.setUser_name(resultSet.getString(5));
                obj.setLink(resultSet.getString(6));
                System.out.println(obj.getId()+obj.getComment()+obj.getStatus()+obj.getUser_name()+obj.getObject_name()+obj.getLink());

                ObjectData.add(new ObjectFromBD(obj.getId(), obj.getComment(), obj.getStatus(), obj.getUser_name(), obj.getObject_name(), obj.getLink()));
            }

            id_td.setCellValueFactory(new PropertyValueFactory<ObjectFromBD, String>("ID"));
            comment_td.setCellValueFactory(new PropertyValueFactory<ObjectFromBD, String>("Comment"));
            status_td.setCellValueFactory(new PropertyValueFactory<ObjectFromBD, String>("status"));
            user_td.setCellValueFactory(new PropertyValueFactory<ObjectFromBD, String>("user"));
            object_td.setCellValueFactory(new PropertyValueFactory<ObjectFromBD, String>("object"));
            url_td.setCellValueFactory(new PropertyValueFactory<ObjectFromBD, String>("url"));

            tableMF.setItems(ObjectData);
            System.out.println("отстроилась таблица");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



*/
    }

//    private void initData(){
//        ObjectData.add(new ObjectFromBD("ew", "ve", "ds", "ve", "wvwe", "revre"));
//    }
}
