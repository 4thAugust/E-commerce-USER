package userServise.userService;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import models.USER;

@SpringBootApplication
@EnableAutoConfiguration
@RestController
public class App 
{
	public static ArrayList<USER> dummyData = new ArrayList<>(); 
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}
