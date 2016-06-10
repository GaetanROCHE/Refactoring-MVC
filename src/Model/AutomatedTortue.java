package Model;

import java.util.ArrayList;

/**
 * Created by Gaëtan on 10/06/2016.
 */
public abstract class AutomatedTortue extends Tortue{
    private int vitesse;

    public AutomatedTortue(int width, int height) {
        super(width, height);
    }

    int getVitesse() {
        return vitesse;
    }

    void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public abstract void move(ArrayList<AutomatedTortue> t);
}
