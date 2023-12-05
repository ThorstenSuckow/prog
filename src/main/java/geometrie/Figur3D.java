package geometrie;

public abstract class Figur3D {

    private Figur2D boden;

    public Figur3D (Figur2D f) {
        boden = f;
    }


    public Figur2D getBoden() {
        return boden;
    }


    public void setBoden(Figur2D f) {
        boden = f;
    }


    public abstract double volumen();

    public abstract double oberflaeche();


}
