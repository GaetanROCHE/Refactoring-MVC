package Model;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by Gaëtan on 11/06/2016.
 */
public class FlockingTortueTest extends TestCase {

    private FlockingTortue caroline;

    public void setUp() throws Exception {
        super.setUp();
        caroline = new FlockingTortue(400,600, 90, 30, 5, 1, 10, 10, 0);

    }

    public void testMoveListTortuesNull() throws Exception {
        caroline.move(null);
    }

    public void testMoveTortueDansChampsVision() throws Exception {
        ArrayList<AutomatedTortue> tortues = new ArrayList<>();
        tortues.add(new FlockingTortue(400,600, 90, 30, 15, 1, 21, 10, 0));
        caroline.move(tortues);
        assertEquals(10, caroline.getVitesse());
    }

    public void testMoveTortueHorsChamp() throws Exception {
        ArrayList<AutomatedTortue> tortues = new ArrayList<>();
        tortues.add(new FlockingTortue(400,600, 90, 30, 15, 1, 0, 10, 0));
        caroline.move(tortues);
        assertEquals(5, caroline.getVitesse());
    }

    public void testPeutAvancerRalentit() throws Exception {
        caroline.peutAvancer(new FlockingTortue(400,600, 90, 30, 15, 1, 15, 10, 0));
        assertEquals(4, caroline.getVitesse());
    }

    public void testPeutAvancerNonAffectee() throws Exception {
        caroline.peutAvancer(new FlockingTortue(400,600, 90, 30, 15, 1, 25, 10, 0));
        assertEquals(5, caroline.getVitesse());
    }


}