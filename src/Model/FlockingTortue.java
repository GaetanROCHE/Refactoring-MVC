package Model;

import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

/**
 * Created by gaetan on 05/06/16.
 */
public class FlockingTortue extends AutomatedTortue {
    private int angle;
    private int viewDist;
    private int distMin;

    public FlockingTortue(int _width, int _height, int angle, int viewDist, int vitesse, int distMin) {
        super(_width, _height);
        this.angle = angle;
        this.viewDist = viewDist;
        this.distMin = distMin;
        this.crayon = true;
        setVitesse(vitesse);
    }


    public void move(ArrayList<AutomatedTortue> tortues) {
        int vitesseMoy = getVitesse();
        int dirMoy = getDir();
        int i = 1;
        for (AutomatedTortue t: tortues) {
            if(estDansChampsVision(t)){
                // System.out.println("champs vision");
                dirMoy += t.getDir();
                vitesseMoy += t.getVitesse();
                i++;
            }
        }
        setVitesse(vitesseMoy / i);
        setDir(dirMoy / i);

        //maintenant on check qu'on est a une distance minimal des autres tortues
        // si non on réduit la vitesse
        for (AutomatedTortue t : tortues) {
            peutAvancer(t);
        }
        avancer(getVitesse());
    }

    public boolean peutAvancer(Tortue t) {
        int newX = (int) Math.round(this.getX()+getVitesse()*Math.cos(ratioDegRad*this.getDir()));
        int newY = (int) Math.round(this.getY()+getVitesse()*Math.sin(ratioDegRad*this.getDir()));
        while( Math.sqrt(Math.pow(t.getX() - newX, 2) + Math.pow(t.getY() - newY, 2)) < distMin && getVitesse() > 0){
            setVitesse(getVitesse()-1);
            // System.out.println("trop proche");
            newX = (int) Math.round(this.getX()+getVitesse()*Math.cos(ratioDegRad*this.getDir()));
            newY = (int) Math.round(this.getY()+getVitesse()*Math.sin(ratioDegRad*this.getDir()));
        }
        return true;
    }

    public double distance(Tortue t) {
        return Math.sqrt(Math.pow(t.getX() - this.getX(), 2) + Math.pow(t.getY() - this.getY(), 2));
    }

    public boolean estDansChampsVision(Tortue t){
        if(distance(t)>viewDist)
            return false;
        //angle entre l'axe des deux tortue et l'horizontal
        double angleCible = Math.atan2(t.getY() - this.getY(), t.getX() - this.getX());
        angleCible = Math.toDegrees(angleCible);
        double anglediff = (this.getDir() -  angleCible + 180 + 360) % 360 - 180;

        return (anglediff <= angle && anglediff>=-angle);
    }
}
