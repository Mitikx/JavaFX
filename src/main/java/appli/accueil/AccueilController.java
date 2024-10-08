package appli.accueil;

import appli.StartApplication;
import appli.liste.EditerListeController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import model.Liste;
import repository.ListeRepository;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AccueilController implements Initializable {

    public Button supprimerListeButton;
    @FXML
    private TableView<Liste> tableauListe;
    String[][] colonnes = {{"Id liste","idliste"},{"Nom","nom"}};

    private ListeRepository listeRepository = new ListeRepository();

    @FXML
    public void onDeconnexionButtonClick() throws IOException {
        StartApplication.changeScene("accueil/Login-view.fxml");
    }

    @FXML
    public void onAjouterListeButtonClick() throws IOException {
        try {
            StartApplication.changeScene("liste/ListeFormView.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onSupprimerListeButtonClick() {
        Liste selectedListe = tableauListe.getSelectionModel().getSelectedItem();
        if (selectedListe != null) {
            listeRepository.deleteListe(selectedListe.getIdliste());
            tableauListe.getItems().remove(selectedListe);
        }
    }

    public void onListeSelection(MouseEvent event){
        if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2){
            TablePosition cell = tableauListe.getSelectionModel().getSelectedCells().get(0);
            int indexLigne = cell.getRow();
            TableColumn colonne = cell.getTableColumn();
            Liste listSel = tableauListe.getItems().get(indexLigne);
            System.out.println("Double click sur la liste : " + indexLigne + " " + colonne.getText() + " :" + listSel);
            EditerListeController controller = new EditerListeController();
            controller.setListe(listSel);
            try {
                StartApplication.changerSceneController("liste/EditerListeView.fxml", controller);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1){
            TablePosition cell = tableauListe.getSelectionModel().getSelectedCells().get(0);
            int indexLigne = cell.getRow();
            TableColumn colonne = cell.getTableColumn();
            Liste listSel = tableauListe.getItems().get(indexLigne);
            System.out.println("Simple click sur la liste : " + indexLigne + " " + colonne.getText() + " :" + listSel);
            EditerListeController controller = new EditerListeController();
            controller.setListe(listSel);
            try {
                StartApplication.changerSceneController("liste/EditerListeView.fxml", controller);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int i = 0 ; i < colonnes.length ; i++){
            TableColumn<Liste,String> maColonne = new TableColumn<>(colonnes[i][0]);
            maColonne.setCellValueFactory(new PropertyValueFactory<Liste,String>(colonnes[i][1]));
            tableauListe.getColumns().add(maColonne);
        }

        List<Liste> listes = listeRepository.getAllListes();

        ObservableList<Liste> observableListes = FXCollections.observableArrayList(listes);
        tableauListe.setItems(observableListes);
    }
}