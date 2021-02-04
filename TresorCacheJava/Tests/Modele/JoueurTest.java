package Modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JoueurTest {

    @Test
    void setTresor() {
        Joueur j = new Joueur("Ibrahim");
        assertFalse(j.isTresor());
        j.setTresor(true);
        assertTrue(j.isTresor());
    }
}