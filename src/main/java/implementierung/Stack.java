package implementierung;

import schnittstellen.IList;
import schnittstellen.IStack;
import schnittstellen.IValueElement;

public class Stack implements IStack {

    private final IList list;

    private int size;

    private final static int MAX_SIZE = 7;

    public Stack() {
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
    public int pop() {
        if (isEmpty()) {
            return -1;
        }

        IValueElement last = list.getElementAt(size);
        list.deleteFirstOf(last);
        size--;
        return last.getValue();
    }

    @Override
    public void push(int value) {
        if (size == MAX_SIZE) {
            return;
        }
        value = Math.max(value, 0);

        IValueElement el = new ValueElement(String.valueOf(value), value);
        list.insertAtTheEnd(el);
        size++;
    }

    @Override
    public int top() {
        if (size == 0) {
            return -1;
        }
        return list.getElementAt(size).getValue();
    }

    public String toString() {
        return list.toString();
    }
}
