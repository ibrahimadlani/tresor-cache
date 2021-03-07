package Controleur;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ControleurPlateau cp = new ControleurPlateau();

        Scanner sc = new Scanner(System.in);
        while (cp.getP().getNbTresor() < 6 || cp.getP().getNbFantomeRouge() < 6) {

            System.out.println("-------------------------------------------------------------------------");
            for (int j = 0; j < cp.getP().listeJoueurs().size() ; j++) {
                System.out.println("/!\\ Tour :"+cp.getP().listeJoueurs().get(j).getNom()+"/!\\ ");
                System.out.println("\n["+cp.getP().listeJoueurs().get(j).getNom()+"] : Appuyer sur ENTRER pour lancer le dé");

                String enter = sc.nextLine();

                while (enter == null) {
                    System.out.println("\n["+cp.getP().listeJoueurs().get(j).getNom()+"] : Appuyer sur ENTRER pour lancer le dé");
                    enter = sc.nextLine();
                }

                Random r = new Random();
                int x = r.nextInt(6)+1;

                System.out.println("\uD83C\uDFB2 : rolling...\n\uD83C\uDFB2 : "+x);

                if(x < 6){cp.tirerCarte();}

                Scanner sc2 = new Scanner(System.in);
                int k = 0;
                while(k<x){
                    System.out.println("\n[ "+cp.getP().listeJoueurs().get(j).getNom()+" ] : Quel mouvemement voulez-vous faire ? ("+(x-k)+" restant(s)...)");
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