package geometrie;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;


class TestFigur3D extends Figur3D {


    public TestFigur3D(Figur2D f) {
        super(f);
    }

    @Override
    public double volumen() {
        return 0;
    }

    @Override
    public double oberflaeche() {
        return 0;
    }


}

public class Figur3DTest {


    @SuppressWarnings("checkstyle:MagicNumber")
    @Test
    @DisplayName("Figur3D")
    void testFigur3D() {

        final int x = 1;
        final int y = 2;

        Punkt p1 = new Punkt(x, y);

        Kreis k = new Kreis(p1);

        TestFigur3D f = new TestFigur3D(k);

        assertSame(k, f.getBoden());

    }

}