package mapToParent;

import mapToParent.from.ChildA;
import mapToParent.from.ChildB;
import mapToParent.to.ParentDTO;
import mapToParent.to.ClassADTO;
import mapToParent.to.ClassBDTO;
import org.modelmapper.ModelMapper;

/**
 * Created by Alex Plate on 26.09.2018.
 * https://stackoverflow.com/questions/52475371/modelmapper-choose-mapping-based-on-child-class/52522951#52522951
 */
public class Main {
    public static void main(String[] args) {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(ChildA.class, ParentDTO.class)
                .setConverter(mappingContext -> modelMapper.map(mappingContext.getSource(), ClassADTO.class));
        modelMapper.createTypeMap(ChildB.class, ParentDTO.class)
                .setConverter(mappingContext -> modelMapper.map(mappingContext.getSource(), ClassBDTO.class));

        ChildA childA = new ChildA(1);
        ChildB childB = new ChildB();


        ParentDTO res = modelMapper.map(childA, ParentDTO.class);
        ParentDTO res2 = modelMapper.map(childB, ParentDTO.class);
        System.out.println("x");
    }
}
