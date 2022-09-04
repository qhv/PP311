package qhv.alex.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class Pp311SpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(Pp311SpringBootApplication.class, args);
    }

}
