package sandbox;

public class RecursionDemo {

    public static int rcalls = 0;

    public static int recursion(int n, int calls) {

        rcalls = Math.max(rcalls, calls);

        if (n <= 0) {
            return 1;
        }

        return recursion(n - 1, calls + 1) + recursion (n -1, calls + 1);
    }

    public static void main (String... args) {

        recursion(3, 1);
        System.out.println(rcalls);

    }

}
