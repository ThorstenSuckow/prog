package implementierung;

import schnittstellen.IList;
import schnittstellen.IListElement;
import schnittstellen.IValueElement;

public class List implements IList {

    private IListElement head;

    private int size;
    public List() {
        head = new ListElement(new ValueElement("", 0));
        head.setPredecessor(null);
        head.setSuccessor(null);
    }

    @Override
    public IListElement getHead() {
        return head;
    }

    @Override
    public void insertAtTheEnd(IValueElement value) {
        value = sanitize(value);

        ListElement newLast = new ListElement(value);
        IListElement oldLast = head.getPredecessor() == null ? head : head.getPredecessor();

        if (head.getSuccessor() == null) {
            head.setSuccessor(newLast);
        }

        oldLast.setSuccessor(newLast);
        newLast.setPredecessor(oldLast);
        head.setPredecessor(newLast);

        size++;
    }

    @Override
    public void insertAtPos(int pos, IValueElement value) {

        value = sanitize(value);
        IListElement newElement = new ListElement(value);

        pos = Math.min(getSize() + 1, Math.max(1, pos));

        if (pos > size) {
            insertAtTheEnd(value);
            return;
        }

        IListElement shiftedElement = getListElementAt(pos);
        IListElement previousElement = shiftedElement.getPredecessor();

        previousElement.setSuccessor(newElement);
        newElement.setPredecessor(previousElement);

        newElement.setSuccessor(shiftedElement);
        shiftedElement.setPredecessor(newElement);

        size++;
    }

    @Override
    public IValueElement getElementAt(int position) {

        // do not return head
        if (position <= 0 || position > size) {
            return null;
        }

        IListElement element = getListElementAt(position);

        return element != null ? element.getValueElement() : null;
    }

    @Override
    public int getFirstPosOf(IValueElement value) {
        return findFirst(value);
    }

    @Override
    public void deleteFirstOf(IValueElement value) {

        int pos = findFirst(value);

        if (pos == -1) {
            return;
        }

        deleteAt(pos);
    }

    @Override
    public void deleteAllOf(IValueElement value) {

        int pos;
        while ((pos = findFirst(value)) != -1) {
            deleteAt(pos);
        }

    }

    @Override
    public boolean member(IValueElement value) {
        return findFirst(value) != -1;
    }

    @Override
    public void reverse() {

        IListElement oldFirst = head.getSuccessor();
        IListElement oldLast = head.getPredecessor();

        // list is empty
        if (oldFirst == null) {
            return;
        }

        // iterate through the elements and switch pointers
        IListElement element = oldFirst;
        IListElement prev = null;
        while (element != null) {
            IListElement next = element.getSuccessor();
            element.setSuccessor(prev);
            element.setPredecessor(next);

            prev = element;
            element = next;
        }

        // adjust head and update oldFirst / oldLast
        oldFirst.setSuccessor(null);
        oldLast.setPredecessor(head);
        head.setPredecessor(oldFirst);
        head.setSuccessor(oldLast);
    }


    private IValueElement sanitize(IValueElement valueElement) {
        if (valueElement == null) {
            valueElement = new ValueElement("", 0);
        }

        return valueElement;
    }


    public String toString() {
        IListElement element = head.getSuccessor();

        StringBuilder b = new StringBuilder();
        while (element != null) {
            b.append(element).append(",");
            element = element.getSuccessor();
        }
        String listString = b.toString();
        return !listString.isEmpty() ? listString.substring(0, listString.length() - 1) : "NULL";
    }

    public int getSize() {
        return size;
    }

    /**
     * Returns the listElement for the specified position.
     *
     * @param position the specified position. 0 returns head, anything greater than size returns
     *                 the last element of the list.
     * @return
     */
    public IListElement getListElementAt(int position) {

        int i = 0;
        IListElement element = head;
        while (i++ < position && element != null) {
            element = element.getSuccessor();
        }

        return element;
    }

    public int findFirst(IValueElement value) {

        int i = 0;
        IListElement element;
        while (i++ < size) {
            element = getListElementAt(i);
            if (element.getValueElement() == value) {
                return i;
            }
        }

        return -1;
    }

    private void deleteAt(int pos) {
        if (pos < 1) {
            return;
        }

        IListElement drop = getListElementAt(pos);

        IListElement succ = drop.getSuccessor();
        IListElement pre = drop.getPredecessor();

        pre.setSuccessor(succ);
        if (succ != null) {
            succ.setPredecessor(pre);
        } else {
            // succ null, last element in list, heads predecessor points to this
            head.setPredecessor(drop.getPredecessor() == head ? null : drop.getPredecessor());
        }

        drop.setPredecessor(null);
        drop.setSuccessor(null);


        size--;
    }

}
