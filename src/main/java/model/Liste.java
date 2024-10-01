package model;

public class Liste {
    private int idliste;
    private String nom;

    public Liste(int idliste, String nom) {
        this.idliste = idliste;
        this.nom = nom;
    }

    public int getIdliste() {
        return idliste;
    }

    public void setIdliste(int idliste) {
        this.idliste = idliste;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}