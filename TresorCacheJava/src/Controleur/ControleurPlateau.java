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

    public Plateau getP() {
        return p;
    }




    public void monterJoueur(Joueur j){
        if (p.getMatrice().get(j.getY()-1).get(j.getX()) instanceof Couloir){
            p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
            j.monter();
            p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);
        }else if (p.getMatrice().get(j.getY()-1).get(j.getX()) == null){
            erreur = "[ERREUR] Le joueur "+j+" à essayé de monter mais bon ...";
        }else if (p.getMatrice().get(j.getY()-1).get(j.getX()) instanceof Salle){
            if((((Salle) p.getMatrice().get(j.getY()-1).get(j.getX())).getPortes().get(0).getX() == j.getX()) && (((Salle) p.getMatrice().get(j.getY()-1).get(j.getX())).getPortes().get(0).getY() == j.getY())){
                p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                j.monter();
                p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);
                vs.affichage((Salle) p.getMatrice().get(j.getY()-1).get(j.getX()));
            }else {
                erreur = "[ERREUR] Le joueur "+j+" à essayé de monter mais bon ...";
            }
        }
    }
    public void descendreJoueur(Joueur j){
        if (p.getMatrice().get(j.getY()+1).get(j.getX()) instanceof Couloir){
            p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
            j.descendre();
            p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);
        }else if (p.getMatrice().get(j.getY()+1).get(j.getX()) == null){
            erreur = "[ERREUR] Le joueur "+j+" à essayé de descendre mais bon ...";
        }else if (p.getMatrice().get(j.getY()+1).get(j.getX()) instanceof Salle){
            if((((Salle) p.getMatrice().get(j.getY()+1).get(j.getX())).getPortes().get(0).getX() == j.getX()) && (((Salle) p.getMatrice().get(j.getY()+1).get(j.getX())).getPortes().get(0).getY() == j.getY())){
                p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                j.descendre();
                p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);

            }else {
                erreur = "[ERREUR] Le joueur "+j+" à essayé de descendre mais bon ...";

            }
        }

    }

    public void droiteJoueur(Joueur j){
        if (p.getMatrice().get(j.getY()).get(j.getX()+1) instanceof Couloir){
            p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
            j.droite();
            p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);
        }else if (p.getMatrice().get(j.getY()).get(j.getX()+1) == null){
            System.out.println("NOOOO");
            erreur = "[ERREUR] Le joueur "+j+" à essayé d'aller à droite mais bon ...";
        }else if (p.getMatrice().get(j.getY()).get(j.getX()+1) instanceof Salle){
            if((((Salle) p.getMatrice().get(j.getY()).get(j.getX()+1)).getPortes().get(0).getX() == j.getX()) && (((Salle) p.getMatrice().get(j.getY()).get(j.getX()+1)).getPortes().get(0).getY() == j.getY())){
                p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                j.droite();
                p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);
            }else {
                erreur = "[ERREUR] Le joueur "+j+" à essayé d'aller à droite mais bon ...";
            }
        }
    }
    public void gaucheJoueur(Joueur j){
        if (p.getMatrice().get(j.getY()).get(j.getX()-1) instanceof Couloir){
            p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
            j.gauche();
            p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);
        }else if (p.getMatrice().get(j.getY()).get(j.getX()-1) == null){
            System.out.println("NOOOO");
            erreur = "[ERREUR] Le joueur "+j+" à essayé d'aller à gauche mais bon ...";
        }else if (p.getMatrice().get(j.getY()).get(j.getX()-1) instanceof Salle){
            if(((((Salle) p.getMatrice().get(j.getY()).get(j.getX()-1)).getPortes().get(0).getX() == j.getX()) && (((Salle) p.getMatrice().get(j.getY()).get(j.getX()-1)).getPortes().get(0).getY() == j.getY())) || ((((Salle) p.getMatrice().get(j.getY()).get(j.getX()-1)).getPortes().get(1).getX() == j.getX()) && (((Salle) p.getMatrice().get(j.getY()).get(j.getX()-1)).getPortes().get(1).getY() == j.getY()))){
                p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                j.gauche();
                p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);
            }else {
                erreur = "[ERREUR] Le joueur "+j+" à essayé d'aller à gauche mais bon ...";
            }
        }
    }
    public void afficher(){
        vue.affichage(p.getMatrice(),p.listeJoueurs());
    }
}
