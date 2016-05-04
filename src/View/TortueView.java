package View;

import Model.Tortue;

import java.awt.*;

/**
 * @author ROCHE Gaetan & PLATTEAU Jonathan
 */
public class TortueView {
    private Tortue tortue;

    public TortueView(Tortue t)
    {
        tortue = t;
    }

    public void drawTurtle(Graphics graph) {
        if (graph == null)
            return;

        tortue.drawTurtle(graph);
    }
}
