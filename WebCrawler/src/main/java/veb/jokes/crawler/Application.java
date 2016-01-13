package veb.jokes.crawler;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import veb.jokes.crawler.db.WordRepository;

@SpringBootApplication
public class Application {
	@Autowired
	private Crawler c;
	
	@Resource
    private Environment env;

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(WordRepository repository) {
		return (args) -> {
			c.asd();
			//System.out.println("ASD");
			//String asd = env.getRequiredProperty("asd");
//			Word a = new Word(asd, 5, 2, 1);
//			System.out.println(asd);
//			repository.save(a);
		};
	}

}