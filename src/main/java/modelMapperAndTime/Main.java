package modelMapperAndTime;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by Alex Plate on 18.09.2018.
 * https://stackoverflow.com/questions/52387605/how-to-map-localdate-to-date-using-dozer-or-modelmapper
 */
public class Main {
    private static final Converter<Date, LocalDate> DATE_TO_LOCAL_DATE_CONVERTER = mappingContext -> {
        Date source = mappingContext.getSource();
        return source.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    };

    private static final Converter<LocalDate, Date> LOCAL_DATE_TO_DATE_CONVERTER = mappingContext -> {
        LocalDate source = mappingContext.getSource();
        return Date.from(source.atStartOfDay(ZoneId.systemDefault()).toInstant());
    };

    public static void main(String[] args) {
        ModelMapper mapper = new ModelMapper();

        TypeMap<Bar, Foo> barToFooMapping = mapper.createTypeMap(Bar.class, Foo.class);
        barToFooMapping.addMappings(mapping -> mapping.using(DATE_TO_LOCAL_DATE_CONVERTER).map(Bar::getSignatureDate, Foo::setSignatureDate));
        TypeMap<Foo, Bar> fooToBarMapping = mapper.createTypeMap(Foo.class, Bar.class);
        fooToBarMapping.addMappings(mapping -> mapping.using(LOCAL_DATE_TO_DATE_CONVERTER).map(Foo::getSignatureDate, Bar::setSignatureDate));

        Foo foo = new Foo();
        foo.setSignatureDate(LocalDate.now());

        Bar bar = new Bar();
        bar.setSignatureDate(new Date());

        Bar bar2 = mapper.map(foo, Bar.class);
        Foo foo2 = mapper.map(bar, Foo.class);

        System.out.println(bar);
    }
}
