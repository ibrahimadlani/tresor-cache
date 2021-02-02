package Modele;

import java.util.ArrayList;

public class Case {
    protected String nomSalle;
    private ArrayList<Joueur> joueurs;
    protected int x;
    protected int y;


    public Case(int x, int y){
        this.joueurs = new ArrayList<>();
        this.nomSalle = " ";
        this.x = x;
        this.y = y;
    }

    public Case(){
        this.joueurs = new ArrayList<>();

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }
    public void setJoueurs(ArrayList<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public String getNomSalle() {
        return nomSalle;
    }

    public String getNom() {
        return this.nomSalle;
    }

    public void setNomSalle(String nomSalle) {
        this.nomSalle = nomSalle;
    }

    public void ajouterJoueur (Joueur j){
        joueurs.add(j);
    }

    public void suppprimerJoueur (Joueur j){
        joueurs.remove(j);
    }
}
