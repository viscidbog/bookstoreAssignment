package hh.tehtava.kirjakauppa.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book, Long> {

    List<Book> findByIsbn(String isbn);
}
