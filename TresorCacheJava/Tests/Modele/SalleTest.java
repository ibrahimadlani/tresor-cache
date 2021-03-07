package Modele;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SalleTest {

    @Test
    void isTresor() {
        Salle s = new Salle(0, 1, "SalleTest", new ArrayList<Case>(),true);
        assertFalse(s.isTresor());
        s.setTresor(true);
        assertTrue(s.isTresor());
    }

    @Test
    void addFantome() {
        Salle s = new Salle(0, 1, "SalleTest", new ArrayList<Case>(),true);
        s.addFantome();
        assertTrue(s.getListeFantomes().size() == 1);
        s.addFantome();
        assertTrue(s.getListeFantomes().size() == 2);
        s.addFantome();
        assertTrue(s.getListeFantomes().size() == 1);
        s.addFantome();
        assertTrue(s.getListeFantomes().size() == 1);
    }

    @Test
    void deleteFantome(){
        Salle s = new Salle(0, 1, "SalleTest", new ArrayList<Case>(),true);
        s.addFantome();
        assertTrue(s.getListeFantomes().size() == 1);
        s.deleteFantome();
        assertTrue(s.getListeFantomes().size() == 0);
    }
}