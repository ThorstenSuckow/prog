package prog.sandbox;


/**
 * Default constructor:
 *
 *     public [Classname]() {
 *         // intentionally left empty
 *     }
 *
 * @see <a href="https://docs.oracle.com/javase/specs/jls/se21/html/jls-8.html#jls-8.8.9">https://docs.oracle.com/javase/specs/jls/se21/html/jls-8.html#jls-8.8.9</a>
 */
class A {
    // implicit default constructor: available

    // implicit default constructor: calls java.lang.Object's constructor
}


class B extends A {

    // implicit default constructor: available

    // implicit default constructor: calls A's constructor
}


class C {

    // implicit default constructor: not available

    public C() {
        // implicit call to java.lang.Object's constructor
        System.out.println("C created.");
    }
}


class D extends C {

    // implicit default constructor: available

    // implicit default constructor: calls C's constructor

}


class E extends D {

    // implicit default constructor: not available

    public E() {
        // implicit call to D's constructor
        System.out.println("E created.");
    }
}


class F extends E {

    // implicit default constructor: not available

    public F(int x) {
        // implicit call to E's constructor
        System.out.println("F created");
    }
}


class G extends F {

    // implicit default constructor: not available

    public G(int x) {
        super(x); // explicit call to F's constructor

        // commenting the above statement will implicitly call 'super()', which yields an error.
        // -> since there is no default constructor available in F, we **must** tell this constructor which parent's
        // constructor is to be called.
        System.out.println("G created");
    }
}


public class Constructors {

    public static void main(String[] args) {

        //A a = new A();
        //B b = new B();
        //C c = new C();
        //D d = new D();
        //E e = new E();

        // F f = new F(); //won't work
        // F f = new F(1);
        G g = new G(2);
    }

}