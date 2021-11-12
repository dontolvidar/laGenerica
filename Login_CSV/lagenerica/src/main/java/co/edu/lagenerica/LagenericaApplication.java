package co.edu.lagenerica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class LagenericaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LagenericaApplication.class, args);
	}

}
