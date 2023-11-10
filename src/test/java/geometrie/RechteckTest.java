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





public class RechteckTest {


    @SuppressWarnings("checkstyle:MagicNumber")
    @Test
    @DisplayName("Rechteck")
    void testRechteck() {

        final int x = 1;
        final int y = 2;

        final int b = 5;
        final int l = 6;

        Punkt p1 = new Punkt(x, y);

        Rechteck r = new Rechteck(p1, b, l);
        assertInstanceOf(Figur2D.class, r);

        assertEquals(Math.sqrt(61) , r.diagonalenLaenge());

        assertEquals(b, r.getBreite());
        assertEquals(l, r.getLaenge());

        assertEquals(30, r.flaeche());
        assertEquals(22, r.umfang());

        Rechteck r2 = new Rechteck(p1, 1, 1);

        assertTrue(r2.umfangKleinerAls(r));
        assertTrue(r2.flaecheKleinerAls(r));

        assertFalse(r.umfangKleinerAls(r2));
        assertFalse(r.flaecheKleinerAls(r2));

        r2.setBreite(15);
        r2.setLaenge(16);

        assertEquals(15, r2.getBreite());
        assertEquals(16, r2.getLaenge());

        assertThrowsExactly(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                r2.setBreite(0);
            }
        });

        assertThrowsExactly(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                r2.setLaenge(0);
            }
        });

    }





}