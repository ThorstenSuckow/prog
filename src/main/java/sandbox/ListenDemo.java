package sandbox;

public class ListenDemo {

    private static class List {

    }

    private static class ListElement {

        private ListElement next;

        private Object data;

        public ListElement(Object data, ListElement el) {
            this.data = data;
            next = el;
        }

        public void setNext(ListElement el) {
            next = el;
        }

        public Object getData() {
            return data;
        }

        public ListElement getNext() {
            return next;
        }

    }




    public static void main(String... args) {

        ListElement element = new ListElement("element", null);
        ListElement tail = new ListElement("tail", null);
        ListElement head = new ListElement("head", null);

        ListElement a = new ListElement("A", null); // headPrepend.next = head;
        ListElement b = new ListElement("B", null); // headPrepend.next = head;


        head = element;
        tail = element;

        tail.next = a;
        tail = a;

        tail.next = b;
        tail = b;

        System.out.println(tail.next == null);
        System.out.println(head.next == a);
        System.out.println(a.next == b);
        System.out.println(tail == b);





    }

}
