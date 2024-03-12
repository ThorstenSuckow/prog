package teildrei;

public class Easy {

    public static double addIf(int a, int b) {

        double a1 = a;
        double b1 = b;

        if (a1 + b1 > 10) {
            return a1 + b1 - 0.5;
        }

        return a1 + b1 + 0.5;

    }

}
