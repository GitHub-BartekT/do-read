package pl.iseebugs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@SpringBootApplication
@EnableMongoRepositories
//@ComponentScan({"pl.iseebugs.read.moduleProperties","pl.iseebugs.read.module"})
public class DoReadApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoReadApplication.class, args);
	}
}
