package modelMapperAndOrder;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.spi.MappingContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.equalsIgnoreCase;

/**
 * Created by Alex Plate on 29.09.2018.
 * <p>
 * https://stackoverflow.com/questions/52500145/spring-boot-issue-with-mapping-entity-to-entitydto
 */
public class Main {
    public static void main(String[] args) {
        List<Order> list = new ArrayList<>();

        Item item = new Item();
        item.setItemId("1");
        item.setItemName("Name");

        Item item1 = new Item();
        item1.setItemId("2");
        item1.setItemName("Name1");

        Order order = new Order();
        order.setOrderUid("1");
        order.setItems(Arrays.asList(item, item1));

        list.add(order);

        Page<Order> x = new PageImpl<>(list);

        Page<OrderDTO> res = convertOrderEntityToDTO(x, "1");
        System.out.println("x");
    }


    public static Page<OrderDTO> convertOrderEntityToDTO(Page<Order> orderList, String itemId) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(Order.class, OrderDTO.class)
                .setConverter(context -> context.getSource().getItems().stream()
                        .filter(item1 -> equalsIgnoreCase(item1.getItemId(), itemId))
                        .findAny().map(o -> {
                            OrderDTO orderDTO = new OrderDTO();
                            orderDTO.setItemId(o.getItemId());
                            orderDTO.setItemName(o.getItemName());
                            orderDTO.setItemUid(o.getItemUid());
                            orderDTO.setIsbn(o.getIsbn());
                            return orderDTO;
                        }).orElse(null));

        List<OrderDTO> orderDtoList = orderList.getContent().stream()
                .map(o -> modelMapper.map(o, OrderDTO.class))
                .collect(Collectors.toList());

        return new PageImpl<>(orderDtoList, orderList.getPageable(), orderList.getTotalElements());
    }

    public static Page<OrderDTO> convertOrderEntityToDTOo(Page<Order> orderList, String itemId) {
        ModelMapper modelMapper = new ModelMapper();
        Type listType = new TypeToken<Page<OrderDTO>>() {
        }.getType();
        modelMapper.createTypeMap(Order.class, OrderDTO.class).setConverter((MappingContext<Order, OrderDTO> context) -> {
            Item item = context.getSource().getItems().stream()
                    .filter(o -> equalsIgnoreCase(o.getItemId(), itemId))
                    .findAny().orElse(null);
            if (item != null) {
                OrderDTO orderDTO = context.getDestination();
                orderDTO.setItemId(item.getItemId());
                orderDTO.setItemName(item.getItemName());
                orderDTO.setItemUid(item.getItemUid());
                orderDTO.setIsbn(item.getIsbn());
                return orderDTO;
            }
            return null;
        });

        return modelMapper.map(orderList, listType);
    }
}
