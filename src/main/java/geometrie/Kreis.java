package geometrie;

public class Kreis extends Figur2D {

    private final static int DEFAULT_RADIUS = 5;

    private int radius;

    public Kreis(Punkt bezug) {
        this(bezug, DEFAULT_RADIUS);
    }


    public Kreis(Punkt bezug, int radius) {
        super(bezug);
        setRadius(radius);
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public double umfang() {
        return radius * 2 * Math.PI;
    }

    @Override
    public double flaeche() {
        return Math.pow(radius, 2) * Math.PI;
    }

    public void setRadius(int r) {
        radius = Math.max(r, 1);
    }

    public boolean equals(Kreis k) {
        if (k == this) {
            return true;
        }

        return radius == k.getRadius() && k.getBezug().equals(getBezug());
    }
}
