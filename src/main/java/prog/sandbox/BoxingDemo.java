package prog.sandbox;

public class BoxingDemo {


    public static void main(String[] args) {

        Object x = 42;
        Boolean y = true;
        Character z = 'a';

        System.out.println(x.getClass()); // class java.lang.Integer
        System.out.println(y.getClass()); // class java.lang.Boolean
        System.out.println(z.getClass()); // class java.lang.Character
    }
}
