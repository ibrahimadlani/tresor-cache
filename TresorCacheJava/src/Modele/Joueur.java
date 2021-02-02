package Modele;

public class Joueur {

    private String nom;
    private boolean tresor;
    private int x;
    private int y;

    public Joueur(String nom){
        this.nom = nom;
        this.tresor = false;
        this.x = 6;
        this.y = 10;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getNom() {
        return nom;
    }

    public boolean isTresor() {
        return tresor;
    }

    public void monter(){
        this.y--;
    }
    public void descendre(){
        this.y++;
    }
    public void droite(){
        this.x++;
    }
    public void gauche(){
        this.x--;
    }
}
