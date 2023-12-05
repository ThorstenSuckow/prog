package geometrie;

public class Gerade {


    private Punkt startPos;

    private Punkt endPos;

    public Gerade(Punkt p1, Punkt p2) {
        startPos = p1;
        endPos = p2;
    }

    public boolean istLaengerAls(Gerade g2) {
        return laenge() > g2.laenge();
    }

    public double laenge() {
        return startPos.abstand(endPos);
    }


    public Punkt getStartPos() {
        return startPos;
    }

    public Punkt getEndPos() {
        return endPos;
    }

    public boolean equals(Gerade g2) {

        if (g2 == null) {
            return false;
        }

        if (this == g2) {
            return true;
        }

        return g2.getEndPos().equals(endPos) &&
            g2.getStartPos().equals(startPos);
    }

    public void setStartPos(Punkt p) {
        startPos = p;
    }
    public void setEndPos(Punkt p) {
        endPos = p;
    }
}
