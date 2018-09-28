package mapToParent.from;

/**
 * Created by Alex Plate on 26.09.2018.
 */
public class ChildA extends Parent {
    private int value;

    public ChildA(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
