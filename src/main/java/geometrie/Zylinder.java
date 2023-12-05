package geometrie;

public class Zylinder extends Figur3D {


    private int hoehe;


    public Zylinder(Kreis k, int hoehe) {
        super(k);
        setHoehe(hoehe);
    }

    public int getHoehe() {
        return hoehe;
    }

    public void setBoden(Kreis z) {
        super.setBoden(z);
    }


    public Kreis getBoden() {
        return (Kreis) super.getBoden();
    }

    @Override
    public double volumen() {
        return getBoden().flaeche() * hoehe;
    }

    @Override
    public double oberflaeche() {
        return 2 * getBoden().flaeche() + mantelflaeche();
    }

    public double mantelflaeche() {
        return getBoden().umfang() * hoehe;
    }

    public void setHoehe(int h) {
        hoehe = Math.max(h, 1);
    }
}
