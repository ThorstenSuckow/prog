package geometrie;

public class Rechteck extends Figur2D {

    /**
     * y-Richtung
     */
    private int breite;

    /**
     * x-Richtung
     */
    private int laenge;

    public Rechteck(Punkt bezug, int b, int l) {
        super(bezug);
        setBreite(b);
        setLaenge(l);
    }


    public double diagonalenLaenge() {
        Punkt p1 = new Punkt(getBezug());

        Punkt p2 = new Punkt(p1);
        p2.verschieben(getLaenge(), getBreite());

        return p1.abstand(p2);
    }

    public boolean umfangKleinerAls(Figur2D f) {
        return umfang() < f.umfang();
    }

    public boolean flaecheKleinerAls(Figur2D f) {
        return flaeche() < f.flaeche();
    }

    @Override
    public double umfang() {
        return 2 * (breite + laenge);
    }

    @Override
    public double flaeche() {
        return breite * laenge;
    }

    public int getBreite() {
        return breite;
    }

    public int getLaenge() {
        return laenge;
    }

    public void setLaenge(int l) {
        this.laenge = Math.max(l, 1);
    }

    public void setBreite(int b) {
        this.breite = Math.max(b, 1);
    }
}
