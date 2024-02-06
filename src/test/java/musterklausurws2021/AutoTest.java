package musterklausurws2021;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AutoTest {


    @Test
    @DisplayName("Auto")
    public void testAuto() {

        Auto gogoMobil = new Auto(0, 5.0, 50, 30);
        assertEquals(0, gogoMobil.getKmStand());
        assertEquals(5.0, gogoMobil.getVerbrauch());
        assertEquals(50, gogoMobil.getTankVolumen());
        assertEquals(30, gogoMobil.getKraftstoffVorrat());

        gogoMobil.fahren(300);
        assertEquals(15, gogoMobil.getKraftstoffVorrat());
        assertEquals(300, gogoMobil.getKmStand());

        gogoMobil.fahren(320);
        assertEquals(0, gogoMobil.getKraftstoffVorrat());
        assertEquals(600, gogoMobil.getKmStand());

        gogoMobil.tanken(1);
        gogoMobil.fahren(1);
        assertEquals(0.95, gogoMobil.getKraftstoffVorrat());

        Auto a = new Auto(0, 12, 48, 0);

        a.fahren(10);
        assertEquals(0, a.getKmStand());

        a.tanken(100);
        assertEquals(48, a.getKraftstoffVorrat());

        a.fahren(300);
        assertEquals(12, a.getKraftstoffVorrat());

        a.fahren(101);
        assertEquals(0, a.getKraftstoffVorrat());
        assertEquals(400, a.getKmStand());
    }
}