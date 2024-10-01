package appli.accueil;

import appli.StartApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.User;
import repository.UtilisateurRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
    @FXML
    private Label labelErreur;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @FXML
    public void onInscriptionButtonClick() throws IOException {
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String email = mailField.getText();
        String motDePasse = passwordField.getText();
        String passwordConfirmation = passwordConfirmationField.getText();

        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || motDePasse.isEmpty() || passwordConfirmation.isEmpty()) {
            labelErreur.setText("Erreur, tous les champs doivent être remplis !");
            return;
        }

        if (!motDePasse.equals(passwordConfirmation)) {
            labelErreur.setText("Erreur, les mots de passe ne coïncident pas !");
            return;
        }

        UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
        if (utilisateurRepository.getUtilisateurByEmail(email) != null) {
            labelErreur.setText("Erreur, un compte avec cet email existe déjà !");
            return;
        }
        String pEncode = passwordEncoder.encode(motDePasse);
        User utilisateur = new User(0, nom, prenom, email, pEncode);
        boolean success = utilisateurRepository.inscription(utilisateur);

        if (success) {
            labelErreur.setText("Utilisateur bien ajouté !");
            nomField.clear();
            prenomField.clear();
            mailField.clear();
            passwordField.clear();
            passwordConfirmationField.clear();
        } else {
            labelErreur.setText("Erreur Email déjà utilisé !");
        }
        StartApplication.changeScene("accueil/Login-view.fxml");
    }

    @FXML
    public void onRetourButtonClick() throws IOException {
        StartApplication.changeScene("accueil/Login-view.fxml");
    }
}