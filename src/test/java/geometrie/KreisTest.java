package geometrie;

import aufgabe1.Flugzeug;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;





public class KreisTest {


    @SuppressWarnings("checkstyle:MagicNumber")
    @Test
    @DisplayName("Rechteck")
    void testPunkt() {

        final int x = 1;
        final int y = 2;

        Punkt p1 = new Punkt(x, y);

        Kreis k = new Kreis(p1);
        assertInstanceOf(Figur2D.class, k);
        assertEquals(5, k.getRadius());
        assertTrue(p1.equals(k.getBezug()));

        k = new Kreis(p1, 8);
        assertEquals(8, k.getRadius());

        assertEquals(16 * Math.PI, k.umfang());
        assertEquals(64 * Math.PI, k.flaeche());

        k.setRadius(17);
        assertEquals(17, k.getRadius());

        Kreis k2 = new Kreis(p1);

        assertFalse(k2.equals(k));
        k2.setRadius(17);
        assertTrue(k2.equals(k));


        k = new Kreis(new Punkt(1, 1));
        k.setRadius(0);
        assertEquals(1, k.getRadius());


    }




}