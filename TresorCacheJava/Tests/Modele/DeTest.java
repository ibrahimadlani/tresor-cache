package Modele;

import Modele.De;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeTest {

    @Test
    void lancer() {
        De de = new De();
        assertFalse(de.lancer() < 0);
        assertFalse(de.lancer() > 6);
    }

}