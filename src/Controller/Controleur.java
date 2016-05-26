package Controller;

import Model.Tortue;
import View.SimpleLogo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author ROCHE Gaetan & PLATTEAU Jonathan
 */
public class Controleur extends Thread implements ActionListener {
    private SimpleLogo simpleLogo;
    private Tortue courante;
    private ArrayList<Tortue> tortues = new ArrayList<>();
    public Tortue getCurrent() {
        return courante;
    }

    public Controleur() {
        courante = new Tortue(600, 400);
        tortues.add(courante);
        simpleLogo = new SimpleLogo(this, 600, 400);
        courante.addObserver(simpleLogo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String c = e.getActionCommand();

        // actions des boutons du haut
        switch (c) {
            case "Avancer":
                System.out.println("command avancer");
                try {
                    int v = Integer.parseInt(simpleLogo.getInputValue());
                    courante.avancer(v);
                } catch (NumberFormatException ex) {
                    System.err.println("ce n'est pas un nombre : " + simpleLogo.getInputValue());
                }
                break;
            case "Droite":
                try {
                    int v = Integer.parseInt(simpleLogo.getInputValue());
                    courante.droite(v);
                } catch (NumberFormatException ex) {
                    System.err.println("ce n'est pas un nombre : " + simpleLogo.getInputValue());
                }
                break;
            case "Gauche":
                try {
                    int v = Integer.parseInt(simpleLogo.getInputValue());
                    courante.gauche(v);
                } catch (NumberFormatException ex) {
                    System.err.println("ce n'est pas un nombre : " + simpleLogo.getInputValue());
                }
                break;
            case "Effacer":
                courante.setPosition(
                        simpleLogo.getFeuille().getSize().width / 2,
                        simpleLogo.getFeuille().getSize().height / 2);
                simpleLogo.effacer();
                break;
            case "Quitter":
                simpleLogo.quitter();
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
        simpleLogo.getFeuille().repaint();
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
