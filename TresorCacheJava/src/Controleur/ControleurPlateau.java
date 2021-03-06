package Controleur;

import Modele.*;

import Vue.VuePlateau;
import Vue.vueSalle;

import java.util.ArrayList;
import java.util.Scanner;

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

        Case caseOrigine = p.getMatrice().get(j.getY()).get(j.getX());
        Case caseDestination = p.getMatrice().get(j.getY()-1).get(j.getX());

        boolean iscaseOrigineSalle = caseOrigine instanceof Salle;
        boolean isCaseDestinationSalle = caseDestination instanceof Salle;

        // ORIGINE : UNE SALLE
        if (iscaseOrigineSalle){
            ArrayList<Case> portesSalle = ((Salle) caseOrigine).getPortes();
            ArrayList<Salle> sallesAdjacentesSalle = ((Salle) caseOrigine).getSallesAdjacentes();
            Salle salleOrigine = (Salle) p.getMatrice().get(j.getY()).get(j.getX());

            // DESTINATION : UNE COULOIR
            if (caseDestination instanceof Couloir){
                System.out.println("Vers un couloir");
                if ((salleOrigine.getPortes().get(0).getX() == caseDestination.getX() && salleOrigine.getPortes().get(0).getY() == caseDestination.getY())){
                    p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                    j.setX((salleOrigine.getPortes().get(0).getX()));
                    j.setY((salleOrigine.getPortes().get(0).getY()));
                    p.getMatrice().get(salleOrigine.getPortes().get(0).getY()).get(salleOrigine.getPortes().get(0).getX()).ajouterJoueur(j);
                }
            }
            // DESTINATION : UNE SALLE ADJACENTES
            else if (salleOrigine.getSallesAdjacentes().get(0) != null){
                p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                j.setX(salleOrigine.getSallesAdjacentes().get(0).getX());
                j.setY(salleOrigine.getSallesAdjacentes().get(0).getY());
                p.getMatrice().get(salleOrigine.getSallesAdjacentes().get(0).getY()).get(salleOrigine.getSallesAdjacentes().get(0).getX()).ajouterJoueur(j);
            }
            // DESTINATION : NULL
            else if (caseDestination == null){ // DESTINATION : null
                System.out.println("La destination est bien une null");
            }
        }
        // ORIGINE : UN COULOIR
        else{
            // DESTINATION : UNE SALLE
            if (caseDestination instanceof Salle){
                Salle salleDestination =  (Salle) caseDestination;
                System.out.println("Destination Salle");
                if ((salleDestination.getPortes().get(0).getX() == caseOrigine.getX() && salleDestination.getPortes().get(0).getY() == caseOrigine.getY())||(salleDestination.getPortes().get(1).getX() == caseOrigine.getX() && salleDestination.getPortes().get(1).getY() == caseOrigine.getY())){
                    System.out.println("La destination est bien une porte vers une salle");
                    p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                    j.setY(j.getY()-1);
                    p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);
                }else{
                    System.out.println("La destination n'est pas une porte vers une salle");
                }
            }
            // DESTINATION : UN COULOIR
            else if (caseDestination instanceof Couloir){
                System.out.println("La destination est un autre couloir");
                p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                j.setY(j.getY()-1);
                p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);
            }
            // DESTINATION : NULL
            else if (caseDestination == null){ // DESTINATION : null
                System.out.println("La destination est bien une null");
            }
        }

    }
    public void descendreJoueur(Joueur j){

        Case caseOrigine = p.getMatrice().get(j.getY()).get(j.getX());
        Case caseDestination = p.getMatrice().get(j.getY()+1).get(j.getX());

        boolean iscaseOrigineSalle = caseOrigine instanceof Salle;
        boolean isCaseDestinationSalle = caseDestination instanceof Salle;

        // ORIGINE : UNE SALLE
        if (iscaseOrigineSalle){
            ArrayList<Case> portesSalle = ((Salle) caseOrigine).getPortes();
            ArrayList<Salle> sallesAdjacentesSalle = ((Salle) caseOrigine).getSallesAdjacentes();
            Salle salleOrigine = (Salle) p.getMatrice().get(j.getY()).get(j.getX());

            // DESTINATION : UNE COULOIR
            if ((salleOrigine.getPortes().get(0).getX() == caseDestination.getX() && salleOrigine.getPortes().get(0).getY() == caseDestination.getY())){
                p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                j.setX((salleOrigine.getPortes().get(0).getX()));
                j.setY((salleOrigine.getPortes().get(0).getY()));
                p.getMatrice().get(salleOrigine.getPortes().get(0).getY()).get(salleOrigine.getPortes().get(0).getX()).ajouterJoueur(j);
            }
            // DESTINATION : UNE SALLE ADJACENTES
            else if (salleOrigine.getSallesAdjacentes().get(2) != null){
                p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                j.setX(salleOrigine.getSallesAdjacentes().get(2).getX());
                j.setY(salleOrigine.getSallesAdjacentes().get(2).getY());
                p.getMatrice().get(j.getY()).get(j.getY()).ajouterJoueur(j);
            }
            // DESTINATION : NULL
            else if (caseDestination == null){ // DESTINATION : null
                System.out.println("La destination est bien une null");
            }
        }
        // ORIGINE : UN COULOIR
        else{
            // DESTINATION : UNE SALLE
            if (caseDestination instanceof Salle){
                Salle salleDestination =  (Salle) caseDestination;
                System.out.println("Destination Salle");
                if ((salleDestination.getPortes().get(0).getX() == caseOrigine.getX() && salleDestination.getPortes().get(0).getY() == caseOrigine.getY())){
                    System.out.println("La destination est bien une porte vers une salle");
                    p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                    j.setY(j.getY()+1);
                    p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);
                }else{
                    System.out.println("La destination n'est pas une porte vers une salle");
                }
            }
            // DESTINATION : UN COULOIR
            else if (caseDestination instanceof Couloir){
                System.out.println("La destination est un autre couloir");
                p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                j.setY(j.getY()+1);
                p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);
            }
            // DESTINATION : NULL
            else if (caseDestination == null){ // DESTINATION : null
                System.out.println("La destination est bien une null");
            }
        }


    }

    public void droiteJoueur(Joueur j){
        Case caseOrigine = p.getMatrice().get(j.getY()).get(j.getX());
        Case caseDestination = p.getMatrice().get(j.getY()).get(j.getX()+1);

        boolean iscaseOrigineSalle = caseOrigine instanceof Salle;
        boolean isCaseDestinationSalle = caseDestination instanceof Salle;

        // ORIGINE : UNE SALLE
        if (iscaseOrigineSalle){
            ArrayList<Case> portesSalle = ((Salle) caseOrigine).getPortes();
            ArrayList<Salle> sallesAdjacentesSalle = ((Salle) caseOrigine).getSallesAdjacentes();

            Salle salleOrigine = (Salle) p.getMatrice().get(j.getY()).get(j.getX());
            System.out.println("De Salle");
            // DESTINATION : UNE COULOIR
            if (caseDestination instanceof Couloir){
                if ((caseDestination.getX() == salleOrigine.getPortes().get(0).getX() && caseDestination.getY() == salleOrigine.getPortes().get(0).getY())) {
                    p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                    j.setX((salleOrigine.getPortes().get(0).getX()));
                    j.setY((salleOrigine.getPortes().get(0).getY()));
                    p.getMatrice().get(salleOrigine.getPortes().get(0).getY()).get(salleOrigine.getPortes().get(0).getX()).ajouterJoueur(j);
                }


            }
            // DESTINATION : UNE SALLE ADJACENTES

            else if (salleOrigine.getSallesAdjacentes().get(1) != null){
                p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                j.setX(salleOrigine.getSallesAdjacentes().get(1).getX());
                j.setY(salleOrigine.getSallesAdjacentes().get(1).getY());
                p.getMatrice().get(j.getY()).get(j.getY()).ajouterJoueur(j);
            }
            // DESTINATION : NULL
            else if (caseDestination == null){ // DESTINATION : null
                System.out.println("La destination est bien une null");
            }
        }
        // ORIGINE : UN COULOIR
        else{
            System.out.println(caseDestination.getClass());
            // DESTINATION : UNE SALLE
            if (caseDestination instanceof Salle){
                Salle salleDestination =  (Salle) caseDestination;
                System.out.println("Destination Salle");
                if ((salleDestination.getPortes().get(0).getX() == caseOrigine.getX() && salleDestination.getPortes().get(0).getY() == caseOrigine.getY())||(salleDestination.getPortes().get(1).getX() == caseOrigine.getX() && salleDestination.getPortes().get(1).getY() == caseOrigine.getY())){
                    System.out.println("La destination est bien une porte vers une salle");
                    p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                    j.setX(j.getX()+1);
                    p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);
                }else{
                    System.out.println("La destination n'est pas une porte vers une salle");
                }
            }
            // DESTINATION : UN COULOIR
            else if (caseDestination instanceof Couloir){
                System.out.println("La destination est un autre couloir");
                p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                j.setX(j.getX()+1);
                p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);
            }
            // DESTINATION : NULL
            else if (caseDestination == null){ // DESTINATION : null
                System.out.println("La destination est bien une null");
            }
        }

    }
    public void gaucheJoueur(Joueur j){

        Case caseOrigine = p.getMatrice().get(j.getY()).get(j.getX());
        Case caseDestination = p.getMatrice().get(j.getY()).get(j.getX()-1);
        boolean iscaseOrigineSalle = caseOrigine instanceof Salle;
        boolean isCaseDestinationSalle = caseDestination instanceof Salle;

        // ORIGINE : UNE SALLE
        if (iscaseOrigineSalle){
            ArrayList<Case> portesSalle = ((Salle) caseOrigine).getPortes();
            ArrayList<Salle> sallesAdjacentesSalle = ((Salle) caseOrigine).getSallesAdjacentes();

            Salle salleOrigine = (Salle) p.getMatrice().get(j.getY()).get(j.getX());

            // DESTINATION : UNE COULOIR
            if ((salleOrigine.getPortes().get(0).getX() == caseDestination.getX() && salleOrigine.getPortes().get(0).getY() == caseDestination.getY())){
                p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                j.setX((salleOrigine.getPortes().get(0).getX()));
                j.setY((salleOrigine.getPortes().get(0).getY()));
                p.getMatrice().get(salleOrigine.getPortes().get(0).getY()).get(salleOrigine.getPortes().get(0).getX()).ajouterJoueur(j);
            }
            // DESTINATION : UNE SALLE ADJACENTES
            else if (salleOrigine.getSallesAdjacentes().get(3) != null){
                p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                j.setX(salleOrigine.getSallesAdjacentes().get(3).getX());
                j.setY(salleOrigine.getSallesAdjacentes().get(3).getY());
                p.getMatrice().get(j.getY()).get(j.getY()).ajouterJoueur(j);
            }
            // DESTINATION : NULL
            else if (caseDestination == null){ // DESTINATION : null
                System.out.println("La destination est bien une null");
            }
        }
        // ORIGINE : UN COULOIR
        else{
            System.out.println(caseDestination.getClass());
            // DESTINATION : UNE SALLE
            if (caseDestination instanceof Salle){
                Salle salleDestination =  (Salle) caseDestination;
                System.out.println("Destination Salle");
                if ((salleDestination.getPortes().get(0).getX() == caseOrigine.getX() && salleDestination.getPortes().get(0).getY() == caseOrigine.getY())||(salleDestination.getPortes().get(1).getX() == caseOrigine.getX() && salleDestination.getPortes().get(1).getY() == caseOrigine.getY())){
                    System.out.println("La destination est bien une porte vers une salle");
                    p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                    j.setX(j.getX()-1);
                    p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);
                }else{
                    System.out.println("La destination n'est pas une porte vers une salle");
                }
            }
            // DESTINATION : UN COULOIR
            else if (caseDestination instanceof Couloir){
                System.out.println("La destination est un autre couloir");
                p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                j.setX(j.getX()-1);
                p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);
            }
            // DESTINATION : NULL
            else if (caseDestination == null){ // DESTINATION : null
                System.out.println("La destination est bien une null");
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
        if (j.isTresor() == true && j.getX() == 6 && j.getY() == 10){ // pas sur des coordoné inverse
            p.setNbTresor(p.getNbTresor()+1);
            j.setTresor(false);
        }
    }

    public void tirerCarte(){
        String messageRetour = p.tirerCarte();
        vue.tirageDeCarte(messageRetour);
    }


    public void afficher(){
        vue.affichage(p.getMatrice(),p.listeJoueurs());
    }
}

