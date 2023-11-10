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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;





public class ZylinderTest {


    @SuppressWarnings("checkstyle:MagicNumber")
    @Test
    @DisplayName("Zylinder")
    void testZylinder() {

        final int x = 1;
        final int y = 2;
        final int b = 3;
        final int l = 4;

        final int h = 10;
        final int radius = 6;

        Punkt p1 = new Punkt(x, y);
        Kreis k = new Kreis(p1, radius);
        Kreis k2 = new Kreis(p1, radius);


        Zylinder z = new Zylinder(k, h);
        assertInstanceOf(Figur3D.class, z);

        assertEquals(10, z.getHoehe());
        assertSame(k, z.getBoden());

        assertNotSame(k, k2);
        z.setBoden(k2);
        assertSame(k2, z.getBoden());

        assertEquals(376.991, z.mantelflaeche(), 0.001);
        assertEquals( 603.186 , z.oberflaeche(), 0.001);
        assertEquals(1130.973 , z.volumen(), 0.001);

        z.setHoehe(21);
        assertEquals(21, z.getHoehe());

        assertThrowsExactly(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                z.setHoehe(0);
            }
        });
    }




}