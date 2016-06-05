package View;

import Controller.Controleur;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observer;

public abstract class SimpleView extends JFrame implements Observer {

    protected JTextField inputValue;
    protected Controleur controleur;
    protected int width, height;
    protected FeuilleDessin feuille;

    public SimpleView(Controleur controleur, int _width, int _height){
        super("un logo tout simple");
        this.controleur = controleur;
        this.width = _width;
        this.height = _height;
        logoInit();
        this.setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                super.windowClosing(arg0);
                System.exit(0);
            }
        });
    }

    public String getInputValue(){
        return(inputValue.getText());
    }

    public FeuilleDessin getFeuille() {
        return feuille;
    }

    public void quitter() {
        System.exit(0);
    }

    abstract void logoInit();

    // efface tout et reinitialise la feuille
    public void effacer() {
        feuille.reset();
        feuille.repaint();
    }
}
