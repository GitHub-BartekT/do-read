package pl.iseebugs.read;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@ComponentScan({"pl.iseebugs.read.moduleProperties","pl.iseebugs.read.module"})
public class DoReadApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoReadApplication.class, args);
	}

}
