package geometrie;

public class Punkt {

    private int x;

    private int y;


    public Punkt(final int x, final int y) {

        this.x = x;
        this.y = y;

    }

    public Punkt(final Punkt org) {
        this.x = org.getX();
        this.y = org.getY();
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void verschieben(int x1, int y1) {
        x += x1;
        y += y1;
    }


    /**
     * Berechnet den euklidischen Abstand zwischen diesem und dem spezifizierten Punkt.
     *
     * @param p2 Der spezifizierte Punkt
     *
     * @return den euklidischen Abstand zwischen diesem und dem spezifizierten Punkt
     */
    public double abstand(Punkt p2) {
        return Math.sqrt(
            Math.pow(x - p2.getX(), 2) +
            Math.pow(y - p2.getY(), 2)
        );
    }


    public boolean equals(Punkt p2) {
        if (p2 == null) {
            return false;
        }

        if (this == p2) {
            return true;
        }

        return p2.getX() == x && p2.getY() == y;
    }


    public String toString() {
        return "Punkt (" + x + ", "+ y + ")";
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
