package Modele;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SalleTest {

    @Test
    void isTresor() {
        Salle s = new Salle(0, 1, "SalleTest", new ArrayList<Case>());
        assertFalse(s.isTresor());
    }

    @Test
    void addFantome() {
    }
}