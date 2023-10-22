package prog.aufgabe1;

import org.junit.jupiter.api.Assertions;

public class Flugzeug {

    public final static double KEROSIN_DICHTE = 0.8;

    private final double maxGewicht;

    private final double leerGewicht;

    private double ladungGewicht;

    private final double reiseGeschw;

    private double flugStunden;

    private final double verbrauch;

    private final double tankKapazitaet;

    private double kerosinVorrat;


    public static void main(String[] args) {

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

        albatros.laden(1500);
        albatros.fliegen(3000);
        albatros.tanken(10_000);
        albatros.fliegen(3000);
    }


    public Flugzeug(
         final double maxGewicht,
         final double leerGewicht,
         final double ladungGewicht,
         final double reiseGeschw,
         final double flugStunden,
         final double verbrauch,
         final double tankKapazitaet,
         final double kerosinVorrat
    ) {

        this.maxGewicht = maxGewicht;
        this.leerGewicht = leerGewicht;
        this.ladungGewicht = ladungGewicht;
        this.reiseGeschw = reiseGeschw;
        this.flugStunden = flugStunden;
        this.verbrauch = verbrauch;
        this.tankKapazitaet = tankKapazitaet;

        betanke(kerosinVorrat);
    }


    public void info() {

        System.out.println("Flugstunden: " + getFlugStunden());
        System.out.println("Tankinhalt: " + getKerosinVorrat());
        System.out.println("Gesamtgewicht: " + getGesamtGewicht());


    }


    /**
     * Belädt das Flugzeug um den angegebene Inhalt (in kg), bzw entlädt es um den
     * angegebenen Inhalt falls negative Werte übergeben werden.
     *
     * @param inhalt in kg, negative Werte für Entladung, pos. für Beladung
     *
     * @return true, wenn be-/entladen erfolgreich, ansonsten false, wenn durch
     * den Ladevorgang das zulässige Maximalgewicht überschritten wird
     */
    public boolean laden(double inhalt) {


        double neuesLadeGewicht = Math.max(0, getLadungGewicht() + inhalt);


        if (getGesamtGewicht(neuesLadeGewicht) > getMaxGewicht()) {
            return false;
        }

        ladungGewicht = neuesLadeGewicht;

        return true;
    }


    /**
     * Betankt das Flugzeug und füllt den Tank um die angegebene Anzahl von Litern auf (f. pos.
     * Werte) bzw lässt Tankinhalt ab (f. neg. Werte).
     *
     * @param liter negative Werte für Menge an lieter, die abgelassen werden, positive
     *              Werte für eine Nachfüllung.
     */
    public void tanken(final double liter) {

        double neuerTankstand = getKerosinVorrat() + liter;

        kerosinVorrat = Math.min(getTankKapazitaet(), Math.max(0, neuerTankstand));

    }


    /**
     * Liefert true zurück, wenn das Flugzeug die angegebene Anzahl von km fliegen kann.
     * Ein Flugzeug kann die angegebene Anzahl von km fliegen, wenn die aktuelle Reichweite grösser oder gleich
     * der angegebenen Anzahl von km entspricht, und das Gesamtgewicht das max. Startgewicht nicht überschreitet.
     *
     * @param km die Anzahl von km, die geflogen werden sollen
     *
     * @return true, falls die angegebene Anzahl von km geflogen werden kann
     */
    public boolean fliegen(double km) {

        if (getReichweite() < km || getGesamtGewicht() > getMaxGewicht()) {
            return false;
        }

        double flugStundenDelta = (km / getReiseGeschw());
        kerosinVorrat = kerosinVorrat - (flugStundenDelta * getVerbrauch());

        flugStunden += flugStundenDelta;

        return true;
    }


    /**
     * Liefert verbleibende Reichweite des Flugzeugs mit dem ggw. #kerosinVorrat zurück.
     *
     * @return verbleibende Reichweite im km
     */
    public double getReichweite() {

        return verbleibendeFlugzeit() * getReiseGeschw();
    }


    /**
     * Liefert das Gesamtgewicht des Flugzeugs, das sich zusammensetzt aus dem
     * Leergewicht des Flugzeugs, dem Gewicht der Ladung und dem Gewicht des
     * Kerosins (vorg. Dichte: 0.8).
     *
     * @return das Gesamtgewicht des Flugzeugs
     *
     * @see #getGesamtGewicht
     */
    public double getGesamtGewicht() {

        return getGesamtGewicht(getLadungGewicht());

    }


    /**
     * @return das maximale Startgewicht des Flugzeugs
     */
    public double getMaxGewicht() {
        return maxGewicht;
    }


    public double getLeerGewicht() {
        return leerGewicht;
    }


    public double getLadungGewicht() {
        return ladungGewicht;
    }


    /**
     * @return Reisegeschwindigkeit (km/h)
     */
    public double getReiseGeschw() {
        return reiseGeschw;
    }


    /**
     * Kerosinverbrauch pro Flugstunde (l/h)
     */
    public double getVerbrauch() {
        return verbrauch;
    }


    public double getTankKapazitaet() {
        return tankKapazitaet;
    }


    public double getKerosinVorrat() {
        return kerosinVorrat;
    }


    public double getFlugStunden() {
        return flugStunden;
    }


    /**
     * Liefert die verbleibende Flugzeit basierend auf dem aktuellen Kerosinvorrat und
     * der Reisegeschwindigkeit zurück, in h
     */
    double verbleibendeFlugzeit() {
        return kerosinVorrat / verbrauch;
    }


    /**
     * Erlaubt das Füllen des Tanks mit der angegebenen Menge (in liter).
     * Wenn die Kerosinmenge grösser als der Tank ist, wird die Tankkapazität verwendet.
     *
     * @param liter der neue Kerosinvorrat.
     *
     * @return dieses Flugzeug
     */
    Flugzeug betanke(final double liter) {
        this.kerosinVorrat = Math.min(liter, tankKapazitaet);

        return this;
    }

    private double getGesamtGewicht(final double gewicht) {
        return gewicht + getLeerGewicht() + (getKerosinVorrat() * KEROSIN_DICHTE);
    }

}
