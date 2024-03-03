package hh.tehtava.kirjakauppa.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CateRepo extends CrudRepository<Category, Long> {
    List<Category> findbyName(String name);
}
