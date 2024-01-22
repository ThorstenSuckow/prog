package sandbox;

public class McCarthy {

    private static int m91depth = 0;


    public static int m91(int n, int depth) {

        m91depth = Math.max(m91depth, depth);

        if (n > 100) {
            return n - 10;
        }

        return m91(m91(n+11, depth + 1), depth +1);
    }


    public static void main(String[] args) {
        m91(97, 0);
    }

}

