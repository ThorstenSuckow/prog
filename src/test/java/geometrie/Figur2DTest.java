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


class TestFigur2D extends Figur2D {


    public TestFigur2D(Punkt b) {
        super(b);
    }
    public TestFigur2D(int x, int y) {
        super(x, y);
    }

    @Override
    public double umfang() {
        return 0;
    }

    @Override
    public double flaeche() {
        return 0;
    }
}

public class Figur2DTest {


    @SuppressWarnings("checkstyle:MagicNumber")
    @Test
    @DisplayName("Figur2D")
    void testFigur2D() {

        final int x = 1;
        final int y = 2;

        TestFigur2D f1 = new TestFigur2D(x, y);
        TestFigur2D f2 = new TestFigur2D(new Punkt(x, y));

        assertEquals(x, f1.getBezug().getX());
        assertEquals(y, f1.getBezug().getY());

        assertTrue(f1.getBezug().equals(f2.getBezug()));

        Punkt p1 = new Punkt(x, y);
        f1.setBezug(p1);
        assertSame(p1, f1.getBezug());

    }




}