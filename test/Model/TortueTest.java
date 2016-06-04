package Model;

import junit.framework.TestCase;

/**
 * Created by gaetan on 04/06/16.
 */
public class TortueTest extends TestCase {

    Tortue caroline;

    public void setUp() throws Exception {
        caroline = new Tortue(600,400);
    }

    public void testReset() throws Exception {
        int initialX, initialY;
        initialX = caroline.getX();
        initialY = caroline.getY();
        caroline.avancer(10);
        caroline.droite(45);
        caroline.reset();
        assertEquals(initialX, caroline.getX());
        assertEquals(initialY, caroline.getY());
    }

    public void testSetPosition() throws Exception {
        caroline.setPosition(27, 86);
        assertEquals(27, caroline.getX());
        assertEquals(86, caroline.getY());
    }

    public void testAvancer() throws Exception {
        caroline.avancer(100);
        assertEquals(300, caroline.getX());
        assertEquals(100, caroline.getY());
    }

    public void testAvancerSortieCarte() throws Exception {
        caroline.avancer(250);
        assertEquals(300, caroline.getX());
        assertEquals(350, caroline.getY());
    }

    public void testDroite() throws Exception {
        caroline.droite(90);
        assertEquals(0, caroline.getDirection());
    }

    public void testGauche() throws Exception {
        caroline.gauche(90);
        assertEquals(180, caroline.getDirection());
    }

    public void testBaisserCrayon() throws Exception {
        assertTrue(caroline.getCrayon());
        caroline.leverCrayon();
        assertFalse(caroline.getCrayon());
        caroline.baisserCrayon();
        assertTrue(caroline.getCrayon());
    }

    public void testCarre() throws Exception {

    }

    public void testPoly() throws Exception {

    }

    public void testSpiral() throws Exception {

    }
}