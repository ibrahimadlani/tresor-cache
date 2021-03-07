package Modele;

import java.util.ArrayList;
import java.util.Scanner;

public class Plateau {

    private ArrayList<ArrayList<Case>> matrice = new ArrayList<>();
    private ArrayList<Joueur> listeJoueurs;
    private ArrayList<Salle> listeSalle = new ArrayList<Salle>();
    private int nbJoueurs;
    private int nbTresor;
    private int nbFantomeRouge;
    private DeCombat deCombat1;
    private DeCombat deCombat2;
    private DeMouvement deMouvement;
    private Paquet paquet1;
    private Paquet paquet2;



    public Plateau() {
        Scanner sc1 = new Scanner(System.in);
        for(int i = 0; i < 11; i++) {
            ArrayList<Case> ligne = new ArrayList();
            for (int j = 0; j < 10; j++) {
                ligne.add(new Case(j,i));
            }
            matrice.add(ligne);
        }

        this.deCombat1 = new DeCombat();
        this.deCombat2 = new DeCombat();
        this.deMouvement = new DeMouvement();



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

        matrice.get(0).set(1, new Salle(1,0,"A", portesA,true));
        matrice.get(0).set(4, new Salle(4,0,"B", portesB,false));
        matrice.get(1).set(0, new Couloir(0,1));
        matrice.get(1).set(1, new Couloir(1,1));
        matrice.get(1).set(2, new Couloir(2,1));
        matrice.get(1).set(3, new Couloir(3,1));
        matrice.get(1).set(4, new Couloir(4,1));
        matrice.get(1).set(7, new Salle(7,1,"C", portesC,true));
        matrice.get(2).set(1, new Salle(1,2,"E", portesE,true));
        matrice.get(2).set(4, new Couloir(4,2));
        matrice.get(2).set(5, new Couloir(5,2));
        matrice.get(2).set(6, new Couloir(6,2));
        matrice.get(2).set(7, new Couloir(7,2));
        matrice.get(2).set(8, new Couloir(8,2));
        matrice.get(2).set(9, new Salle(9,2,"D", portesD,true));
        matrice.get(3).set(4, new Salle(4,3,"F", portesF,false));
        matrice.get(3).set(6, new Couloir(6,3));
        matrice.get(4).set(5, matrice.get(3).get(4));
        matrice.get(3).set(7, new Salle(7,3,"G", portesG,true));
        matrice.get(4).set(6, new Couloir(6,4));
        matrice.get(5).set(6, new Couloir(6,5));
        matrice.get(6).set(1, new Salle(1,6,"H", portesH,false));
        matrice.get(6).set(4, new Salle(4,6,"I", portesI,true));
        matrice.get(6).set(6, new Couloir(6,6));
        matrice.get(7).set(0, new Couloir(0,7));
        matrice.get(7).set(1, new Couloir(1,7));
        matrice.get(7).set(2, new Couloir(2,7));
        matrice.get(7).set(3, new Couloir(3,7));
        matrice.get(7).set(4, new Couloir(4,7));
        matrice.get(7).set(5, new Couloir(5,7));
        matrice.get(7).set(6, new Couloir(6,7));
        matrice.get(8).set(0, new Salle(0,8,"K", portesK,false));
        matrice.get(8).set(5, new Salle(5,8,"L", portesL,true));
        matrice.get(8).set(6, new Couloir(6,8));
        matrice.get(8).set(7, new Salle(7,8,"J", portesJ,true));
        matrice.get(9).set(6, new Couloir(6,9));
        matrice.get(10).set(6, new Couloir(6,10)); // c'est l'entrée

        listeSalle.add((Salle) matrice.get(0).get(1));//A 0
        listeSalle.add((Salle) matrice.get(0).get(4));//B 1
        listeSalle.add((Salle) matrice.get(1).get(7));//C 2
        listeSalle.add((Salle) matrice.get(2).get(9));//D 3
        listeSalle.add((Salle) matrice.get(2).get(1));//E 4
        listeSalle.add((Salle) matrice.get(3).get(4));//F 5
        listeSalle.add((Salle) matrice.get(3).get(7));//G 6
        listeSalle.add((Salle) matrice.get(6).get(1));//H 7
        listeSalle.add((Salle) matrice.get(6).get(4));//I 8
        listeSalle.add((Salle) matrice.get(8).get(7));//J 9
        listeSalle.add((Salle) matrice.get(8).get(0));//K 10
        listeSalle.add((Salle) matrice.get(8).get(5));//L 11


        ArrayList<Salle> a = new ArrayList<Salle>();
        a.add(null);
        a.add(listeSalle.get(1));
        a.add(null);
        a.add(null);
        ((Salle) matrice.get(0).get(1)).setSallesAdjacentes(a);

        ArrayList<Salle> b = new ArrayList<Salle>();
        b.add(null);
        b.add(listeSalle.get(2));
        b.add(null);
        b.add(listeSalle.get(0));
        ((Salle) matrice.get(0).get(4)).setSallesAdjacentes(b);

        ArrayList<Salle> c = new ArrayList<Salle>();
        c.clear();
        c.add(null);
        c.add(listeSalle.get(3));
        c.add(null);
        c.add(listeSalle.get(1));
        ((Salle) matrice.get(1).get(7)).setSallesAdjacentes(c);

        ArrayList<Salle> d = new ArrayList<Salle>();
        d.clear();
        d.add(null);
        d.add(null);
        d.add(null);
        d.add(listeSalle.get(2));
        ((Salle) matrice.get(2).get(9)).setSallesAdjacentes(d);

        ArrayList<Salle> e = new ArrayList<Salle>();
        e.clear();
        e.add(null);
        e.add(listeSalle.get(5));
        e.add(listeSalle.get(7));
        e.add(null);
        ((Salle) matrice.get(2).get(1)).setSallesAdjacentes(e);

        ArrayList<Salle> f = new ArrayList<Salle>();
        f.clear();
        f.add(null);
        f.add(null);
        f.add(listeSalle.get(8));
        f.add(listeSalle.get(4));
        ((Salle) matrice.get(3).get(4)).setSallesAdjacentes(f);

        ArrayList<Salle> g = new ArrayList<Salle>();
        g.clear();
        g.add(null);
        g.add(null);
        g.add(listeSalle.get(9));
        g.add(null);
        ((Salle) matrice.get(3).get(7)).setSallesAdjacentes(g);

        ArrayList<Salle> h = new ArrayList<Salle>();
        h.clear();
        h.add(listeSalle.get(4));
        h.add(listeSalle.get(8));
        h.add(null);
        h.add(null);
        ((Salle) matrice.get(6).get(1)).setSallesAdjacentes(h);

        ArrayList<Salle> y = new ArrayList<Salle>();

        y.add(listeSalle.get(5));
        y.add(null);
        y.add(null);
        y.add(listeSalle.get(7));
        ((Salle) matrice.get(6).get(4)).setSallesAdjacentes(y);

        ArrayList<Salle> z = new ArrayList<Salle>();

        z.add(listeSalle.get(6));
        z.add(null);
        z.add(null);
        z.add(null);
        ((Salle) matrice.get(8).get(7)).setSallesAdjacentes(z);

        ArrayList<Salle> k = new ArrayList<Salle>();
        k.add(null);
        k.add(listeSalle.get(11));
        k.add(null);
        k.add(null);
        ((Salle) matrice.get(8).get(0)).setSallesAdjacentes(k);

        ArrayList<Salle> l = new ArrayList<Salle>();
        l.add(null);
        l.add(null);
        l.add(null);
        l.add(listeSalle.get(10));
        ((Salle) matrice.get(8).get(5)).setSallesAdjacentes(l);



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

        this.paquet1 = new Paquet(this);
        this.paquet2 = new Paquet();

    }

