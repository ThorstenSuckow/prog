package prog.sandbox;

public class WidenAccessModifierDemo {

    static class A {

        private int m;
        private void foo() {
            System.out.println("A.foo()");
        }

        protected void snafu() {
            System.out.println("A.snafu()");
        }

        public void bar() {}

    }

    static class B extends A {

        public void foo() {
            System.out.println("B.foo()");
            super.foo();
            System.out.println("super.m: " + super.m);
        }

        public void snafu() {
            super.snafu();
            System.out.println("B.snafu()");
        }


        // private void bar() {}// not allowed
    }

    static class C extends B {

        public void foo() {
            // System.out.println(super.m); // error: m has private access in A
        }
    }

    public static void main(String[] args) {

        B b = new B();
        b.foo();

        b.snafu();

        C c = new C();
        c.foo();
    }

}
