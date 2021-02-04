package Modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaseTest {

    @Test
    void ajouterJoueur() {
        Case c = new Case(0, 1);

        assertEquals(c.getJoueurs().size(), 0);
        Joueur i = new Joueur("Ibrahim");
        c.ajouterJoueur(i);
        assertTrue(c.getJoueurs().contains(i));
    }

    @Test
    void suppprimerJoueur() {
        Case c = new Case(0, 1);

        assertEquals(c.getJoueurs().size(), 0);
        Joueur i = new Joueur("Ibrahim");
        c.ajouterJoueur(i);
        assertEquals(c.getJoueurs().size(), 1);
        c.suppprimerJoueur(i);
        assertFalse(c.getJoueurs().contains(i));
    }
}