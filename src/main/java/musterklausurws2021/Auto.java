package musterklausurws2021;

public class Auto {

    private int kmStand;

    private double verbrauch;

    private double tankVolumen;

    private double kraftstoffVorrat;

    public Auto(int kmStand, double verbrauch, double tankVolumen, double kraftstoffVorrat) {
        this.kmStand = kmStand;
        this.verbrauch = verbrauch;
        this.tankVolumen = tankVolumen;
        this.kraftstoffVorrat = kraftstoffVorrat;
    }

    public String toString() {
        return "verbrauch: " + verbrauch + "; tankVolumen: " + tankVolumen +
            "; kmStand: " + kmStand + "; kraftstoffVorrat: " + kraftstoffVorrat;
    }

    public void fahren(int km) {

        if (km <= 0) {
            return;
        }

        double proKm = verbrauch / 100;

        int maxReichweite = (int) (kraftstoffVorrat / proKm);

        if (maxReichweite < km) {
            kmStand += maxReichweite;
            kraftstoffVorrat =0;
        } else {
            kmStand += km;
            kraftstoffVorrat -= proKm * km;
        }
    }

    public void tanken(double liter) {

        if (liter <= 0) {
            return;
        }

        if (liter + kraftstoffVorrat >= tankVolumen) {
            kraftstoffVorrat = tankVolumen;
        } else {
            kraftstoffVorrat += liter;
        }
    }

    public static void main (String[] args) {

        Auto gogoMobil = new Auto(0, 5.0, 50, 30);

        gogoMobil.fahren(300);

        gogoMobil.tanken(25);

    }

    public int getKmStand() {
        return kmStand;
    }

    public double getKraftstoffVorrat() {
        return kraftstoffVorrat;
    }

    public double getTankVolumen() {
        return tankVolumen;
    }

    public double getVerbrauch() {
        return verbrauch;
    }
}
