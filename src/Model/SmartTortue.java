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
        double oa = ((double)t.getY()-(double)this.getY())/((double)t.getX()-(double)this.getX());
        Double angleCible = (Math.toDegrees(Math.atan(oa)) + 360) % 360; //angle entre l'axe des deux tortue et l'horizontal
        System.out.println(angleCible);
        return angleCible<(this.getDir()-angle/2+360)%360 && angleCible > (this.getDir()+angle/2)%360 && distance(t)<=viewDist;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }
}
