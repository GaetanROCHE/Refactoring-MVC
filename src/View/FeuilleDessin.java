package View;

import Model.SimpleTortue;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Titre :        Logo
 * Description :  Un exemple de programme graphique utilisant la celebre SimpleTortue Logo
 * Copyright :    Copyright (c) 2000
 * Societe :      LIRMM
 * @author J. Ferber
 * @version 2.0
 */

public class FeuilleDessin extends JPanel {
    private ArrayList<TortueView> tortues; // la liste des tortues enregistrees

    public void setTortues(ArrayList<TortueView> tortues) {
        this.tortues = tortues;
    }

    public FeuilleDessin() {
        tortues = new ArrayList<>();
    }

    public void addTortue(SimpleTortue o) {
        tortues.add(new TortueView(o));
    }

    public void reset() {
        for (TortueView t : tortues) {
            t.getTortue().reset();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Color c = g.getColor();

        Dimension dim = getSize();
        g.setColor(Color.white);
        g.fillRect(0,0,dim.width, dim.height);
        g.setColor(c);

        showTurtles(g);
    }

    public void showTurtles(Graphics g) {
        for (TortueView t : tortues) {
            t.drawTurtle(g);
        }
    }
}
