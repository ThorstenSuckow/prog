package musterklausurws2021;


public class VerketteListe {

    static class ListElement {

        private Object daten;
        private ListElement naechstes;

        ListElement(Object daten, ListElement naechstes) {
            this.daten = daten;
            this.naechstes = naechstes;
        }

        ListElement(Object daten) {
            this(daten, null);
        }

        Object getDaten() {
            return daten;
        }

        ListElement getNaechstes() {
            return naechstes;
        }

        void setNaechstes(ListElement naechstes) {
            this.naechstes = naechstes;
        }

        void setDaten(Object daten) {
            this.daten = daten;
        }

    }

    static class Liste {

        private ListElement kopf;

        boolean istEnthalten(Object daten) {
            ListElement next = kopf;

            while (next != null) {
                if (next.getDaten().equals(daten)) {
                    return true;
                }
                next = next.getNaechstes();
            }

            return false;
        }

        void add(ListElement element) {

            if (kopf == null) {
                kopf = element;
                return;
            }

            ListElement tail = kopf;
            while (tail.getNaechstes() != null) {
                tail = tail.getNaechstes();
            }

            tail.setNaechstes(element);
        }


        public String toString() {
            ListElement next = kopf;
            StringBuilder p = new StringBuilder();
            while (next != null) {
                p.append("[" + next.getDaten() + "]");
                next = next.getNaechstes();
            }
            return p.toString();
        }
    }


    public static void main(String[] args) {

        Liste liste = new Liste();

        assert(!liste.istEnthalten(1));

        liste.add(new ListElement(1));
        assert(liste.istEnthalten(1));

        liste.add(new ListElement(2));

        assert(liste.istEnthalten(1));
        assert(liste.istEnthalten(2));

        liste.add(new ListElement(3));

        assert(liste.istEnthalten(1));
        assert(liste.istEnthalten(2));
        assert(liste.istEnthalten(3));

        assert(!liste.istEnthalten(1234));

        System.out.println(liste);
    }
}