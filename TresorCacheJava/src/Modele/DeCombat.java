package Modele;

public class DeCombat extends De{
    public DeCombat(){

    }
    public int roll(){
        int r = 0;
        if (super.chiffre < 4){
            r = 1;
        }else if (super.chiffre == 5 || super.chiffre == 4){
            r = 2;
        }else if (super.chiffre == 6){
            r = 0;
        }
        return r;
    }
}
