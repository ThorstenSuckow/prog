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

    // has a default constructor

}

class B extends A {

    // new B has a default constructor that calls the parent constructor

}


class C {
    public C() {
        System.out.println("C created.");
    }
}
class D extends C {
    // automatically calls the default constructor which automatically calls parent
    // constructor: new D -> D(){ super(); }
}
class E extends D {
    public E() {
        // will first call D(), then C(), then the following line is printed.
        System.out.println("E created.");
    }
}

class F extends E {


    public F(int x) {
        // the default constructor for THIS class will not be available unless explicitly
        // implemented.

        // A class that implements a parameterized constructor does automatically
        // call the parent's default constructor.
        // E() -> D() ->  C()
        System.out.println("F created");
    }
}


class G extends F {

    public G(int x) {
         super(x);
        // uncommenting the preceeding line will yield the error "There is no default constructor available in 'prog.sandbox.F'".
        // This is because super(); is added by the compiler as the first statement to THIS constructor.
        // -> since there is no default constructor available in F, we must tell THIS object how the constructor chain looks like.
        // A class overriding a parameterized constructor must call the parent's parameterized constructor,
        // otherwise the parent's default constructor is called, if implemented. If neither a default constructor
        // nor an explicit call to a parent-constructor exists, the program won't compile.
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