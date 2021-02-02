package Modele;

import java.util.ArrayList;

public class Salle extends Case{
    private ArrayList<Fantome> listeFantomes;
    private boolean tresor;
    private String nom;
    private ArrayList<Case> portes;
    private ArrayList<Salle> sallesAdjacentes;

    public Salle(int x, int y, String nom, ArrayList<Case> portes) {
        super.nomSalle = nom;
        super.x = x;
        super.y = y;
        this.portes = portes;
    }

    public boolean isTresor() {
        return tresor;
    }

    public ArrayList<Fantome> getListeFantomes() {
        return listeFantomes;
    }

    public ArrayList<Case> getPortes() {
        return portes;
    }

    public void evolution(){
        if (this.listeFantomes.get(0) instanceof FantomeVert && this.listeFantomes.get(1) instanceof FantomeVert &&this.listeFantomes.get(2) instanceof FantomeVert){
            this.listeFantomes.removeAll(listeFantomes);
            FantomeRouge fr = new FantomeRouge(this);
            this.listeFantomes.add(fr);
        }else {
            System.out.println("Evolution impossible");
        }
    }
}