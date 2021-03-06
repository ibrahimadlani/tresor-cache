package Modele;

import java.util.ArrayList;

public class Salle extends Case{
    private ArrayList<Fantome> listeFantomes;
    private boolean tresor;
    private String nom;
    private ArrayList<Case> portes;
    private ArrayList<Salle> sallesAdjacentes;
    private boolean fantomeRouge;

    public Salle(int x, int y, String nom, ArrayList<Case> portes,boolean t) {
        this.nom = nom;
        super.x = x;
        super.y = y;
        this.portes = portes;
        this.listeFantomes = new ArrayList<>();
        this.fantomeRouge = false;
        this.tresor = t;
    }

    public Salle() {
    }

    public void setTresor(boolean tresor) {
        this.tresor = tresor;
    }

    public boolean isTresor() { return tresor; }
    public ArrayList<Fantome> getListeFantomes() { return listeFantomes; }
    public ArrayList<Case> getPortes() { return portes; }
    public String getNom() { return nom; }
    public ArrayList<Salle> getSallesAdjacentes() { return sallesAdjacentes; }

    public boolean isFantomeRouge() {
        return fantomeRouge;
    }



    public void setSallesAdjacentes(ArrayList<Salle> sallesAdjacentes) {
        this.sallesAdjacentes = sallesAdjacentes;
    }

    public void addFantome(){
        if (this.listeFantomes.size() == 0) {
            this.listeFantomes.add(new FantomeVert(this));
        }else if (this.listeFantomes.size() == 1 && (this.listeFantomes.get(0) instanceof FantomeVert)){
            this.listeFantomes.add(new FantomeVert(this));
        }else if (this.listeFantomes.size() == 2 && (this.listeFantomes.get(0) instanceof FantomeVert) && (this.listeFantomes.get(1) instanceof FantomeVert)){
            this.listeFantomes.removeAll(listeFantomes);
            this.listeFantomes.add(new FantomeRouge(this));
            this.fantomeRouge = true;
        }else {
        }
    }

    public void deleteFantome(){
        if (this.listeFantomes.size() == 0) {
            System.out.println("Erreur");
        }else if (this.listeFantomes.size() == 1 && (this.listeFantomes.get(0) instanceof FantomeVert)){
            this.listeFantomes.clear();
        }else if (this.listeFantomes.size() == 2 && (this.listeFantomes.get(0) instanceof FantomeVert) && (this.listeFantomes.get(1) instanceof FantomeVert)){
            this.listeFantomes.remove(1);
        }else if (this.listeFantomes.size() == 1 && (this.listeFantomes.get(0) instanceof FantomeRouge)){
            this.listeFantomes.clear();
            this.fantomeRouge = false;
        } {
        }
    }

}