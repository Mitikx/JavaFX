package repository;

import model.User;
import appli.database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UtilisateurRepository {

    private Connection connection;

    public UtilisateurRepository() {
        this.connection = Database.getConnection();
    }
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean inscription(User utilisateur) {
        if (getUtilisateurByEmail(utilisateur.getEmail()) != null) {
            return false;
        }
        String sql = "INSERT INTO utilisateur (nom, prenom, email, mot_de_passe) VALUES (?, ?, ?, ?)";
        Connection cnx = Database.getConnection();
        try {
            PreparedStatement st = cnx.prepareStatement(sql);
            st.setString(1, utilisateur.getNom());
            st.setString(2, utilisateur.getPrenom());
            st.setString(3, utilisateur.getEmail());
            st.setString(4, utilisateur.getMotDePasse());
            int rowsInserted = st.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User getUtilisateurByEmail(String email) {
        String query = "SELECT id_utilisateur, nom, prenom, email, mot_de_passe FROM utilisateur WHERE email = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new User(
                            resultSet.getInt("id_utilisateur"),
                            resultSet.getString("nom"),
                            resultSet.getString("prenom"),
                            resultSet.getString("email"),
                            resultSet.getString("mot_de_passe")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}