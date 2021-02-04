package Modele;

import java.util.ArrayList;
import java.util.Collections;

public class Paquet {
    private ArrayList<Carte> paquet;

    public Paquet(Plateau p){
        ArrayList<Carte> paquet = new ArrayList<Carte>();
        paquet.add(new Carte("A",p.getListeSalle().get(0)));
        paquet.add(new Carte("A",p.getListeSalle().get(1)));
        paquet.add(new Carte("A",p.getListeSalle().get(2)));
        paquet.add(new Carte("A",p.getListeSalle().get(3)));
        paquet.add(new Carte("A",p.getListeSalle().get(4)));
        paquet.add(new Carte("A",p.getListeSalle().get(5)));
        paquet.add(new Carte("A",p.getListeSalle().get(6)));
        paquet.add(new Carte("A",p.getListeSalle().get(7)));
        paquet.add(new Carte("A",p.getListeSalle().get(8)));
        paquet.add(new Carte("A",p.getListeSalle().get(9)));
        paquet.add(new Carte("A",p.getListeSalle().get(10)));
        paquet.add(new Carte("A",p.getListeSalle().get(11)));
        paquet.add(new Carte("Melange",null));
    }

    public Paquet(){
        ArrayList<Carte> paquet = new ArrayList<Carte>();
    }

    public void melanger(Paquet p){
        this.paquet.addAll(p.paquet);
        Collections.shuffle(paquet);
    }
    public void vider(){
        this.paquet.removeAll(paquet);
    }

    public Carte piocher(Paquet p){
        this.paquet.remove(paquet.get(paquet.size()-1));
        p.paquet.add(paquet.get(paquet.size()-1));
    }

}
