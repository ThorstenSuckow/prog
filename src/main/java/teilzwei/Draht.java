package teilzwei;

public class Draht {

    public enum Material{
        KUPFER,
        SILIZIUM
    };

    private Material material;

    private double laenge;

    private double durchmesser;

    /**
     * • Kupfer: ρ = 17, 8 ∗ 10−9 Ω × m
     * • Silizium: ρ = 2, 3 ∗ 103 Ω × m
     *
     */
    public double getRho() {

        return switch (getMaterial()) {
            case KUPFER -> 17.8 * Math.pow(10, -9);
            case SILIZIUM -> 2.3 * Math.pow(10, 3);
        };

    }

    public double getDurchmesser() {
        return durchmesser;
    }

    public double getLaenge() {
        return laenge;
    }

    public Material getMaterial() {
        return material;
    }

    public void setDurchmesser(double durchmesser) {
        this.durchmesser = durchmesser;
    }

    public void setLaenge(double laenge) {
        this.laenge = laenge;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
