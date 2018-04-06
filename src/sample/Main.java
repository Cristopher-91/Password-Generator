package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Visual.fxml"));
        primaryStage.setTitle("Password Generator");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        Controller controller = new Controller();
        controller.setMain(this);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
