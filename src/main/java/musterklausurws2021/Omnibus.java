package musterklausurws2021;

public class Omnibus extends Auto {

    private int anzahlSitzplaetze;

    public Omnibus(
            int anzahlSitzplaetze,
            int kmStand,
            double verbrauch,
            double tankVolumen,
            double kraftstoffVorrat) {
        super(kmStand, verbrauch, tankVolumen, kraftstoffVorrat);
        this.anzahlSitzplaetze = anzahlSitzplaetze;
    }

    public String toString() {
        return "anzahlSitzplaetze: " + anzahlSitzplaetze + "; " + super.toString();
    }

    public int getAnzahlSitzplaetze() {
        return anzahlSitzplaetze;
    }
}
