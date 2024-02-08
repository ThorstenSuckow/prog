package musterklausurws2021;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class OmnibusTest {


    @Test
    @DisplayName("Omnibus")
    public void testOmnibus() {

        Omnibus omni = new Omnibus(12,0, 5.0, 50, 30);
        assertEquals(0, omni.getKmStand());
        assertEquals(5.0, omni.getVerbrauch());
        assertEquals(50, omni.getTankVolumen());
        assertEquals(30, omni.getKraftstoffVorrat());
        assertEquals(12, omni.getAnzahlSitzplaetze());

        assertEquals(
        "anzahlSitzplaetze: 12; verbrauch: 5.0; tankVolumen: 50.0; " +
                "kmStand: 0; kraftstoffVorrat: 30.0",
                omni.toString()
        );
    }
}