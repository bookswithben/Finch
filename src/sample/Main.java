package sample;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    //public static Finch finch = new Finch();


    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        FXMLLoader loader = new FXMLLoader();

        // Print where the fmxl file is (making sure it's readable) - for debugging
        System.out.println(getClass().getResource("/fxml/Main.fxml"));


        loader.setLocation(getClass().getResource("/fxml/Main.fxml"));

        Parent content = loader.load();

        primaryStage.setTitle("Navigate Your Finch");
        content.setStyle("-fx-background-color: white");
        primaryStage.setScene(new Scene(content, 1000, 700));

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
