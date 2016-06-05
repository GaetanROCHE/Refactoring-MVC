package Model;

import java.util.ArrayList;

/**
 * @author ROCHE Gaetan & PLATTEAU Jonathan
 */
public class SimpleTortue extends Tortue {
    private static final double ratioDegRad = 0.0174533; // Rapport radians/degres (pour la conversion)

    private ArrayList<Segment> listSegments; // Trace de la tortue

    private boolean crayon;
    private int coul;

    public SimpleTortue(int _width, int _height) {
        super(_width, _height);
        listSegments = new ArrayList<>();
        reset();
        this.setChanged();
        this.notifyObservers();
    }

    public void reset() {
        setPosition(this.getWidth() >> 1, this.getHeight() >> 1);
        this.setDir(270);
        coul = 0;
        crayon = true;
        listSegments.clear();
        this.setChanged();
        this.notifyObservers();
    }

    public void setPosition(int newX, int newY) {

        this.setX(newX);
        this.setY(newY);
        this.setChanged();
        this.notifyObservers();
    }

    public void setColor(int n)
    {
        coul = n;
        this.setChanged();
        this.notifyObservers();
    }

    public int getColor()
    {
        return coul;
    }

    public void avancer(int dist) {
        int newX = (int) Math.round(getX()+dist*Math.cos(ratioDegRad*getDir()));
        int newY = (int) Math.round(getY()+dist*Math.sin(ratioDegRad*getDir()));

        if (crayon) {
            Segment seg = new Segment(getX(), getY(), newX, newY, coul);
            listSegments.add(seg);
        }

        setX((newX + getWidth()) % getWidth());
        setY((newY + getHeight()) % getHeight());
        if (crayon) { //on affiche le segment dans le sens inverse pour avoir l'impression que le segment se prolonge
            int oldX = (int) Math.round(getX()-dist*Math.cos(ratioDegRad*getDir()));
            int oldY = (int) Math.round(getY()-dist*Math.sin(ratioDegRad*getDir()));
            Segment seg = new Segment(getX(), getY(), oldX, oldY, coul);
            listSegments.add(seg);
        }
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

    public void baisserCrayon() {
        crayon = true;
    }

    public void leverCrayon() {
        crayon = false;
    }

    private void couleur(int n) {
        coul = n % 12;
    }

    public void couleurSuivante() {
        couleur(coul+1);
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
            couleur(coul+1);
            avancer(n);
            droite(360/a);
            n = n+1;
        }
        this.setChanged();
        this.notifyObservers();
    }

    public ArrayList<Segment> getListSegments() {
        return listSegments;
    }

    public boolean getCrayon() {
        return crayon;
    }
}
