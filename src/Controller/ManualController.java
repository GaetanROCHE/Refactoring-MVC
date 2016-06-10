package Controller;

import Model.SimpleTortue;
import View.ViewCommand;

import java.awt.event.ActionEvent;

/**
 * @author ROCHE Gaetan & PLATTEAU Jonathan
 */
public class ManualController extends Controleur {

    protected SimpleTortue courante;

    public SimpleTortue getCurrent() {
        return courante;
    }

    public ManualController(int width, int height) {
        super(width, height);
        courante = new SimpleTortue(width, height);
        vue = new ViewCommand(this, width, height);
        courante.addObserver(vue);
        vue.getFeuille().addTortue(courante);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String c = e.getActionCommand();

        // actions des boutons du haut
        switch (c) {
            case "Avancer":
                System.out.println("command avancer");
                try {
                    int v = Integer.parseInt(vue.getInputValue());
                    courante.avancer(v);
                } catch (NumberFormatException ex) {
                    System.err.println("ce n'est pas un nombre : " + vue.getInputValue());
                }
                break;
            case "Droite":
                try {
                    int v = Integer.parseInt(vue.getInputValue());
                    courante.droite(v);
                } catch (NumberFormatException ex) {
                    System.err.println("ce n'est pas un nombre : " + vue.getInputValue());
                }
                break;
            case "Gauche":
                try {
                    int v = Integer.parseInt(vue.getInputValue());
                    courante.gauche(v);
                } catch (NumberFormatException ex) {
                    System.err.println("ce n'est pas un nombre : " + vue.getInputValue());
                }
                break;
            case "Effacer":
                courante.setPosition(
                        vue.getFeuille().getSize().width / 2,
                        vue.getFeuille().getSize().height / 2);
                vue.effacer();
                break;
            case "Quitter":
                vue.quitter();
                break;
            case "Lever":
                courante.leverCrayon();
                break;
            case "Baisser":
                courante.baisserCrayon();
                break;
            case "Proc1":
                proc1();
                break;
            case "Proc2":
                proc2();
                break;
            case "Proc3":
                proc3();
                break;
        }
        vue.getFeuille().repaint();
    }

    /** les procedures Logo qui combine plusieurs commandes..*/
    private void proc1() {
        courante.carre();
    }

    private void proc2() {
        courante.poly(60,8);
    }

    private void proc3() {
        courante.spiral(50,40,6);
    }
}
