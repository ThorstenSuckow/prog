package implementierung;

import schnittstellen.IValueElement;

public class ValueElement implements IValueElement {

    private String name;

    private int value;

    public ValueElement(String name, int value) {
        setName(name);
        setValue(value);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String paramName) {
        if (paramName == null) {
            paramName = "";
        }
        name = paramName;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int paramValue) {
        value = paramValue;
    }

    public String toString() {
        return name + "," + value;
    }
}
