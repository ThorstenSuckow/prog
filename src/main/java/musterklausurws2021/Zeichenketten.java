package musterklausurws2021;

public class Zeichenketten {


    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            char c;
            int v;
            for (int j = 0; j < arg.length(); j++) {
                c = arg.charAt(j);
                v = c - '0';
                if (v >= 0 && v <= 9) {
                    sum += v;
                }
            }
        }
        System.out.println("Ergebnis: " + sum);
    }

}
