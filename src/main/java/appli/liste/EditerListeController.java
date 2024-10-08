package appli.liste;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Liste;
import repository.ListeRepository;

public class EditerListeController {

    @FXML
    private TextField nomField;

    private ListeRepository listeRepository = new ListeRepository();
    private Liste liste;

    public void setListe(Liste liste) {
        this.liste = liste;
        nomField.setText(liste.getNom());
    }

    @FXML
    public void onMettreAJourButtonClick() {
        String nom = nomField.getText();
        if (!nom.isEmpty() && liste != null) {
            liste.setNom(nom);
            listeRepository.updateListe(liste);
        }
    }
}