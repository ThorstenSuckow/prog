package prog.sandbox.innerSandbox;

import prog.sandbox.ProtectedMember;

public class ProtectedMemberAccessor {

    public ProtectedMemberAccessor() {

        //int bar = ProtectedMember.staticFoo; // wont work, since we're not in the same package
        //System.out.println(bar);

        //bar = (new ProtectedMember()).foo; // wont work, since we're not in the same package
        //System.out.println(bar);
    }


    public static void main (String[] args) {
        new ProtectedMemberAccessor();
    }

}
