package Controleur;

import Modele.Couloir;
import Modele.Joueur;
import Modele.Plateau;
import Modele.Salle;

import Vue.VuePlateau;
import Vue.vueSalle;

public class ControleurPlateau {
    private Plateau p;
    private VuePlateau vue;
    private vueSalle vs;
    private String erreur = "";

    public ControleurPlateau() {
        this.p = new Plateau();
        this.vue = new VuePlateau();
    }

    public Plateau getP() { return p; }

    public void monterJoueur(Joueur j){
        if (p.getMatrice().get(j.getY()-1).get(j.getX()) instanceof Couloir){
            p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
            j.setY(j.getY()-1);
            p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);
        }else if (p.getMatrice().get(j.getY()-1).get(j.getX()) == null){
            System.out.println("NO");
        }else if (p.getMatrice().get(j.getY()-1).get(j.getX()) instanceof Salle){
            if((((Salle) p.getMatrice().get(j.getY()-1).get(j.getX())).getPortes().get(0).getX() == j.getX()) && (((Salle) p.getMatrice().get(j.getY()-1).get(j.getX())).getPortes().get(0).getY() == j.getY())){
                p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                j.setY(j.getY()-1);
                p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);
                vs.affichage((Salle) p.getMatrice().get(j.getY()-1).get(j.getX()));
            }
        }
    }
    public void descendreJoueur(Joueur j){
        if (p.getMatrice().get(j.getY()+1).get(j.getX()) instanceof Couloir){
            p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
            j.setY(j.getY()+1);
            p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);
        }else if (p.getMatrice().get(j.getY()+1).get(j.getX()) == null){
            System.out.println("NO");
        }else if (p.getMatrice().get(j.getY()+1).get(j.getX()) instanceof Salle){
            if((((Salle) p.getMatrice().get(j.getY()+1).get(j.getX())).getPortes().get(0).getX() == j.getX()) && (((Salle) p.getMatrice().get(j.getY()+1).get(j.getX())).getPortes().get(0).getY() == j.getY())){
                p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                j.setY(j.getY()+1);
                p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);
            }
        }

    }

    public void droiteJoueur(Joueur j){
        if (p.getMatrice().get(j.getY()).get(j.getX()+1) instanceof Couloir){
            p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
            j.setX(j.getX()+1);
            p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);
        }else if (p.getMatrice().get(j.getY()).get(j.getX()+1) == null){
            System.out.println("NO");
        }else if (p.getMatrice().get(j.getY()).get(j.getX()+1) instanceof Salle){
            if((((Salle) p.getMatrice().get(j.getY()).get(j.getX()+1)).getPortes().get(0).getX() == j.getX()) && (((Salle) p.getMatrice().get(j.getY()).get(j.getX()+1)).getPortes().get(0).getY() == j.getY())){
                p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                j.setX(j.getX()+1);
                p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);
            }
        }
    }
    public void gaucheJoueur(Joueur j){
        if (p.getMatrice().get(j.getY()).get(j.getX()-1) instanceof Couloir){
            p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
            j.setX(j.getX()-1);
            p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);
        }else if (p.getMatrice().get(j.getY()).get(j.getX()-1) == null){
            System.out.println("NO");
        }else if (p.getMatrice().get(j.getY()).get(j.getX()-1) instanceof Salle){
            if(((((Salle) p.getMatrice().get(j.getY()).get(j.getX()-1)).getPortes().get(0).getX() == j.getX()) && (((Salle) p.getMatrice().get(j.getY()).get(j.getX()-1)).getPortes().get(0).getY() == j.getY())) || ((((Salle) p.getMatrice().get(j.getY()).get(j.getX()-1)).getPortes().get(1).getX() == j.getX()) && (((Salle) p.getMatrice().get(j.getY()).get(j.getX()-1)).getPortes().get(1).getY() == j.getY()))){
                p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                j.setX(j.getX()-1);
                p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);
            }
        }
    }
    public void afficher(){
        vue.affichage(p.getMatrice(),p.listeJoueurs());
    }
}
