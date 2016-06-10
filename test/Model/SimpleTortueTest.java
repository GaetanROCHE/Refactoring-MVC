package Model;

import junit.framework.TestCase;

/**
 * Created by gaetan on 04/06/16.
 */
public class SimpleTortueTest extends TestCase {

    SimpleTortue caroline;

    public void setUp() throws Exception {
        caroline = new SimpleTortue(600,400);
    }

    public void testReset() throws Exception {
        double initialX, initialY;
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
        assertEquals(0, caroline.getDir());
    }

    public void testGauche() throws Exception {
        caroline.gauche(90);
        assertEquals(180, caroline.getDir());
    }

    public void testBaisserCrayon() throws Exception {
        assertTrue(caroline.getCrayon());
        caroline.leverCrayon();
        assertFalse(caroline.getCrayon());
        caroline.baisserCrayon();
        assertTrue(caroline.getCrayon());
    }

    public void testCarre() throws Exception {
        double initialX, initialY, nombreSegment;
        initialX = caroline.getX();
        initialY = caroline.getY();
        nombreSegment = caroline.getListSegments().size();
        caroline.carre();
        assertEquals(initialX, caroline.getX());
        assertEquals(initialY, caroline.getY());
        assertEquals(nombreSegment+8, caroline.getListSegments().size());
    }

    public void testPoly() throws Exception {
        double initialX, initialY, nombreSegment;
        initialX = caroline.getX();
        initialY = caroline.getY();
        nombreSegment = caroline.getListSegments().size();
        caroline.poly(5,6);
        assertEquals(initialX, caroline.getX());
        assertEquals(initialY, caroline.getY());
        assertEquals(nombreSegment+12, caroline.getListSegments().size());
    }

    public void testSpiral() throws Exception {
        double initialX, initialY, nombreSegment;
        initialX = caroline.getX();
        initialY = caroline.getY();
        nombreSegment = caroline.getListSegments().size();
        caroline.spiral(4,12,8);
        assertEquals(initialX+25, caroline.getX());
        assertEquals(initialY-7, caroline.getY());
        assertEquals(nombreSegment+24, caroline.getListSegments().size());
    }
}