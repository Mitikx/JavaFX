package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.lang.reflect.Field;

public class LoginController {
    @FXML
    private Label erreurLabel;
    private Button inscriptionLabel;
    private Button mdpOublieLabel;
    private Button connexionLabel;
    private Field passwordField;
    private Field mailField;


    @FXML
    protected void onInscriptionButtonClick() throws IOException {
        StartApplication.changeScene("accueil/inscriptionView.fxml");
    }

    @FXML
    protected void onMdpOublieButtonClick() {
        System.out.println(passwordField);
    }

    @FXML
    protected void onConnexionButtonCLick() {
        System.out.println("Connexion");
    }
}
