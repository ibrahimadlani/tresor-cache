package Modele;

import java.util.ArrayList;
import java.util.Scanner;

public class Plateau {

    private ArrayList<ArrayList<Case>> matrice = new ArrayList<>();
    private ArrayList<Joueur> listeJoueurs;
    private ArrayList<Salle> listeSalle;
    private int nbJoueurs;
    private int nbTresor;
    private int nbFantomeRouge;

    public Plateau() {
        Scanner sc1 = new Scanner(System.in);
        for(int i = 0; i < 11; i++) {
            ArrayList<Case> ligne = new ArrayList();
            for (int j = 0; j < 10; j++) {
                ligne.add(new Case(j,i));
            }
            matrice.add(ligne);
        }

        ArrayList<Case> portesA = new ArrayList<Case>();
        ArrayList<Case> portesB = new ArrayList<Case>();
        ArrayList<Case> portesC = new ArrayList<Case>();
        ArrayList<Case> portesD = new ArrayList<Case>();
        ArrayList<Case> portesE = new ArrayList<Case>();
        ArrayList<Case> portesF = new ArrayList<Case>();
        ArrayList<Case> portesG = new ArrayList<Case>();
        ArrayList<Case> portesH = new ArrayList<Case>();
        ArrayList<Case> portesI = new ArrayList<Case>();
        ArrayList<Case> portesJ = new ArrayList<Case>();
        ArrayList<Case> portesK = new ArrayList<Case>();
        ArrayList<Case> portesL = new ArrayList<Case>();

        portesA.add(matrice.get(1).get(1));
        portesB.add(matrice.get(1).get(4));
        portesC.add(matrice.get(2).get(7));
        portesD.add(matrice.get(2).get(8));
        portesE.add(matrice.get(1).get(1));
        portesF.add(matrice.get(4).get(6));
        portesF.add(matrice.get(2).get(4));

        portesG.add(matrice.get(3).get(6));
        portesH.add(matrice.get(7).get(1));
        portesI.add(matrice.get(7).get(4));
        portesJ.add(matrice.get(8).get(6));
        portesK.add(matrice.get(7).get(0));
        portesL.add(matrice.get(8).get(6));

        matrice.get(0).set(1, new Salle(1,0,"A", portesA));
        matrice.get(0).set(4, new Salle(4,0,"B", portesB));
        matrice.get(1).set(0, new Couloir(0,1));
        matrice.get(1).set(1, new Couloir(1,1));
        matrice.get(1).set(2, new Couloir(2,1));
        matrice.get(1).set(3, new Couloir(3,1));
        matrice.get(1).set(4, new Couloir(4,1));
        matrice.get(1).set(7, new Salle(7,1,"C", portesC));
        matrice.get(2).set(1, new Salle(1,2,"E", portesE));
        matrice.get(2).set(4, new Couloir(4,2));
        matrice.get(2).set(5, new Couloir(5,2));
        matrice.get(2).set(6, new Couloir(6,2));
        matrice.get(2).set(7, new Couloir(7,2));
        matrice.get(2).set(8, new Couloir(8,2));
        matrice.get(2).set(9, new Salle(9,2,"D", portesD));
        matrice.get(3).set(4, new Salle(4,3,"F", portesF));
        matrice.get(3).set(6, new Couloir(6,3));
        matrice.get(4).set(5, matrice.get(3).get(4));
        matrice.get(3).set(7, new Salle(7,3,"G", portesG));
        matrice.get(4).set(6, new Couloir(6,4));
        matrice.get(5).set(6, new Couloir(6,5));
        matrice.get(6).set(1, new Salle(1,6,"H", portesH));
        matrice.get(6).set(4, new Salle(4,6,"I", portesI));
        matrice.get(6).set(6, new Couloir(6,6));
        matrice.get(7).set(0, new Couloir(0,7));
        matrice.get(7).set(1, new Couloir(1,7));
        matrice.get(7).set(2, new Couloir(2,7));
        matrice.get(7).set(3, new Couloir(3,7));
        matrice.get(7).set(4, new Couloir(4,7));
        matrice.get(7).set(5, new Couloir(5,7));
        matrice.get(7).set(6, new Couloir(6,7));
        matrice.get(8).set(0, new Salle(0,8,"K", portesK));
        matrice.get(8).set(5, new Salle(5,8,"L", portesL));
        matrice.get(8).set(6, new Couloir(6,8));
        matrice.get(8).set(7, new Salle(7,8,"J", portesJ));
        matrice.get(9).set(6, new Couloir(6,9));
        matrice.get(10).set(6, new Couloir(6,10)); // c'est l'entrée

        ArrayList<Salle> listeSalle = new ArrayList<Salle>();
        listeSalle.add((Salle) matrice.get(0).get(1));
        listeSalle.add((Salle) matrice.get(0).get(4));
        listeSalle.add((Salle) matrice.get(1).get(7));
        listeSalle.add((Salle) matrice.get(2).get(9));
        listeSalle.add((Salle) matrice.get(2).get(1));
        listeSalle.add((Salle) matrice.get(3).get(4));
        listeSalle.add((Salle) matrice.get(3).get(7));
        listeSalle.add((Salle) matrice.get(6).get(1));
        listeSalle.add((Salle) matrice.get(6).get(4));
        listeSalle.add((Salle) matrice.get(8).get(7));
        listeSalle.add((Salle) matrice.get(8).get(0));
        listeSalle.add((Salle) matrice.get(8).get(5));


        ArrayList<Salle> x = new ArrayList<Salle>();
        x.clear();
        x.add(null);
        x.add(listeSalle.get(1));
        x.add(null);
        x.add(null);
        listeSalle.get(0).setSallesAdjacentes(x);
        x.clear();
        x.add(null);
        x.add(listeSalle.get(0));
        x.add(null);
        x.add(listeSalle.get(0));
        listeSalle.get(1).setSallesAdjacentes(x);
        x.clear();
        x.add(null);
        x.add(listeSalle.get(0));
        x.add(null);
        x.add(listeSalle.get(0));
        listeSalle.get(2).setSallesAdjacentes(x);
        x.clear();
        x.add(null);
        x.add(listeSalle.get(0));
        x.add(listeSalle.get(0));
        x.add(null);
        listeSalle.get(3).setSallesAdjacentes(x);
        x.clear();
        x.add(null);
        x.add(null);
        x.add(listeSalle.get(0));
        x.add(listeSalle.get(0));
        listeSalle.get(4).setSallesAdjacentes(x);
        x.clear();
        x.add(null);
        x.add(null);
        x.add(null);
        x.add(listeSalle.get(0));
        listeSalle.get(5).setSallesAdjacentes(x);
        x.clear();
        x.add(null);
        x.add(null);
        x.add(listeSalle.get(0));
        x.add(null);
        listeSalle.get(6).setSallesAdjacentes(x);
        x.clear();
        x.add(listeSalle.get(0));
        x.add(listeSalle.get(0));
        x.add(null);
        x.add(null);
        listeSalle.get(7).setSallesAdjacentes(x);
        x.clear();
        x.add(listeSalle.get(0));
        x.add(null);
        x.add(null);
        x.add(listeSalle.get(0));
        listeSalle.get(8).setSallesAdjacentes(x);
        x.clear();
        x.add(listeSalle.get(0));
        x.add(null);
        x.add(null);
        x.add(null);
        listeSalle.get(9).setSallesAdjacentes(x);
        x.clear();
        x.add(null);
        x.add(listeSalle.get(0));
        x.add(null);
        x.add(null);
        listeSalle.get(10).setSallesAdjacentes(x);
        x.clear();
        x.add(null);
        x.add(null);
        x.add(null);
        x.add(listeSalle.get(0));
        listeSalle.get(11).setSallesAdjacentes(x);
        x.clear();






        this.nbTresor = 0;
        System.out.println("Entrez le nombre de joueurs (2 - 4):");

        this.nbJoueurs = sc1.nextInt();
        while (this.nbJoueurs > 4 || this.nbJoueurs < 2) {
            System.out.println("Entrez le nombre de joueurs (2 - 4):");
            this.nbJoueurs = sc1.nextInt();
        }
        this.listeJoueurs = new ArrayList<Joueur>();
        Scanner sc2 = new Scanner(System.in);
        for (int i = 0; i < this.nbJoueurs; i++) {
            System.out.println("Entrez le nom du joueur #"+i+".");
            String nom = sc2.nextLine();
            Joueur j = new Joueur(nom);
            listeJoueurs.add(j);
            matrice.get(10).get(6).ajouterJoueur(j);
        }

    }

    public ArrayList<ArrayList<Case>> getMatrice() {
        return matrice;
    }

    public ArrayList<Joueur> listeJoueurs() {
        return listeJoueurs;
    }

    public ArrayList<Salle> getListeSalle() {
        return listeSalle;
    }
}
