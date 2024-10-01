package appli.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static String serveur = "localhost";
    private static String nomDelaBase = "todolist";
    private static String utilisateur = "root";
    private static String motDePasse = "";

    private static String getUrl() {
       return "jdbc:mysql://" + serveur + "/" + nomDelaBase;
    }
    public static Connection getConnection() {
        try{
            Connection cnx = DriverManager.getConnection(getUrl(), utilisateur, motDePasse);
            System.out.println("Etat de la connexion :");
            System.out.println(cnx.isClosed()? "Fermée" : "Ouverte \r\n");
            return cnx;
        }catch (SQLException e){
            System.out.println("Erreur de connexion à la base de données");
            e.printStackTrace();
            return null;
        }
    }
}
