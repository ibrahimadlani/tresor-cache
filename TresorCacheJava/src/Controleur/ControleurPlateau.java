package Controleur;

import Modele.*;

import Vue.VuePlateau;
import Vue.vueSalle;

import java.util.ArrayList;

public class ControleurPlateau {
    private Plateau p;
    private VuePlateau vue;
    private vueSalle vs;
    private String erreur = "";

    //private

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
        Case caseOrigine = p.getMatrice().get(j.getY()).get(j.getX());
        Case caseDestination = p.getMatrice().get(j.getY()).get(j.getX()+1);

        boolean iscaseOrigineSalle = caseOrigine instanceof Salle;
        boolean isCaseDestinationSalle = caseDestination instanceof Salle;

        if (iscaseOrigineSalle){
            ArrayList<Case> portesSalle = ((Salle) caseOrigine).getPortes();
            ArrayList<Salle> sallesAdjacentesSalle = ((Salle) caseOrigine).getSallesAdjacentes();
            Salle salleDestination =  (Salle) caseDestination;
            if (portesSalle.contains(caseDestination)){
                System.out.println("La destination est bien une porte vers la sortie");
            }else if (sallesAdjacentesSalle.contains(salleDestination)){
                System.out.println("La destination est bien une salle adjacente");
            }else{
                System.out.println("Erreur : vous n'avez bouger de la salle");
            }
        }else{
            if (caseDestination == null){
                System.out.println("Erreur : Destination null");
            }else if (isCaseDestinationSalle){
                System.out.println("Erreur : Destination null");
            }
        }

        //if (p.getMatrice().get(j.getY()).get(j.getX()+1) instanceof Couloir){
        //    p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
        //    j.setX(j.getX()+1);
        //    p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);
        //}else if (p.getMatrice().get(j.getY()).get(j.getX()+1) == null){
        //        System.out.println("NO");
        //}else if (p.getMatrice().get(j.getY()).get(j.getX()+1) instanceof Salle){
        //    if((((Salle) p.getMatrice().get(j.getY()).get(j.getX()+1)).getPortes().get(0).getX() == j.getX()) && (((Salle) p.getMatrice().get(j.getY()).get(j.getX()+1)).getPortes().get(0).getY() == j.getY())){
        //        p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
        //        j.setX(j.getX()+1);
        //        p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);
        //    }
        //}
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

    public void prendreTresor(Joueur j){
        if (p.getMatrice().get(j.getY()).get(j.getX()) instanceof Salle && ((Salle) p.getMatrice().get(j.getY()).get(j.getX())).isTresor() && j.isTresor() == false){
            Salle emplacement = (Salle) p.getMatrice().get(j.getY()).get(j.getX());
            emplacement.setTresor(false);
            j.setTresor(true);
            if (emplacement.isFantomeRouge()){
                //combat
            }

        }
    }
    public void depotTresor(Joueur j){
        if (j.isTresor() == true && j.getX() == 3 && j.getY() == 2){
            p.setNbTresor(p.getNbTresor()+1);
            j.setTresor(false);
        }
    }

    public void afficher(){
        vue.affichage(p.getMatrice(),p.listeJoueurs());
    }
}
