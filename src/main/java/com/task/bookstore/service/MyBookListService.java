package com.task.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.bookstore.entity.MyBookList;
import com.task.bookstore.repository.MyBookListRepository;

@Service
public class MyBookListService {
	
	@Autowired
	private MyBookListRepository myBookRepo;
	
	
	public void saveMyBooks(MyBookList myBook) {
		 myBookRepo.save(myBook);
	}
	

	public List<MyBookList> getAllMyBooks(){
		
		return myBookRepo.findAll();
	}
	
	public void deleteById(int id) {
		myBookRepo.deleteById(id);
	}
}
