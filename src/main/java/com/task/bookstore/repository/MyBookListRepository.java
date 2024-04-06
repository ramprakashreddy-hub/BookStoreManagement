package com.task.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.bookstore.entity.MyBookList;

@Repository
public interface MyBookListRepository  extends JpaRepository<MyBookList, Integer>{

	
}
