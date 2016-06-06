package Model;

import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

/**
 * Created by gaetan on 05/06/16.
 */
public class SmartTortue extends SimpleTortue {
    private int angle;
    private int viewDist;
    private int vitesse;
    private int distMin;

    public SmartTortue(int _width, int _height, int angle, int viewDist, int vitesse, int distMin) {
        super(_width, _height);
        Random rand = new Random();
        this.angle = angle;
        this.viewDist = viewDist;
        this.vitesse = vitesse;
        this.distMin = distMin;
        this.crayon = false;
        this.setDir(rand.nextInt(360));
        setX(rand.nextInt(_width));
        setY(rand.nextInt(_height));
    }


    public void moveFlocking(ArrayList<SmartTortue> tortues) {
        int vitesseMoy = 0;
        int dirMoy = 0;
        int i = 0;
        for (SmartTortue t: tortues) {
            if(estDansChampsVision(t)){
                System.out.println("champs vision");
                dirMoy += t.getDir();
                vitesseMoy += t.getVitesse();
                i++;
            }
        }
        if(i !=0) {
            setVitesse(vitesseMoy / i);
            setDir(dirMoy / i);
        }

        //maintenant on check qu'on est a une distance minimal des autres tortues
        // si non on réduit la vitesse
        for (SmartTortue t : tortues) {
            peutAvancer(t);
        }
        avancer(vitesse);
    }

    public boolean peutAvancer(Tortue t) {
        int newX = (int) Math.round(this.getX()+vitesse*Math.cos(ratioDegRad*this.getDir()));
        int newY = (int) Math.round(this.getY()+vitesse*Math.sin(ratioDegRad*this.getDir()));
        while( Math.sqrt(Math.pow(t.getX() - newX, 2) + Math.pow(t.getY() - newY, 2)) < distMin && vitesse > 0){
            vitesse--;
            System.out.println("trop proche");
            newX = (int) Math.round(this.getX()+vitesse*Math.cos(ratioDegRad*this.getDir()));
            newY = (int) Math.round(this.getY()+vitesse*Math.sin(ratioDegRad*this.getDir()));
        }
        return true;
    }

    public double distance(Tortue t) {
        return Math.sqrt(Math.pow(t.getX() - this.getX(), 2) + Math.pow(t.getY() - this.getY(), 2));
    }

    public boolean estDansChampsVision(SmartTortue t){
        if(distance(t)>viewDist)
            return false;
        //angle entre l'axe des deux tortue et l'horizontal
        double angleCible = Math.atan2(t.getY() - this.getY(), t.getX() - this.getX());
        angleCible = Math.toDegrees(angleCible);
        double angleMax = this.getDir() + angle / 2;
        double angleMin = this.getDir() - angle / 2;
        if (angleMin < 0)
            return angleCible + 90 < angleMax + 90 && angleCible + 90 > angleMin + 90;
        else
            return angleCible < angleMax && angleCible > angleMin;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }
}
