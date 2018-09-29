package modelMapperAndOrder;

import java.util.List;

/**
 * Created by Alex Plate on 29.09.2018.
 */
public class Order {
    private String orderUid;
    private List<Item> items;

    public String getOrderUid() {
        return orderUid;
    }

    public void setOrderUid(String orderUid) {
        this.orderUid = orderUid;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
