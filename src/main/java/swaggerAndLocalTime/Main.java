package swaggerAndLocalTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Alex Plate on 18.09.2018.
 * https://stackoverflow.com/questions/51636477/conflict-between-swagger2-and-jackson-datatype-jsr310-in-spring-boot-application
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
