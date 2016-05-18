package Model;

import java.awt.*;

/**
 * @author ROCHE Gaetan & PLATTEAU Jonathan
 */
public class Segment {
    private Point ptStart, ptEnd;
    private Color color;

    private Color decodeColor(int c) {
        switch(c) {
            case 0: return(Color.black);
            case 1: return(Color.blue);
            case 2: return(Color.cyan);
            case 3: return(Color.darkGray);
            case 4: return(Color.red);
            case 5: return(Color.green);
            case 6: return(Color.lightGray);
            case 7: return(Color.magenta);
            case 8: return(Color.orange);
            case 9: return(Color.gray);
            case 10: return(Color.pink);
            case 11: return(Color.yellow);
            default : return(Color.black);
        }
    }

    Segment(int x1, int y1, int x2, int y2, int c) {
        ptStart = new Point(x1,y1);
        ptEnd = new Point(x2,y2);
        color = decodeColor(c);
    }

    public Point getPtStart() {
        return ptStart;
    }

    public Point getPtEnd() {
        return ptEnd;
    }

    public Color getColor() {
        return color;
    }
}
