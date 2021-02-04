package Modele;

public class DeMouvement extends De{
    public boolean tirerCarte(){
        if (super.chiffre <= 5){
            return true;
        }else {
            return false;
        }
    }
}
