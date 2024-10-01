package model;

public class User {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String MotDePasse;

    public User(int id, String nom, String prenom, String email, String MotDePasse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.MotDePasse = MotDePasse;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getMotDePasse() {
        return MotDePasse;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMotDePasse(String password) {
        this.MotDePasse = MotDePasse;
    }
}
