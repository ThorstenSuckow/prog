package encryption;

public class SymmetricEncryption {

    private static int mod(int m, int n) {
        int erg = m % n ;
        while (erg < 0) {
            erg += n ;
        }
        return erg;
    }

    public static boolean isStringValid(String input) {

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c < 'A' ||  c > 'Z') {
                return false;
            }
        }

        return true;
    }


    public static String caesar(String input, int shift) {

        if (!isStringValid(input)) {
            throw new IllegalArgumentException();
        }

        int baseStart  = 'A';
        int baseLength  = 26;

        StringBuilder b = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char orgC = input.charAt(i);
            char shiftedC = (char)('A' + mod(orgC - baseStart + shift,  baseLength));
            b.append(shiftedC);
        }

        return b.toString();

    }
    public static String rot13(String input) {
        return caesar(input, 13);
    }
    public static String vigenereEncrypt(String input, String key) {
        return vigenereImpl(input, key, true);
    }
    private static String vigenereImpl(String input, String key, boolean encrypt) {
        if (!isStringValid(input) || !isStringValid(key)) {
            throw new IllegalArgumentException();
        }
        int targetLength = input.length();
        while (key.length() < targetLength) {
            key += key;
        }
        key = key.substring(0, targetLength);

        int baseStart  = 'A';
        int baseLength  = 26;

        StringBuilder b = new StringBuilder();

        byte v = (byte)(encrypt ? 1 : -1);
        for (int i = 0; i < input.length(); i++) {
            char orgC = input.charAt(i);

            char shiftedC = (char)('A' + mod(orgC - baseStart + (key.charAt(i) - baseStart) * v,  baseLength));
            b.append(shiftedC);
        }

        return b.toString();
    }
    public static String vigenereDecrypt(String input, String key) {
        return vigenereImpl(input, key, false);
    }

    public static void main (String... args) {

        vigenereEncrypt("Hallo", "HALLO");
    }

}
