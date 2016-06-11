package Model;

import junit.framework.TestCase;

/**
 * Created by Gaëtan on 11/06/2016.
 */
public class RandomTortueTest extends TestCase {

    RandomTortue caroline;

    public void setUp() throws Exception {
        super.setUp();
        caroline = new RandomTortue(400,600);
    }

    public void testMove() throws Exception {
        int oldDir = caroline.getDir();
        int oldVitesse = caroline.getVitesse();
        int oldColor = caroline.getColor();
        caroline.move(null);
        assertTrue(oldColor != caroline.getColor() || oldDir != caroline.getDir() || oldVitesse != caroline.getVitesse());
    }

}