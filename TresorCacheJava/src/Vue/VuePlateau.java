package Vue;

import Modele.Case;
import Modele.Salle;
import Modele.Couloir;
import Modele.Joueur;

import java.util.ArrayList;
import java.util.Scanner;

public class VuePlateau {

    public void affichage(ArrayList<ArrayList<Case>> plateau,ArrayList<Joueur> listeJoueur,int nbtresor){
        String affiche = "+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+";
        for(int i = 0; i < 11; i++){
            affiche += "\n";
            for(int j = 0; j < 10; j++){
                if ( plateau.get(i).get(j) instanceof Couloir){
                    if (plateau.get(i).get(j).getJoueurs().size() > 0){
                        affiche += "\t"+plateau.get(i).get(j).getJoueurs().size()+"\t|";
                    }else {
                        affiche += "\t"+ plateau.get(i).get(j).getNom() + "\t|";
                    }

                }else if (plateau.get(i).get(j) instanceof Salle){
                    if(!((Salle)plateau.get(i).get(j)).isTresor()){
                        if (((Salle) plateau.get(i).get(j)).isFantomeRouge()) {
                            affiche += "\t"+ plateau.get(i).get(j).getNom().toLowerCase() + "*\t|";
                        }else if (!((Salle) plateau.get(i).get(j)).isFantomeRouge() && ((Salle) plateau.get(i).get(j)).getListeFantomes().size() > 0){
                            affiche += "\t"+ plateau.get(i).get(j).getNom().toLowerCase() + "'\t|";
                        }else{
                            affiche += "\t"+ plateau.get(i).get(j).getNom().toLowerCase() + "\t|";
                        }
                    }else if(((Salle)plateau.get(i).get(j)).isTresor()){
                        if (((Salle) plateau.get(i).get(j)).isFantomeRouge()) {
                            affiche += "\t"+ plateau.get(i).get(j).getNom() + "*\t|";
                        }else if (!((Salle) plateau.get(i).get(j)).isFantomeRouge() && ((Salle) plateau.get(i).get(j)).getListeFantomes().size() > 0){
                            affiche += "\t"+ plateau.get(i).get(j).getNom() + "'\t|";
                        }else{
                            affiche += "\t"+ plateau.get(i).get(j).getNom() + "\t|";
                        }
                    }
                }else {
                    affiche += "\t"+ plateau.get(i).get(j).getNom() + "\t|";
                }
            }
            affiche += "\n+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+";
        }
        affiche += "\n";
        for (int i = 0; i < listeJoueur.size(); i++) {
            affiche += "\nJoueur "+i+" :"+listeJoueur.get(i).getNom()+"\t("+listeJoueur.get(i).getX()+";"+listeJoueur.get(i).getY()+")";
            if (listeJoueur.get(i).isTresor()){
                affiche += "\t[*]";
            }else {
                affiche += "\t[ ]";
            }
        }
        affiche += "\nTrésors restant : "+(6-nbtresor);
        System.out.println(affiche);
    }

    public void tirageDeCarte(String message){
        System.out.println("\n\uD83C\uDCCF : Tirage de carte en cours...");
        System.out.println(message);
    }

    public void erreurEntree(){
        System.out.println("Merci de rentrer une action valide\n");
    }

    public void erreurDeplacement(){
        System.out.println("Merci de faire un déplacement valide\n");
    }

    public void messageCombatAvantDeplacement(){
        System.out.println("Vous devez d'abbord combatre le fantome avant de vous déplacer");
    }

    public void erreurTresor(String s){
        System.out.println(s);
    }

    public int initNbJoueur(){
        System.out.println("Entrez le nombre de joueurs (2 - 4):");
        Scanner sc1 = new Scanner(System.in);
        int nbJoueur = sc1.nextInt();
        while (nbJoueur > 4 || nbJoueur < 2) {
            System.out.println("Entrez le nombre de joueurs (2 - 4):");
            nbJoueur = sc1.nextInt();
        }
        return nbJoueur;
    }

    public ArrayList<Joueur> initJoueurs(int nbJoueurs){
        ArrayList<Joueur> listeJoueurs = new ArrayList<Joueur>();
        Scanner sc2 = new Scanner(System.in);
        for (int i = 0; i < nbJoueurs; i++) {
            System.out.println("Entrez le nom du joueur #"+i+".");
            String nom = sc2.nextLine();
            Joueur j = new Joueur(nom);
            listeJoueurs.add(j);
        }
        return listeJoueurs;
    }

    public void affichageTourJoueur(String j){
        System.out.println("/!\\ Tour :"+j+"/!\\ ");
    }

    public void affichageNom(String j){
        System.out.println("\n["+j+"] : Appuyer sur ENTRER pour lancer le dé");
    }

    public void affichageMouvementRestant(int j, int mouvements){
        System.out.println("\n[ "+j+" ] : Quel mouvemement voulez-vous faire ? ("+mouvements+" restant(s)...)");
    }

    public void rolling(int x){
        System.out.println("\uD83C\uDFB2 : rolling...\n\uD83C\uDFB2 : "+x);
    }

    public void affichagePauseThematique(){
        System.out.println("-------------------------------------------------------------------------");
    }

    public void combartVert(String j){
        System.out.println("\n[ "+j+" ] : Appuyer sur ENTRER pour combatre le fantome vert");
    }

    public void combartRouge(String j){
        System.out.println("\n[ "+j+" ] : Appuyer sur ENTRER pour combatre le fantome rouge");
    }
}
