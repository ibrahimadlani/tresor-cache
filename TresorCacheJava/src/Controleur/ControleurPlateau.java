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

    public boolean monterJoueur(Joueur j){

        Case caseOrigine = p.getMatrice().get(j.getY()).get(j.getX());
        Case caseDestination = p.getMatrice().get(j.getY()).get(j.getX());

        boolean iscaseOrigineSalle = caseOrigine instanceof Salle;
        boolean isCaseDestinationSalle = caseDestination instanceof Salle;

            try {
                caseDestination = p.getMatrice().get(j.getY() - 1).get(j.getX());
                if (!(caseDestination instanceof Salle) && !(caseDestination instanceof Couloir) && !iscaseOrigineSalle) {
                    vue.erreurDeplacement();
                    return false;
                }
            } catch (Exception e) {
                vue.erreurDeplacement();
                return false;
            }

        // ORIGINE : UNE SALLE
        if (iscaseOrigineSalle){
            ArrayList<Case> portesSalle = ((Salle) caseOrigine).getPortes();
            ArrayList<Salle> sallesAdjacentesSalle = ((Salle) caseOrigine).getSallesAdjacentes();
            Salle salleOrigine = (Salle) p.getMatrice().get(j.getY()).get(j.getX());

            // DESTINATION : UNE COULOIR
            if (caseDestination instanceof Couloir){
                System.out.println("yes il va dans couloir");
                if ((salleOrigine.getPortes().get(0).getX() == caseDestination.getX() && salleOrigine.getPortes().get(0).getY() == caseDestination.getY())){
                    p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                    j.setX((salleOrigine.getPortes().get(0).getX()));
                    j.setY((salleOrigine.getPortes().get(0).getY()));
                    p.getMatrice().get(salleOrigine.getPortes().get(0).getY()).get(salleOrigine.getPortes().get(0).getX()).ajouterJoueur(j);
                }
            }
            // DESTINATION : UNE SALLE ADJACENTES
            else if (salleOrigine.getSallesAdjacentes().get(0) != null){
                System.out.println(salleOrigine.getSallesAdjacentes().get(0).getX()+";"+salleOrigine.getSallesAdjacentes().get(0).getY());
                p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                j.setX(salleOrigine.getSallesAdjacentes().get(0).getX());
                j.setY(salleOrigine.getSallesAdjacentes().get(0).getY());
                p.getMatrice().get(salleOrigine.getSallesAdjacentes().get(0).getY()).get(salleOrigine.getSallesAdjacentes().get(0).getX()).ajouterJoueur(j);
            }
            // DESTINATION : NULL
            else if (caseDestination == null){ // DESTINATION : null
            }
            // DESTINATION : COMBAT FANTOME ROUGE
            else if (j.isTresor() && ((Salle) caseOrigine).isFantomeRouge()){
                vue.messageCombatAvantDeplacement();
            }
        }
        // ORIGINE : UN COULOIR
        else{
            // DESTINATION : UNE SALLE
            if (caseDestination instanceof Salle){
                Salle salleDestination =  (Salle) caseDestination;
                if ((salleDestination.getPortes().get(0).getX() == caseOrigine.getX() && salleDestination.getPortes().get(0).getY() == caseOrigine.getY())||(salleDestination.getPortes().get(1).getX() == caseOrigine.getX() && salleDestination.getPortes().get(1).getY() == caseOrigine.getY())){
                    p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                    j.setY(j.getY()-1);
                    p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);
                }else{
                }
            }
            // DESTINATION : UN COULOIR
            else if (caseDestination instanceof Couloir){
                p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                j.setY(j.getY()-1);
                p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);
            }
            // DESTINATION : NULL
            else if (caseDestination == null){ // DESTINATION : null
            }
            // DESTINATION : OUT OF INDEX
            else if (caseOrigine.getY()-1 < 0){
            }
        }
        return true;

    }
    public boolean descendreJoueur(Joueur j){

        Case caseOrigine = p.getMatrice().get(j.getY()).get(j.getX());
        Case caseDestination = p.getMatrice().get(j.getY()).get(j.getX());

        boolean iscaseOrigineSalle = caseOrigine instanceof Salle;
        boolean isCaseDestinationSalle = caseDestination instanceof Salle;

            try {
                caseDestination = p.getMatrice().get(j.getY() + 1).get(j.getX());
                if (!(caseDestination instanceof Salle) && !(caseDestination instanceof Couloir) && !iscaseOrigineSalle) {
                    vue.erreurDeplacement();
                    return false;
                }
            } catch (Exception e) {
                vue.erreurDeplacement();
                return false;
            }

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
                System.out.println(salleOrigine.getSallesAdjacentes().get(2).getX()+";"+salleOrigine.getSallesAdjacentes().get(2).getY());
                p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                j.setX(salleOrigine.getSallesAdjacentes().get(2).getX());
                j.setY(salleOrigine.getSallesAdjacentes().get(2).getY());
                p.getMatrice().get(salleOrigine.getSallesAdjacentes().get(2).getY()).get(salleOrigine.getSallesAdjacentes().get(2).getX()).ajouterJoueur(j);
            }
            // DESTINATION : NULL
            else if (caseDestination == null){ // DESTINATION : null
            }
            // DESTINATION : COMBAT FANTOME ROUGE
            else if (j.isTresor() && ((Salle) caseOrigine).isFantomeRouge()){
                vue.messageCombatAvantDeplacement();
            }
        }
        // ORIGINE : UN COULOIR
        else{
            // DESTINATION : UNE SALLE
            if (caseDestination instanceof Salle){
                Salle salleDestination =  (Salle) caseDestination;
                if ((salleDestination.getPortes().get(0).getX() == caseOrigine.getX() && salleDestination.getPortes().get(0).getY() == caseOrigine.getY())){
                    p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                    j.setY(j.getY()+1);
                    p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);
                }else{
                }
            }
            // DESTINATION : UN COULOIR
            else if (caseDestination instanceof Couloir){
                p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                j.setY(j.getY()+1);
                p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);
            }
            // DESTINATION : NULL
            else if (caseDestination == null){ // DESTINATION : null
            }
        }

    return true;
    }
    public boolean droiteJoueur(Joueur j){
        Case caseOrigine = p.getMatrice().get(j.getY()).get(j.getX());
        Case caseDestination = p.getMatrice().get(j.getY()).get(j.getX());

        boolean iscaseOrigineSalle = caseOrigine instanceof Salle;
        boolean isCaseDestinationSalle = caseDestination instanceof Salle;

            try {
                caseDestination = p.getMatrice().get(j.getY()).get(j.getX() + 1);
                if (!(caseDestination instanceof Salle) && !(caseDestination instanceof Couloir) && !iscaseOrigineSalle) {
                    vue.erreurDeplacement();
                    return false;
                }
            } catch (Exception e) {
                vue.erreurDeplacement();
                return false;
            }

        // ORIGINE : UNE SALLE
        if (iscaseOrigineSalle){
            ArrayList<Case> portesSalle = ((Salle) caseOrigine).getPortes();
            ArrayList<Salle> sallesAdjacentesSalle = ((Salle) caseOrigine).getSallesAdjacentes();

            Salle salleOrigine = (Salle) p.getMatrice().get(j.getY()).get(j.getX());
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
                System.out.println(salleOrigine.getSallesAdjacentes().get(1).getX()+";"+salleOrigine.getSallesAdjacentes().get(1).getY());
                p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                j.setX(salleOrigine.getSallesAdjacentes().get(1).getX());
                j.setY(salleOrigine.getSallesAdjacentes().get(1).getY());
                p.getMatrice().get(salleOrigine.getSallesAdjacentes().get(1).getY()).get(salleOrigine.getSallesAdjacentes().get(1).getX()).ajouterJoueur(j);
            }
            // DESTINATION : NULL
            else if (caseDestination == null){ // DESTINATION : null
            }
            // DESTINATION : COMBAT FANTOME ROUGE
            else if (j.isTresor() && ((Salle) caseOrigine).isFantomeRouge()){
                vue.messageCombatAvantDeplacement();
            }
        }
        // ORIGINE : UN COULOIR
        else{
            System.out.println(caseDestination.getClass());
            // DESTINATION : UNE SALLE
            if (caseDestination instanceof Salle){
                Salle salleDestination =  (Salle) caseDestination;
                if ((salleDestination.getPortes().get(0).getX() == caseOrigine.getX() && salleDestination.getPortes().get(0).getY() == caseOrigine.getY())||(salleDestination.getPortes().get(1).getX() == caseOrigine.getX() && salleDestination.getPortes().get(1).getY() == caseOrigine.getY())){
                    p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                    j.setX(j.getX()+1);
                    p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);
                }else{
                }
            }
            // DESTINATION : UN COULOIR
            else if (caseDestination instanceof Couloir){
                p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                j.setX(j.getX()+1);
                p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);
            }
            // DESTINATION : NULL
            else if (caseDestination == null){ // DESTINATION : null
            }
            // DESTINATION : OUT OF INDEX
            else if (caseOrigine.getX()+1 > p.getMatrice().size()){
            }
        }
        return true;
    }
    public boolean gaucheJoueur(Joueur j){

        Case caseOrigine = p.getMatrice().get(j.getY()).get(j.getX());
        Case caseDestination = p.getMatrice().get(j.getY()).get(j.getX());
        boolean iscaseOrigineSalle = caseOrigine instanceof Salle;
        boolean isCaseDestinationSalle = caseDestination instanceof Salle;

            try {
                caseDestination = p.getMatrice().get(j.getY()).get(j.getX() - 1);
                if (!(caseDestination instanceof Salle) && !(caseDestination instanceof Couloir) && !iscaseOrigineSalle) {
                    vue.erreurDeplacement();
                    return false;
                }
            } catch (Exception e) {
                vue.erreurDeplacement();
                return false;
            }


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
                System.out.println(salleOrigine.getSallesAdjacentes().get(3).getX()+";"+salleOrigine.getSallesAdjacentes().get(3).getY());
                p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                j.setX(salleOrigine.getSallesAdjacentes().get(3).getX());
                j.setY(salleOrigine.getSallesAdjacentes().get(3).getY());
                p.getMatrice().get(salleOrigine.getSallesAdjacentes().get(3).getY()).get(salleOrigine.getSallesAdjacentes().get(3).getX()).ajouterJoueur(j);
            }
            // DESTINATION : NULL
            else if (caseDestination == null){ // DESTINATION : null
            }
            // DESTINATION : COMBAT FANTOME ROUGE
            else if (j.isTresor() && ((Salle) caseOrigine).isFantomeRouge()){
                vue.messageCombatAvantDeplacement();
            }
        }
        // ORIGINE : UN COULOIR
        else{
            System.out.println(caseDestination.getClass());
            // DESTINATION : UNE SALLE
            if (caseDestination instanceof Salle){
                Salle salleDestination =  (Salle) caseDestination;
                if ((salleDestination.getPortes().get(0).getX() == caseOrigine.getX() && salleDestination.getPortes().get(0).getY() == caseOrigine.getY())||(salleDestination.getPortes().get(1).getX() == caseOrigine.getX() && salleDestination.getPortes().get(1).getY() == caseOrigine.getY())){
                    p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                    j.setX(j.getX()-1);
                    p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);
                }else{
                }
            }
            // DESTINATION : UN COULOIR
            else if (caseDestination instanceof Couloir){
                p.getMatrice().get(j.getY()).get(j.getX()).suppprimerJoueur(j);
                j.setX(j.getX()-1);
                p.getMatrice().get(j.getY()).get(j.getX()).ajouterJoueur(j);
            }
            // DESTINATION : NULL
            else if (caseDestination == null){ // DESTINATION : null
            }
            // DESTINATION : OUT OF INDEX
            else if (caseOrigine.getX()-1 < 0){
            }
        }
        return true;
    }

    public void prendreTresor(Joueur j){
        if (p.getMatrice().get(j.getY()).get(j.getX()) instanceof Salle){
            if (((Salle) p.getMatrice().get(j.getY()).get(j.getX())).isTresor()){
                if (j.isTresor() == false){
                    Salle emplacement = (Salle) p.getMatrice().get(j.getY()).get(j.getX());
                    emplacement.setTresor(false);
                    j.setTresor(true);
                    if (((Salle) p.getMatrice().get(j.getY()).get(j.getX())).isFantomeRouge()){

                        if ((p.getMatrice().get(j.getY()).get(j.getX())).getJoueurs().size() >= 2){
                            vue.erreurTresor("Combat fantome rouge");
                            this.combatRouge(j,j,((Salle) p.getMatrice().get(j.getY()).get(j.getX())));
                        }else {
                            vue.erreurTresor("HELP ! Vous ne pouvez pas combatre le fantome seule");
                        }
                    }
                }else {
                    vue.erreurTresor("Vous avez deja un tresor sur vous");
                }
            }else {
                vue.erreurTresor("La salle n'a pas de tresor");
            }
        }else{
            vue.erreurTresor("Vous n'etes pas dans une salle");
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

    public void combatVert(Joueur j, Salle s){
        Scanner sc = new Scanner(System.in);
        String enter = sc.nextLine();
        while (enter == null) {
            System.out.println("\n["+j.getNom()+"] : Appuyer sur ENTRER pour combatre le fantome vert");
            enter = sc.nextLine();
        }
        if (!s.isFantomeRouge() && s.getListeFantomes().size() > 0){
            if (p.getDeCombat1().roll() == 1){
                //SupprimerFantomeVert
            }else {
                System.out.println("Defaite Combat");
            }
        }
    }

    public void combatRouge(Joueur j1,Joueur j2, Salle s) {
        Scanner sc = new Scanner(System.in);
        String enter = sc.nextLine();
        while (enter == null) {
            System.out.println("\n[" + j1.getNom() + "] : Appuyer sur ENTRER pour combatre le fantome vert");
            enter = sc.nextLine();
        }
        if (s.isFantomeRouge() && s.getListeFantomes().size() > 0) {
            if (p.getDeCombat1().roll() == 2) {
                //SupprimerFantomeRouge
            } else {
                Scanner sc2 = new Scanner(System.in);
                String enter2 = sc.nextLine();
                while (enter2 == null) {
                    System.out.println("\n[" + j2.getNom() + "] : Appuyer sur ENTRER pour combatre le fantome vert");
                    enter = sc.nextLine();
                }
                if (s.isFantomeRouge() && s.getListeFantomes().size() > 0) {
                    if (p.getDeCombat1().roll() == 2) {
                        //SupprimerFantomeRouge
                    } else {
                        System.out.println("Defaite Combat");
                    }
                }
            }
        }
    }

    /*public void combat(Joueur j1){
        Salle s = ((Salle) p.getMatrice().get(j1.getY()).get(j1.getX()));
        if (s.isFantomeRouge()){
            if (.isFantomeRouge()){

            }
        }
    }*/

    public void erreurEntree(){
        vue.erreurEntree();
    }

    public void afficher(){
        vue.affichage(p.getMatrice(),p.listeJoueurs(),p.getNbTresor());
    }
}
