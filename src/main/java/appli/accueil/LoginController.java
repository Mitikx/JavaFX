package appli.accueil;

import appli.StartApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.User;
import org.springframework.security.crypto.bcrypt.BCrypt;
import repository.UtilisateurRepository;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField mailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label labelErreur;

    @FXML
    public void onConnexionButtonClick() throws IOException {
        String email = mailField.getText();
        String motDePasse = passwordField.getText();

        UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
        User utilisateur = utilisateurRepository.getUtilisateurByEmail(email);

        if (utilisateur != null && BCrypt.checkpw(motDePasse, utilisateur.getMotDePasse())) {
            StartApplication.changeScene("accueil/AcceuilView.fxml");
        } else {
            labelErreur.setText("Erreur, email ou mot de passe incorrect !");
        }
    }

    @FXML
    public void onInscriptionButtonClick() throws IOException {
        StartApplication.changeScene("accueil/InscriptionView.fxml");
    }
}