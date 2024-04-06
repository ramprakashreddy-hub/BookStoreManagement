package com.task.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.task.bookstore.service.MyBookListService;

@Controller
public class MyBookListController {
	
	
	@Autowired
	private MyBookListService mybookServ;
	
	
	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id") int id) {
		mybookServ.deleteById(id);
		return "redirect:/my_books";
		
	}

}
