package Model;

import java.util.ArrayList;

/**
 * Created by gaetan on 05/06/16.
 */
public class SmartTortue extends SimpleTortue {
    private int angle;
    private int viewDist;

    public SmartTortue(int _width, int _height, int angle, int viewDist) {
        super(_width, _height);
        this.angle = angle;
        this.viewDist = viewDist;
    }


    public void moveFlocking(ArrayList<SmartTortue> tortues) {

    }
}
