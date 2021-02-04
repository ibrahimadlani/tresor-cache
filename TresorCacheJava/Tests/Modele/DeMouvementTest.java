package Modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeMouvementTest {

    @Test
    void tirerCarte() {
        DeMouvement dm = new DeMouvement();
        int x = dm.lancer();
        if(x <= 5) {
            assertTrue(dm.tirerCarte());
        }else{
            assertFalse(dm.tirerCarte());
        }
    }
}