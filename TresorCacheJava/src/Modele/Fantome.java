package Modele;

public class Fantome {
    protected Salle salle;

    public Fantome(Salle salle){
        this.salle = salle;
    }

    public Fantome(){
        this.salle = null;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }
}
