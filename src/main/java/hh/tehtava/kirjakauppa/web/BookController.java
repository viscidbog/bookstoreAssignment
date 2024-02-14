package hh.tehtava.kirjakauppa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping(value = "/savebook", method = RequestMethod.POST)
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "redirect:index";

    }
}