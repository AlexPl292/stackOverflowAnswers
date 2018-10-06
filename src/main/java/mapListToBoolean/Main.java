package mapListToBoolean;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alex Plate on 06.10.2018.
 * <p>
 * https://stackoverflow.com/questions/52653810/modelmapper-how-to-set-a-destination-property-based-on-whether-collection-in-so
 */
public class Main {


    public static void main(String[] args) {
        ModelMapper modelMapper = new ModelMapper();
        Converter<Set, Boolean> SET_BOOLEAN_CONVERTER =
                mappingContext -> !mappingContext.getSource().isEmpty();

        modelMapper.createTypeMap(MyEntity.class, MyEntityDto.class)
                .addMappings(mappings -> mappings.using(SET_BOOLEAN_CONVERTER).map(MyEntity::getFoos, MyEntityDto::setHasFoos));


        MyEntity myEntity = new MyEntity();
        myEntity.setFoos(new HashSet<>(Arrays.asList(1, 2)));

        MyEntityDto map = modelMapper.map(myEntity, MyEntityDto.class);
        System.out.println("x");
    }
}
