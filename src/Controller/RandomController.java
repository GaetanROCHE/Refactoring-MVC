package Controller;

import Model.SimpleTortue;
import View.ViewRandom;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by the mother of dragons
 */
public class RandomController extends Controleur {
    protected ArrayList<SimpleTortue> tortues = new ArrayList<>();

    public RandomController(byte number) {
        vue = new ViewRandom(this, width, height);
        while(number > 0) {
            SimpleTortue t = new SimpleTortue(width, height);
            tortues.add(t);
            t.addObserver(vue);
            vue.getFeuille().addTortue(t);
            number--;
        }
    }

    @Override
    public void run() {
        super.run();
        Random rand;
        while(true) {
            for (SimpleTortue t: tortues) {
                rand = new Random();
                int alea = rand.nextInt(3);
                switch(alea){
                    case 0 :
                        t.droite(rand.nextInt(360));
                        break;
                    case 1 :
                        t.avancer(rand.nextInt(100));
                        break;
                    case 2 :
                        t.setColor(rand.nextInt(12));
                        break;
                    default :
                        break;

                }
            }
            vue.getFeuille().repaint();
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
