package geometrie;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class QuaderTest {


    @SuppressWarnings("checkstyle:MagicNumber")
    @Test
    @DisplayName("Quader")
    void testQuader() {

        final int x = 1;
        final int y = 2;
        final int b = 3;
        final int l = 4;

        final int h = 10;

        Punkt p1 = new Punkt(x, y);
        Rechteck r = new Rechteck(p1, b, l);

        Rechteck r2 = new Rechteck(p1, b, l);

                Quader q = new Quader(r, h);
        assertInstanceOf(Figur3D.class, q);

        assertEquals(10, q.getHoehe());
        assertSame(r, q.getBoden());

        q.setBoden(r2);
        assertSame(r2, q.getBoden());

        assertEquals(11.18, q.laengeRaumdiagonale(), 0.01);
        assertEquals(164, q.oberflaeche());
        assertEquals(120, q.volumen());

        assertFalse(Quader.istWuerfel(q));

        r2 = new Rechteck(p1, b, b);
        Quader q2 = new Quader(r2, b);
        assertTrue(Quader.istWuerfel(q2));

        Rechteck r3 = new Rechteck(p1, b, l);
        Quader q3 = new Quader(r3, h);

        Quader q4 = new Quader(r3, h);

        assertTrue(q3.equals(q3));
        assertFalse(q3.equals(q2));
        assertTrue(q3.equals(q4));

        q4.setHoehe(19);
        assertEquals(19, q4.getHoehe());

        q4.setHoehe(0);
        assertEquals(1, q4.getHoehe());


    }

}