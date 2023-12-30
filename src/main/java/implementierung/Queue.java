package implementierung;

import schnittstellen.IList;
import schnittstellen.IQueue;
import schnittstellen.IValueElement;

public class Queue implements IQueue {

    private final IList list;

    private int size;

    private final static int MAX_SIZE = 7;

    public Queue() {
        list = new List();
    }

    @Override
    public IList getDVL() {
        return list;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == MAX_SIZE;
    }


    @Override
    public int dequeue() {
        if (isEmpty()) {
            return -1;
        }

        IValueElement first = list.getElementAt(1);
        list.deleteFirstOf(first);
        size--;
        return first.getValue();
    }

    @Override
    public void enqueue(int value) {
        if (size == MAX_SIZE) {
            return;
        }
        value = Math.max(value, 0);

        IValueElement el = new ValueElement(String.valueOf(value), value);
        list.insertAtPos(1, el);
        size++;
    }

    @Override
    public int front() {
        if (size == 0) {
            return -1;
        }
        return list.getElementAt(1).getValue();
    }

    public String toString() {
        return list.toString();
    }


}
