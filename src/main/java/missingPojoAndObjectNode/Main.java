package missingPojoAndObjectNode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Created by Alex Plate on 21.09.2018.
 * https://stackoverflow.com/questions/52436391/passing-missingnode-to-objectmapper-to-convert-to-pojo
 */
public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Pojo[] arr = new Pojo[2];
        arr[0] = new Pojo(1);
        arr[1] = new Pojo(1);
        ObjectNode root = mapper.createObjectNode();
        JsonNode pojoJson = root.withArray("Test");
        mapper.treeToValue(pojoJson, Pojo[].class);
    }
}
