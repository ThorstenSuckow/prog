package prog.sandbox.innerSandbox;

import prog.sandbox.AccessModifierLessConstructor;

public class ModifierLessConstructorCaller {


    public static void main(String[] args) {

        // new prog.sandbox.ModifierLessConstructor(); // won't work here
        new AccessModifierLessConstructor(2);
    }

}
