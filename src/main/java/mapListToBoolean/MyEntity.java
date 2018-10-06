package mapListToBoolean;

import java.util.Set;

/**
 * Created by Alex Plate on 06.10.2018.
 */
class MyEntity {
    private Integer id;
    private String someField;
    private Set<Object> foos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSomeField() {
        return someField;
    }

    public void setSomeField(String someField) {
        this.someField = someField;
    }

    public Set<Object> getFoos() {
        return foos;
    }

    public void setFoos(Set<Object> foos) {
        this.foos = foos;
    }
}
