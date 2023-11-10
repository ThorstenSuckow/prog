package geometrie;

import aufgabe.AufgabePool;
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





public class AufgabePoolTest {


    @SuppressWarnings("checkstyle:MagicNumber")
    @Test
    @DisplayName("AufgabePool")
    void testAufgabePool() {

        AufgabePool pool = new AufgabePool();

        Quader q =  pool.getQ();
        Zylinder z1 = pool.getZ1();
        Zylinder z2 = pool.getZ2();
        Zylinder z3 = pool.getZ3();

        Rechteck r = q.getBoden();

        assertEquals(316, r.getBreite());
        assertEquals(875, r.getLaenge());

        assertEquals(2, q.getHoehe());

        assertTrue(z1.getBoden().equals(new Kreis(new Punkt(791, 390),158)));
        assertTrue(z2.getBoden().equals(new Kreis(new Punkt(0, 390),74)));
        assertTrue(z3.getBoden().equals(new Kreis(new Punkt(0, 222),74)));


        assertEquals(2, z1.getHoehe());
        assertEquals(2, z2.getHoehe());
        assertEquals(2, z3.getHoehe());
    }


    @Test
    @DisplayName("poolVolumen")
    void testPoolVolumen() {

        AufgabePool pool = new AufgabePool();

        assertEquals(665833.441, pool.poolVolumen(), 0.01);
    }


    @Test
    @DisplayName("poolUmfang")
    void testPoolUmfang() {

        AufgabePool pool = new AufgabePool();

        assertEquals(2731.327, pool.poolUmfang(), 0.01);
    }

    @Test
    @DisplayName("poolInnererMantel")
    void testPoolInnererMantel() {

        AufgabePool pool = new AufgabePool();

        assertEquals(338379.375, pool.poolInnererMantel(), 0.01);
    }

    @Test
    @DisplayName("poolWasserOberflaeche")
    void testPoolWasserOberflaeche() {

        AufgabePool pool = new AufgabePool();

        assertEquals(332916.720, pool.poolWasserOberflaeche(), 0.01);
    }

    @Test
    @DisplayName("kostenZaun")
    void testKostenZaun() {

        AufgabePool pool = new AufgabePool();

        assertEquals(957.25, pool.kostenZaun(1.75), 0.01);
    }


}