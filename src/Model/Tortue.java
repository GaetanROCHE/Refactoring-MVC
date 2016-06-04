package Model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

/**
 * @author ROCHE Gaetan & PLATTEAU Jonathan
 */
public class Tortue extends Observable {
    private static final double ratioDegRad = 0.0174533; // Rapport radians/degres (pour la conversion)

    private ArrayList<Segment> listSegments; // Trace de la tortue

    private int x, y;
    private int width, height;
    private int dir;
    private boolean crayon;
    private int coul;

    public Tortue(int _width, int _height) {
        listSegments = new ArrayList<>();
        this.width = _width;
        this.height = _height;
        reset();
        this.setChanged();
        this.notifyObservers();
    }

    public void reset() {
        setPosition(width >> 1, height >> 1);
        dir = 270;
        coul = 0;
        crayon = true;
        listSegments.clear();
        this.setChanged();
        this.notifyObservers();
    }

    public void setPosition(int newX, int newY) {

        x = newX;
        y = newY;
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
        int newX = (int) Math.round(x+dist*Math.cos(ratioDegRad*dir));
        int newY = (int) Math.round(y+dist*Math.sin(ratioDegRad*dir));

        if (crayon) {
            Segment seg = new Segment(x, y, newX, newY, coul);
            listSegments.add(seg);
        }

        x = (newX + width) % width;
        y = (newY + height)% height;
        if (crayon) { //on affiche le segment dans le sens inverse pour avoir l'impression que le segment se prolonge
            int oldX = (int) Math.round(x-dist*Math.cos(ratioDegRad*dir));
            int oldY = (int) Math.round(y-dist*Math.sin(ratioDegRad*dir));
            Segment seg = new Segment(x, y, oldX, oldY, coul);
            listSegments.add(seg);
        }
        this.setChanged();
        this.notifyObservers();
    }

    public void droite(int ang) {
        dir = (dir + ang) % 360;
        this.setChanged();
        this.notifyObservers();
    }

    public void gauche(int ang) {
        dir = (dir - ang) % 360;
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

    public int getDirection() {
        return dir;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ArrayList<Segment> getListSegments() {
        return listSegments;
    }

    public boolean getCrayon() {
        return crayon;
    }
}
