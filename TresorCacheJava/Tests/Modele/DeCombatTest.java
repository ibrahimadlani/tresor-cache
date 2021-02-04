package Modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeCombatTest {

    @Test
    void combat() {
        DeCombat dc = new DeCombat();
        int x = dc.lancer();
        if(x <= 4){
            assertEquals(1, dc.combat());
        }else if(x == 5){
            assertEquals(2, dc.combat());
        }else{
            assertEquals(0, dc.combat());
        }
    }
}