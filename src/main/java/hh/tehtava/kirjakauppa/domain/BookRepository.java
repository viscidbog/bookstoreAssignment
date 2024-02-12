package hh.tehtava.kirjakauppa.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<book, Long> {

    List<book> findByIsbn(String isbn);
}
