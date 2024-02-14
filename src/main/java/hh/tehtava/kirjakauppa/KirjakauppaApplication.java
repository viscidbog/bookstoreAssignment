package hh.tehtava.kirjakauppa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.tehtava.kirjakauppa.domain.Book;
import hh.tehtava.kirjakauppa.domain.BookRepo;

@SpringBootApplication
public class KirjakauppaApplication {

	private static final Logger log = LoggerFactory.getLogger(KirjakauppaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KirjakauppaApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemoAdder(BookRepo repository) {
		return (args) -> {
			log.info("put some books in the store");
			repository.save(new Book("A Storm of Swords", "George R. R. Martin", 2000L, "0-00-224586-8", 50L));
			repository.save(new Book("Neuromancer", "William Gibson", 1984L, "0-441-56956-0", 15L));
			repository.save(new Book("Advanced Demonology", "Louis Cypher", 1666L, "666-666-666", 6L));

		};
	}

}
