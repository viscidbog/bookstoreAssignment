package hh.tehtava.kirjakauppa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.tehtava.kirjakauppa.domain.Book;
import hh.tehtava.kirjakauppa.domain.BookRepository;

@SpringBootApplication
public class KirjakauppaApplication {

	private static final Logger log = LoggerFactory.getLogger(KirjakauppaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KirjakauppaApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			log.info("put some books in the store");
			repository.save(new Book(title:"A Storm of Swords", author:"George R. R. Martin", publicationYear:2000, isbn:"0-00-224586-8", price:3.50 ));
			repository.save(new Book(title:"Neuromancer", author:"William Gibson", publicationYear:1984, isbn:"	0-441-56956-0", price:15));
			repository.save(new Book(title:""))
		}
	}

}
