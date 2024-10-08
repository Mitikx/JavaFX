package repository;

import database.Database;
import model.Liste;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListeRepository {

    private Connection connection;

    public  ListeRepository(){
        this.connection = Database.getConnection();
    }

    public boolean AjouterListe(Liste liste) {
        String sql = "INSERT INTO liste (nom) VALUES (?)";
        Connection cnx = Database.getConnection();
        try {
            PreparedStatement st = cnx.prepareStatement(sql);
            st.setString(1, liste.getNom());
            int rowsInserted = st.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    private List<Liste> listes = new ArrayList<>();

    public List<Liste> getAllListes() {
        List<Liste> listes = new ArrayList<>();
        String sql = "SELECT * FROM liste";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Liste liste = new Liste(
                        resultSet.getInt("id_liste"),
                        resultSet.getString("nom")
                );
                listes.add(liste);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listes;
    }

    public void addListe(Liste liste) {
        listes.add(liste);
    }

    public void deleteListe(int idListe) {
        listes.removeIf(liste -> liste.getIdliste() == idListe);
    }

    public void updateListe(Liste liste) {

    }
}