package geometrie;

import aufgabe1.Flugzeug;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PunktTest {


    @SuppressWarnings("checkstyle:MagicNumber")
    @Test
    @DisplayName("Punkt")
    void testPunkt() {

        final int x = 1;
        final int y = 2;

        final int x2 = 3;
        final int y2 = 5;

        Punkt p1 = new Punkt(x, y);
        Punkt p2 = new Punkt(new Punkt(x2, y2));

        assertEquals(x, p1.getX());
        assertEquals(y, p1.getY());

        assertEquals(x2, p2.getX());
        assertEquals(y2, p2.getY());

        assertEquals(Math.sqrt(13), p1.abstand(p2));


        p1.verschieben(x2, y2);
        assertEquals(4, p1.getX());
        assertEquals(7, p1.getY());

        Punkt p3 = new Punkt(p1);

        assertFalse(p1.equals(p2));
        assertNotSame(p1, p3);
        assertTrue(p1.equals(p3));

        p1.setX(11);
        p1.setY(12);

        assertEquals(11, p1.getX());
        assertEquals(12, p1.getY());

    }




}