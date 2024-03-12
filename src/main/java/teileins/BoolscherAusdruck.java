package teileins;

public class BoolscherAusdruck {

    public enum SternZeichen {
        WIDDER,
        STIER,
        ZWILLINGE,
        KREBS,
        LOEWE,
        JUNGFRAU,
        WAAGE,
        SKORPION,
        SCHUETZE,
        STEINBOCK,
        WASSERMANN,
        FISCHE
    };

    private SternZeichen sternZeichen;

    private Integer jahresBrutto;

    private int alter;

    private String haarfarbe;
    private static final SternZeichen[] UNERWUENSCHT = new SternZeichen[]{
        SternZeichen.STIER, SternZeichen.SCHUETZE, SternZeichen.WASSERMANN
    };

    public BoolscherAusdruck() {
    }


    public boolean istGenehm() {

        if (getAlter() < 18) {
            return false;
        }


        for (int i = 0; i < UNERWUENSCHT.length; i++) {
            if (UNERWUENSCHT[i] == getSternZeichen()) {
                return false;
            }
        }

        if (getHaarfarbe().equals("rot") && (getSternZeichen() == SternZeichen.WIDDER || getSternZeichen() == SternZeichen.KREBS)) {
            return false;
        }

        if (getSternZeichen() == SternZeichen.LOEWE && getJahresBrutto() <= 40_000) {
            return false;
        }

        if (getAlter() > 40 && getHaarfarbe().equals("blond") && jahresBrutto > 50_000) {
            return true;
        }

        if (getSternZeichen() == SternZeichen.FISCHE || getAlter() < 30) {
            return true;
        }

        return false;
    }

    public SternZeichen[] getUNERWUENSCHT() {
        return UNERWUENSCHT;
    }

    public SternZeichen getSternZeichen() {
        return sternZeichen;
    }
    public void setSternZeichen(SternZeichen sternZeichen) {
        this.sternZeichen = sternZeichen;
    }

    public Integer getJahresBrutto() {
        return jahresBrutto;
    }

    public void setJahresBrutto(Integer jahresBrutto) {
        this.jahresBrutto = jahresBrutto;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public String getHaarfarbe() {
        return haarfarbe;
    }


    public void setHaarfarbe(String haarfarbe) {
        this.haarfarbe = haarfarbe;
    }

    public static void main(String... args) {
        new BoolscherAusdruck();
    }
}
