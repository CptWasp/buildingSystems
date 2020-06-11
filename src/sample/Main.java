package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("appSchema.fxml"));
        Image anotherImage = new Image("file:icon.png");
        primaryStage.getIcons().add(anotherImage);
        primaryStage.setTitle("Buildings platforms");
        primaryStage.setScene(new Scene(root, 630, 450));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
