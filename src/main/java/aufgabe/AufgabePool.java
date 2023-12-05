package aufgabe;

import geometrie.Kreis;
import geometrie.Punkt;
import geometrie.Quader;
import geometrie.Rechteck;
import geometrie.Zylinder;

public class AufgabePool {


    private Kreis k1;

    private Kreis k2;

    private Kreis k3;

    private Zylinder z1;

    private Zylinder z2;

    private Zylinder z3;

    private Quader q;

    public AufgabePool () {
        int hoehe = 2;

        Rechteck r = new Rechteck(new Punkt(74, 390), 316, 875);

        k1 = new Kreis(new Punkt(791, 390), r.getBreite() / 2);

        k2 = new Kreis(new Punkt(0, 390), (r.getBreite() - 20) / 4);

        k3 = new Kreis(new Punkt(0, 222), (r.getBreite() - 20) / 4);

        z1 = new Zylinder(k1, hoehe);
        z2 = new Zylinder(k2, hoehe);
        z3 = new Zylinder(k3, hoehe);

        q = new Quader(r, hoehe);
    }

    public double poolVolumen() {
        return q.volumen() + (z1.volumen() / 2) + (z2.volumen() / 2) + (z3.volumen() / 2);
    }

    public double poolUmfang() {
        return (2 * q.getBoden().getLaenge() + 20) +
            + (z1.getBoden().umfang() / 2)
            + (z2.getBoden().umfang() / 2)
            + (z3.getBoden().umfang() / 2);
    }

    public double poolInnererMantel() {
        return poolUmfang() * getQ().getHoehe() + dach();
    }

    private double dach () {
        return  (q.getBoden().flaeche())
            + z1.getBoden().flaeche() / 2
            + z2.getBoden().flaeche() / 2
            + z3.getBoden().flaeche() / 2;
    }
    public double poolWasserOberflaeche() {
        return  dach();
    }

    public double kostenZaun(double preisProStueck) {
        return (Math.ceil(poolUmfang() / 5)) * preisProStueck;
    }


    public Quader getQ() {
        return q;
    }
    public Zylinder getZ1() {
        return z1;
    }

    public Zylinder getZ2() {
        return z2;
    }

    public Zylinder getZ3() {
        return z3;
    }

}
