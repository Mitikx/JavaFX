package repository;

import model.user;
import appli.database.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class UtilisateurRepository {

    public boolean inscription(user utilisateur) {
        String sql = "INSERT INTO utilisateur (nom, prenom, email, mot_de_passe) VALUES (?, ?, ?, ?)";
        try (Connection cnx = database.getConnection();
             PreparedStatement st = cnx.prepareStatement(sql)) {
            st.setString(1, utilisateur.getNom());
            st.setString(2, utilisateur.getPrenom());
            st.setString(3, utilisateur.getEmail());
            st.setString(4, utilisateur.getMotDePasse());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            if (e instanceof SQLIntegrityConstraintViolationException) {
                System.out.println("Duplicate email detected: " + utilisateur.getEmail());
            } else {
                e.printStackTrace();
            }
            return false;
        }
    }
    public user getUtilisateurByEmail(String email) {
        String sql = "SELECT * FROM utilisateur WHERE email = ?";
        try (Connection cnx = database.getConnection();
             PreparedStatement st = cnx.prepareStatement(sql)) {
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new user(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("motDePasse")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}