package geometrie;

public abstract class Figur2D {

    private Punkt bezug;


    public Figur2D(Punkt bezug) {
        this(bezug.getX(), bezug.getY());
    }

    public Figur2D(int x, int y) {
        this.bezug = new Punkt(x, y);
    }

    public Punkt getBezug() {
        return bezug;
    }

    abstract public double umfang();

    abstract public double flaeche();


    public void setBezug(Punkt p) {
        bezug = p;
    }
}
