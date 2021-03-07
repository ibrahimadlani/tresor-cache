package Vue;

import Modele.Case;
import Modele.Salle;
import Modele.Couloir;
import Modele.Joueur;

import java.util.ArrayList;

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
}
