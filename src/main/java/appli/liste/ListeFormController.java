package appli.liste;

import appli.StartApplication;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import model.Liste;
import repository.ListeRepository;

import java.io.IOException;
import java.util.List;

public class ListeFormController {

    @FXML
    private TextField nomField;

    @FXML
    private TableView<Liste> tableauListe;

    private ListeRepository listeRepository = new ListeRepository();

    @FXML
    public void onAjouterListeButtonClick() {
        String nomListe = nomField.getText();
        ajouterNouvelleListe(nomListe);
    }

    public void ajouterNouvelleListe(String nomListe) {
        Liste nouvelleListe = new Liste(0, nomListe);
        boolean success = listeRepository.AjouterListe(nouvelleListe);
        if (success) {
            List<Liste> listes = listeRepository.getAllListes();
            tableauListe.setItems(FXCollections.observableArrayList(listes));
        } else {
            System.out.println("Erreur lors de l'ajout de la liste");
        }
    }
}