package Controller;

import Model.Tortue;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by the mother of dragons
 */
public class RandomMode extends Controleur {
    private ArrayList<Tortue> tortues = new ArrayList<>();

    public Tortue getCurrent() {
        return courante;
    }

    public RandomMode(byte number) {
        super();
        tortues.add(courante);
        while(number > 1) {
            Tortue t = new Tortue(width, height);
            tortues.add(t);
            t.addObserver(simpleLogo);
            simpleLogo.getFeuille().addTortue(t);
            number--;
        }
    }

    @Override
    public void run() {
        super.run();
        Random rand;
        while(true) {
            for (Tortue t: tortues) {
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
            simpleLogo.getFeuille().repaint();
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String c = e.getActionCommand();

        // actions des boutons du haut
        switch (c) {
            case "Quitter":
                simpleLogo.quitter();
                break;
        }
        simpleLogo.getFeuille().repaint();
    }
}
