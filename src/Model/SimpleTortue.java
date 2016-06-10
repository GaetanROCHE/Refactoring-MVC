package Model;

import java.util.ArrayList;

/**
 * @author ROCHE Gaetan & PLATTEAU Jonathan
 */
public class SimpleTortue extends Tortue {


    public SimpleTortue(int _width, int _height) {
        super(_width, _height);
        reset();
        this.setChanged();
        this.notifyObservers();
    }

    public void droite(int ang) {
        setDir((getDir() + ang) % 360);
        this.setChanged();
        this.notifyObservers();
    }

    public void gauche(int ang) {
        setDir((getDir() - ang) % 360);
        this.setChanged();
        this.notifyObservers();
    }

    /** quelques classiques */

    public void carre() {
        for (int i=0;i<4;i++) {
            avancer(100);
            droite(90);
        }
        this.setChanged();
        this.notifyObservers();
    }

    public void poly(int n, int a) {
        for (int j=0;j<a;j++) {
            avancer(n);
            droite(360/a);
        }
        this.setChanged();
        this.notifyObservers();
    }

    public void spiral(int n, int k, int a) {
        for (int i = 0; i < k; i++) {
            couleurSuivante();
            avancer(n);
            droite(360/a);
            n = n+1;
        }
        this.setChanged();
        this.notifyObservers();
    }
}
