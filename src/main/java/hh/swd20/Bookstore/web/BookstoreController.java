package hh.swd20.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;

@Controller

public class BookstoreController {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String mainpage() {
		return "bookstore";
	}

	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String getBooks(Model model) {

		model.addAttribute("books", bookRepository.findAll());
		return "booklist";
	}

	@RequestMapping(value = "/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryRepository.findAll());
		return "addbook";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteBook(@PathVariable("id") Long id, Model model) {
		bookRepository.deleteById(id);
		return "redirect:../booklist";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book) {
		bookRepository.save(book);
		return "redirect:booklist";
	}

	@RequestMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", bookRepository.findById(id));
		return "editbook";
	}

	@RequestMapping(value = "/categorylist", method = RequestMethod.GET)
	public String getCategories(Model model) {

		model.addAttribute("categories", categoryRepository.findAll());
		return "categorylist";
	}

	@RequestMapping(value = "/addcat", method = RequestMethod.GET)
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "newcategory";
	}

	@RequestMapping(value = "/savecat", method = RequestMethod.POST)
	public String save(Category category) {
		categoryRepository.save(category);
		return "redirect:categorylist";
	}

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> bookListREST() {
		return (List<Book>) bookRepository.findAll();
	}

	@RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Book> getCarRest(@PathVariable("id") Long id) {
		return bookRepository.findById(id);
	}

	@RequestMapping(value = "/books", method = RequestMethod.POST)
	public @ResponseBody Book saveBookREST(@RequestBody Book book) {
		bookRepository.save(book);
		return book;
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

}