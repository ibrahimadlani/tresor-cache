package Controleur;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ControleurPlateau cp = new ControleurPlateau();

        cp.initNbJoueur(); //initialisation du nombre de joueurs
        cp.initJoueurs(); //initialisation des noms et de la positions des joueurs

        Scanner sc = new Scanner(System.in);
        while (cp.getP().getNbTresor() < 6 || cp.getP().getNbFantomeRouge() < 6) {
            cp.affichagePauseThematique();
            for (int j = 0; j < cp.getP().listeJoueurs().size() ; j++) {
                cp.affichageTourJoueur(j);
                cp.affichageNom(j);

                String enter = sc.nextLine();

                while (enter == null) {
                    cp.affichageNom(j);
                    enter = sc.nextLine();
                }

                int x = cp.rolling();

                Scanner sc2 = new Scanner(System.in);
                int k = 0;
                while(k<x){
                    cp.affichageMouvementRestant(j, x-k);

                    int mouv = sc2.nextInt();

                    boolean mouvementEffectue;
                    if (mouv == 8){
                        if(cp.monterJoueur(cp.getP().listeJoueurs().get(j))){
                            k++;
                        }
                        cp.afficher();
                    }else if (mouv == 2){
                        if(cp.descendreJoueur(cp.getP().listeJoueurs().get(j))){
                            k++;
                        }
                        cp.afficher();
                    }else if(mouv == 4){
                        if(cp.gaucheJoueur(cp.getP().listeJoueurs().get(j))) {
                            k++;
                        }
                        cp.afficher();
                    }else if(mouv == 6){
                        if(cp.droiteJoueur(cp.getP().listeJoueurs().get(j))){
                            k++;
                        }
                        cp.afficher();
                    }else if(mouv == 1){
                        cp.prendreTresor(cp.getP().listeJoueurs().get(j));
                        cp.afficher();
                        break;
                    }
                    else if(mouv == 3){
                        cp.depotTresor(cp.getP().listeJoueurs().get(j));
                        cp.afficher();
                        k++;
                    }
                    else if(mouv == 5){
                        cp.afficher();
                        break;
                    }
                    else if(mouv == 0){
                        //cp.combat(cp.getP().listeJoueurs().get(j));
                        break;
                    }else{
                        cp.erreurEntree();
                    }
                }
            }
        }
    }
}
/*
GUIDES DES TOUCHES :
8 -> Haut
4 ->Gauche
6->Droite
2->Bas
-------------
1->Prendre
3->Deposer
------------
0->Combatre
5->Skip le tour
 */