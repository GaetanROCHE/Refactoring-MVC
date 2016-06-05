package Model;

import java.util.ArrayList;
import java.util.Random;

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
        this.angle = angle;
        this.viewDist = viewDist;
        this.vitesse = vitesse;
        this.distMin = distMin;
    }


    public void moveFlocking(ArrayList<SmartTortue> tortues) {
        int vitesseMoy = 0;
        int dirMoy = 0;
        int i = 0;
        for (SmartTortue t: tortues) {
            if(estDansChampsVision(t)){
                dirMoy += t.getDir();
                vitesseMoy += t.getVitesse();
                i++;
            }
        }
        if(i !=0) {
            setVitesse(vitesseMoy / i);
            setDir(dirMoy / i);
        }
        else{
            Random rand = new Random();
            setDir(rand.nextInt(360));
            setVitesse(rand.nextInt(50));
        }

        //maintenant on check qu'on est a une distance minimal des autres tortues
        for (SmartTortue t : tortues) {
            //TO DO
        }
    }

    public boolean estDansChampsVision(SmartTortue t){
        int x = t.getX();
        int y = t.getY();
        return true;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }
}
