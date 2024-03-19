package sandbox;

public class MatrikelNummerDemo {

    public static void main (String... args) {

        int matrikelNummer = 900011;

        int[] faktoren = {2, 1, 4, 3, 2, 1};

        int[] ziffern = new int[6];

        if (matrikelNummer < 90_0000 || matrikelNummer > 99_9999) {
            System.out.println("matrikelNummer oob: " + matrikelNummer);
            return;
        }

        int tmp = matrikelNummer;
        int i = ziffern.length - 1;

        while (i >= 0) {

            int z = tmp % 10;
            ziffern[i] = z;
            tmp = tmp / 10;
            i--;
        }

        int res = 0;

        for (i = 0; i < ziffern.length; i++) {
            res += ziffern[i] * faktoren[i];
        }

        if (res % 10 == ziffern[ziffern.length - 1]) {
            System.out.println("true");
        }

        System.out.println("false: " + res + "; " + (res % 10) + ", " + ziffern[ziffern.length - 1]);

    }

}
