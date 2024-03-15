package sandbox;

class Dummy {
    public Dummy(String from) {
        System.out.println("Dummy for " + from);
    }
}

class A {
    Dummy d = new Dummy("A");
    public A() {
        System.out.println("A");
    }
}

class B extends A {
    public B() {
        System.out.println("B");
    }
}

class C extends B {
    Dummy d = new Dummy("C");
    public C() {
        System.out.println("C");
    }
}

public class TypConvertDemo {



    public static void main (String... args) {

        new C();


    }


}
