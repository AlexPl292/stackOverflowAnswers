package missingPojoAndObjectNode;

import java.util.Random;

/**
 * Created by Alex Plate on 21.09.2018.
 */
public class Pojo {
    int number;

    public Pojo(int x) {
        this.number = new Random().nextInt();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
