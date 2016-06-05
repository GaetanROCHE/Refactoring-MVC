package Controller;

import View.SimpleView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Controleur extends Thread implements ActionListener {
    protected int width = 600, height = 400;
    protected SimpleView vue;

    @Override
    public void actionPerformed(ActionEvent e) {
        String c = e.getActionCommand();

        // actions des boutons du haut
        switch (c) {
            case "Quitter":
                vue.quitter();
                break;
        }
        vue.getFeuille().repaint();
    }
}
