package appli.accueil;

import appli.StartApplication;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class InscriptionController {

    @FXML
    private TextField nomField;
    @FXML
    private TextField prenomField;
    @FXML
    private TextField mailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField passwordConfirmationField;

    public void onInscriptionButtonClick() {
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String mail = mailField.getText();
        String password = passwordField.getText();
        String passwordConfirmation = passwordConfirmationField.getText();
    }
    public void onRetourButtonClick() throws IOException {
        StartApplication.changeScene("accueil/Login-view.fxml");
    }
}
