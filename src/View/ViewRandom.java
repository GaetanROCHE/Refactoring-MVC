package View;

import Controller.Controleur;
import Model.Tortue;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;

/**
 * Created by gaetan on 05/06/16.
 */
public class ViewRandom extends SimpleView {

    public ViewRandom(Controleur Controleur, int _width, int _height) {
        super(Controleur, _width, _height);
    }

    @Override
    void logoInit() {
        getContentPane().setLayout(new BorderLayout(10,10));

        JToolBar toolBar = new JToolBar();
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(toolBar);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        feuille = new FeuilleDessin();
        feuille.setBackground(Color.white);
        feuille.setSize(new Dimension(width,height));
        feuille.setPreferredSize(new Dimension(width, height));

        getContentPane().add(feuille,"Center");

        pack();
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.getFeuille().repaint();
    }
}
