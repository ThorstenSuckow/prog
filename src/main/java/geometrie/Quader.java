package geometrie;

public class Quader extends Figur3D {


    private int hoehe;

    public Quader(Rechteck r, int hoehe) {
        super(r);
        setHoehe(hoehe);
    }

    public void setBoden(Rechteck r) {
        super.setBoden(r);
    }

    public Rechteck getBoden() {
        return (Rechteck) super.getBoden();
    }

    public double laengeRaumdiagonale() {

        Punkt p1 = getBoden().getBezug();

        Punkt p2 = new Punkt(p1);
        p2.verschieben(getBoden().getLaenge(), getBoden().getBreite());

        Punkt p3 = new Punkt(p2);
        p3.verschieben(0, hoehe);

        Gerade g1 = new Gerade(p1, p2);
        Gerade g2 = new Gerade(p2, p3);

        return Math.sqrt(Math.pow(g1.laenge(), 2) + Math.pow(g2.laenge(), 2));
    }

    public static boolean istWuerfel(Object q2) {

        if (!(q2 instanceof Quader)) {
            return false;
        }

        Quader q = (Quader)q2;

        return q.getBoden().getBreite() == q.getBoden().getLaenge()
            && q.getBoden().getLaenge() == q.getHoehe();
    }

    public int getHoehe() {
        return hoehe;
    }

    @Override
    public double volumen() {
        return getBoden().getBreite() * getBoden().getLaenge() * hoehe;
    }

    @Override
    public double oberflaeche() {

        return (2 * (getBoden().getBreite() * getBoden().getLaenge()))
            + (2 * (getBoden().getBreite() * hoehe))
            + (2 * (getBoden().getLaenge() * hoehe));
    }

    public boolean equals(Figur3D f) {

        if (!(f instanceof Quader q)) {
            return false;
        }

        return getBoden().equals(q.getBoden()) && q.getHoehe() == getHoehe();
    }

    public void setHoehe(int h) {
        hoehe = Math.max(h, 1);
    }
}
