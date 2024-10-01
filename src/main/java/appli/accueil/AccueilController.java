package appli.accueil;

import appli.StartApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Liste;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AccueilController implements Initializable {

    private TableView<Liste> tableauListe;
    String[][] colonnes = {{"Id liste","idliste"},{"Nom","nom"}};

    @FXML
    public void onDeconnexionButtonClick() throws IOException {
        StartApplication.changeScene("accueil/Login-view.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int i = 0 ; i < colonnes.length ; i++){
            TableColumn<Liste,String> maColonne = new TableColumn<>(colonnes[i][0]);
            maColonne.setCellValueFactory(new PropertyValueFactory<Liste,String>(colonnes[i][1]));
            tableauListe.getColumns().add(maColonne);
        }
    }
}