package mapListToBoolean;

/**
 * Created by Alex Plate on 06.10.2018.
 */
class MyEntityDto {
    private Integer id;
    private String someField;
    private Boolean hasFoos;

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

    public Boolean getHasFoos() {
        return hasFoos;
    }

    public void setHasFoos(Boolean hasFoos) {
        this.hasFoos = hasFoos;
    }
}
