package Model;

import java.util.Observable;

public abstract class Tortue extends Observable {
    protected static final double ratioDegRad = 0.0174533; // Rapport radians/degres (pour la conversion)

    private int x, y;
    private int width, height;
    private int dir;

    public Tortue(int width, int height){
        this.width=width;
        this.height=height;
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
}
