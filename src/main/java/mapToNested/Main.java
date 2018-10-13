package mapToNested;

import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alex Plate on 13.10.2018.
 *
 * https://stackoverflow.com/questions/52778981/modelmapper-cannot-convert-from-plain-dto-to-entity-with-complex-field/52795183#52795183
 */
public class Main {
    public static void main(String[] args) {
        ModelMapper mapper = new ModelMapper();
        mapper.createTypeMap(DTO.class, Entity.class)
                .addMappings(mapping -> mapping.<Set<String>>map(DTO::getProp, (dest, v) -> dest.getNested().setProp(v)));

        mapper.createTypeMap(Entity.class, DTO.class)
                .addMappings(mapping -> mapping.map(src -> src.getNested().getProp(), DTO::setProp));

        DTO dto = new DTO();
        dto.setProp(new HashSet<>(Arrays.asList("1", "2")));

        Entity entity = new Entity();
        entity.setNested(new Nested());
        entity.getNested().setProp(new HashSet<>(Arrays.asList("3", "4")));

        Entity res = mapper.map(dto, Entity.class);
        DTO res2 = mapper.map(entity, DTO.class);
        System.out.println();
    }
}
