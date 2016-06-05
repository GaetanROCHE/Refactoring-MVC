package Controller;

import Model.SmartTortue;
import View.ViewRandom;

import java.util.ArrayList;

public class FlockingController extends Controleur {
    protected ArrayList<SmartTortue> tortues = new ArrayList<>();

    public FlockingController(byte number) {
        vue = new ViewRandom(this, width, height);
        while(number > 0) {
            SmartTortue t = new SmartTortue(width, height, 45, 10);
            tortues.add(t);
            t.addObserver(vue);
            vue.getFeuille().addTortue(t);
            number--;
        }
    }

    @Override
    public void run(){
        super.run();
        while(true) {
            for (SmartTortue t: tortues) {
                t.moveFlocking(tortues);
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
