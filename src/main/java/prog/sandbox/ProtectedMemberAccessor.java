package prog.sandbox;

public class ProtectedMemberAccessor {

    public ProtectedMemberAccessor() {

        int bar = ProtectedMember.staticFoo;
        System.out.println(bar);

        bar = (new ProtectedMember()).foo;
        System.out.println(bar);
    }


    public static void main (String[] args) {
        new ProtectedMemberAccessor();
    }

}
