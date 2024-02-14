package hh.tehtava.kirjakauppa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.tehtava.kirjakauppa.domain.Book;
import hh.tehtava.kirjakauppa.domain.BookRepo;

@Controller
public class BookController {

    @Autowired
    private BookRepo repository;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String showIndex(Model model) {
        System.out.println("Index endpoint");
        model.addAttribute("books", repository.findAll());
        return "index";
    }

    @RequestMapping(value = "/addbook", method = RequestMethod.GET)
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "/addbook";
    }

    @RequestMapping(value = "/savebook", method = RequestMethod.POST)
    public String save(Book book) {
        repository.save(book);
        return "redirect:index";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        repository.deleteById(bookId);
        return "redirect:../index";
    }

    @RequestMapping(value = "/editbook/{id}")
    public String editing(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("book", repository.findById(bookId));
        return "/editbook";
    }

}
