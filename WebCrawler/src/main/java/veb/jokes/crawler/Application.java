package veb.jokes.crawler;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Application {
	@Autowired
	private Crawler crawler;
	
	@Autowired
	private IAlgorithmGrader algo;
	
	@Resource
    private Environment env;

//	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
	
	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
//			String joke = "gay lord what the fuck";
			String joke = readJoke();
			JokeGrade grade = algo.grade(joke);
			System.out.println("THE FINAL GRADE IS: ");
			System.out.println(grade);
		};
	}
	
	private static String readJoke() {
		JokeReader jr = new JokeReader();
		String result = null;
		try {
			result = jr.read();
		} catch (FileNotFoundException e) {
			System.out.println("FNF");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOE");
			e.printStackTrace();
		}
		
		return result;
	}

//	@Bean
//	public CommandLineRunner crawler(WordRepository repository) {
//		return (args) -> {
//			crawler.crawlersGonnaCrawl();
//		};
//	}

}