    public ArrayList<ArrayList<Case>> getMatrice() {
        return matrice;
    }

    public void setNbTresor(int nbTresor) {
        this.nbTresor = nbTresor;
    }

    public int getNbTresor() {
        return nbTresor;
    }

    public DeCombat getDeCombat1() {
        return deCombat1;
    }

    public DeCombat getDeCombat2() {
        return deCombat2;
    }

    public DeMouvement getDeMouvement() {
        return deMouvement;
    }


    public Paquet getPaquet1() {
        return paquet1;
    }

    public Paquet getPaquet2() {
        return paquet2;
    }

    public String tirerCarte(){
        Carte c = paquet1.piocher(paquet2);
        System.out.println("La carte tirée est " + c.getNom());
        if(c.getNom() == "Melange"){
            paquet1.melanger(paquet2);
            return "\uD83C\uDCCF : Mélange de la pioche et du paquet";
        }else{
            Salle destination = c.getSalle();
            if(destination.getListeFantomes().size() == 2){
                destination.addFantome();
                return "\uD83C\uDCCF : Ajout d'un fantome rouge dans la salle " + c.getNom();
            }else if(destination.getListeFantomes().size() == 1 && destination.getListeFantomes().get(0) instanceof FantomeRouge){
                tirerCarte();
                System.out.println("\uD83C\uDCCF : Il y à déja un fantome rouge, joueur retire une carte");
            }else{
                destination.addFantome();
                return "\uD83C\uDCCF : Ajout d'un fantome vert dans la salle " + c.getNom();
            }
        }

        return "Error";
    }


    public ArrayList<Joueur> listeJoueurs() {
        return listeJoueurs;
    }

    public ArrayList<Salle> getListeSalle() {
        return listeSalle;
    }



    public int getNbFantomeRouge() {
        return nbFantomeRouge;
    }
}
