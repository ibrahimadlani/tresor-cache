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
                System.out.println("\uD83C\uDFB2 : rolling...");
                System.out.println("\uD83C\uDFB2 : "+x);
                Scanner sc2 = new Scanner(System.in);
                int k = 0;
                while(k<x){
                    System.out.println("\n["+cp.getP().listeJoueurs().get(j).getNom()+"] : Quel mouvemement voulez-vous faire ? ("+(x-k)+" restant(s)...)");
                    int mouv = sc2.nextInt();
                    if (mouv == 8){
                        try {
                            cp.monterJoueur(cp.getP().listeJoueurs().get(j));
                            k++;
                        }catch(Exception e){
                            System.out.println("Erreur");
                        }
                        cp.afficher();
                    }else if (mouv == 2){
                        try {
                            cp.descendreJoueur(cp.getP().listeJoueurs().get(j));
                            k++;
                        }catch (Exception e){
                            System.out.println("Erreur");
                        }
                        cp.afficher();
                    }else if(mouv == 4){
                        try {
                            cp.gaucheJoueur(cp.getP().listeJoueurs().get(j));
                            k++;
                        }catch(Exception e){
                            System.out.println("Erreur");
                        }
                        cp.afficher();
                    }else if(mouv == 6){
                        try {
                            cp.droiteJoueur(cp.getP().listeJoueurs().get(j));
                            k++;
                        }catch(Exception e){
                            System.out.println("Erreur");
                        }
                        cp.afficher();
                    }else if(mouv == 0){
                        cp.afficher();
                        break;
                    }
                }

            }
        }
    }
}
