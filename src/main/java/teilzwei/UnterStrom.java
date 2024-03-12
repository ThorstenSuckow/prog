package teilzwei;

public class UnterStrom {

    private static UnterStrom instance;

    public synchronized static UnterStrom getInstance() {

        if (instance == null) {
            instance = new UnterStrom();
        }

        return instance;
    }

    private UnterStrom() {

    }

    public double berechneWiderstand(Draht draht) {
        double widerstand = 0.0;

        double rho = draht.getRho();

        widerstand = rho * (draht.getLaenge() / (Math.pow((draht.getDurchmesser()/2), 2) * Math.PI));

        return widerstand;
    }

    public double berechneSpannung(Draht draht, double stromstaerke) {
        double spannung = 0.0;

        double widerstand = berechneWiderstand(draht);

        spannung = widerstand * stromstaerke;

        return spannung;
    }

}
