package prog.sandbox;

class OverrideParent {

    public String foo() {
        return "";
    }

}

class OverrideChild extends OverrideParent {


    // overloads foo
    public int foo(int f) {
        return 1;
    }

    // overrides foo
    public String foo() {
        return "foo";
    }

    public void bar() {}
}
public class OverrideMethodDemo {

    public static void main(String[] args) {
        OverrideChild c = new OverrideChild();
        System.out.println(c.foo(1));
        System.out.println(c.foo());

        OverrideParent p = c;
        c.foo(); // works, calls foo from OverrideChild
        // p.bar(); does not work. requires explicit cast to child class
        ((OverrideChild)p).bar();
    }
}
