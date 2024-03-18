package sandbox;

public class PalindromDemo {

    public static boolean isPalindrom(String str) {

        System.out.println(str);
        if (str.length() <= 1) {
            return true;
        }

        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            return isPalindrom(str.substring(1, str.length() - 1));
        }

        return false;
    }


    public static void main(String... args) {

        String str = args[0];

        System.out.println(isPalindrom(str));


    }

}
