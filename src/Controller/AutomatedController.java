package Controller;

import Model.AutomatedTortue;
import View.ViewRandom;

import java.util.ArrayList;

public class AutomatedController extends Controleur {
    protected ArrayList<AutomatedTortue> tortues;

    public AutomatedController(ArrayList<AutomatedTortue> tortues, int width, int height) {
        super(width, height);
        vue = new ViewRandom(this, width, height);
        for(AutomatedTortue t : tortues) {
            t.addObserver(vue);
            vue.getFeuille().addTortue(t);
        }
        this.tortues = tortues;
    }

    @Override
    public void run(){
        super.run();
        while(true) {
            for (AutomatedTortue t: tortues) {
                ArrayList<AutomatedTortue> temp = (ArrayList<AutomatedTortue>) tortues.clone();
                temp.remove(t);
                t.move(temp);
            }
            vue.getFeuille().repaint();
            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
