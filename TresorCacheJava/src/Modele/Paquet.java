package Modele;

import java.util.ArrayList;
import java.util.Collections;

public class Paquet {
    private ArrayList<Carte> paquet;

    public Paquet(Plateau p){
        paquet = new ArrayList<Carte>();
        paquet.add(new Carte("A",p.getListeSalle().get(0)));
        paquet.add(new Carte("B",p.getListeSalle().get(1)));
        paquet.add(new Carte("C",p.getListeSalle().get(2)));
        paquet.add(new Carte("D",p.getListeSalle().get(3)));
        paquet.add(new Carte("E",p.getListeSalle().get(4)));
        paquet.add(new Carte("F",p.getListeSalle().get(5)));
        paquet.add(new Carte("G",p.getListeSalle().get(6)));
        paquet.add(new Carte("H",p.getListeSalle().get(7)));
        paquet.add(new Carte("I",p.getListeSalle().get(8)));
        paquet.add(new Carte("J",p.getListeSalle().get(9)));
        paquet.add(new Carte("K",p.getListeSalle().get(10)));
        paquet.add(new Carte("L",p.getListeSalle().get(11)));
        paquet.add(new Carte("Melange",null));
        Collections.shuffle(paquet);
    }

    public Paquet(ArrayList<Carte> paquet){
        this.paquet = paquet;
    }

    public Paquet(){
        paquet = new ArrayList<Carte>();
    }

    public void melanger(Paquet p){
        this.paquet.addAll(p.paquet);
        Collections.shuffle(paquet);
        p.vider();
    }

    public void vider(){
        this.paquet.removeAll(paquet);
    }

    public Carte piocher(Paquet p){
        Carte c = paquet.get(paquet.size()-1);
        p.paquet.add(c);
        paquet.remove(c);
        return c;
    }

    public ArrayList<Carte> getPaquet() {
        return paquet;
    }

    public void setPaquet(ArrayList<Carte> paquet) {
        this.paquet = paquet;
    }

    
}
