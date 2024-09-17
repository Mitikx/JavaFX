package appli.accueil;

import appli.StartApplication;

import java.io.IOException;

public class InscriptionController {

    private String nom;
    private String prenom;
    private String mail;
    private String password;
    private String passwordConfirmation;

    public void onInscriptionButtonClick() {
        System.out.println(nom);
        System.out.println(prenom);
        System.out.println(mail);
        System.out.println(password);
        System.out.println(passwordConfirmation);
    }
    public void onRetourButtonClick() throws IOException {
        StartApplication.changeScene("accueil/Login-view.fxml");
    }
}
