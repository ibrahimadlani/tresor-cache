package Modele;

public class Carte {
    private String nom;
    private Salle salle;

    public Carte(String nom, Salle salle){
        this.nom = nom;
        this.salle = salle;
    }

    public String getNom() {
        return nom;
    }

    public Salle getSalle() {
        return salle;
    }
}