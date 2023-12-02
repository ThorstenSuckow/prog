package prog.sandbox;

class Parent {

}

class Child extends Parent {

    public int foo = 1;

}

public class TypeAssignmentDemo {

    public static void main(String[] args) {

        Parent p = new Parent();
        Child c = new Child();

        // Parent p can reference an instance of Child.
        p = c;

        // conversely, p cannot be assigned to c without an explicit cast,
        // since c  represents a specific of p
        // c = p; // fails
        // c = (Child) p; // works


    }

}
