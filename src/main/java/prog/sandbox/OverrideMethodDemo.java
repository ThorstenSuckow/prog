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

}
public class OverrideMethodDemo {

    public static void main(String[] args) {
        OverrideChild c = new OverrideChild();
        System.out.println(c.foo(1));
        System.out.println(c.foo());
    }
}
