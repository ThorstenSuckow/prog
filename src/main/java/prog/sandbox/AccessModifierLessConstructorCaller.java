package prog.sandbox;

public class AccessModifierLessConstructorCaller {


    public static void main(String[] args) {

        /**
         * No errors, since the default access modifier (if none specified) is package protected
         */
        new AccessModifierLessConstructor();
        new AccessModifierLessConstructor(2);
    }

}
