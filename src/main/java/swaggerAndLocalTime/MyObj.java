package swaggerAndLocalTime;

import java.time.LocalDateTime;

/**
 * Created by Alex Plate on 18.09.2018.
 */
public class MyObj {
    int id;
    LocalDateTime localDateTime;

    public MyObj(int id) {
        this.id = id;
        localDateTime = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
