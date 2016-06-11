package Controller;

import Model.AutomatedTortue;
import View.ViewRandom;

import java.util.ArrayList;

public class AutomatedController extends Controleur {
    private ArrayList<AutomatedTortue> tortues;
    private int tempo;

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
        boolean changeColor = false;
        long tempo = System.currentTimeMillis();
        while(true) {
            if(System.currentTimeMillis() - tempo > 20000) {
                changeColor = true;
                tempo = System.currentTimeMillis();
            }
            for (AutomatedTortue t: tortues) {
                ArrayList<AutomatedTortue> temp = (ArrayList<AutomatedTortue>) tortues.clone();
                temp.remove(t);
                t.move(temp);
                if(changeColor) {
                    t.setColor(t.getColor() + 1);
                    t.clearSegment();
                }
            }
            vue.getFeuille().repaint();
            changeColor = false;
            try {
                sleep(32);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
