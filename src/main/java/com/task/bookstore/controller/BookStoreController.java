package com.task.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.task.bookstore.entity.Book;
import com.task.bookstore.entity.MyBookList;
import com.task.bookstore.service.BookService;
import com.task.bookstore.service.MyBookListService;

@Controller
public class BookStoreController {

	@Autowired
	private BookService service;
	
	@Autowired
    private MyBookListService myBookServ;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}

	@GetMapping("/available_books")
	public ModelAndView getAllBooks() {
		List<Book> list = service.getAllBooks();
		return new ModelAndView("availablebooks", "book", list);
	}

	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		service.save(b);
		return "redirect:/available_books";

	}

	@GetMapping("/my_books")
	public String getMyBooks(Model model) {
		List<MyBookList> allMyBooks = myBookServ.getAllMyBooks();
		model.addAttribute("book", allMyBooks);
		return "myBooks";
	}
	
	
	@RequestMapping("/myList/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b=service.getBookById(id);
		MyBookList my=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookServ.saveMyBooks(my);
		return "redirect:/my_books";
	}
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id,Model model) {
		
		Book b=service.getBookById(id);
		model.addAttribute("book",b);
		return "bookEdit";
		
	}
	
	@RequestMapping("/deleteBook/{id}")
	public String deletBook(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/available_books";
	}
}
