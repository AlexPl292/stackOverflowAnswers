package alexp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Alex Plate on 18.09.2018.
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public MyObj index() {
        return new MyObj(1);
    }

}
