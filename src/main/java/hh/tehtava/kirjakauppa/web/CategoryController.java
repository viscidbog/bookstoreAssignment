package hh.tehtava.kirjakauppa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.tehtava.kirjakauppa.domain.Category;
import hh.tehtava.kirjakauppa.domain.CateRepo;

@Controller
public class CategoryController {

    @Autowired
    private CateRepo repository;

    @RequestMapping(value = "/categorylist", method = RequestMethod.GET)
    public String showIndex(Model model) {
        model.addAttribute("categories", repository.findAll());
        return "categorylist";
    }

    @RequestMapping(value = "/addcategory", method = RequestMethod.GET)
    public String addBook(Model model) {
        model.addAttribute("category", new Category());
        return "/addcategory";
    }

    @RequestMapping(value = "/savecategory", method = RequestMethod.POST)
    public String save(Category category) {
        repository.save(category);
        return "redirect:categorylist";
    }

}