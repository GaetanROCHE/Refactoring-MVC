package Model;

import java.util.ArrayList;
import java.util.Observable;

public abstract class Tortue extends Observable {
    protected static final double ratioDegRad = 0.0174533; // Rapport radians/degres (pour la conversion)

    ArrayList<Segment> listSegments; // Trace de la tortue

    private int x, y;
    private int width, height;
    private int dir;
    boolean crayon;
    private int coul;

    public Tortue(int width, int height){
        this.width=width;
        this.height=height;
        listSegments = new ArrayList<>();
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

    public void avancer(int dist) {
        int newX = (int) Math.round(getX()+dist*Math.cos(ratioDegRad*getDir()));
        int newY = (int) Math.round(getY()+dist*Math.sin(ratioDegRad*getDir()));

        if (crayon) {
            Segment seg = new Segment(getX(), getY(), newX, newY, getColor());
            listSegments.add(seg);
        }

        setX((newX + getWidth()) % getWidth());
        setY((newY + getHeight()) % getHeight());
        if (crayon) { //on affiche le segment dans le sens inverse pour avoir l'impression que le segment se prolonge
            int oldX = (int) Math.round(getX()-dist*Math.cos(ratioDegRad*getDir()));
            int oldY = (int) Math.round(getY()-dist*Math.sin(ratioDegRad*getDir()));
            Segment seg = new Segment(getX(), getY(), oldX, oldY, getColor());
            listSegments.add(seg);
        }
        this.setChanged();
        this.notifyObservers();
    }

    public int getColor()
    {
        return coul;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
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

    public ArrayList<Segment> getListSegments() {
        return listSegments;
    }

    public boolean getCrayon() {
        return crayon;
    }
}
