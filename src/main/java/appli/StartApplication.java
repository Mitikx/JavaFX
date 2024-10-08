package appli;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartApplication extends Application {
    private static Stage mainStage;
    @Override
        public void start(Stage stage) throws IOException {
        mainStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("accueil/Login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        mainStage.setTitle("Bienvenue");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void changeScene(String view) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource(view));
        Scene scene = new Scene(fxmlLoader.load());
        mainStage.setTitle("Inscription");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void changerSceneController(String fxmlFile, Object controller) throws IOException {
        mainStage.close();
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource(fxmlFile));
            fxmlLoader.setController(controller);
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            mainStage.setScene(scene);
            mainStage.show();
        }catch (IOException e){
            System.err.println(String.format("Erreur lors du chargement de la vue %s", e.getMessage()));
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
