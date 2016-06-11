package Model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Gaëtan on 10/06/2016.
 */
public class RandomTortue extends AutomatedTortue {
    public RandomTortue(int width, int height) {
        super(width, height);
    }

    @Override
    public void move(ArrayList<AutomatedTortue> tortues) {
        Random rand = new Random();
        int alea = rand.nextInt(3);
        switch(alea){
            case 0 :
                setDir(rand.nextInt(360));
                break;
            case 1 :
                setVitesse(rand.nextInt(50));
                avancer(getVitesse());
                break;
            case 2 :
                setColor(rand.nextInt(12));
                break;
            default :
                break;

        }

    }
}
