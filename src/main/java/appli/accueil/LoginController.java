package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.lang.reflect.Field;

public class LoginController {
    public Label erreurLabel;
    @FXML
    private Button connexionButton;
    @FXML
    private TextField mailField;
    @FXML
    private TextField passwordField;



    @FXML
    protected void onInscriptionButtonClick() throws IOException {
        StartApplication.changeScene("accueil/inscriptionView.fxml");
    }

    @FXML
    protected void onMdpOublieButtonClick() {
        System.out.println(passwordField.getText());
}

    @FXML
    protected void onConnexionButtonCLick() {
        String mail = mailField.getText();
        String password = passwordField.getText();
    }
}
