package implementierung;

import schnittstellen.IListElement;
import schnittstellen.IValueElement;

public class ListElement implements IListElement {

    private IValueElement valueElement;

    private IListElement predecessor;

    private IListElement successor;

    public ListElement(IValueElement elem) {
        setValueElement(elem);
    }

    @Override
    public IValueElement getValueElement() {
        return valueElement;
    }

    @Override
    public void setValueElement(IValueElement value) {
        if (value == null) {
            value = new ValueElement("", 0);
        }

        valueElement = value;
    }

    @Override
    public IListElement getPredecessor() {
        return predecessor;
    }

    @Override
    public void setPredecessor(IListElement pre) {
        predecessor = pre;
    }

    @Override
    public IListElement getSuccessor() {
        return successor;
    }

    @Override
    public void setSuccessor(IListElement succ) {
        successor = succ;
    }

    public String toString() {
        return "[" + valueElement + "]";
    }
}
