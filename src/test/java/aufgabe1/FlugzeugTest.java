package aufgabe1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class FlugzeugTest {


    final double maxGewicht = 12.0;
    final double leerGewicht = 10.0;
    final double ladungGewicht = 10.0;
    final double reiseGeschw = 500.0;
    final double flugStunden = 23.0;
    final double verbrauch = 24.0;
    final double tankKapazitaet = 132.1;
    final double kerosinVorrat = 12.34;


    public Flugzeug getFlugzeug() {
        return new Flugzeug(
            maxGewicht,
            leerGewicht,
            ladungGewicht,
            reiseGeschw,
            flugStunden,
            verbrauch,
            tankKapazitaet,
            kerosinVorrat
        );
    }


    @SuppressWarnings("checkstyle:MagicNumber")
    @Test
    @DisplayName("Flugzeug")
    void testFlugzeug() {

        Flugzeug f = getFlugzeug();

        Assertions.assertEquals(maxGewicht, f.getMaxGewicht());
        Assertions.assertEquals(leerGewicht, f.getLeerGewicht());
        Assertions.assertEquals(ladungGewicht, f.getLadungGewicht());
        Assertions.assertEquals(reiseGeschw, f.getReiseGeschw());
        Assertions.assertEquals(flugStunden, f.getFlugStunden());
        Assertions.assertEquals(verbrauch, f.getVerbrauch());
        Assertions.assertEquals(tankKapazitaet, f.getTankKapazitaet());
        Assertions.assertEquals(kerosinVorrat, f.getKerosinVorrat());

        // flip kerosin > tank
        f = new Flugzeug(
            maxGewicht,
            leerGewicht,
            ladungGewicht,
            reiseGeschw,
            flugStunden,
            verbrauch,
            12.5,
            100
        );

        Assertions.assertEquals(12.5, f.getTankKapazitaet());
        Assertions.assertEquals(12.5, f.getKerosinVorrat());
    }


    @SuppressWarnings("checkstyle:MagicNumber")
    @Test
    @DisplayName("getGesamtGewicht")
    void testGesamtGewicht() {

        Flugzeug f = getFlugzeug();

        Assertions.assertEquals(
            f.getLadungGewicht() +
                f.getLeerGewicht() +
                (f.getKerosinVorrat() * 0.8),
            f.getGesamtGewicht()
        );
    }

    @SuppressWarnings("checkstyle:MagicNumber")
    @Test
    @DisplayName("betanken")
    void testBetanken() {

        Flugzeug f = getFlugzeug();

        Assertions.assertNotEquals(f.getKerosinVorrat(), f.getTankKapazitaet());

        f.betanke(f.getTankKapazitaet() * 2);
        Assertions.assertEquals(f.getTankKapazitaet(), f.getKerosinVorrat());
    }


    @SuppressWarnings("checkstyle:MagicNumber")
    @Test
    @DisplayName("verbleibendeFlugzeit")
    void testVerbleibendeFlugzeit() {

        Flugzeug f = getFlugzeug();

        f.betanke(f.getVerbrauch());
        Assertions.assertEquals(1, f.verbleibendeFlugzeit());
        f.betanke(f.getVerbrauch() / 2);
        Assertions.assertEquals(0.5, f.verbleibendeFlugzeit());
    }


    @SuppressWarnings("checkstyle:MagicNumber")
    @Test
    @DisplayName("getReichweite")
    void testGetReichweite() {

        Flugzeug f = getFlugzeug();

        f.betanke(f.getVerbrauch());
        Assertions.assertEquals(f.getReiseGeschw(), f.getReichweite());

        f.betanke(f.getVerbrauch() * 2);
        Assertions.assertEquals(f.getReiseGeschw() * 2, f.getReichweite(), 0.01);

        f.betanke(f.getVerbrauch() / 2);
        Assertions.assertEquals(f.getReiseGeschw() / 2, f.getReichweite(), 0.01);

        f.betanke(f.getVerbrauch() / 9);
        Assertions.assertEquals(f.getReiseGeschw() / 9, f.getReichweite(), 0.01);


        f.betanke(f.getVerbrauch() / 2);
        Assertions.assertEquals(0.5, f.verbleibendeFlugzeit());
    }


    @SuppressWarnings("checkstyle:MagicNumber")
    @Test
    @DisplayName("fliegen")
    void testFliegen() {

        Flugzeug f = new Flugzeug(
            101,
            50,
            50,
            250,
            flugStunden,
            1,
            1,
            1
        );


        Assertions.assertFalse(f.fliegen(-1));

        Assertions.assertTrue(f.getGesamtGewicht() <= f.getMaxGewicht());
        Assertions.assertEquals(250, f.getReichweite());
        Assertions.assertFalse(f.fliegen(f.getReichweite() + 1));
        Assertions.assertTrue(f.fliegen(f.getReichweite() - 1));

        Assertions.assertEquals(0, f.getKerosinVorrat(), 0.1);
        Assertions.assertEquals(1 + flugStunden, f.getFlugStunden(), 0.1);

        f = new Flugzeug(
            100,
            50,
            50,
            250,
            23,
            1,
            1,
            1
        );

        Assertions.assertTrue(f.getGesamtGewicht() > f.getMaxGewicht());
        Assertions.assertEquals(250, f.getReichweite());
        Assertions.assertFalse(f.fliegen(f.getReichweite()));

        Assertions.assertEquals(1, f.getKerosinVorrat(), 0.1);
        Assertions.assertEquals(23, f.getFlugStunden(), 0.1);
    }

    @SuppressWarnings("checkstyle:MagicNumber")
    @Test
    @DisplayName("tanken")
    void testTanken() {

        Flugzeug f = new Flugzeug(
            100,
            50,
            50,
            250,
            0,
            1,
            50,
            25
        );

        f.tanken(50);
        Assertions.assertEquals(f.getTankKapazitaet(), f.getKerosinVorrat());

        f.tanken(-12);
        Assertions.assertEquals(38, f.getKerosinVorrat());

        f.tanken(-50);
        Assertions.assertEquals(0, f.getKerosinVorrat());

    }


    @SuppressWarnings("checkstyle:MagicNumber")
    @Test
    @DisplayName("laden")
    void testLaden() {

        final double maxGewicht = 100;
        final double ladungGewicht  = 50;

        Flugzeug f = new Flugzeug(
            maxGewicht,
            10,
            ladungGewicht,
            250,
            0,
            1,
            50,
            25
        );


        double gesamtGewicht = f.getGesamtGewicht();
        double nochPlatz = maxGewicht - gesamtGewicht;

        // beladen mit 0
        Assertions.assertTrue(f.laden(0));
        Assertions.assertEquals(gesamtGewicht, f.getGesamtGewicht());

        // komplett entladen
        Assertions.assertNotEquals(0, f.getLadungGewicht());
        Assertions.assertTrue(f.laden(-f.getLadungGewicht()));
        Assertions.assertEquals(0, f.getLadungGewicht());

        // beladen mit maxGewicht
        Assertions.assertFalse(f.laden(maxGewicht));
        Assertions.assertEquals(0, f.getLadungGewicht());

        // beladen mit maxGewicht
        gesamtGewicht = f.getGesamtGewicht();
        Assertions.assertTrue(f.laden(12));
        Assertions.assertEquals(12, f.getLadungGewicht());
        Assertions.assertEquals(gesamtGewicht + 12, f.getGesamtGewicht());
    }



    @SuppressWarnings("checkstyle:MagicNumber")
    @Test
    @DisplayName("albatros")
    void testAlbatros() {

        final double maxGewicht = 70_000;
        final double leerGewicht = 35_000;
        final double ladungGewicht = 10_000;
        final double reiseGeschw = 800;
        final double flugStunden = 50;
        final double verbrauch = 2500;
        final double tankKapazitaet = 25_000;
        final double kerosinVorrat = 8000;

        Flugzeug albatros = new Flugzeug(
            maxGewicht,
            leerGewicht,
            ladungGewicht,
            reiseGeschw,
            flugStunden,
            verbrauch,
            tankKapazitaet,
            kerosinVorrat
        );

        Assertions.assertTrue(albatros.laden(1500));
        Assertions.assertFalse(albatros.fliegen(3000));
        albatros.tanken(10_000);
        Assertions.assertTrue(albatros.fliegen(3000));

    }

}