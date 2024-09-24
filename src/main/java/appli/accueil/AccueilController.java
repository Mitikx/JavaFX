package appli.accueil;

import appli.StartApplication;
import javafx.fxml.FXML;
import java.io.IOException;

public class AccueilController {

    @FXML
    public void onDeconnexionButtonClick() throws IOException {
        StartApplication.changeScene("accueil/Login-view.fxml");
    }
}
