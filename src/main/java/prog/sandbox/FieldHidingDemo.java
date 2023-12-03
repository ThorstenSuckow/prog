package prog.sandbox;

public class FieldHidingDemo {

    // needs to be static since instances are
    // created in static context (...main)
    static class A {
        int x = 0;

        public String toString() {
            return "I'm A";
        }
    }

    static class B extends A {
        int x = 2; // hides(!) A.x

        // overrides(!) A.toString
        public String toString() {
            return "I'm B";
        }
    }


    public static void main(String[] args) {

        A a = new B();

        System.out.println(a); // "I'm B"
        System.out.println(a.x); // 0

    }

}
