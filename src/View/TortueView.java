package View;

import Model.Segment;
import Model.SimpleTortue;

import java.awt.*;

/**
 * @author ROCHE Gaetan & PLATTEAU Jonathan
 */
public class TortueView {
    private SimpleTortue tortue;
    private static final int rp=10, rb=5; // Taille de la pointe et de la base de la fleche
    private static final double ratioDegRad = 0.0174533; // Rapport radians/degres (pour la conversion)

    public TortueView(SimpleTortue t)
    {
        tortue = t;
    }

    public SimpleTortue getTortue() {
        return tortue;
    }

    public void drawTurtle(Graphics graph) {
        if (graph==null)
            return;

        // Dessine les segments
        for (Segment seg : tortue.getListSegments()) {
            graph.setColor(seg.getColor());
            graph.drawLine(seg.getPtStart().x, seg.getPtStart().y, seg.getPtEnd().x, seg.getPtEnd().y);
        }

        //Calcule les 3 coins du triangle a partir de
        // la position de la tortue p
        Point p = new Point(tortue.getX(),tortue.getY());
        Polygon arrow = new Polygon();

        //Calcule des deux bases
        //Angle de la droite
        double theta=ratioDegRad*(-tortue.getDir());
        //Demi angle au sommet du triangle
        double alpha=Math.atan( (float)rb / (float)rp );
        //Rayon de la fleche
        double r=Math.sqrt( rp*rp + rb*rb );
        //Sens de la fleche

        //Pointe
        Point p2=new Point((int) Math.round(p.x+r*Math.cos(theta)),
                (int) Math.round(p.y-r*Math.sin(theta)));
        arrow.addPoint(p2.x,p2.y);
        arrow.addPoint((int) Math.round( p2.x-r*Math.cos(theta + alpha) ),
                (int) Math.round( p2.y+r*Math.sin(theta + alpha) ));

        //Base2
        arrow.addPoint((int) Math.round( p2.x-r*Math.cos(theta - alpha) ),
                (int) Math.round( p2.y+r*Math.sin(theta - alpha) ));

        arrow.addPoint(p2.x,p2.y);
        graph.setColor(Color.green);
        graph.fillPolygon(arrow);
    }
}
