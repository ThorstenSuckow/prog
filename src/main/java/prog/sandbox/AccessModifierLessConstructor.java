package prog.sandbox;

/**
 * The default access modifier in Java makes the constructor AccessModifierLessConstructor()
 * not available in other packages than prog.sandbox.
 */
public class AccessModifierLessConstructor {

    /**
     * Will be available from outside this package.
     */
    public AccessModifierLessConstructor(int a) {

    }

    /**
     * Will not be available from outside this package.
     */
    AccessModifierLessConstructor(){

    }


}
