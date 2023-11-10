package geometrie;

import aufgabe1.Flugzeug;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class GeradeTest {


    @SuppressWarnings("checkstyle:MagicNumber")
    @Test
    @DisplayName("Gerade")
    void testGerade() {

        Punkt p1 = new Punkt(1, 2);
        Punkt p2 = new Punkt(3, 4);
        Punkt p3 = new Punkt(4, 5);

        Gerade g = new Gerade(p1, p2);

        Gerade g2 = new Gerade(p1, p3);

        assertEquals(p1, g.getStartPos());
        assertEquals(p2, g.getEndPos());

        assertEquals(Math.sqrt(8), g.laenge());

        assertFalse(g.istLaengerAls(g));
        assertFalse(g.istLaengerAls(g2));
        assertTrue(g2.istLaengerAls(g));

        assertTrue(g.equals(g));
        assertFalse(g.equals(g2));

        assertTrue(g.equals(new Gerade(new Punkt(p1), new Punkt(p2))));

        Punkt pStart = new Punkt(1, 1);
        Punkt pEnd = new Punkt(2, 2);

        g.setStartPos(pStart);
        assertSame(pStart, g.getStartPos());

        g.setEndPos(pEnd);
        assertSame(pEnd, g.getEndPos());


    }




}