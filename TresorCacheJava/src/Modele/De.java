package Modele;

import java.util.Random;

public class De {
    private int chiffre;

    public De(){
        this.chiffre = 0;
    }

    public int lancer(){
        Random r = new Random();
        int x = r.nextInt(6)+1;
        this.chiffre = x;
        return x;
    }


}
