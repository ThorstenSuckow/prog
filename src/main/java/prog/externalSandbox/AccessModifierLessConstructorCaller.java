package prog.externalSandbox;

import prog.sandbox.AccessModifierLessConstructor;

public class AccessModifierLessConstructorCaller {


    /**
     * won't compile
     * @param args
     */
    public static void main(String[] args) {
        // new prog.sandbox.ModifierLessConstructor(); // won't work here
        new AccessModifierLessConstructor(2);
    }

}
