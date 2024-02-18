package sandbox;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.sql.SQLClientInfoException;

public class ExceptionsDemo {

    abstract class AbstractExceptionThrower {

        void foo() throws IOException {
            throw new IOException();
        }

        abstract void fooAbstract() throws RemoteException;
    }

    class BaseExceptionThrower extends AbstractExceptionThrower {
        void foo() throws IOException{
            super.foo();
        }

        void fooAbstract() {

        }


    }

    interface Exceptionable {
        void createClient() throws IOException;
    }
    static class ExceptionImpl implements Exceptionable {

        @Override
        public void createClient()  {
            // Implementierung benutzt keine
            // Methode, die eine IOException werfen kann
        }
    }

    private void writeFile() throws IOException {
        File f = new File("./datei.txt");
        f.createNewFile();
    }

    private void runtimeThrow() throws RuntimeException {
        throw new RuntimeException();
    }

    private void runtimeThrowCaller() {
        runtimeThrow();
    }


    public static void main (String[] args) {

        new ExceptionImpl();

    }

}
