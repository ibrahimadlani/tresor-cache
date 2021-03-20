package Vue;

import Controleur.ControleurPlateau;
import Modele.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class VuePlateau {

    private ControleurPlateau cp;
    private JFrame frame = new JFrame("Trésor Caché");
    private JPanel entryPanel = new JPanel(new GridBagLayout());
    private JPanel setupPanel1 = new JPanel();
    private JPanel setupPanel2 = new JPanel();
    private JPanel gamePanel = new JPanel();
    private JPanel nextGamePanel = new JPanel();

    public VuePlateau(ControleurPlateau cp) {
        this.cp = cp;
    }

    public void initEntryPanel(Plateau p){


        this.entryPanel.setBackground(Color.white);
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(200, 80));
        button.setText("Nouvelle Partie");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cp.setupNbJoueurs();
            }
        });

        this.entryPanel.add(button);
        this.frame.add(entryPanel, BorderLayout.CENTER);

        this.frame.setSize(854, 480);
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);

    }
    public void setupPanel1(Plateau p){
        this.setupPanel1.setBackground(Color.white);
        this.setupPanel1.setLayout(new FlowLayout());

        JLabel label1 = new JLabel();
        label1.setText("Selectionnez le nombre de joueurs");

        JButton button1 = new JButton();
        button1.setPreferredSize(new Dimension(150, 40));
        button1.setText("Trois joueurs");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cp.initNbJoueur(3);
            }
        });


        JButton button2 = new JButton();
        button2.setPreferredSize(new Dimension(150, 40));
        button2.setText("Quatre joueurs");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cp.initNbJoueur(4);
            }
        });

        this.setupPanel1.add(label1);
        this.setupPanel1.add(button1);
        this.setupPanel1.add(button2);

        this.frame.setContentPane(setupPanel1);
        this.frame.revalidate();
        this.frame.repaint();
    }

    public void setupPanel2(Plateau p, int nbJ){
        this.setupPanel2.setBackground(Color.white);
        this.setupPanel2.setLayout(new FlowLayout());
        ArrayList<String> listeNoms = new ArrayList<>();
        ArrayList<JTextField> listeField = new ArrayList<>();

        for (int i = 0; i < nbJ; i++) {
            JLabel label2 = new JLabel();
            label2.setText("Joueur #"+i);
            JTextField tfield1 = new JTextField(8);
            this.setupPanel2.add(label2);
            this.setupPanel2.add(tfield1);
            listeField.add(tfield1);
        }
        JButton button1 = new JButton();
        button1.setPreferredSize(new Dimension(200, 80));
        button1.setText("Lancer la partie");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < listeField.size(); i++) {
                    listeNoms.add(listeField.get(i).getText());
                }
                boolean valide = true;
                for (int i = 0; i < listeNoms.size(); i++) {
                    if(listeNoms.get(i).length() == 0){
                        valide = false;
                        System.out.println(listeNoms);
                    }
                }
                if(valide) {
                    cp.gamePanel(listeNoms);
                }else{
                    listeNoms.clear();
                    listeField.clear();
                    JLabel jl = new JLabel("erreur");
                    setupPanel2.add(jl);
                }
            }
        });

        this.setupPanel2.add(button1);

        this.frame.setContentPane(setupPanel2);
        this.frame.revalidate();
        this.frame.repaint();
    }
    public static JPanel getMap(ArrayList<ArrayList<Case>> plateau){

        JPanel global = new JPanel();global.setLayout(new BoxLayout(global,BoxLayout.Y_AXIS));
        global.setBackground(new Color(207,193,175));
        JPanel ligne;
        JPanel caseGraphique;
        File fichier;


        ImageIcon bg= new ImageIcon("TresorCacheJava/Images/salle.png");
        JLabel bgl =new JLabel(bg);
        global.add(bgl);

        for(int i=0 ; i<plateau.size() ; i++){
            ligne = new JPanel();
            for(int j=0 ; j<plateau.get(0).size(); j++){
                caseGraphique = new JPanel();


                ImageIcon imageCouloir = new ImageIcon("TresorCacheJava/Images/couloir.png");

                ImageIcon imageVoid= new ImageIcon("TresorCacheJava/Images/void.png");



                caseGraphique.setLayout(new BoxLayout(caseGraphique,BoxLayout.X_AXIS));
                ligne.add(caseGraphique,BorderLayout.CENTER);
                ligne.setLayout(new BoxLayout(ligne,BoxLayout.X_AXIS));
            }
            global.add(ligne);//ajouter le panel ligne au tout
        }
        return global;
    }
    public void gamePanel(Plateau plateau){

        JPanel southBorderLayoutPanel;
        JPanel centerGridBagLayoutPanel;
        JPanel eastGridLayoutPanel;
        JButton southButton = new JButton("South Button");
        JButton centerButton = new JButton("Center Button");
        ArrayList<JLabel> listeJoueur = new ArrayList<>();
        for (int i = 0; i < plateau.getListeJoueurs().size(); i++) {
            String affiche = "";
            affiche += "" + plateau.getListeJoueurs().get(i).getNom()+"\t("+plateau.getListeJoueurs().get(i).getX()+";"+plateau.getListeJoueurs().get(i).getY()+")";
            if (plateau.getListeJoueurs().get(i).isTresor()){
                affiche += "\t[*]";
            }else {
                affiche += "\t[ ]";
            }
            listeJoueur.add(new JLabel(affiche));
        }
        for (int i = 0; i < plateau.getListeJoueurs().size(); i++) {
            JLabel label2 = new JLabel();
            label2.setText("Joueur #"+plateau.getListeJoueurs().get(i));
        }
        southBorderLayoutPanel = new JPanel(new BorderLayout());
        centerGridBagLayoutPanel = new JPanel(new GridBagLayout());
        eastGridLayoutPanel = new JPanel(new GridLayout(plateau.getListeJoueurs().size(), 1));
        southBorderLayoutPanel.add(southButton);
        southBorderLayoutPanel.setBorder(BorderFactory.createTitledBorder("Joueurs"));
        centerGridBagLayoutPanel.add(getMap(plateau.getMatrice()));
        centerGridBagLayoutPanel.setBorder(BorderFactory.createTitledBorder("Plateau"));
        for (int i = 0; i < listeJoueur.size(); i++) {
            eastGridLayoutPanel.add(listeJoueur.get(i));
        }
        eastGridLayoutPanel.setBorder(BorderFactory.createTitledBorder("Information"));
        int height = eastGridLayoutPanel.getHeight();
        eastGridLayoutPanel.setSize(new Dimension(300,height));
        this.gamePanel.setLayout(new BorderLayout());      // This is the deafault layout
        this.gamePanel.add(southBorderLayoutPanel, BorderLayout.PAGE_END);
        this.gamePanel.add(centerGridBagLayoutPanel, BorderLayout.CENTER);
        this.gamePanel.add(eastGridLayoutPanel, BorderLayout.LINE_END);
        this.gamePanel.setVisible(true);
        this.frame.pack();
        this.frame.setSize(1280, 720);
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setContentPane(gamePanel);
        this.frame.revalidate();
        this.frame.repaint();

    }

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

    public int initNbJoueur(int j){
        return j;
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
