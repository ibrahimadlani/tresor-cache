package Modele;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PaquetTest {

    @Test
    void melanger() {
        ArrayList<Carte> paquet1 = new ArrayList<>();
        paquet1.add(new Carte("A",new Salle()));
        paquet1.add(new Carte("B",new Salle()));
        paquet1.add(new Carte("C",new Salle()));
        paquet1.add(new Carte("C",new Salle()));
        paquet1.add(new Carte("D",new Salle()));
        paquet1.add(new Carte("E",new Salle()));
        paquet1.add(new Carte("F",new Salle()));
        paquet1.add(new Carte("G",new Salle()));
        paquet1.add(new Carte("H",new Salle()));
        paquet1.add(new Carte("I",new Salle()));

        Paquet p1 = new Paquet(paquet1);

        ArrayList<Carte> paquet2 = new ArrayList<>();
        paquet2.add(new Carte("A",new Salle()));
        paquet2.add(new Carte("B",new Salle()));
        paquet2.add(new Carte("C",new Salle()));
        paquet2.add(new Carte("C",new Salle()));
        paquet2.add(new Carte("D",new Salle()));
        paquet2.add(new Carte("E",new Salle()));
        paquet2.add(new Carte("F",new Salle()));
        paquet2.add(new Carte("G",new Salle()));
        paquet2.add(new Carte("H",new Salle()));
        paquet2.add(new Carte("I",new Salle()));

        Paquet p2 = new Paquet(paquet2);

        assertEquals(paquet1, p1.getPaquet());

        p1.melanger(p2);

        assertEquals(p2.getPaquet().size(), 0);
        assertEquals(p1.getPaquet().size(), 20);

    }

    @Test
    void vider() {
        ArrayList<Carte> paquet = new ArrayList<>();
        paquet.add(new Carte("A",new Salle()));
        paquet.add(new Carte("B",new Salle()));
        paquet.add(new Carte("C",new Salle()));
        paquet.add(new Carte("C",new Salle()));
        paquet.add(new Carte("D",new Salle()));
        paquet.add(new Carte("E",new Salle()));
        paquet.add(new Carte("F",new Salle()));
        paquet.add(new Carte("G",new Salle()));
        paquet.add(new Carte("H",new Salle()));
        paquet.add(new Carte("I",new Salle()));

        Paquet p = new Paquet(paquet);

        assertEquals(paquet, p.getPaquet());

        p.vider();

        assertTrue(p.getPaquet().size() == 0);
    }



    @Test
    void piocher() {
        ArrayList<Carte> paquet1 = new ArrayList<>();
        paquet1.add(new Carte("A",new Salle()));
        paquet1.add(new Carte("B",new Salle()));
        paquet1.add(new Carte("C",new Salle()));
        paquet1.add(new Carte("C",new Salle()));
        paquet1.add(new Carte("D",new Salle()));
        paquet1.add(new Carte("E",new Salle()));
        paquet1.add(new Carte("F",new Salle()));
        paquet1.add(new Carte("G",new Salle()));
        paquet1.add(new Carte("H",new Salle()));
        paquet1.add(new Carte("I",new Salle()));

        Paquet p1 = new Paquet(paquet1);
        int taille1 = p1.getPaquet().size();

        ArrayList<Carte> paquet2 = new ArrayList<>();
        paquet2.add(new Carte("A",new Salle()));
        paquet2.add(new Carte("B",new Salle()));
        paquet2.add(new Carte("C",new Salle()));
        paquet2.add(new Carte("C",new Salle()));
        paquet2.add(new Carte("D",new Salle()));
        paquet2.add(new Carte("E",new Salle()));
        paquet2.add(new Carte("F",new Salle()));
        paquet2.add(new Carte("G",new Salle()));
        paquet2.add(new Carte("H",new Salle()));
        paquet2.add(new Carte("I",new Salle()));

        Paquet p2 = new Paquet(paquet2);
        int taille2 = p2.getPaquet().size();

        p1.piocher(p2);

        assertEquals(p1.getPaquet().size(), taille1 - 1);
        assertEquals(p2.getPaquet().size(), taille2 + 1);
    }
}