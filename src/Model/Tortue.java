package Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

/**
 * @author ROCHE Gaetan & PLATTEAU Jonathan
 */
public class Tortue extends Observable {
    private static final int rp=10, rb=5; // Taille de la pointe et de la base de la fleche
    private static final double ratioDegRad = 0.0174533; // Rapport radians/degres (pour la conversion)

    private ArrayList<Segment> listSegments; // Trace de la tortue

    private int x, y;
    private int dir;
    private boolean crayon;
    private int coul;

    public Tortue() {
        listSegments = new ArrayList<>();
        reset();
        this.setChanged();
        this.notifyObservers();
    }

    public void reset() {
        x = 0;
        y = 0;
        dir = -90;
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

    public void drawTurtle (Graphics graph) {
        if (graph==null)
            return;

        // Dessine les segments
        for (Segment seg : listSegments) {
            seg.drawSegment(graph);
        }

        //Calcule les 3 coins du triangle a partir de
        // la position de la tortue p
        Point p = new Point(x,y);
        Polygon arrow = new Polygon();

        //Calcule des deux bases
        //Angle de la droite
        double theta=ratioDegRad*(-dir);
        //Demi angle au sommet du triangle
        double alpha=Math.atan( (float)rb / (float)rp );
        //Rayon de la fleche
        double r=Math.sqrt( rp*rp + rb*rb );
        //Sens de la fleche

        //Pointe
        Point p2=new Point((int) Math.round(p.x+r*Math.cos(theta)),
                (int) Math.round(p.y-r*Math.sin(theta)));
        arrow.addPoint(p2.x,p2.y);
        arrow.addPoint((int) Math.round( p2.x-r*Math.cos(theta + alpha) ),
                (int) Math.round( p2.y+r*Math.sin(theta + alpha) ));

        //Base2
        arrow.addPoint((int) Math.round( p2.x-r*Math.cos(theta - alpha) ),
                (int) Math.round( p2.y+r*Math.sin(theta - alpha) ));

        arrow.addPoint(p2.x,p2.y);
        graph.setColor(Color.green);
        graph.fillPolygon(arrow);
        this.setChanged();
        this.notifyObservers();
    }

    public void avancer(int dist) {
        int newX = (int) Math.round(x+dist*Math.cos(ratioDegRad*dir));
        int newY = (int) Math.round(y+dist*Math.sin(ratioDegRad*dir));

        if (crayon) {
            Segment seg = new Segment(x, y, newX, newY, coul);
            listSegments.add(seg);
        }

        x = newX;
        y = newY;
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
}