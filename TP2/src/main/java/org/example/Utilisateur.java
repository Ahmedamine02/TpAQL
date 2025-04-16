package org.example;

public class Utilisateur {
    private String prenom;
    private String nom;
    private String email;
    private int Id;

    public Utilisateur(String prenom, String nom, String email, int id) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        Id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
