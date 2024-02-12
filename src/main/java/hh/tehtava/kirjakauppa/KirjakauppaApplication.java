package hh.tehtava.kirjakauppa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.tehtava.kirjakauppa.domain.BookRepository;
import hh.tehtava.kirjakauppa.domain.book;

@SpringBootApplication
public class KirjakauppaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KirjakauppaApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			repository.save(new book(title:"A Storm of Swords", author:"George R. R. Martin", publicationYear:2000, isbn:"0-00-224586-8", price:3.50 ));
			repository.save(new book(title:"Neuromancer", author:"William Gibson", publicationYear:1984, isbn:"	0-441-56956-0", price:15))
		}
	}

}
