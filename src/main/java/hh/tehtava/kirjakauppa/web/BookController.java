package hh.tehtava.kirjakauppa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.tehtava.kirjakauppa.domain.Book;
import hh.tehtava.kirjakauppa.domain.BookRepo;
import hh.tehtava.kirjakauppa.domain.CateRepo;

@Controller
public class BookController {

    @Autowired
    private BookRepo brepository;
    @Autowired
    private CateRepo crepository;

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String showIndex(Model model) {
        model.addAttribute("books", brepository.findAll());
        return "index";
    }

    @RequestMapping(value = "/addbook", method = RequestMethod.GET)
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", crepository.findAll());
        return "/addbook";
    }

    @RequestMapping(value = "/savebook", method = RequestMethod.POST)
    public String save(Book book) {
        brepository.save(book);
        return "redirect:index";
    }

    @RequestMapping(value = "/delete/{bookid}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("bookid") Long bookDel, Model model) {
        brepository.deleteById(bookDel);
        return "redirect:../index";
    }

    @RequestMapping(value = "/editbook/{bookid}")
    public String editing(@PathVariable("bookid") Long bookId, Model model) {
        model.addAttribute("book", brepository.findById(bookId));
        model.addAttribute("categories", crepository.findAll());
        return "/editbook";
    }

}
